package io.eigr.astreu.publisher;

import akka.actor.typed.ActorSystem;
import io.eigr.astreu.MessageType;
import io.eigr.astreu.PublisherContext;
import io.eigr.astreu.protocol.Message;
import io.eigr.astreu.protocol.System;
import org.slf4j.Logger;

import java.util.Objects;

public final class ReplyMessage implements PublisherContext {

    private MessageType type;
    private final Message message;
    private final ActorSystem<Void> system;

    public ReplyMessage(ActorSystem<Void> system, Message message) {
        this.system = system;
        this.message = message;
        setType(message);
    }

    public MessageType getType() {
        return type;
    }

    public <T> T getMessage() {
        Objects.requireNonNull(type, "Received invalid message type");

        switch (type) {
            case ACK:
                return (T) this.message.getAck();
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

    @Override
    public Logger logger() {
        return this.system.log();
    }

    private void setType(Message message) {
        final Message.DataCase dataCase = message.getDataCase();
        switch (dataCase) {
            case EXCHANGE:
                this.type = MessageType.EXCHANGE;
                break;
            case SYSTEM:
                final System sys = message.getSystem();
                switch (sys.getDataCase()) {
                    case INFO:
                        type = MessageType.INFO;
                        break;
                    case FAILURE:
                        type = MessageType.FAILURE;
                        break;
                    default:
                        throw new IllegalStateException("Received invalid message type");
                }
                break;
            case ACK:
                type = MessageType.ACK;
                break;
            case DATA_NOT_SET:
                break;
            default:
                throw new IllegalStateException("Received invalid message type");
        }
    }

    @Override
    public String toString() {
        return "ReplyMessage{" +
                "type=" + type +
                ", message=" + message +
                '}';
    }
}
