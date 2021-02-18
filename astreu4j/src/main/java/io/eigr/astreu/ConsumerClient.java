package io.eigr.astreu;

import io.eigr.astreu.subscriber.AcknowledgeContext;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

class ConsumerClient {

    public static void main(final String[] args) {
        final Publisher<MessageWithContext> publisher =
                Astreu.at("127.0.0.1", 9980)
                        .asSub("test", "test1")
                        .bind();

        Flux.from(publisher).subscribe(messageWithContext -> {
            AcknowledgeContext ackCtx = (AcknowledgeContext) messageWithContext
                    .getContext();

            ackCtx.getLogger().info("In Exchange Message {}", messageWithContext.getExchange());
            ackCtx.accept();
        });
    }
}
