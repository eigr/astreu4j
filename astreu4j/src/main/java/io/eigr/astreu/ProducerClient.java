package io.eigr.astreu;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import io.eigr.astreu.publisher.ReplyMessage;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

import java.util.UUID;

class ProducerClient {

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
