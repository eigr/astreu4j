package io.eigr.astreu.subscriber;

import akka.actor.typed.ActorSystem;
import com.google.protobuf.Timestamp;
import io.eigr.astreu.NotMessageCorrelationException;
import io.eigr.astreu.SubscriptionContext;
import io.eigr.astreu.protocol.Ack;
import io.eigr.astreu.protocol.Exchange;
import io.eigr.astreu.protocol.Message;
import io.eigr.astreu.protocol.Metadata;
import org.slf4j.Logger;
import reactor.core.publisher.EmitterProcessor;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

public final class AcknowledgeContext implements SubscriptionContext {

    private final String subscription;
    private final ActorSystem<Void> system;
    private final Optional<Exchange> exchange;
    private final EmitterProcessor<Message> stream;

    public AcknowledgeContext(
            ActorSystem<Void> system, String subscription, Optional<Exchange> exchange, EmitterProcessor<Message> stream) {
        this.stream = stream;
        this.system = system;
        this.exchange = exchange;
        this.subscription = subscription;
    }

    @Override
    public void accept() {
        if (exchange.isPresent()) {
            Instant time = Instant.now();
            stream.onNext(Message.newBuilder()
                    .setAck(
                            Ack.newBuilder()
                                    .setSubscription(subscription)
                                    .setReason(Ack.Reason.ACCEPT)
                                    .setUuid(UUID.randomUUID().toString())
                                    .setMetadata(createMetadata(time))
                                    .build())
                    .build());
        }
    }

    @Override
    public void reject() {
        if (exchange.isPresent()) {
            Instant time = Instant.now();
            stream.onNext(Message.newBuilder()
                    .setAck(
                            Ack.newBuilder()
                                    .setSubscription(subscription)
                                    .setReason(Ack.Reason.REJECT)
                                    .setUuid(UUID.randomUUID().toString())
                                    .setMetadata(createMetadata(time))
                                    .build())
                    .build());
        }
    }

    @Override
    public void reply(Exchange message) throws NotMessageCorrelationException {
        if (exchange.isPresent()) {
            Instant time = Instant.now();
            final Metadata metadata = message.getMetadata();
            final Metadata required = createMetadata(time);

            stream.onNext(Message.newBuilder()
                    .setExchange(message.toBuilder()
                            .setMetadata(
                                    metadata.toBuilder()
                                            .mergeFrom(required)
                                            .build()))
                    .build());
        } else {
            throw new NotMessageCorrelationException();
        }
    }

    @Override
    public Logger logger() {
        return this.system.log();
    }

    private Metadata createMetadata(Instant time) {
        Exchange exc = exchange.get();
        return Metadata.newBuilder()
                .setCorrelation(exc.getUuid())
                .setTopic(exc.getMetadata().getTopic())
                .setProducerId(exc.getMetadata().getProducerId())
                .putProperties(
                        SubscriptionContext.SOURCE_MESSAGE_TIME_NANOS,
                        String.valueOf(exc.getMetadata().getTimestamp().getNanos()))
                .putProperties(
                        SubscriptionContext.SOURCE_MESSAGE_TIME_SECONDS,
                        String.valueOf(exc.getMetadata().getTimestamp().getSeconds()))
                .setTimestamp(
                        Timestamp.newBuilder()
                                .setNanos(time.getNano())
                                .setSeconds(time.getEpochSecond())
                                .build())
                .build();
    }
}
