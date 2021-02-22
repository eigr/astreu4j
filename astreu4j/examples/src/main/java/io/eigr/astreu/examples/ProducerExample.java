package io.eigr.astreu.examples;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import io.eigr.astreu.Astreu;
import io.eigr.astreu.Producer;
import io.eigr.astreu.protocol.Ack;
import io.eigr.astreu.protocol.Exchange;
import io.eigr.astreu.protocol.Metadata;
import io.eigr.astreu.publisher.ReplyMessage;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;
import java.util.stream.IntStream;

class ProducerExample {

    public static void main(final String[] args) {

        final Producer producer =
                Astreu.at("127.0.0.1", 9980)
                        .asPub("test", UUID.randomUUID().toString().toLowerCase());

        final Publisher<ReplyMessage> publisher = producer.bind(); //This create a org.reactivestreams.Publisher

        // Then use with any Reactive Streams framework (build-in with Project Reactor or Akka)
        Flux.from(publisher).subscribe(replyMessage -> {
            //Messages can be of some types: [Ack, Exchange, Info, Failure]
            Metadata metadata;
            switch (replyMessage.getType()) {
                case ACK:
                    Ack ack = replyMessage.getMessage();
                    metadata = ack.getMetadata();
                    computeRtt(replyMessage.logger(), metadata);
                    break;
                case EXCHANGE:
                    Exchange exchange = replyMessage.getMessage();
                    metadata = exchange.getMetadata();
                    computeRtt(replyMessage.logger(), metadata);
                    break;
                case FAILURE:
                case INFO:
                    break;
            }

            replyMessage.logger().info("Reply Message -> {}", replyMessage);
        });

        IntStream.range(0, 2).parallel().forEach(i -> {
            producer.publish(
                    String.valueOf(i), //id of a message or use producer.publish(any) For automatic creation of UUID-based ids
                    Any.newBuilder()
                            .setTypeUrl("io.astreu.custom/Text")
                            .setValue(ByteString.copyFrom(String.format("Hello World Astreu %s", i).getBytes()))
                            .build()
            );
        });
    }

    private static void computeRtt(Logger logger, Metadata metadata) {
        final Map<String, String> properties = metadata.getPropertiesMap();
        if (properties.containsKey("source-time-seconds")) {
            long seconds = Long.valueOf(properties.get("source-time-seconds"));
            final Instant sourceInstant = Instant.ofEpochSecond(seconds);
            logger.info("Total RTT between send Message [{}] and Receive ACK in millis [{}]",
                            metadata.getCorrelation(),
                            Duration.between(sourceInstant, Instant.now()).toMillis());
        }
    }
}
