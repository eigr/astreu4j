// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: astreu/core/protocol/producer/publisher.proto

package io.eigr.astreu.producer;

public final class PublisherProto {
  private PublisherProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n-astreu/core/protocol/producer/publishe" +
      "r.proto\022\035astreu.core.protocol.producer\032#" +
      "astreu/core/protocol/protocol.proto2Z\n\tP" +
      "ublisher\022M\n\007Publish\022\035.astreu.core.protoc" +
      "ol.Message\032\035.astreu.core.protocol.Messag" +
      "e\"\000(\0010\001BG\n\027io.eigr.astreu.producerB\016Publ" +
      "isherProtoH\001P\001\252\002\027Io.Eigr.Astreu.Producer" +
      "b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          io.eigr.astreu.protocol.ProtocolProto.getDescriptor(),
        });
    io.eigr.astreu.protocol.ProtocolProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
