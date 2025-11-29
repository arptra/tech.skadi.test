package com.upuphone.xr.sapp.vu.input;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class VibrationOuterClass {

    /* renamed from: a  reason: collision with root package name */
    public static final Descriptors.Descriptor f8077a;
    public static final GeneratedMessageV3.FieldAccessorTable b;
    public static Descriptors.FileDescriptor c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fVibration.proto\u0012\u001dcom.upuphone.xr.sapp.vu.input\"F\n\tVibration\u0012\u0011\n\tfrequency\u0018\u0001 \u0001(\u0002\u0012\u0011\n\tamplitude\u0018\u0002 \u0001(\u0002\u0012\u0013\n\u000bduration_ns\u0018\u0003 \u0001(\u0003b\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    public static final class Vibration extends GeneratedMessageV3 implements VibrationOrBuilder {
        public static final int AMPLITUDE_FIELD_NUMBER = 2;
        private static final Vibration DEFAULT_INSTANCE = new Vibration();
        public static final int DURATION_NS_FIELD_NUMBER = 3;
        public static final int FREQUENCY_FIELD_NUMBER = 1;
        private static final Parser<Vibration> PARSER = new AbstractParser<Vibration>() {
            /* renamed from: a */
            public Vibration parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Builder newBuilder = Vibration.newBuilder();
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
        public float amplitude_;
        /* access modifiers changed from: private */
        public long durationNs_;
        /* access modifiers changed from: private */
        public float frequency_;
        private byte memoizedIsInitialized;

        public static Vibration getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return VibrationOuterClass.f8077a;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Vibration parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Vibration) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Vibration parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<Vibration> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Vibration)) {
                return super.equals(obj);
            }
            Vibration vibration = (Vibration) obj;
            return Float.floatToIntBits(getFrequency()) == Float.floatToIntBits(vibration.getFrequency()) && Float.floatToIntBits(getAmplitude()) == Float.floatToIntBits(vibration.getAmplitude()) && getDurationNs() == vibration.getDurationNs() && getUnknownFields().equals(vibration.getUnknownFields());
        }

        public float getAmplitude() {
            return this.amplitude_;
        }

        public long getDurationNs() {
            return this.durationNs_;
        }

        public float getFrequency() {
            return this.frequency_;
        }

        public Parser<Vibration> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeFloatSize = Float.floatToRawIntBits(this.frequency_) != 0 ? CodedOutputStream.computeFloatSize(1, this.frequency_) : 0;
            if (Float.floatToRawIntBits(this.amplitude_) != 0) {
                computeFloatSize += CodedOutputStream.computeFloatSize(2, this.amplitude_);
            }
            long j = this.durationNs_;
            if (j != 0) {
                computeFloatSize += CodedOutputStream.computeInt64Size(3, j);
            }
            int serializedSize = computeFloatSize + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Float.floatToIntBits(getFrequency())) * 37) + 2) * 53) + Float.floatToIntBits(getAmplitude())) * 37) + 3) * 53) + Internal.hashLong(getDurationNs())) * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return VibrationOuterClass.b.ensureFieldAccessorsInitialized(Vibration.class, Builder.class);
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
            return new Vibration();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (Float.floatToRawIntBits(this.frequency_) != 0) {
                codedOutputStream.writeFloat(1, this.frequency_);
            }
            if (Float.floatToRawIntBits(this.amplitude_) != 0) {
                codedOutputStream.writeFloat(2, this.amplitude_);
            }
            long j = this.durationNs_;
            if (j != 0) {
                codedOutputStream.writeInt64(3, j);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VibrationOrBuilder {
            private float amplitude_;
            private int bitField0_;
            private long durationNs_;
            private float frequency_;

            private void buildPartial0(Vibration vibration) {
                int i = this.bitField0_;
                if ((i & 1) != 0) {
                    vibration.frequency_ = this.frequency_;
                }
                if ((i & 2) != 0) {
                    vibration.amplitude_ = this.amplitude_;
                }
                if ((i & 4) != 0) {
                    vibration.durationNs_ = this.durationNs_;
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return VibrationOuterClass.f8077a;
            }

            public Builder clearAmplitude() {
                this.bitField0_ &= -3;
                this.amplitude_ = 0.0f;
                onChanged();
                return this;
            }

            public Builder clearDurationNs() {
                this.bitField0_ &= -5;
                this.durationNs_ = 0;
                onChanged();
                return this;
            }

            public Builder clearFrequency() {
                this.bitField0_ &= -2;
                this.frequency_ = 0.0f;
                onChanged();
                return this;
            }

            public float getAmplitude() {
                return this.amplitude_;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return VibrationOuterClass.f8077a;
            }

            public long getDurationNs() {
                return this.durationNs_;
            }

            public float getFrequency() {
                return this.frequency_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return VibrationOuterClass.b.ensureFieldAccessorsInitialized(Vibration.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setAmplitude(float f) {
                this.amplitude_ = f;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setDurationNs(long j) {
                this.durationNs_ = j;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setFrequency(float f) {
                this.frequency_ = f;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            private Builder() {
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public Vibration build() {
                Vibration buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
            }

            public Vibration buildPartial() {
                Vibration vibration = new Vibration(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(vibration);
                }
                onBuilt();
                return vibration;
            }

            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Vibration getDefaultInstanceForType() {
                return Vibration.getDefaultInstance();
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
                this.frequency_ = 0.0f;
                this.amplitude_ = 0.0f;
                this.durationNs_ = 0;
                return this;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder mergeFrom(Message message) {
                if (message instanceof Vibration) {
                    return mergeFrom((Vibration) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Vibration vibration) {
                if (vibration == Vibration.getDefaultInstance()) {
                    return this;
                }
                if (vibration.getFrequency() != 0.0f) {
                    setFrequency(vibration.getFrequency());
                }
                if (vibration.getAmplitude() != 0.0f) {
                    setAmplitude(vibration.getAmplitude());
                }
                if (vibration.getDurationNs() != 0) {
                    setDurationNs(vibration.getDurationNs());
                }
                mergeUnknownFields(vibration.getUnknownFields());
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
                                this.frequency_ = codedInputStream.readFloat();
                                this.bitField0_ |= 1;
                            } else if (readTag == 21) {
                                this.amplitude_ = codedInputStream.readFloat();
                                this.bitField0_ |= 2;
                            } else if (readTag == 24) {
                                this.durationNs_ = codedInputStream.readInt64();
                                this.bitField0_ |= 4;
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

        private Vibration(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.frequency_ = 0.0f;
            this.amplitude_ = 0.0f;
            this.durationNs_ = 0;
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(Vibration vibration) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(vibration);
        }

        public static Vibration parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Vibration parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Vibration) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Vibration parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public Vibration getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static Vibration parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Vibration parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static Vibration parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        private Vibration() {
            this.frequency_ = 0.0f;
            this.amplitude_ = 0.0f;
            this.durationNs_ = 0;
            this.memoizedIsInitialized = -1;
        }

        public static Vibration parseFrom(InputStream inputStream) throws IOException {
            return (Vibration) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Vibration parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Vibration) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Vibration parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Vibration) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Vibration parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Vibration) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    public interface VibrationOrBuilder extends MessageOrBuilder {
        float getAmplitude();

        long getDurationNs();

        float getFrequency();
    }

    static {
        Descriptors.Descriptor descriptor = c().getMessageTypes().get(0);
        f8077a = descriptor;
        b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Frequency", "Amplitude", "DurationNs"});
    }

    public static Descriptors.FileDescriptor c() {
        return c;
    }
}
