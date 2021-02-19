package io.eigr.astreu;

import io.eigr.astreu.subscriber.AcknowledgeContext;
import io.eigr.astreu.subscriber.MessageWithContext;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

class ConsumerClient {

    public static void main(final String[] args) {
        final Publisher<MessageWithContext> publisher =
                Astreu.at("127.0.0.1", 9980)
                        .asSub("test", "unique-subscription")
                        .bind(); //This create a org.reactivestreams.Publisher

        // Then use with any Reactive Streams framework (build-in with Project Reactor or Akka)
        Flux.from(publisher).subscribe(messageWithContext -> {
            final AcknowledgeContext context = messageWithContext.getContext();
            context.logger().info("Incoming Message {}", messageWithContext.getMessage());
            context.accept(); // Send acknowledge or reject message with ackCtx.reject()
        });
    }
}
