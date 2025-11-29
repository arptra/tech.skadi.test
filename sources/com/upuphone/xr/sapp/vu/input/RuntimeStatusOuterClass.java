package com.upuphone.xr.sapp.vu.input;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class RuntimeStatusOuterClass {

    /* renamed from: a  reason: collision with root package name */
    public static final Descriptors.Descriptor f8075a;
    public static final GeneratedMessageV3.FieldAccessorTable b;
    public static Descriptors.FileDescriptor c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013RuntimeStatus.proto\u0012\u001dcom.upuphone.xr.sapp.vu.input\"\u001c\n\rRuntimeStatus\u0012\u000b\n\u0003fps\u0018\u0001 \u0001(\u0002b\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    public static final class RuntimeStatus extends GeneratedMessageV3 implements RuntimeStatusOrBuilder {
        private static final RuntimeStatus DEFAULT_INSTANCE = new RuntimeStatus();
        public static final int FPS_FIELD_NUMBER = 1;
        private static final Parser<RuntimeStatus> PARSER = new AbstractParser<RuntimeStatus>() {
            /* renamed from: a */
            public RuntimeStatus parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Builder newBuilder = RuntimeStatus.newBuilder();
                try {
                    newBuilder.mergeFrom(codedInputStream, extensionRegistryLite);
                    return newBuilder.buildPartial();
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(newBuilder.buildPartial());
                } catch (UninitializedMessageException e2) {
                    throw e2.asInvalidProtocolBufferException().setUnfinishedMessage(newBuilder.buildPartial());
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3).setUnfinishedMessage(newBuilder.buildPartial());
                }
            }
        };
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public float fps_;
        private byte memoizedIsInitialized;

        public static RuntimeStatus getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return RuntimeStatusOuterClass.f8075a;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static RuntimeStatus parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RuntimeStatus) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static RuntimeStatus parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<RuntimeStatus> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof RuntimeStatus)) {
                return super.equals(obj);
            }
            RuntimeStatus runtimeStatus = (RuntimeStatus) obj;
            return Float.floatToIntBits(getFps()) == Float.floatToIntBits(runtimeStatus.getFps()) && getUnknownFields().equals(runtimeStatus.getUnknownFields());
        }

        public float getFps() {
            return this.fps_;
        }

        public Parser<RuntimeStatus> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeFloatSize = (Float.floatToRawIntBits(this.fps_) != 0 ? CodedOutputStream.computeFloatSize(1, this.fps_) : 0) + getUnknownFields().getSerializedSize();
            this.memoizedSize = computeFloatSize;
            return computeFloatSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Float.floatToIntBits(getFps())) * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RuntimeStatusOuterClass.b.ensureFieldAccessorsInitialized(RuntimeStatus.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new RuntimeStatus();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (Float.floatToRawIntBits(this.fps_) != 0) {
                codedOutputStream.writeFloat(1, this.fps_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RuntimeStatusOrBuilder {
            private int bitField0_;
            private float fps_;

            private void buildPartial0(RuntimeStatus runtimeStatus) {
                if ((this.bitField0_ & 1) != 0) {
                    runtimeStatus.fps_ = this.fps_;
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return RuntimeStatusOuterClass.f8075a;
            }

            public Builder clearFps() {
                this.bitField0_ &= -2;
                this.fps_ = 0.0f;
                onChanged();
                return this;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return RuntimeStatusOuterClass.f8075a;
            }

            public float getFps() {
                return this.fps_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RuntimeStatusOuterClass.b.ensureFieldAccessorsInitialized(RuntimeStatus.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setFps(float f) {
                this.fps_ = f;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            private Builder() {
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public RuntimeStatus build() {
                RuntimeStatus buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
            }

            public RuntimeStatus buildPartial() {
                RuntimeStatus runtimeStatus = new RuntimeStatus(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(runtimeStatus);
                }
                onBuilt();
                return runtimeStatus;
            }

            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public RuntimeStatus getDefaultInstanceForType() {
                return RuntimeStatus.getDefaultInstance();
            }

            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
            }

            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.fps_ = 0.0f;
                return this;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder mergeFrom(Message message) {
                if (message instanceof RuntimeStatus) {
                    return mergeFrom((RuntimeStatus) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(RuntimeStatus runtimeStatus) {
                if (runtimeStatus == RuntimeStatus.getDefaultInstance()) {
                    return this;
                }
                if (runtimeStatus.getFps() != 0.0f) {
                    setFps(runtimeStatus.getFps());
                }
                mergeUnknownFields(runtimeStatus.getUnknownFields());
                onChanged();
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                extensionRegistryLite.getClass();
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 13) {
                                this.fps_ = codedInputStream.readFloat();
                                this.bitField0_ |= 1;
                            } else if (super.parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.unwrapIOException();
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }
        }

        private RuntimeStatus(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.fps_ = 0.0f;
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(RuntimeStatus runtimeStatus) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(runtimeStatus);
        }

        public static RuntimeStatus parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static RuntimeStatus parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RuntimeStatus) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static RuntimeStatus parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public RuntimeStatus getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static RuntimeStatus parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        private RuntimeStatus() {
            this.fps_ = 0.0f;
            this.memoizedIsInitialized = -1;
        }

        public static RuntimeStatus parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static RuntimeStatus parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static RuntimeStatus parseFrom(InputStream inputStream) throws IOException {
            return (RuntimeStatus) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static RuntimeStatus parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RuntimeStatus) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static RuntimeStatus parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (RuntimeStatus) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static RuntimeStatus parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RuntimeStatus) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    public interface RuntimeStatusOrBuilder extends MessageOrBuilder {
        float getFps();
    }

    static {
        Descriptors.Descriptor descriptor = c().getMessageTypes().get(0);
        f8075a = descriptor;
        b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Fps"});
    }

    public static Descriptors.FileDescriptor c() {
        return c;
    }
}
