package io.eigr.astreu.subscriber;

import akka.actor.typed.ActorSystem;
import com.google.protobuf.Timestamp;
import io.eigr.astreu.SubscriptionContext;
import io.eigr.astreu.protocol.Ack;
import io.eigr.astreu.protocol.Exchange;
import io.eigr.astreu.protocol.Message;
import io.eigr.astreu.protocol.Metadata;
import org.slf4j.Logger;
import reactor.core.publisher.EmitterProcessor;

import java.time.Instant;
import java.util.UUID;

public final class AcknowledgeContext implements SubscriptionContext {

    private final Logger log;
    private final Exchange exchange;
    private final String subscription;
    private final EmitterProcessor<Message> stream;

    public AcknowledgeContext(ActorSystem<Void> system, String subscription, Exchange exchange, EmitterProcessor<Message> stream) {
        this.stream = stream;
        this.log = system.log();
        this.exchange = exchange;
        this.subscription = subscription;
    }

    @Override
    public void accept() {
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

    private Metadata createMetadata(Instant time) {
        return Metadata.newBuilder()
                .setCorrelation(exchange.getUuid())
                .setProducerId(exchange.getMetadata().getProducerId())
                .putProperties(
                        SubscriptionContext.SOURCE_MESSAGE_TIME_NANOS,
                        String.valueOf(exchange.getMetadata().getTimestamp().getNanos()))
                .putProperties(
                        SubscriptionContext.SOURCE_MESSAGE_TIME_SECONDS,
                        String.valueOf(exchange.getMetadata().getTimestamp().getSeconds()))
                .setTimestamp(
                        Timestamp.newBuilder()
                                .setNanos(time.getNano())
                                .setSeconds(time.getEpochSecond())
                                .build())
                .build();
    }

    @Override
    public void accept(String reason) {

    }

    @Override
    public void reject() {
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

    @Override
    public void reject(String reason) {

    }

    @Override
    public Logger getLogger() {
        return log;
    }
}
