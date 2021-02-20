package io.eigr.astreu.publisher;

import akka.NotUsed;
import akka.actor.typed.ActorSystem;
import akka.grpc.GrpcClientSettings;
import akka.stream.javadsl.AsPublisher;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import io.eigr.astreu.Config;
import io.eigr.astreu.Producer;
import io.eigr.astreu.producer.PublisherClient;
import io.eigr.astreu.protocol.System;
import io.eigr.astreu.protocol.*;
import org.reactivestreams.Publisher;
import reactor.core.publisher.EmitterProcessor;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class DefaultPublisher implements Producer {
    private static final EmitterProcessor<Message> stream = EmitterProcessor.create();
    private static final Source<Message, NotUsed> requestStream = Source.fromPublisher(stream);

    private final String topic;
    private final Config config;
    private final String connectionId;
    private final PublisherClient client;
    private final ActorSystem<Void> system;
    private final Source<Message, NotUsed> responseStream;

    public DefaultPublisher(String topic, String connectionId, ActorSystem<Void> system, Config config) {
        this.topic = topic;
        this.system = system;
        this.config = config;
        this.connectionId = connectionId;
        this.client = getClient(system, config);
        this.responseStream = client.publish(requestStream);
    }

    @Override
    public Publisher<ReplyMessage> bind() {
        stream.onNext(
                Message.newBuilder()
                        .setSystem(createSystemMessage())
                        .build()
        );
        return responseStream
                .map(this::transform)
                .runWith(Sink.asPublisher(AsPublisher.WITH_FANOUT), system);
    }

    @Override
    public void publish(Any message) {
        stream.onNext(creatMessage(getId(), message, new HashMap<>()));
    }

    @Override
    public void publish(Any message, Map<String, String> metadataProperties) {
        stream.onNext(creatMessage(getId(), message, metadataProperties));
    }

    @Override
    public void publish(String id, Any message) {
        stream.onNext(creatMessage(id, message, new HashMap<>()));
    }

    @Override
    public void publish(String id, Any message, Map<String, String> metadataProperties) {
        stream.onNext(creatMessage(id, message, metadataProperties));
    }

    public String getTopic() {
        return topic;
    }

    public Config getConfig() {
        return config;
    }

    public String getConnectionId() {
        return connectionId;
    }

    private PublisherClient getClient(ActorSystem<Void> system, Config config) {
        return PublisherClient.create(
                GrpcClientSettings.connectToServiceAt(config.getHost(), config.getPort(), system)
                        .withTls(config.getOptions().isUseTls()),
                system
        );
    }

    private Message creatMessage(String id, Any any, Map<String, String> metadataProperties) {
        Instant instant = Instant.now();
        return Message.newBuilder()
                .setExchange(
                        Exchange.newBuilder()
                                .setUuid(id)
                                .setMessage(any)
                                .setMetadata(
                                        Metadata.newBuilder()
                                                .putAllProperties(metadataProperties)
                                                .setTopic(this.topic)
                                                .setTimestamp(getTime(instant))
                                                .setProducerId(connectionId)
                                                .build()
                                )
                                .build()
                )
                .build();
    }

    private System createSystemMessage() {
        return System.newBuilder()
                .setConnect(
                        Connect.newBuilder()
                                .setTopic(topic)
                                .setUuid(connectionId)
                                .build()
                )
                .build();
    }

    private Timestamp getTime(Instant time) {
        return Timestamp.newBuilder()
                .setNanos(time.getNano())
                .setSeconds(time.getEpochSecond())
                .build();
    }

    private ReplyMessage transform(Message incoming) {
        return new ReplyMessage(system, incoming);
    }

    private String getId() {
        return UUID.randomUUID().toString().toLowerCase();
    }
}
