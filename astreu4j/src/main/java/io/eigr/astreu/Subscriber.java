package io.eigr.astreu;

import io.eigr.astreu.subscriber.MessageWithContext;
import org.reactivestreams.Publisher;

public interface Subscriber {

    Publisher<MessageWithContext> bind();
}
