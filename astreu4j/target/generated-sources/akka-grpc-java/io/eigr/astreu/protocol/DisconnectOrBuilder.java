// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: astreu/core/protocol/protocol.proto

package io.eigr.astreu.protocol;

public interface DisconnectOrBuilder extends
    // @@protoc_insertion_point(interface_extends:astreu.core.protocol.Disconnect)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Unique identifier
   * </pre>
   *
   * <code>string uuid = 1;</code>
   * @return The uuid.
   */
  java.lang.String getUuid();
  /**
   * <pre>
   * Unique identifier
   * </pre>
   *
   * <code>string uuid = 1;</code>
   * @return The bytes for uuid.
   */
  com.google.protobuf.ByteString
      getUuidBytes();

  /**
   * <pre>
   * name of a topic to register
   * </pre>
   *
   * <code>string topic = 2;</code>
   * @return The topic.
   */
  java.lang.String getTopic();
  /**
   * <pre>
   * name of a topic to register
   * </pre>
   *
   * <code>string topic = 2;</code>
   * @return The bytes for topic.
   */
  com.google.protobuf.ByteString
      getTopicBytes();

  /**
   * <pre>
   * name of subscription. (both consumers and producers must provide a unique registration name )
   * </pre>
   *
   * <code>string subscription = 3;</code>
   * @return The subscription.
   */
  java.lang.String getSubscription();
  /**
   * <pre>
   * name of subscription. (both consumers and producers must provide a unique registration name )
   * </pre>
   *
   * <code>string subscription = 3;</code>
   * @return The bytes for subscription.
   */
  com.google.protobuf.ByteString
      getSubscriptionBytes();

  /**
   * <pre>
   * Moment of message creation
   * </pre>
   *
   * <code>.google.protobuf.Timestamp timestamp = 4;</code>
   * @return Whether the timestamp field is set.
   */
  boolean hasTimestamp();
  /**
   * <pre>
   * Moment of message creation
   * </pre>
   *
   * <code>.google.protobuf.Timestamp timestamp = 4;</code>
   * @return The timestamp.
   */
  com.google.protobuf.Timestamp getTimestamp();
  /**
   * <pre>
   * Moment of message creation
   * </pre>
   *
   * <code>.google.protobuf.Timestamp timestamp = 4;</code>
   */
  com.google.protobuf.TimestampOrBuilder getTimestampOrBuilder();
}
