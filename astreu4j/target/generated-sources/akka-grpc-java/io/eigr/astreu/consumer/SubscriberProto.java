// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: astreu/consumer/subscriber.proto

package io.eigr.astreu.consumer;

public final class SubscriberProto {
  private SubscriberProto() {}
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
      "\n astreu/consumer/subscriber.proto\022\017astr" +
      "eu.consumer\032\036astreu/protocol/protocol.pr" +
      "oto\032\033google/protobuf/empty.proto2\226\001\n\nSub" +
      "scriber\022E\n\tSubscribe\022\030.astreu.protocol.M" +
      "essage\032\030.astreu.protocol.Message\"\000(\0010\001\022A" +
      "\n\013Unsubscribe\022\030.astreu.protocol.Message\032" +
      "\026.google.protobuf.Empty\"\000BH\n\027io.eigr.ast" +
      "reu.consumerB\017SubscriberProtoH\001P\001\252\002\027Io.E" +
      "igr.Astreu.Consumerb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          io.eigr.astreu.protocol.ProtocolProto.getDescriptor(),
          com.google.protobuf.EmptyProto.getDescriptor(),
        });
    io.eigr.astreu.protocol.ProtocolProto.getDescriptor();
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
