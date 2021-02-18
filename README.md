# astreu4j
Astreu Java client

## Usage

Create Subscriber

```java
package io.eigr.astreu;

import io.eigr.astreu.subscriber.AcknowledgeContext;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

class ConsumerClient {

    public static void main(final String[] args) {
        final Publisher<MessageWithContext> publisher =
                Astreu.at("127.0.0.1", 9980)
                        .asSub("test", "test1")
                        .bind(); //This create a org.reactivestreams.Publisher
        
        // Then use with any Reactive Streams framework (build-in with Project Reactor or Akka)
        Flux.from(publisher).subscribe(messageWithContext -> {
            AcknowledgeContext ackCtx = (AcknowledgeContext) messageWithContext
                    .getContext();

            ackCtx.getLogger().info("In Exchange Message {}", messageWithContext.getExchange());
            ackCtx.accept(); // Send acknowledge or reject message with ackCtx.reject()
        });
    }
}

```

Create Publisher

```
```
