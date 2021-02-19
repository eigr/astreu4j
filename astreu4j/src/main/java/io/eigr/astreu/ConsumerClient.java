package io.eigr.astreu;

import io.eigr.astreu.protocol.Exchange;
import io.eigr.astreu.subscriber.AcknowledgeContext;
import io.eigr.astreu.subscriber.MessageWithContext;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

class ConsumerClient {

    public static void main(final String[] args) {
        final Publisher<MessageWithContext> publisher =
                Astreu.at("127.0.0.1", 9980)
                        .asSub("test", "unique-subscription")
                        //.bindWithThrottle(1, Duration.ofSeconds(1), 2);
                        .bind(); //This create a org.reactivestreams.Publisher

        // Then use with any Reactive Streams framework (build-in with Project Reactor or Akka)
        Flux.from(publisher).subscribe(messageWithContext -> {
            final AcknowledgeContext context = messageWithContext.getContext();

            //Messages can be of some types: [Exchange, Info, Failure]
            context.logger().debug("Message type is -> {}", messageWithContext.getType());
            // For now I am assuming it is an Exchange, but you should check this out before doing this here
            final Exchange message = messageWithContext.getMessage();

            context.logger().info("Incoming Message {}", message);

            /* Request / Response pattern is supported
            context.reply(
                    Exchange.newBuilder()
                            .setUuid(UUID.randomUUID().toString())
                            .setMessage(
                                    Any.newBuilder()
                                    .setTypeUrl("your.custom.package.type/YourTypeHere")
                                    .setValue(ByteString.copyFrom("Hello I got your message".getBytes()))
                                    .build())
                            .build());

            */

            // Or simply confirm or reject the message
            context.accept(); // Send acknowledge or reject message with context.reject()
        });
    }
}
