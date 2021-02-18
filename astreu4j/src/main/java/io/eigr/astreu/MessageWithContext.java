package io.eigr.astreu;

import io.eigr.astreu.protocol.Message;

public final class MessageWithContext {
    private Context context;
    private Message message;

    public MessageWithContext(Context context, Message message) {
        this.context = context;
        this.message = message;
    }

    public Context getContext() {
        return context;
    }

    public Message getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "MessageWithContext{" +
                "context=" + context +
                ", message=" + message +
                '}';
    }
}
