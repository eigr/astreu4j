package io.eigr.astreu.subscriber;

import akka.NotUsed;
import akka.actor.typed.ActorSystem;
import akka.grpc.GrpcClientSettings;
import akka.stream.javadsl.AsPublisher;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import io.eigr.astreu.Config;
import io.eigr.astreu.MessageWithContext;
import io.eigr.astreu.Subscriber;
import io.eigr.astreu.consumer.SubscriberClient;
import io.eigr.astreu.protocol.Connect;
import io.eigr.astreu.protocol.Message;
import io.eigr.astreu.protocol.System;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import reactor.core.publisher.EmitterProcessor;

import java.util.UUID;

public final class DefaultSubscriber implements Subscriber {
    private static final EmitterProcessor<Message> stream = EmitterProcessor.<Message>create();
    private static final Source<Message, NotUsed> requestStream = Source.fromPublisher(stream);

    private final Logger log;
    private final String topic;
    private final Config config;
    private final String connectionId;
    private final String subscription;
    private final SubscriberClient client;
    private final ActorSystem<Void> system;
    private final Source<Message, NotUsed> responseStream;

    public DefaultSubscriber(String topic, String subscription, ActorSystem<Void> system, Config config) {
        this.log = system.log();
        this.topic = topic;
        this.subscription = subscription;
        this.system = system;
        this.config = config;
        this.connectionId = UUID.randomUUID().toString().toLowerCase();
        this.client = SubscriberClient.create(
                GrpcClientSettings.connectToServiceAt(config.getHost(), config.getPort(), system)
                        .withTls(config.getOptions().isUseTls()),
                system
        );
        this.responseStream = client.subscribe(requestStream);
    }

    @Override
    public Publisher<MessageWithContext> bind() {
        stream.onNext(Message.newBuilder()
                .setSystem(
                        System.newBuilder()
                                .setConnect(
                                        Connect.newBuilder()
                                                .setTopic(topic)
                                                .setSubscription(subscription)
                                                .setUuid(connectionId)
                                                .build()
                                )
                                .build())
                .build());

        return responseStream
                .map(incoming -> new MessageWithContext(new AcknowledgeContext(incoming, stream), incoming))
                .runWith(Sink.asPublisher(AsPublisher.WITHOUT_FANOUT), system);
    }

    public String getTopic() {
        return topic;
    }

    public Config getConfig() {
        return config;
    }

    public String getSubscription() {
        return subscription;
    }


}
