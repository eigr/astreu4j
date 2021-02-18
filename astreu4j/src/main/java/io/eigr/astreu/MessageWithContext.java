package io.eigr.astreu;

import io.eigr.astreu.protocol.Exchange;

public final class MessageWithContext {
    private Context context;
    private Exchange exchange;

    public MessageWithContext(Context context, Exchange exchange) {
        this.context = context;
        this.exchange = exchange;
    }

    public Context getContext() {
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
