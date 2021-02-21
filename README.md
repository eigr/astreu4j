# Astreu4j
Astreu Java client

[![Maven Build](https://github.com/eigr/astreu4j/actions/workflows/maven.yml/badge.svg)](https://github.com/eigr/astreu4j/actions/workflows/maven.yml) [![Maven Release](https://github.com/eigr/astreu4j/actions/workflows/release.yml/badge.svg)](https://github.com/eigr/astreu4j/actions/workflows/release.yml)

## Usage

Create Subscriber

```java
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

```

Create Publisher

```java
package io.eigr.astreu.examples;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import io.eigr.astreu.Astreu;
import io.eigr.astreu.Producer;
import io.eigr.astreu.publisher.ReplyMessage;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

import java.util.UUID;

class ProducerExample {

    public static void main(final String[] args) {

        final Producer producer =
                Astreu.at("127.0.0.1", 9980)
                .asPub("test", UUID.randomUUID().toString().toLowerCase());

        final Publisher<ReplyMessage> publisher = producer.bind(); //This create a org.reactivestreams.Publisher

        // Then use with any Reactive Streams framework (build-in with Project Reactor or Akka)
        Flux.from(publisher).subscribe(replyMessage -> {
            //Messages can be of some types: [Ack, Exchange, Info, Failure]
            replyMessage.logger().info("Reply Message -> {}", replyMessage);
        });

        for (int i = 0; i < 500000; i++) {
            producer.publish(
                    String.valueOf(i), //id of a message or use producer.publish(any) For automatic creation of UUID-based ids
                    Any.newBuilder()
                            .setTypeUrl("io.astreu.custom/Text")
                            .setValue(ByteString.copyFrom(String.format("Hello World Astreu %s", i).getBytes()))
                            .build()
            );
        }
    }
}

```
