package io.eigr.astreu.subscriber;

import io.eigr.astreu.protocol.Exchange;
import io.eigr.astreu.protocol.Failure;
import io.eigr.astreu.protocol.Info;
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

    public Object getMessage() {
        Objects.requireNonNull(type, "Received invalid message type");
        switch (type) {
            case EXCHANGE:
                return this.message.getExchange();
            case INFO:
                return this.message.getSystem().getInfo();
            case FAILURE:
                return this.message.getSystem().getFailure();
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
