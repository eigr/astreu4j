package io.eigr.astreu;

import com.google.protobuf.Any;
import io.eigr.astreu.publisher.ReplyMessage;
import org.reactivestreams.Publisher;

import java.util.Map;

public interface Producer {

    Publisher<ReplyMessage> bind();
    void publish(Any message);
    void publish(String id, Any message);
    void publish(Any message, Map<String, String> metadataProperties);
    void publish(String id, Any message, Map<String, String> metadataProperties);
}
