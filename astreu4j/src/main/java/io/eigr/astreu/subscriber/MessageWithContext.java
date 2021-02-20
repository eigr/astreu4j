package io.eigr.astreu.subscriber;

import io.eigr.astreu.MessageType;
import io.eigr.astreu.protocol.Message;

import java.util.Objects;

public final class MessageWithContext {
    private final Message message;
    private final MessageType type;
    private final AcknowledgeContext context;

    public MessageWithContext(MessageType type, AcknowledgeContext context, Message message) {
        this.type = type;
        this.context = context;
        this.message = message;
    }

    public MessageType getType() {
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

    @Override
    public String toString() {
        return "MessageWithContext{" +
                "type=" + type +
                ", message=" + message +
                ", context=" + context +
                '}';
    }
}
