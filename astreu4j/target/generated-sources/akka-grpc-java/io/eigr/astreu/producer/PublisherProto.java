// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: astreu/producer/publisher.proto

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
      "\n\037astreu/producer/publisher.proto\022\017astre" +
      "u.producer\032\036astreu/protocol/protocol.pro" +
      "to2P\n\tPublisher\022C\n\007Publish\022\030.astreu.prot" +
      "ocol.Message\032\030.astreu.protocol.Message\"\000" +
      "(\0010\001BG\n\027io.eigr.astreu.producerB\016Publish" +
      "erProtoH\001P\001\252\002\027Io.Eigr.Astreu.Producerb\006p" +
      "roto3"
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
