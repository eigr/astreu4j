package io.eigr.astreu;

import org.reactivestreams.Publisher;

public interface Subscriber {

    Publisher<MessageWithContext> bind();
}
