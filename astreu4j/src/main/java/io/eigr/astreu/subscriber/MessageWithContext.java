package io.eigr.astreu.subscriber;

import io.eigr.astreu.Context;
import io.eigr.astreu.protocol.Exchange;

public final class MessageWithContext {
    private Exchange exchange;
    private AcknowledgeContext context;

    public MessageWithContext(AcknowledgeContext context, Exchange exchange) {
        this.context = context;
        this.exchange = exchange;
    }

    public AcknowledgeContext getContext() {
        return context;
    }

    public Exchange getExchange() {
        return exchange;
    }

    @Override
    public String toString() {
        return "MessageWithContext{" +
                "context=" + context +
                ", exchange=" + exchange +
                '}';
    }
}
