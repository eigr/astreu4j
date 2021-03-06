// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: astreu/core/protocol/protocol.proto

package io.eigr.astreu.protocol;

/**
 * <pre>
 * Exchange is a type of message used to exchange information between producers and consumers.
 * It has a uuid field, a metadata field (see Metadata) and an attribute containing the message payload.
 * </pre>
 *
 * Protobuf type {@code astreu.core.protocol.Exchange}
 */
public  final class Exchange extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:astreu.core.protocol.Exchange)
    ExchangeOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Exchange.newBuilder() to construct.
  private Exchange(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Exchange() {
    uuid_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Exchange();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Exchange(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            uuid_ = s;
            break;
          }
          case 18: {
            io.eigr.astreu.protocol.Metadata.Builder subBuilder = null;
            if (metadata_ != null) {
              subBuilder = metadata_.toBuilder();
            }
            metadata_ = input.readMessage(io.eigr.astreu.protocol.Metadata.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(metadata_);
              metadata_ = subBuilder.buildPartial();
            }

            break;
          }
          case 26: {
            com.google.protobuf.Any.Builder subBuilder = null;
            if (message_ != null) {
              subBuilder = message_.toBuilder();
            }
            message_ = input.readMessage(com.google.protobuf.Any.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(message_);
              message_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.eigr.astreu.protocol.ProtocolProto.internal_static_astreu_core_protocol_Exchange_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.eigr.astreu.protocol.ProtocolProto.internal_static_astreu_core_protocol_Exchange_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.eigr.astreu.protocol.Exchange.class, io.eigr.astreu.protocol.Exchange.Builder.class);
  }

  public static final int UUID_FIELD_NUMBER = 1;
  private volatile java.lang.Object uuid_;
  /**
   * <pre>
   * Unique identifier of a ack message.
   * </pre>
   *
   * <code>string uuid = 1;</code>
   * @return The uuid.
   */
  public java.lang.String getUuid() {
    java.lang.Object ref = uuid_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      uuid_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * Unique identifier of a ack message.
   * </pre>
   *
   * <code>string uuid = 1;</code>
   * @return The bytes for uuid.
   */
  public com.google.protobuf.ByteString
      getUuidBytes() {
    java.lang.Object ref = uuid_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      uuid_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int METADATA_FIELD_NUMBER = 2;
  private io.eigr.astreu.protocol.Metadata metadata_;
  /**
   * <pre>
   * Metadata. Must contain the Timestamp of creation of this message.
   * </pre>
   *
   * <code>.astreu.core.protocol.Metadata metadata = 2;</code>
   * @return Whether the metadata field is set.
   */
  public boolean hasMetadata() {
    return metadata_ != null;
  }
  /**
   * <pre>
   * Metadata. Must contain the Timestamp of creation of this message.
   * </pre>
   *
   * <code>.astreu.core.protocol.Metadata metadata = 2;</code>
   * @return The metadata.
   */
  public io.eigr.astreu.protocol.Metadata getMetadata() {
    return metadata_ == null ? io.eigr.astreu.protocol.Metadata.getDefaultInstance() : metadata_;
  }
  /**
   * <pre>
   * Metadata. Must contain the Timestamp of creation of this message.
   * </pre>
   *
   * <code>.astreu.core.protocol.Metadata metadata = 2;</code>
   */
  public io.eigr.astreu.protocol.MetadataOrBuilder getMetadataOrBuilder() {
    return getMetadata();
  }

  public static final int MESSAGE_FIELD_NUMBER = 3;
  private com.google.protobuf.Any message_;
  /**
   * <pre>
   * Payload of this message.
   * </pre>
   *
   * <code>.google.protobuf.Any message = 3;</code>
   * @return Whether the message field is set.
   */
  public boolean hasMessage() {
    return message_ != null;
  }
  /**
   * <pre>
   * Payload of this message.
   * </pre>
   *
   * <code>.google.protobuf.Any message = 3;</code>
   * @return The message.
   */
  public com.google.protobuf.Any getMessage() {
    return message_ == null ? com.google.protobuf.Any.getDefaultInstance() : message_;
  }
  /**
   * <pre>
   * Payload of this message.
   * </pre>
   *
   * <code>.google.protobuf.Any message = 3;</code>
   */
  public com.google.protobuf.AnyOrBuilder getMessageOrBuilder() {
    return getMessage();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getUuidBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, uuid_);
    }
    if (metadata_ != null) {
      output.writeMessage(2, getMetadata());
    }
    if (message_ != null) {
      output.writeMessage(3, getMessage());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getUuidBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, uuid_);
    }
    if (metadata_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getMetadata());
    }
    if (message_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getMessage());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.eigr.astreu.protocol.Exchange)) {
      return super.equals(obj);
    }
    io.eigr.astreu.protocol.Exchange other = (io.eigr.astreu.protocol.Exchange) obj;

    if (!getUuid()
        .equals(other.getUuid())) return false;
    if (hasMetadata() != other.hasMetadata()) return false;
    if (hasMetadata()) {
      if (!getMetadata()
          .equals(other.getMetadata())) return false;
    }
    if (hasMessage() != other.hasMessage()) return false;
    if (hasMessage()) {
      if (!getMessage()
          .equals(other.getMessage())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + UUID_FIELD_NUMBER;
    hash = (53 * hash) + getUuid().hashCode();
    if (hasMetadata()) {
      hash = (37 * hash) + METADATA_FIELD_NUMBER;
      hash = (53 * hash) + getMetadata().hashCode();
    }
    if (hasMessage()) {
      hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
      hash = (53 * hash) + getMessage().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.eigr.astreu.protocol.Exchange parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.eigr.astreu.protocol.Exchange parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.eigr.astreu.protocol.Exchange parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.eigr.astreu.protocol.Exchange parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.eigr.astreu.protocol.Exchange parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.eigr.astreu.protocol.Exchange parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.eigr.astreu.protocol.Exchange parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.eigr.astreu.protocol.Exchange parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.eigr.astreu.protocol.Exchange parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.eigr.astreu.protocol.Exchange parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.eigr.astreu.protocol.Exchange parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.eigr.astreu.protocol.Exchange parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.eigr.astreu.protocol.Exchange prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Exchange is a type of message used to exchange information between producers and consumers.
   * It has a uuid field, a metadata field (see Metadata) and an attribute containing the message payload.
   * </pre>
   *
   * Protobuf type {@code astreu.core.protocol.Exchange}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:astreu.core.protocol.Exchange)
      io.eigr.astreu.protocol.ExchangeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.eigr.astreu.protocol.ProtocolProto.internal_static_astreu_core_protocol_Exchange_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.eigr.astreu.protocol.ProtocolProto.internal_static_astreu_core_protocol_Exchange_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.eigr.astreu.protocol.Exchange.class, io.eigr.astreu.protocol.Exchange.Builder.class);
    }

    // Construct using io.eigr.astreu.protocol.Exchange.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      uuid_ = "";

      if (metadataBuilder_ == null) {
        metadata_ = null;
      } else {
        metadata_ = null;
        metadataBuilder_ = null;
      }
      if (messageBuilder_ == null) {
        message_ = null;
      } else {
        message_ = null;
        messageBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.eigr.astreu.protocol.ProtocolProto.internal_static_astreu_core_protocol_Exchange_descriptor;
    }

    @java.lang.Override
    public io.eigr.astreu.protocol.Exchange getDefaultInstanceForType() {
      return io.eigr.astreu.protocol.Exchange.getDefaultInstance();
    }

    @java.lang.Override
    public io.eigr.astreu.protocol.Exchange build() {
      io.eigr.astreu.protocol.Exchange result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.eigr.astreu.protocol.Exchange buildPartial() {
      io.eigr.astreu.protocol.Exchange result = new io.eigr.astreu.protocol.Exchange(this);
      result.uuid_ = uuid_;
      if (metadataBuilder_ == null) {
        result.metadata_ = metadata_;
      } else {
        result.metadata_ = metadataBuilder_.build();
      }
      if (messageBuilder_ == null) {
        result.message_ = message_;
      } else {
        result.message_ = messageBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.eigr.astreu.protocol.Exchange) {
        return mergeFrom((io.eigr.astreu.protocol.Exchange)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.eigr.astreu.protocol.Exchange other) {
      if (other == io.eigr.astreu.protocol.Exchange.getDefaultInstance()) return this;
      if (!other.getUuid().isEmpty()) {
        uuid_ = other.uuid_;
        onChanged();
      }
      if (other.hasMetadata()) {
        mergeMetadata(other.getMetadata());
      }
      if (other.hasMessage()) {
        mergeMessage(other.getMessage());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      io.eigr.astreu.protocol.Exchange parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.eigr.astreu.protocol.Exchange) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object uuid_ = "";
    /**
     * <pre>
     * Unique identifier of a ack message.
     * </pre>
     *
     * <code>string uuid = 1;</code>
     * @return The uuid.
     */
    public java.lang.String getUuid() {
      java.lang.Object ref = uuid_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        uuid_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * Unique identifier of a ack message.
     * </pre>
     *
     * <code>string uuid = 1;</code>
     * @return The bytes for uuid.
     */
    public com.google.protobuf.ByteString
        getUuidBytes() {
      java.lang.Object ref = uuid_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        uuid_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * Unique identifier of a ack message.
     * </pre>
     *
     * <code>string uuid = 1;</code>
     * @param value The uuid to set.
     * @return This builder for chaining.
     */
    public Builder setUuid(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      uuid_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Unique identifier of a ack message.
     * </pre>
     *
     * <code>string uuid = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearUuid() {
      
      uuid_ = getDefaultInstance().getUuid();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Unique identifier of a ack message.
     * </pre>
     *
     * <code>string uuid = 1;</code>
     * @param value The bytes for uuid to set.
     * @return This builder for chaining.
     */
    public Builder setUuidBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      uuid_ = value;
      onChanged();
      return this;
    }

    private io.eigr.astreu.protocol.Metadata metadata_;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.eigr.astreu.protocol.Metadata, io.eigr.astreu.protocol.Metadata.Builder, io.eigr.astreu.protocol.MetadataOrBuilder> metadataBuilder_;
    /**
     * <pre>
     * Metadata. Must contain the Timestamp of creation of this message.
     * </pre>
     *
     * <code>.astreu.core.protocol.Metadata metadata = 2;</code>
     * @return Whether the metadata field is set.
     */
    public boolean hasMetadata() {
      return metadataBuilder_ != null || metadata_ != null;
    }
    /**
     * <pre>
     * Metadata. Must contain the Timestamp of creation of this message.
     * </pre>
     *
     * <code>.astreu.core.protocol.Metadata metadata = 2;</code>
     * @return The metadata.
     */
    public io.eigr.astreu.protocol.Metadata getMetadata() {
      if (metadataBuilder_ == null) {
        return metadata_ == null ? io.eigr.astreu.protocol.Metadata.getDefaultInstance() : metadata_;
      } else {
        return metadataBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * Metadata. Must contain the Timestamp of creation of this message.
     * </pre>
     *
     * <code>.astreu.core.protocol.Metadata metadata = 2;</code>
     */
    public Builder setMetadata(io.eigr.astreu.protocol.Metadata value) {
      if (metadataBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        metadata_ = value;
        onChanged();
      } else {
        metadataBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * Metadata. Must contain the Timestamp of creation of this message.
     * </pre>
     *
     * <code>.astreu.core.protocol.Metadata metadata = 2;</code>
     */
    public Builder setMetadata(
        io.eigr.astreu.protocol.Metadata.Builder builderForValue) {
      if (metadataBuilder_ == null) {
        metadata_ = builderForValue.build();
        onChanged();
      } else {
        metadataBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * Metadata. Must contain the Timestamp of creation of this message.
     * </pre>
     *
     * <code>.astreu.core.protocol.Metadata metadata = 2;</code>
     */
    public Builder mergeMetadata(io.eigr.astreu.protocol.Metadata value) {
      if (metadataBuilder_ == null) {
        if (metadata_ != null) {
          metadata_ =
            io.eigr.astreu.protocol.Metadata.newBuilder(metadata_).mergeFrom(value).buildPartial();
        } else {
          metadata_ = value;
        }
        onChanged();
      } else {
        metadataBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * Metadata. Must contain the Timestamp of creation of this message.
     * </pre>
     *
     * <code>.astreu.core.protocol.Metadata metadata = 2;</code>
     */
    public Builder clearMetadata() {
      if (metadataBuilder_ == null) {
        metadata_ = null;
        onChanged();
      } else {
        metadata_ = null;
        metadataBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * Metadata. Must contain the Timestamp of creation of this message.
     * </pre>
     *
     * <code>.astreu.core.protocol.Metadata metadata = 2;</code>
     */
    public io.eigr.astreu.protocol.Metadata.Builder getMetadataBuilder() {
      
      onChanged();
      return getMetadataFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * Metadata. Must contain the Timestamp of creation of this message.
     * </pre>
     *
     * <code>.astreu.core.protocol.Metadata metadata = 2;</code>
     */
    public io.eigr.astreu.protocol.MetadataOrBuilder getMetadataOrBuilder() {
      if (metadataBuilder_ != null) {
        return metadataBuilder_.getMessageOrBuilder();
      } else {
        return metadata_ == null ?
            io.eigr.astreu.protocol.Metadata.getDefaultInstance() : metadata_;
      }
    }
    /**
     * <pre>
     * Metadata. Must contain the Timestamp of creation of this message.
     * </pre>
     *
     * <code>.astreu.core.protocol.Metadata metadata = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.eigr.astreu.protocol.Metadata, io.eigr.astreu.protocol.Metadata.Builder, io.eigr.astreu.protocol.MetadataOrBuilder> 
        getMetadataFieldBuilder() {
      if (metadataBuilder_ == null) {
        metadataBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.eigr.astreu.protocol.Metadata, io.eigr.astreu.protocol.Metadata.Builder, io.eigr.astreu.protocol.MetadataOrBuilder>(
                getMetadata(),
                getParentForChildren(),
                isClean());
        metadata_ = null;
      }
      return metadataBuilder_;
    }

    private com.google.protobuf.Any message_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> messageBuilder_;
    /**
     * <pre>
     * Payload of this message.
     * </pre>
     *
     * <code>.google.protobuf.Any message = 3;</code>
     * @return Whether the message field is set.
     */
    public boolean hasMessage() {
      return messageBuilder_ != null || message_ != null;
    }
    /**
     * <pre>
     * Payload of this message.
     * </pre>
     *
     * <code>.google.protobuf.Any message = 3;</code>
     * @return The message.
     */
    public com.google.protobuf.Any getMessage() {
      if (messageBuilder_ == null) {
        return message_ == null ? com.google.protobuf.Any.getDefaultInstance() : message_;
      } else {
        return messageBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * Payload of this message.
     * </pre>
     *
     * <code>.google.protobuf.Any message = 3;</code>
     */
    public Builder setMessage(com.google.protobuf.Any value) {
      if (messageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        message_ = value;
        onChanged();
      } else {
        messageBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * Payload of this message.
     * </pre>
     *
     * <code>.google.protobuf.Any message = 3;</code>
     */
    public Builder setMessage(
        com.google.protobuf.Any.Builder builderForValue) {
      if (messageBuilder_ == null) {
        message_ = builderForValue.build();
        onChanged();
      } else {
        messageBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * Payload of this message.
     * </pre>
     *
     * <code>.google.protobuf.Any message = 3;</code>
     */
    public Builder mergeMessage(com.google.protobuf.Any value) {
      if (messageBuilder_ == null) {
        if (message_ != null) {
          message_ =
            com.google.protobuf.Any.newBuilder(message_).mergeFrom(value).buildPartial();
        } else {
          message_ = value;
        }
        onChanged();
      } else {
        messageBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * Payload of this message.
     * </pre>
     *
     * <code>.google.protobuf.Any message = 3;</code>
     */
    public Builder clearMessage() {
      if (messageBuilder_ == null) {
        message_ = null;
        onChanged();
      } else {
        message_ = null;
        messageBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * Payload of this message.
     * </pre>
     *
     * <code>.google.protobuf.Any message = 3;</code>
     */
    public com.google.protobuf.Any.Builder getMessageBuilder() {
      
      onChanged();
      return getMessageFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * Payload of this message.
     * </pre>
     *
     * <code>.google.protobuf.Any message = 3;</code>
     */
    public com.google.protobuf.AnyOrBuilder getMessageOrBuilder() {
      if (messageBuilder_ != null) {
        return messageBuilder_.getMessageOrBuilder();
      } else {
        return message_ == null ?
            com.google.protobuf.Any.getDefaultInstance() : message_;
      }
    }
    /**
     * <pre>
     * Payload of this message.
     * </pre>
     *
     * <code>.google.protobuf.Any message = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> 
        getMessageFieldBuilder() {
      if (messageBuilder_ == null) {
        messageBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder>(
                getMessage(),
                getParentForChildren(),
                isClean());
        message_ = null;
      }
      return messageBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:astreu.core.protocol.Exchange)
  }

  // @@protoc_insertion_point(class_scope:astreu.core.protocol.Exchange)
  private static final io.eigr.astreu.protocol.Exchange DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.eigr.astreu.protocol.Exchange();
  }

  public static io.eigr.astreu.protocol.Exchange getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Exchange>
      PARSER = new com.google.protobuf.AbstractParser<Exchange>() {
    @java.lang.Override
    public Exchange parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Exchange(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Exchange> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Exchange> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.eigr.astreu.protocol.Exchange getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

