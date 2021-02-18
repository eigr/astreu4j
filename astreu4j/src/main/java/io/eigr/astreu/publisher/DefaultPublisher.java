package io.eigr.astreu.publisher;

import akka.actor.typed.ActorSystem;
import akka.grpc.GrpcClientSettings;
import io.eigr.astreu.Config;
import io.eigr.astreu.Publisher;
import io.eigr.astreu.producer.PublisherClient;
import org.slf4j.Logger;

public final class DefaultPublisher implements Publisher {

    private final Logger log;
    private final String topic;
    private final Config config;
    private final String connectionId;
    private final PublisherClient client;
    private final ActorSystem<Void> system;

    public DefaultPublisher(String topic, String connectionId, ActorSystem<Void> system, Config config) {
        this.log = system.log();
        this.topic = topic;
        this.system = system;
        this.config = config;
        this.connectionId = connectionId;
        this.client = PublisherClient.create(
                GrpcClientSettings.connectToServiceAt(config.getHost(), config.getPort(), system)
                        .withTls(config.getOptions().isUseTls()),
                system
        );
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
}
