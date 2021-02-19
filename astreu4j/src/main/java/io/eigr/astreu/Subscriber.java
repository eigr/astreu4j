package io.eigr.astreu;

import io.eigr.astreu.subscriber.MessageWithContext;

import org.reactivestreams.Publisher;

import java.time.Duration;
import java.util.function.Predicate;

public interface Subscriber {
    Subscriber receiveOnly(MessageWithContext.IncomingType... types);

    Subscriber filter(Predicate<MessageWithContext> predicate);

    Publisher<MessageWithContext> bind();

    Publisher<MessageWithContext> bindWithThrottle(int elements, Duration per, int maximumBurst);
}
