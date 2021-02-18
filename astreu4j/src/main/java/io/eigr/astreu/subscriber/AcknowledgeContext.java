package io.eigr.astreu.subscriber;

import io.eigr.astreu.SubscriptionContext;
import io.eigr.astreu.protocol.Message;
import reactor.core.publisher.EmitterProcessor;

public final class AcknowledgeContext implements SubscriptionContext {

    private final Message message;
    private final EmitterProcessor<Message> stream;

    public AcknowledgeContext(Message message, EmitterProcessor<Message> stream) {
        this.message = message;
        this.stream = stream;
    }

    @Override
    public void accept() {

    }

    @Override
    public void accept(String reason) {

    }

    @Override
    public void reject() {

    }

    @Override
    public void reject(String reason) {

    }
}
