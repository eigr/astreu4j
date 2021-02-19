package io.eigr.astreu.subscriber;

import io.eigr.astreu.protocol.Message;

import java.util.Objects;

public final class MessageWithContext {
    private final IncomingType type;
    private final Message message;
    private final AcknowledgeContext context;

    public MessageWithContext(IncomingType type, AcknowledgeContext context, Message message) {
        this.type = type;
        this.context = context;
        this.message = message;
    }

    public IncomingType getType() {
        return type;
    }

    public <T> T getMessage() {
        Objects.requireNonNull(type, "Received invalid message type");

        switch (type) {
            case EXCHANGE:
                return (T) this.message.getExchange();
            case INFO:
                return (T) this.message.getSystem().getInfo();
            case FAILURE:
                return (T) this.message.getSystem().getFailure();
            default:
                throw new IllegalStateException("Received invalid message type");
        }

    }

    public AcknowledgeContext getContext() {
        return context;
    }

    public enum IncomingType {
        EXCHANGE, FAILURE, INFO
    }

    @Override
    public String toString() {
        return "MessageWithContext{" +
                "type=" + type +
                ", message=" + message +
                ", context=" + context +
                '}';
    }
}
