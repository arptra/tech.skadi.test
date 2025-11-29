package com.ucar.protocol.test;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class TestPbData {

    /* renamed from: a  reason: collision with root package name */
    public static final Descriptors.Descriptor f9653a;
    public static final GeneratedMessageV3.FieldAccessorTable b;
    public static Descriptors.FileDescriptor c;

    public static final class TestUserData extends GeneratedMessageV3 implements TestUserDataOrBuilder {
        public static final int AGE_FIELD_NUMBER = 4;
        private static final TestUserData DEFAULT_INSTANCE = new TestUserData();
        public static final int EMAIL_FIELD_NUMBER = 3;
        public static final int HEIGHT_FIELD_NUMBER = 5;
        public static final int ID_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final Parser<TestUserData> PARSER = new AbstractParser<TestUserData>() {
            /* renamed from: a */
            public TestUserData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new TestUserData(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int USERNAME_FIELD_NUMBER = 2;
        public static final int WIGHT_FIELD_NUMBER = 6;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int age_;
        /* access modifiers changed from: private */
        public volatile Object email_;
        /* access modifiers changed from: private */
        public double height_;
        /* access modifiers changed from: private */
        public long id_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public volatile Object username_;
        /* access modifiers changed from: private */
        public float wight_;

        public static TestUserData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TestPbData.f9653a;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static TestUserData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TestUserData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static TestUserData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<TestUserData> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TestUserData)) {
                return super.equals(obj);
            }
            TestUserData testUserData = (TestUserData) obj;
            return getId() == testUserData.getId() && getUsername().equals(testUserData.getUsername()) && getEmail().equals(testUserData.getEmail()) && getAge() == testUserData.getAge() && Double.doubleToLongBits(getHeight()) == Double.doubleToLongBits(testUserData.getHeight()) && Float.floatToIntBits(getWight()) == Float.floatToIntBits(testUserData.getWight()) && this.unknownFields.equals(testUserData.unknownFields);
        }

        public int getAge() {
            return this.age_;
        }

        public String getEmail() {
            Object obj = this.email_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.email_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getEmailBytes() {
            Object obj = this.email_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.email_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public double getHeight() {
            return this.height_;
        }

        public long getId() {
            return this.id_;
        }

        public Parser<TestUserData> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            long j = this.id_;
            int computeInt64Size = j != 0 ? CodedOutputStream.computeInt64Size(1, j) : 0;
            if (!getUsernameBytes().isEmpty()) {
                computeInt64Size += GeneratedMessageV3.computeStringSize(2, this.username_);
            }
            if (!getEmailBytes().isEmpty()) {
                computeInt64Size += GeneratedMessageV3.computeStringSize(3, this.email_);
            }
            int i2 = this.age_;
            if (i2 != 0) {
                computeInt64Size += CodedOutputStream.computeInt32Size(4, i2);
            }
            double d = this.height_;
            if (d != 0.0d) {
                computeInt64Size += CodedOutputStream.computeDoubleSize(5, d);
            }
            float f = this.wight_;
            if (f != 0.0f) {
                computeInt64Size += CodedOutputStream.computeFloatSize(6, f);
            }
            int serializedSize = computeInt64Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public String getUsername() {
            Object obj = this.username_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.username_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getUsernameBytes() {
            Object obj = this.username_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.username_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public float getWight() {
            return this.wight_;
        }

        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = ((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getId())) * 37) + 2) * 53) + getUsername().hashCode()) * 37) + 3) * 53) + getEmail().hashCode()) * 37) + 4) * 53) + getAge()) * 37) + 5) * 53) + Internal.hashLong(Double.doubleToLongBits(getHeight()))) * 37) + 6) * 53) + Float.floatToIntBits(getWight())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TestPbData.b.ensureFieldAccessorsInitialized(TestUserData.class, Builder.class);
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

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j = this.id_;
            if (j != 0) {
                codedOutputStream.writeInt64(1, j);
            }
            if (!getUsernameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.username_);
            }
            if (!getEmailBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.email_);
            }
            int i = this.age_;
            if (i != 0) {
                codedOutputStream.writeInt32(4, i);
            }
            double d = this.height_;
            if (d != 0.0d) {
                codedOutputStream.writeDouble(5, d);
            }
            float f = this.wight_;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(6, f);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TestUserDataOrBuilder {
            private int age_;
            private Object email_;
            private double height_;
            private long id_;
            private Object username_;
            private float wight_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TestPbData.f9653a;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearAge() {
                this.age_ = 0;
                onChanged();
                return this;
            }

            public Builder clearEmail() {
                this.email_ = TestUserData.getDefaultInstance().getEmail();
                onChanged();
                return this;
            }

            public Builder clearHeight() {
                this.height_ = 0.0d;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = 0;
                onChanged();
                return this;
            }

            public Builder clearUsername() {
                this.username_ = TestUserData.getDefaultInstance().getUsername();
                onChanged();
                return this;
            }

            public Builder clearWight() {
                this.wight_ = 0.0f;
                onChanged();
                return this;
            }

            public int getAge() {
                return this.age_;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return TestPbData.f9653a;
            }

            public String getEmail() {
                Object obj = this.email_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.email_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getEmailBytes() {
                Object obj = this.email_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.email_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public double getHeight() {
                return this.height_;
            }

            public long getId() {
                return this.id_;
            }

            public String getUsername() {
                Object obj = this.username_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.username_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getUsernameBytes() {
                Object obj = this.username_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.username_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public float getWight() {
                return this.wight_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TestPbData.b.ensureFieldAccessorsInitialized(TestUserData.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setAge(int i) {
                this.age_ = i;
                onChanged();
                return this;
            }

            public Builder setEmail(String str) {
                str.getClass();
                this.email_ = str;
                onChanged();
                return this;
            }

            public Builder setEmailBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.email_ = byteString;
                onChanged();
                return this;
            }

            public Builder setHeight(double d) {
                this.height_ = d;
                onChanged();
                return this;
            }

            public Builder setId(long j) {
                this.id_ = j;
                onChanged();
                return this;
            }

            public Builder setUsername(String str) {
                str.getClass();
                this.username_ = str;
                onChanged();
                return this;
            }

            public Builder setUsernameBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.username_ = byteString;
                onChanged();
                return this;
            }

            public Builder setWight(float f) {
                this.wight_ = f;
                onChanged();
                return this;
            }

            private Builder() {
                this.username_ = "";
                this.email_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public TestUserData build() {
                TestUserData buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
            }

            public TestUserData buildPartial() {
                TestUserData testUserData = new TestUserData((GeneratedMessageV3.Builder) this);
                long unused = testUserData.id_ = this.id_;
                Object unused2 = testUserData.username_ = this.username_;
                Object unused3 = testUserData.email_ = this.email_;
                int unused4 = testUserData.age_ = this.age_;
                double unused5 = testUserData.height_ = this.height_;
                float unused6 = testUserData.wight_ = this.wight_;
                onBuilt();
                return testUserData;
            }

            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public TestUserData getDefaultInstanceForType() {
                return TestUserData.getDefaultInstance();
            }

            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFieldsProto3(unknownFieldSet);
            }

            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.username_ = "";
                this.email_ = "";
                this.age_ = 0;
                this.height_ = 0.0d;
                this.wight_ = 0.0f;
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.username_ = "";
                this.email_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder mergeFrom(Message message) {
                if (message instanceof TestUserData) {
                    return mergeFrom((TestUserData) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(TestUserData testUserData) {
                if (testUserData == TestUserData.getDefaultInstance()) {
                    return this;
                }
                if (testUserData.getId() != 0) {
                    setId(testUserData.getId());
                }
                if (!testUserData.getUsername().isEmpty()) {
                    this.username_ = testUserData.username_;
                    onChanged();
                }
                if (!testUserData.getEmail().isEmpty()) {
                    this.email_ = testUserData.email_;
                    onChanged();
                }
                if (testUserData.getAge() != 0) {
                    setAge(testUserData.getAge());
                }
                if (testUserData.getHeight() != 0.0d) {
                    setHeight(testUserData.getHeight());
                }
                if (testUserData.getWight() != 0.0f) {
                    setWight(testUserData.getWight());
                }
                mergeUnknownFields(testUserData.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.ucar.protocol.test.TestPbData.TestUserData.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.ucar.protocol.test.TestPbData.TestUserData.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    com.ucar.protocol.test.TestPbData$TestUserData r3 = (com.ucar.protocol.test.TestPbData.TestUserData) r3     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    if (r3 == 0) goto L_0x0010
                    r2.mergeFrom((com.ucar.protocol.test.TestPbData.TestUserData) r3)
                L_0x0010:
                    return r2
                L_0x0011:
                    r3 = move-exception
                    goto L_0x0021
                L_0x0013:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x0011 }
                    com.ucar.protocol.test.TestPbData$TestUserData r4 = (com.ucar.protocol.test.TestPbData.TestUserData) r4     // Catch:{ all -> 0x0011 }
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001f }
                    throw r3     // Catch:{ all -> 0x001f }
                L_0x001f:
                    r3 = move-exception
                    r0 = r4
                L_0x0021:
                    if (r0 == 0) goto L_0x0026
                    r2.mergeFrom((com.ucar.protocol.test.TestPbData.TestUserData) r0)
                L_0x0026:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ucar.protocol.test.TestPbData.TestUserData.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.ucar.protocol.test.TestPbData$TestUserData$Builder");
            }
        }

        public static Builder newBuilder(TestUserData testUserData) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(testUserData);
        }

        public static TestUserData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private TestUserData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        public static TestUserData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TestUserData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static TestUserData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public TestUserData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static TestUserData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        private TestUserData() {
            this.memoizedIsInitialized = -1;
            this.id_ = 0;
            this.username_ = "";
            this.email_ = "";
            this.age_ = 0;
            this.height_ = 0.0d;
            this.wight_ = 0.0f;
        }

        public static TestUserData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static TestUserData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static TestUserData parseFrom(InputStream inputStream) throws IOException {
            return (TestUserData) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static TestUserData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TestUserData) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static TestUserData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (TestUserData) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        private TestUserData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.id_ = codedInputStream.readInt64();
                        } else if (readTag == 18) {
                            this.username_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 26) {
                            this.email_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 32) {
                            this.age_ = codedInputStream.readInt32();
                        } else if (readTag == 41) {
                            this.height_ = codedInputStream.readDouble();
                        } else if (readTag == 53) {
                            this.wight_ = codedInputStream.readFloat();
                        } else if (parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }

        public static TestUserData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TestUserData) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    public interface TestUserDataOrBuilder extends MessageOrBuilder {
        int getAge();

        String getEmail();

        ByteString getEmailBytes();

        double getHeight();

        long getId();

        String getUsername();

        ByteString getUsernameBytes();

        float getWight();
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012test_pb_data.proto\"g\n\fTestUserData\u0012\n\n\u0002id\u0018\u0001 \u0001(\u0003\u0012\u0010\n\busername\u0018\u0002 \u0001(\t\u0012\r\n\u0005email\u0018\u0003 \u0001(\t\u0012\u000b\n\u0003age\u0018\u0004 \u0001(\u0005\u0012\u000e\n\u0006height\u0018\u0005 \u0001(\u0001\u0012\r\n\u0005wight\u0018\u0006 \u0001(\u0002B\u0018\n\u0016com.ucar.protocol.testb\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = TestPbData.c = fileDescriptor;
                return null;
            }
        });
        Descriptors.Descriptor descriptor = d().getMessageTypes().get(0);
        f9653a = descriptor;
        b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Id", "Username", "Email", "Age", "Height", "Wight"});
    }

    public static Descriptors.FileDescriptor d() {
        return c;
    }
}
