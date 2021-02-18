package io.eigr.astreu;

import akka.actor.typed.ActorSystem;
import akka.actor.typed.javadsl.Behaviors;
import io.eigr.astreu.publisher.DefaultPublisher;
import io.eigr.astreu.subscriber.DefaultSubscriber;

import java.util.Objects;

public final class Astreu {

    private final Config config;
    private final ActorSystem<Void> system;

    private Astreu(Config config){
        this.config = config;
        this.system = ActorSystem.create(Behaviors.empty(), "AstreuSystem");
    }

    public static Astreu at(String host, int port) {
        Objects.requireNonNull(host, "Host not to be null");
        Objects.requireNonNull(port, "Port not to be null");
        return new Astreu(new Config(host, port, new ConnectionOptions()));
    }
    public static Astreu at(String host, int port, ConnectionOptions options) {
        Objects.requireNonNull(host, "Host not to be null");
        Objects.requireNonNull(port, "Port not to be null");
        Objects.requireNonNull(options, "Use at(host, port) if you not use ConnectionOptions argument");
        return new Astreu(new Config(host, port, options));
    }

    public Subscriber asSub(String topic, String subscription) {
        return new DefaultSubscriber(topic, subscription, system, config);
    }

    public Publisher asPub(String topic, String connectionId) {
        return new DefaultPublisher(topic, connectionId, system, config);
    }
}
