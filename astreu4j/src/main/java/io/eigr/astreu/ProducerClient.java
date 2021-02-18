package io.eigr.astreu;

import akka.Done;
import akka.NotUsed;
import akka.japi.Pair;
import akka.actor.typed.ActorSystem;
import akka.actor.typed.javadsl.Behaviors;
import akka.grpc.GrpcClientSettings;
import akka.stream.javadsl.Source;

import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.CompletionStage;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import io.eigr.astreu.producer.PublisherClient;
import io.eigr.astreu.protocol.Connect;
import io.eigr.astreu.protocol.Exchange;
import io.eigr.astreu.protocol.Message;
import io.eigr.astreu.protocol.Metadata;
import io.eigr.astreu.protocol.System;
import org.slf4j.Logger;

import static akka.NotUsed.notUsed;

class ProducerClient {

    public static void main(final String[] args) {
        final ActorSystem<Void> system = ActorSystem.create(Behaviors.empty(), "PublisherClient");
        final Logger log = system.log();

        final PublisherClient client = PublisherClient.create(
                GrpcClientSettings.fromConfig("io.astreu.PublisherService", system).withTls(false),
                system
        );

        final String connectionId = UUID.randomUUID().toString().toLowerCase();

        Source<Message, NotUsed> requestStream =
                Source
                        .tick(Duration.ofSeconds(1), Duration.ofMillis(1), "tick")
                        .zipWithIndex()
                        .map(Pair::second)
                        .map(i -> {
                            if (i == 1) {
                                return Message.newBuilder()
                                        .setSystem(
                                                System.newBuilder()
                                                        .setConnect(
                                                                Connect.newBuilder()
                                                                        .setTopic("test")
                                                                        .setUuid(connectionId)
                                                                        .build()
                                                        )
                                                        .build())
                                        .build();
                            } else {
                                java.time.Instant time = java.time.Instant.now();
                                return Message.newBuilder()
                                        .setExchange(
                                                Exchange.newBuilder()
                                                        .setUuid(String.format("%s", i))
                                                        .setMessage(
                                                                Any.newBuilder()
                                                                .setTypeUrl("io.astreu.custom/Text")
                                                                .setValue(ByteString.copyFrom(String.format("Hello World Astreu from %s", i).getBytes()))
                                                                .build())
                                                        .setMetadata(
                                                                Metadata.newBuilder()
                                                                        .setTopic("test")
                                                                        .setTimestamp(
                                                                                Timestamp.newBuilder()
                                                                                        .setNanos(time.getNano())
                                                                                        .setSeconds(time.getEpochSecond())
                                                                                        .build())
                                                                        .setProducerId(connectionId)
                                                                        .build()
                                                        )
                                                        .build()
                                        )
                                        .build();
                            }

                        })
                        .mapMaterializedValue(ignored -> notUsed());

        Source<Message, NotUsed> responseStream = client.publish(requestStream);

        CompletionStage<Done> done =
                responseStream.runForeach(reply ->
                                log.info("In message {}", reply),
                        system);

        done.whenComplete((reply, error) -> {
            if (error == null) {
               log.warn("streamingBroadcast done");
            } else {
                log.error("Error streamingBroadcast ", error);
            }
        });
    }
}
