
// Generated by Akka gRPC. DO NOT EDIT.
package io.eigr.astreu.consumer;


import akka.grpc.javadsl.StreamResponseRequestBuilder;
import akka.grpc.javadsl.SingleResponseRequestBuilder;


public abstract class SubscriberClientPowerApi {
  
    /**
     * Lower level "lifted" version of the method, giving access to request metadata etc.
     * prefer subscribe(io.eigr.astreu.protocol.Message) if possible.
     */
    
      public StreamResponseRequestBuilder<akka.stream.javadsl.Source<io.eigr.astreu.protocol.Message, akka.NotUsed>, io.eigr.astreu.protocol.Message> subscribe()
    
    {
        throw new java.lang.UnsupportedOperationException();
    }
  
    /**
     * Lower level "lifted" version of the method, giving access to request metadata etc.
     * prefer unsubscribe(io.eigr.astreu.protocol.Message) if possible.
     */
    
      public SingleResponseRequestBuilder<io.eigr.astreu.protocol.Message, com.google.protobuf.Empty> unsubscribe()
    
    {
        throw new java.lang.UnsupportedOperationException();
    }
  
}
