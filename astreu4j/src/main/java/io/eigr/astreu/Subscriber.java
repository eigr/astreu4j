package io.eigr.astreu;

import io.eigr.astreu.subscriber.MessageWithContext;

import org.reactivestreams.Publisher;

import java.time.Duration;

public interface Subscriber {

    Publisher<MessageWithContext> bind();
    Publisher<MessageWithContext> bindWithThrottle(int elements, Duration per, int maximumBurst);

}
