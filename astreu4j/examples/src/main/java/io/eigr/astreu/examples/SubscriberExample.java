package io.eigr.astreu.examples;

import io.eigr.astreu.Astreu;
import io.eigr.astreu.protocol.Exchange;
import io.eigr.astreu.subscriber.AcknowledgeContext;
import io.eigr.astreu.subscriber.MessageWithContext;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

class SubscriberExample {

    public static void main(final String[] args) {
        final Publisher<MessageWithContext> publisher =
                Astreu.at("127.0.0.1", 9980)
                        .asSub("test", "unique-subscription")

                        // You can use some filter options during receive messages
                        //.filter(msg -> true)
                        //.receiveOnly(MessageType.EXCHANGE)

                        //.bindWithThrottle(1, Duration.ofSeconds(1), 2);
                        .bind(); //This create a org.reactivestreams.Publisher

        // Then use with any Reactive Streams framework (build-in with Project Reactor or Akka)
        Flux.from(publisher).subscribe(messageWithContext -> {
            final AcknowledgeContext context = messageWithContext.getContext();

            //Messages can be of some types: [Exchange, Info, Failure]
            context.logger().debug("Message type is -> {}", messageWithContext.getType());
            // I am assuming it is an Exchange, but you should check this out before doing this here
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
