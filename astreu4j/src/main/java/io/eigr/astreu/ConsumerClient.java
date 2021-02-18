package io.eigr.astreu;

import akka.Done;
import akka.NotUsed;
import akka.actor.typed.ActorSystem;
import akka.actor.typed.javadsl.Behaviors;
import akka.grpc.GrpcClientSettings;
import akka.stream.javadsl.Source;
import com.google.protobuf.Timestamp;
import io.eigr.astreu.consumer.SubscriberClient;
import io.eigr.astreu.protocol.System;
import io.eigr.astreu.protocol.*;
import org.slf4j.Logger;
import reactor.core.publisher.EmitterProcessor;

import java.util.UUID;
import java.util.concurrent.CompletionStage;

class ConsumerClient {

    public static void main(final String[] args) {
        final ActorSystem<Void> system = ActorSystem.create(Behaviors.empty(), "SubscriberClient");
        final Logger log = system.log();

        final SubscriberClient client = SubscriberClient.create(
                GrpcClientSettings.fromConfig("io.astreu.SubscriberService", system).withTls(false),
                system
        );

        final String connectionId = UUID.randomUUID().toString().toLowerCase();

        final EmitterProcessor<Message> stream = EmitterProcessor.<Message>create();

        final Source<Message, NotUsed> requestStream = Source.<Message>fromPublisher(stream);

        final Source<Message, NotUsed> responseStream = client.subscribe(requestStream);

        stream.onNext(Message.newBuilder()
                .setSystem(
                        System.newBuilder()
                                .setConnect(
                                        Connect.newBuilder()
                                                .setTopic("test")
                                                .setSubscription("test1")
                                                .setUuid(connectionId)
                                                .build()
                                )
                                .build())
                .build());

        final CompletionStage<Done> done =
                responseStream.runForeach(reply -> {
                            final Message.DataCase dataCase = reply.getDataCase();

                            switch (dataCase) {
                                case SYSTEM:
                                    final System sys = reply.getSystem();
                                    log.info("In System Message {}", sys);
                                    break;
                                case EXCHANGE:
                                    final Exchange exchange = reply.getExchange();
                                    log.info("In Exchange Message {}", exchange);
                                    java.time.Instant time = java.time.Instant.now();
                                    stream.onNext(Message.newBuilder()
                                            .setAck(
                                                    Ack.newBuilder()
                                                            .setSubscription("test1")
                                                            .setReason(Ack.Reason.ACCEPT)
                                                            .setUuid(UUID.randomUUID().toString())
                                                            .setMetadata(
                                                                    Metadata.newBuilder()
                                                                            .setCorrelation(exchange.getUuid())
                                                                            .setProducerId(exchange.getMetadata().getProducerId())
                                                                            .setTimestamp(
                                                                                    Timestamp.newBuilder()
                                                                                    .setNanos(time.getNano())
                                                                                    .setSeconds(time.getEpochSecond())
                                                                                    .build())
                                                                            .build())
                                                            .build())
                                            .build());
                                    break;
                                case ACK:
                                    final Ack ack = reply.getAck();
                                    log.info("In Ack Message {}", ack);
                                    break;
                                case DATA_NOT_SET:
                                    log.warn("In No Data Message!");
                                    break;
                                default:
                                    // code block
                            }

                        },
                        system);

        done.whenComplete((reply, error) -> {
            if (error == null) {
                log.warn("streamingBroadcast done");
            } else {
                log.error("Error streamingBroadcast", error);
            }
        });
    }
}
