package io.eigr.astreu;

import akka.actor.typed.ActorSystem;
import akka.actor.typed.javadsl.Behaviors;
import io.eigr.astreu.publisher.DefaultPublisher;
import io.eigr.astreu.subscriber.DefaultSubscriber;

public final class Astreu {

    private final Config config;
    private final ActorSystem<Void> system;

    private Astreu(Config config){
        this.config = config;
        this.system = ActorSystem.create(Behaviors.empty(), "AstreuSystem");
    }

    public static Astreu at(String host, int port) {
        return new Astreu(new Config(host, port, new ConnectionOptions()));
    }
    public static Astreu at(String host, int port, ConnectionOptions options) {
        return new Astreu(new Config(host, port, options));
    }

    public Subscriber asSubscriber(String topic, String subscription) {
        return new DefaultSubscriber(topic, subscription, system, config);
    }

    public Publisher asPublisher(String topic, String connectionId) {
        return new DefaultPublisher(topic, connectionId, system, config);
    }
}
