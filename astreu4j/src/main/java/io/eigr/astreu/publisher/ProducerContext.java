package io.eigr.astreu.publisher;

import akka.actor.typed.ActorSystem;
import io.eigr.astreu.PublisherContext;
import io.eigr.astreu.protocol.Exchange;
import io.eigr.astreu.protocol.Message;
import org.slf4j.Logger;
import reactor.core.publisher.EmitterProcessor;

public final class ProducerContext implements PublisherContext {

    private final Exchange exchange;
    private final String subscription;
    private final ActorSystem<Void> system;
    private final EmitterProcessor<Message> stream;

    public ProducerContext(ActorSystem<Void> system, String subscription, Exchange exchange, EmitterProcessor<Message> stream) {
        this.stream = stream;
        this.system = system;
        this.exchange = exchange;
        this.subscription = subscription;
    }

    @Override
    public Logger logger() {
        return this.system.log();
    }
}
