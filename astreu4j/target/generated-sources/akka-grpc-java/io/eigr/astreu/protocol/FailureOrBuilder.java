// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: astreu/core/protocol/protocol.proto

package io.eigr.astreu.protocol;

public interface FailureOrBuilder extends
    // @@protoc_insertion_point(interface_extends:astreu.core.protocol.Failure)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string uuid = 1;</code>
   * @return The uuid.
   */
  java.lang.String getUuid();
  /**
   * <code>string uuid = 1;</code>
   * @return The bytes for uuid.
   */
  com.google.protobuf.ByteString
      getUuidBytes();

  /**
   * <code>string correlation = 2;</code>
   * @return The correlation.
   */
  java.lang.String getCorrelation();
  /**
   * <code>string correlation = 2;</code>
   * @return The bytes for correlation.
   */
  com.google.protobuf.ByteString
      getCorrelationBytes();

  /**
   * <code>string description = 3;</code>
   * @return The description.
   */
  java.lang.String getDescription();
  /**
   * <code>string description = 3;</code>
   * @return The bytes for description.
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <code>.google.protobuf.Timestamp timestamp = 4;</code>
   * @return Whether the timestamp field is set.
   */
  boolean hasTimestamp();
  /**
   * <code>.google.protobuf.Timestamp timestamp = 4;</code>
   * @return The timestamp.
   */
  com.google.protobuf.Timestamp getTimestamp();
  /**
   * <code>.google.protobuf.Timestamp timestamp = 4;</code>
   */
  com.google.protobuf.TimestampOrBuilder getTimestampOrBuilder();
}
