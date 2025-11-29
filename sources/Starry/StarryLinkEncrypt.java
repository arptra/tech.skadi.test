package Starry;

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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import com.upuphone.starrynet.strategy.pair.ble.RingSecurityPair;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class StarryLinkEncrypt {
    /* access modifiers changed from: private */
    public static Descriptors.FileDescriptor descriptor;
    /* access modifiers changed from: private */
    public static final Descriptors.Descriptor internal_static_Starry_BLEConnectStatus_descriptor;
    /* access modifiers changed from: private */
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_Starry_BLEConnectStatus_fieldAccessorTable;
    /* access modifiers changed from: private */
    public static final Descriptors.Descriptor internal_static_Starry_BTConnectStatus_descriptor;
    /* access modifiers changed from: private */
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_Starry_BTConnectStatus_fieldAccessorTable;
    /* access modifiers changed from: private */
    public static final Descriptors.Descriptor internal_static_Starry_DeviceInfo_descriptor;
    /* access modifiers changed from: private */
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_Starry_DeviceInfo_fieldAccessorTable;
    /* access modifiers changed from: private */
    public static final Descriptors.Descriptor internal_static_Starry_IOSConnectBt_descriptor;
    /* access modifiers changed from: private */
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_Starry_IOSConnectBt_fieldAccessorTable;
    /* access modifiers changed from: private */
    public static final Descriptors.Descriptor internal_static_Starry_LinkProtocol_descriptor;
    /* access modifiers changed from: private */
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_Starry_LinkProtocol_fieldAccessorTable;
    /* access modifiers changed from: private */
    public static final Descriptors.Descriptor internal_static_Starry_ReadSwitchInfo_descriptor;
    /* access modifiers changed from: private */
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_Starry_ReadSwitchInfo_fieldAccessorTable;
    /* access modifiers changed from: private */
    public static final Descriptors.Descriptor internal_static_Starry_ReadSwitchKey_descriptor;
    /* access modifiers changed from: private */
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_Starry_ReadSwitchKey_fieldAccessorTable;
    /* access modifiers changed from: private */
    public static final Descriptors.Descriptor internal_static_Starry_WifiApInfo_descriptor;
    /* access modifiers changed from: private */
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_Starry_WifiApInfo_fieldAccessorTable;
    /* access modifiers changed from: private */
    public static final Descriptors.Descriptor internal_static_Starry_WifiGcInfo_descriptor;
    /* access modifiers changed from: private */
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_Starry_WifiGcInfo_fieldAccessorTable;
    /* access modifiers changed from: private */
    public static final Descriptors.Descriptor internal_static_Starry_WifiGoInfo_descriptor;
    /* access modifiers changed from: private */
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_Starry_WifiGoInfo_fieldAccessorTable;
    /* access modifiers changed from: private */
    public static final Descriptors.Descriptor internal_static_Starry_WifiStaInfo_descriptor;
    /* access modifiers changed from: private */
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_Starry_WifiStaInfo_fieldAccessorTable;
    /* access modifiers changed from: private */
    public static final Descriptors.Descriptor internal_static_Starry_WriteSwitchInfo_descriptor;
    /* access modifiers changed from: private */
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_Starry_WriteSwitchInfo_fieldAccessorTable;
    /* access modifiers changed from: private */
    public static final Descriptors.Descriptor internal_static_Starry_WriteSwitchKey_descriptor;
    /* access modifiers changed from: private */
    public static final GeneratedMessageV3.FieldAccessorTable internal_static_Starry_WriteSwitchKey_fieldAccessorTable;

    public static final class BLEConnectStatus extends GeneratedMessageV3 implements BLEConnectStatusOrBuilder {
        public static final int BTSTATUS_FIELD_NUMBER = 1;
        private static final BLEConnectStatus DEFAULT_INSTANCE = new BLEConnectStatus();
        /* access modifiers changed from: private */
        public static final Parser<BLEConnectStatus> PARSER = new AbstractParser<BLEConnectStatus>() {
            public BLEConnectStatus parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new BLEConnectStatus(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int btStatus_;
        private byte memoizedIsInitialized;

        public static BLEConnectStatus getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StarryLinkEncrypt.internal_static_Starry_BLEConnectStatus_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static BLEConnectStatus parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (BLEConnectStatus) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static BLEConnectStatus parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<BLEConnectStatus> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BLEConnectStatus)) {
                return super.equals(obj);
            }
            BLEConnectStatus bLEConnectStatus = (BLEConnectStatus) obj;
            return this.btStatus_ == bLEConnectStatus.btStatus_ && this.unknownFields.equals(bLEConnectStatus.unknownFields);
        }

        public IosBleSTATUS getBtStatus() {
            IosBleSTATUS valueOf = IosBleSTATUS.valueOf(this.btStatus_);
            return valueOf == null ? IosBleSTATUS.UNRECOGNIZED : valueOf;
        }

        public int getBtStatusValue() {
            return this.btStatus_;
        }

        public Parser<BLEConnectStatus> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = (this.btStatus_ != IosBleSTATUS.BLE_BONDED.getNumber() ? CodedOutputStream.computeEnumSize(1, this.btStatus_) : 0) + this.unknownFields.getSerializedSize();
            this.memoizedSize = computeEnumSize;
            return computeEnumSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.btStatus_) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StarryLinkEncrypt.internal_static_Starry_BLEConnectStatus_fieldAccessorTable.ensureFieldAccessorsInitialized(BLEConnectStatus.class, Builder.class);
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
            if (this.btStatus_ != IosBleSTATUS.BLE_BONDED.getNumber()) {
                codedOutputStream.writeEnum(1, this.btStatus_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BLEConnectStatusOrBuilder {
            private int btStatus_;

            public static final Descriptors.Descriptor getDescriptor() {
                return StarryLinkEncrypt.internal_static_Starry_BLEConnectStatus_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearBtStatus() {
                this.btStatus_ = 0;
                onChanged();
                return this;
            }

            public IosBleSTATUS getBtStatus() {
                IosBleSTATUS valueOf = IosBleSTATUS.valueOf(this.btStatus_);
                return valueOf == null ? IosBleSTATUS.UNRECOGNIZED : valueOf;
            }

            public int getBtStatusValue() {
                return this.btStatus_;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return StarryLinkEncrypt.internal_static_Starry_BLEConnectStatus_descriptor;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StarryLinkEncrypt.internal_static_Starry_BLEConnectStatus_fieldAccessorTable.ensureFieldAccessorsInitialized(BLEConnectStatus.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setBtStatus(IosBleSTATUS iosBleSTATUS) {
                iosBleSTATUS.getClass();
                this.btStatus_ = iosBleSTATUS.getNumber();
                onChanged();
                return this;
            }

            public Builder setBtStatusValue(int i) {
                this.btStatus_ = i;
                onChanged();
                return this;
            }

            private Builder() {
                this.btStatus_ = 0;
                maybeForceBuilderInitialization();
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public BLEConnectStatus build() {
                BLEConnectStatus buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
            }

            public BLEConnectStatus buildPartial() {
                BLEConnectStatus bLEConnectStatus = new BLEConnectStatus((GeneratedMessageV3.Builder) this);
                int unused = bLEConnectStatus.btStatus_ = this.btStatus_;
                onBuilt();
                return bLEConnectStatus;
            }

            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public BLEConnectStatus getDefaultInstanceForType() {
                return BLEConnectStatus.getDefaultInstance();
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
                this.btStatus_ = 0;
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.btStatus_ = 0;
                maybeForceBuilderInitialization();
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder mergeFrom(Message message) {
                if (message instanceof BLEConnectStatus) {
                    return mergeFrom((BLEConnectStatus) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(BLEConnectStatus bLEConnectStatus) {
                if (bLEConnectStatus == BLEConnectStatus.getDefaultInstance()) {
                    return this;
                }
                if (bLEConnectStatus.btStatus_ != 0) {
                    setBtStatusValue(bLEConnectStatus.getBtStatusValue());
                }
                mergeUnknownFields(bLEConnectStatus.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public Starry.StarryLinkEncrypt.BLEConnectStatus.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = Starry.StarryLinkEncrypt.BLEConnectStatus.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    Starry.StarryLinkEncrypt$BLEConnectStatus r3 = (Starry.StarryLinkEncrypt.BLEConnectStatus) r3     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    if (r3 == 0) goto L_0x0010
                    r2.mergeFrom((Starry.StarryLinkEncrypt.BLEConnectStatus) r3)
                L_0x0010:
                    return r2
                L_0x0011:
                    r3 = move-exception
                    goto L_0x0021
                L_0x0013:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x0011 }
                    Starry.StarryLinkEncrypt$BLEConnectStatus r4 = (Starry.StarryLinkEncrypt.BLEConnectStatus) r4     // Catch:{ all -> 0x0011 }
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001f }
                    throw r3     // Catch:{ all -> 0x001f }
                L_0x001f:
                    r3 = move-exception
                    r0 = r4
                L_0x0021:
                    if (r0 == 0) goto L_0x0026
                    r2.mergeFrom((Starry.StarryLinkEncrypt.BLEConnectStatus) r0)
                L_0x0026:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: Starry.StarryLinkEncrypt.BLEConnectStatus.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):Starry.StarryLinkEncrypt$BLEConnectStatus$Builder");
            }
        }

        public static Builder newBuilder(BLEConnectStatus bLEConnectStatus) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(bLEConnectStatus);
        }

        public static BLEConnectStatus parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private BLEConnectStatus(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        public static BLEConnectStatus parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BLEConnectStatus) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static BLEConnectStatus parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public BLEConnectStatus getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static BLEConnectStatus parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        private BLEConnectStatus() {
            this.memoizedIsInitialized = -1;
            this.btStatus_ = 0;
        }

        public static BLEConnectStatus parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static BLEConnectStatus parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static BLEConnectStatus parseFrom(InputStream inputStream) throws IOException {
            return (BLEConnectStatus) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        private BLEConnectStatus(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.btStatus_ = codedInputStream.readEnum();
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

        public static BLEConnectStatus parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BLEConnectStatus) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static BLEConnectStatus parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (BLEConnectStatus) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static BLEConnectStatus parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BLEConnectStatus) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    public interface BLEConnectStatusOrBuilder extends MessageOrBuilder {
        IosBleSTATUS getBtStatus();

        int getBtStatusValue();
    }

    public static final class BTConnectStatus extends GeneratedMessageV3 implements BTConnectStatusOrBuilder {
        public static final int BTSTATUS_FIELD_NUMBER = 1;
        private static final BTConnectStatus DEFAULT_INSTANCE = new BTConnectStatus();
        /* access modifiers changed from: private */
        public static final Parser<BTConnectStatus> PARSER = new AbstractParser<BTConnectStatus>() {
            public BTConnectStatus parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new BTConnectStatus(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int btStatus_;
        private byte memoizedIsInitialized;

        public static BTConnectStatus getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StarryLinkEncrypt.internal_static_Starry_BTConnectStatus_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static BTConnectStatus parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (BTConnectStatus) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static BTConnectStatus parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<BTConnectStatus> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BTConnectStatus)) {
                return super.equals(obj);
            }
            BTConnectStatus bTConnectStatus = (BTConnectStatus) obj;
            return this.btStatus_ == bTConnectStatus.btStatus_ && this.unknownFields.equals(bTConnectStatus.unknownFields);
        }

        public BTSTATUS getBtStatus() {
            BTSTATUS valueOf = BTSTATUS.valueOf(this.btStatus_);
            return valueOf == null ? BTSTATUS.UNRECOGNIZED : valueOf;
        }

        public int getBtStatusValue() {
            return this.btStatus_;
        }

        public Parser<BTConnectStatus> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = (this.btStatus_ != BTSTATUS.DEFAULT.getNumber() ? CodedOutputStream.computeEnumSize(1, this.btStatus_) : 0) + this.unknownFields.getSerializedSize();
            this.memoizedSize = computeEnumSize;
            return computeEnumSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.btStatus_) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StarryLinkEncrypt.internal_static_Starry_BTConnectStatus_fieldAccessorTable.ensureFieldAccessorsInitialized(BTConnectStatus.class, Builder.class);
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
            if (this.btStatus_ != BTSTATUS.DEFAULT.getNumber()) {
                codedOutputStream.writeEnum(1, this.btStatus_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BTConnectStatusOrBuilder {
            private int btStatus_;

            public static final Descriptors.Descriptor getDescriptor() {
                return StarryLinkEncrypt.internal_static_Starry_BTConnectStatus_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearBtStatus() {
                this.btStatus_ = 0;
                onChanged();
                return this;
            }

            public BTSTATUS getBtStatus() {
                BTSTATUS valueOf = BTSTATUS.valueOf(this.btStatus_);
                return valueOf == null ? BTSTATUS.UNRECOGNIZED : valueOf;
            }

            public int getBtStatusValue() {
                return this.btStatus_;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return StarryLinkEncrypt.internal_static_Starry_BTConnectStatus_descriptor;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StarryLinkEncrypt.internal_static_Starry_BTConnectStatus_fieldAccessorTable.ensureFieldAccessorsInitialized(BTConnectStatus.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setBtStatus(BTSTATUS btstatus) {
                btstatus.getClass();
                this.btStatus_ = btstatus.getNumber();
                onChanged();
                return this;
            }

            public Builder setBtStatusValue(int i) {
                this.btStatus_ = i;
                onChanged();
                return this;
            }

            private Builder() {
                this.btStatus_ = 0;
                maybeForceBuilderInitialization();
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public BTConnectStatus build() {
                BTConnectStatus buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
            }

            public BTConnectStatus buildPartial() {
                BTConnectStatus bTConnectStatus = new BTConnectStatus((GeneratedMessageV3.Builder) this);
                int unused = bTConnectStatus.btStatus_ = this.btStatus_;
                onBuilt();
                return bTConnectStatus;
            }

            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public BTConnectStatus getDefaultInstanceForType() {
                return BTConnectStatus.getDefaultInstance();
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
                this.btStatus_ = 0;
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.btStatus_ = 0;
                maybeForceBuilderInitialization();
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder mergeFrom(Message message) {
                if (message instanceof BTConnectStatus) {
                    return mergeFrom((BTConnectStatus) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(BTConnectStatus bTConnectStatus) {
                if (bTConnectStatus == BTConnectStatus.getDefaultInstance()) {
                    return this;
                }
                if (bTConnectStatus.btStatus_ != 0) {
                    setBtStatusValue(bTConnectStatus.getBtStatusValue());
                }
                mergeUnknownFields(bTConnectStatus.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public Starry.StarryLinkEncrypt.BTConnectStatus.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = Starry.StarryLinkEncrypt.BTConnectStatus.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    Starry.StarryLinkEncrypt$BTConnectStatus r3 = (Starry.StarryLinkEncrypt.BTConnectStatus) r3     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    if (r3 == 0) goto L_0x0010
                    r2.mergeFrom((Starry.StarryLinkEncrypt.BTConnectStatus) r3)
                L_0x0010:
                    return r2
                L_0x0011:
                    r3 = move-exception
                    goto L_0x0021
                L_0x0013:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x0011 }
                    Starry.StarryLinkEncrypt$BTConnectStatus r4 = (Starry.StarryLinkEncrypt.BTConnectStatus) r4     // Catch:{ all -> 0x0011 }
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001f }
                    throw r3     // Catch:{ all -> 0x001f }
                L_0x001f:
                    r3 = move-exception
                    r0 = r4
                L_0x0021:
                    if (r0 == 0) goto L_0x0026
                    r2.mergeFrom((Starry.StarryLinkEncrypt.BTConnectStatus) r0)
                L_0x0026:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: Starry.StarryLinkEncrypt.BTConnectStatus.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):Starry.StarryLinkEncrypt$BTConnectStatus$Builder");
            }
        }

        public static Builder newBuilder(BTConnectStatus bTConnectStatus) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(bTConnectStatus);
        }

        public static BTConnectStatus parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private BTConnectStatus(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        public static BTConnectStatus parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BTConnectStatus) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static BTConnectStatus parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public BTConnectStatus getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static BTConnectStatus parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        private BTConnectStatus() {
            this.memoizedIsInitialized = -1;
            this.btStatus_ = 0;
        }

        public static BTConnectStatus parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static BTConnectStatus parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static BTConnectStatus parseFrom(InputStream inputStream) throws IOException {
            return (BTConnectStatus) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        private BTConnectStatus(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.btStatus_ = codedInputStream.readEnum();
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

        public static BTConnectStatus parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BTConnectStatus) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static BTConnectStatus parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (BTConnectStatus) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static BTConnectStatus parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BTConnectStatus) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    public interface BTConnectStatusOrBuilder extends MessageOrBuilder {
        BTSTATUS getBtStatus();

        int getBtStatusValue();
    }

    public enum BTSTATUS implements ProtocolMessageEnum {
        DEFAULT(0),
        BOND(1),
        BONDING(2),
        NOBOND(3),
        CONNECTED_ACL(4),
        CONNECTED_HFP(5),
        CONNECTED_A2DP(6),
        DISCONNECTED(7),
        NO_CONNECTED_BT(8),
        EXIST_CONNECTED_BT(9),
        CONNECT_FAIL(10),
        BOND_CANCEL_OR_TIMEOUT(11),
        UNRECOGNIZED(-1);
        
        public static final int BONDING_VALUE = 2;
        public static final int BOND_CANCEL_OR_TIMEOUT_VALUE = 11;
        public static final int BOND_VALUE = 1;
        public static final int CONNECTED_A2DP_VALUE = 6;
        public static final int CONNECTED_ACL_VALUE = 4;
        public static final int CONNECTED_HFP_VALUE = 5;
        public static final int CONNECT_FAIL_VALUE = 10;
        public static final int DEFAULT_VALUE = 0;
        public static final int DISCONNECTED_VALUE = 7;
        public static final int EXIST_CONNECTED_BT_VALUE = 9;
        public static final int NOBOND_VALUE = 3;
        public static final int NO_CONNECTED_BT_VALUE = 8;
        private static final BTSTATUS[] VALUES = null;
        private static final Internal.EnumLiteMap<BTSTATUS> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<BTSTATUS>() {
                public BTSTATUS findValueByNumber(int i) {
                    return BTSTATUS.forNumber(i);
                }
            };
            VALUES = values();
        }

        private BTSTATUS(int i) {
            this.value = i;
        }

        public static BTSTATUS forNumber(int i) {
            switch (i) {
                case 0:
                    return DEFAULT;
                case 1:
                    return BOND;
                case 2:
                    return BONDING;
                case 3:
                    return NOBOND;
                case 4:
                    return CONNECTED_ACL;
                case 5:
                    return CONNECTED_HFP;
                case 6:
                    return CONNECTED_A2DP;
                case 7:
                    return DISCONNECTED;
                case 8:
                    return NO_CONNECTED_BT;
                case 9:
                    return EXIST_CONNECTED_BT;
                case 10:
                    return CONNECT_FAIL;
                case 11:
                    return BOND_CANCEL_OR_TIMEOUT;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return StarryLinkEncrypt.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<BTSTATUS> internalGetValueMap() {
            return internalValueMap;
        }

        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }

        @Deprecated
        public static BTSTATUS valueOf(int i) {
            return forNumber(i);
        }

        public static BTSTATUS valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[enumValueDescriptor.getIndex()];
            }
        }
    }

    public enum COMMAND implements ProtocolMessageEnum {
        INIT(0),
        ENSURE(1),
        UN_BONDED(2),
        CONNECT_GO(3),
        CONNECT_GC(4),
        DISCONNECT_P2P(5),
        DISCONNECT_P2P_ACTIVE(6),
        READ_SWITCH_KEY(10),
        WRITE_SWITCH_KEY(11),
        READ_SWITCH_INFO(12),
        WRITE_SWITCH_INFO(13),
        BOND_MSG_CHANGE(14),
        CANCEL_AUTH(17),
        AUTH_STATUE(18),
        AUTH_MESSAGE(19),
        CREATE_AP(20),
        CONNECT_AP(21),
        CONNECTED_AP(22),
        DISCONNECT_AP(23),
        DISCONNECTED_AP(24),
        CONNECT_AP_FAIL(25),
        SEVER_REQUEST_CLIENT_DISCONNECT_CONNECTION(26),
        DISCONNECT_BLE(30),
        PEERS_DISABLE_WIFI(31),
        IOS_CONNECT_BT(32),
        IOS_DISCONNECT_BT(33),
        BT_STATE_CHANGE(34),
        REQUEST_STATUS_BT(35),
        BLE_STATUS_CHANGE(36),
        SYNC_3RD_MAC(40),
        SYNC_GC_IP(41),
        PEERS_NAME_CHANGE(50),
        EXTERNAL_MESSAGE_NORMAL(60),
        EXTERNAL_MESSAGE_ENCRYPT(61),
        SPP_SERVER_UUID_SYNC(70),
        SPP_SERVER_REQUEST_CONNECT(71),
        SPP_SERVER_REQUEST_STATE_OPEN(72),
        SPP_SERVER_REQUEST_STATE_CLOSE(73),
        STARRY_NET_STACK(80),
        UNRECOGNIZED(-1);
        
        public static final int AUTH_MESSAGE_VALUE = 19;
        public static final int AUTH_STATUE_VALUE = 18;
        public static final int BLE_STATUS_CHANGE_VALUE = 36;
        public static final int BOND_MSG_CHANGE_VALUE = 14;
        public static final int BT_STATE_CHANGE_VALUE = 34;
        public static final int CANCEL_AUTH_VALUE = 17;
        public static final int CONNECTED_AP_VALUE = 22;
        public static final int CONNECT_AP_FAIL_VALUE = 25;
        public static final int CONNECT_AP_VALUE = 21;
        public static final int CONNECT_GC_VALUE = 4;
        public static final int CONNECT_GO_VALUE = 3;
        public static final int CREATE_AP_VALUE = 20;
        public static final int DISCONNECTED_AP_VALUE = 24;
        public static final int DISCONNECT_AP_VALUE = 23;
        public static final int DISCONNECT_BLE_VALUE = 30;
        public static final int DISCONNECT_P2P_ACTIVE_VALUE = 6;
        public static final int DISCONNECT_P2P_VALUE = 5;
        public static final int ENSURE_VALUE = 1;
        public static final int EXTERNAL_MESSAGE_ENCRYPT_VALUE = 61;
        public static final int EXTERNAL_MESSAGE_NORMAL_VALUE = 60;
        public static final int INIT_VALUE = 0;
        public static final int IOS_CONNECT_BT_VALUE = 32;
        public static final int IOS_DISCONNECT_BT_VALUE = 33;
        public static final int PEERS_DISABLE_WIFI_VALUE = 31;
        public static final int PEERS_NAME_CHANGE_VALUE = 50;
        public static final int READ_SWITCH_INFO_VALUE = 12;
        public static final int READ_SWITCH_KEY_VALUE = 10;
        public static final int REQUEST_STATUS_BT_VALUE = 35;
        public static final int SEVER_REQUEST_CLIENT_DISCONNECT_CONNECTION_VALUE = 26;
        public static final int SPP_SERVER_REQUEST_CONNECT_VALUE = 71;
        public static final int SPP_SERVER_REQUEST_STATE_CLOSE_VALUE = 73;
        public static final int SPP_SERVER_REQUEST_STATE_OPEN_VALUE = 72;
        public static final int SPP_SERVER_UUID_SYNC_VALUE = 70;
        public static final int STARRY_NET_STACK_VALUE = 80;
        public static final int SYNC_3RD_MAC_VALUE = 40;
        public static final int SYNC_GC_IP_VALUE = 41;
        public static final int UN_BONDED_VALUE = 2;
        private static final COMMAND[] VALUES = null;
        public static final int WRITE_SWITCH_INFO_VALUE = 13;
        public static final int WRITE_SWITCH_KEY_VALUE = 11;
        private static final Internal.EnumLiteMap<COMMAND> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<COMMAND>() {
                public COMMAND findValueByNumber(int i) {
                    return COMMAND.forNumber(i);
                }
            };
            VALUES = values();
        }

        private COMMAND(int i) {
            this.value = i;
        }

        public static COMMAND forNumber(int i) {
            if (i == 40) {
                return SYNC_3RD_MAC;
            }
            if (i == 41) {
                return SYNC_GC_IP;
            }
            if (i == 50) {
                return PEERS_NAME_CHANGE;
            }
            if (i == 80) {
                return STARRY_NET_STACK;
            }
            if (i == 60) {
                return EXTERNAL_MESSAGE_NORMAL;
            }
            if (i == 61) {
                return EXTERNAL_MESSAGE_ENCRYPT;
            }
            switch (i) {
                case 0:
                    return INIT;
                case 1:
                    return ENSURE;
                case 2:
                    return UN_BONDED;
                case 3:
                    return CONNECT_GO;
                case 4:
                    return CONNECT_GC;
                case 5:
                    return DISCONNECT_P2P;
                case 6:
                    return DISCONNECT_P2P_ACTIVE;
                default:
                    switch (i) {
                        case 10:
                            return READ_SWITCH_KEY;
                        case 11:
                            return WRITE_SWITCH_KEY;
                        case 12:
                            return READ_SWITCH_INFO;
                        case 13:
                            return WRITE_SWITCH_INFO;
                        case 14:
                            return BOND_MSG_CHANGE;
                        default:
                            switch (i) {
                                case 17:
                                    return CANCEL_AUTH;
                                case 18:
                                    return AUTH_STATUE;
                                case 19:
                                    return AUTH_MESSAGE;
                                case 20:
                                    return CREATE_AP;
                                case 21:
                                    return CONNECT_AP;
                                case 22:
                                    return CONNECTED_AP;
                                case 23:
                                    return DISCONNECT_AP;
                                case 24:
                                    return DISCONNECTED_AP;
                                case 25:
                                    return CONNECT_AP_FAIL;
                                case 26:
                                    return SEVER_REQUEST_CLIENT_DISCONNECT_CONNECTION;
                                default:
                                    switch (i) {
                                        case 30:
                                            return DISCONNECT_BLE;
                                        case 31:
                                            return PEERS_DISABLE_WIFI;
                                        case 32:
                                            return IOS_CONNECT_BT;
                                        case 33:
                                            return IOS_DISCONNECT_BT;
                                        case 34:
                                            return BT_STATE_CHANGE;
                                        case 35:
                                            return REQUEST_STATUS_BT;
                                        case 36:
                                            return BLE_STATUS_CHANGE;
                                        default:
                                            switch (i) {
                                                case 70:
                                                    return SPP_SERVER_UUID_SYNC;
                                                case 71:
                                                    return SPP_SERVER_REQUEST_CONNECT;
                                                case 72:
                                                    return SPP_SERVER_REQUEST_STATE_OPEN;
                                                case 73:
                                                    return SPP_SERVER_REQUEST_STATE_CLOSE;
                                                default:
                                                    return null;
                                            }
                                    }
                            }
                    }
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return StarryLinkEncrypt.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<COMMAND> internalGetValueMap() {
            return internalValueMap;
        }

        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }

        @Deprecated
        public static COMMAND valueOf(int i) {
            return forNumber(i);
        }

        public static COMMAND valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[enumValueDescriptor.getIndex()];
            }
        }
    }

    public static final class DeviceInfo extends GeneratedMessageV3 implements DeviceInfoOrBuilder {
        public static final int BATTERY_FIELD_NUMBER = 6;
        public static final int BTMAC_FIELD_NUMBER = 1;
        public static final int BTSTATUS_FIELD_NUMBER = 7;
        public static final int CATEGORYID_FIELD_NUMBER = 3;
        public static final int COMPANYID_FIELD_NUMBER = 2;
        private static final DeviceInfo DEFAULT_INSTANCE = new DeviceInfo();
        public static final int MODELID_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 5;
        /* access modifiers changed from: private */
        public static final Parser<DeviceInfo> PARSER = new AbstractParser<DeviceInfo>() {
            public DeviceInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new DeviceInfo(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int battery_;
        /* access modifiers changed from: private */
        public volatile Object btMac_;
        /* access modifiers changed from: private */
        public int btStatus_;
        /* access modifiers changed from: private */
        public volatile Object categoryId_;
        /* access modifiers changed from: private */
        public volatile Object companyId_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public volatile Object modelId_;
        /* access modifiers changed from: private */
        public ByteString name_;

        public static DeviceInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StarryLinkEncrypt.internal_static_Starry_DeviceInfo_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static DeviceInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DeviceInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static DeviceInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<DeviceInfo> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DeviceInfo)) {
                return super.equals(obj);
            }
            DeviceInfo deviceInfo = (DeviceInfo) obj;
            return getBtMac().equals(deviceInfo.getBtMac()) && getCompanyId().equals(deviceInfo.getCompanyId()) && getCategoryId().equals(deviceInfo.getCategoryId()) && getModelId().equals(deviceInfo.getModelId()) && getName().equals(deviceInfo.getName()) && getBattery() == deviceInfo.getBattery() && this.btStatus_ == deviceInfo.btStatus_ && this.unknownFields.equals(deviceInfo.unknownFields);
        }

        public int getBattery() {
            return this.battery_;
        }

        public String getBtMac() {
            Object obj = this.btMac_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.btMac_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getBtMacBytes() {
            Object obj = this.btMac_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.btMac_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public BTSTATUS getBtStatus() {
            BTSTATUS valueOf = BTSTATUS.valueOf(this.btStatus_);
            return valueOf == null ? BTSTATUS.UNRECOGNIZED : valueOf;
        }

        public int getBtStatusValue() {
            return this.btStatus_;
        }

        public String getCategoryId() {
            Object obj = this.categoryId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.categoryId_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getCategoryIdBytes() {
            Object obj = this.categoryId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.categoryId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getCompanyId() {
            Object obj = this.companyId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.companyId_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getCompanyIdBytes() {
            Object obj = this.companyId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.companyId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getModelId() {
            Object obj = this.modelId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.modelId_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getModelIdBytes() {
            Object obj = this.modelId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.modelId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public ByteString getName() {
            return this.name_;
        }

        public Parser<DeviceInfo> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = !getBtMacBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.btMac_) : 0;
            if (!getCompanyIdBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(2, this.companyId_);
            }
            if (!getCategoryIdBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(3, this.categoryId_);
            }
            if (!getModelIdBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(4, this.modelId_);
            }
            if (!this.name_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeBytesSize(5, this.name_);
            }
            int i2 = this.battery_;
            if (i2 != 0) {
                computeStringSize += CodedOutputStream.computeInt32Size(6, i2);
            }
            if (this.btStatus_ != BTSTATUS.DEFAULT.getNumber()) {
                computeStringSize += CodedOutputStream.computeEnumSize(7, this.btStatus_);
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
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
            int hashCode = ((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getBtMac().hashCode()) * 37) + 2) * 53) + getCompanyId().hashCode()) * 37) + 3) * 53) + getCategoryId().hashCode()) * 37) + 4) * 53) + getModelId().hashCode()) * 37) + 5) * 53) + getName().hashCode()) * 37) + 6) * 53) + getBattery()) * 37) + 7) * 53) + this.btStatus_) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StarryLinkEncrypt.internal_static_Starry_DeviceInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DeviceInfo.class, Builder.class);
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
            if (!getBtMacBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.btMac_);
            }
            if (!getCompanyIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.companyId_);
            }
            if (!getCategoryIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.categoryId_);
            }
            if (!getModelIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.modelId_);
            }
            if (!this.name_.isEmpty()) {
                codedOutputStream.writeBytes(5, this.name_);
            }
            int i = this.battery_;
            if (i != 0) {
                codedOutputStream.writeInt32(6, i);
            }
            if (this.btStatus_ != BTSTATUS.DEFAULT.getNumber()) {
                codedOutputStream.writeEnum(7, this.btStatus_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DeviceInfoOrBuilder {
            private int battery_;
            private Object btMac_;
            private int btStatus_;
            private Object categoryId_;
            private Object companyId_;
            private Object modelId_;
            private ByteString name_;

            public static final Descriptors.Descriptor getDescriptor() {
                return StarryLinkEncrypt.internal_static_Starry_DeviceInfo_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearBattery() {
                this.battery_ = 0;
                onChanged();
                return this;
            }

            public Builder clearBtMac() {
                this.btMac_ = DeviceInfo.getDefaultInstance().getBtMac();
                onChanged();
                return this;
            }

            public Builder clearBtStatus() {
                this.btStatus_ = 0;
                onChanged();
                return this;
            }

            public Builder clearCategoryId() {
                this.categoryId_ = DeviceInfo.getDefaultInstance().getCategoryId();
                onChanged();
                return this;
            }

            public Builder clearCompanyId() {
                this.companyId_ = DeviceInfo.getDefaultInstance().getCompanyId();
                onChanged();
                return this;
            }

            public Builder clearModelId() {
                this.modelId_ = DeviceInfo.getDefaultInstance().getModelId();
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = DeviceInfo.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public int getBattery() {
                return this.battery_;
            }

            public String getBtMac() {
                Object obj = this.btMac_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.btMac_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getBtMacBytes() {
                Object obj = this.btMac_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.btMac_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public BTSTATUS getBtStatus() {
                BTSTATUS valueOf = BTSTATUS.valueOf(this.btStatus_);
                return valueOf == null ? BTSTATUS.UNRECOGNIZED : valueOf;
            }

            public int getBtStatusValue() {
                return this.btStatus_;
            }

            public String getCategoryId() {
                Object obj = this.categoryId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.categoryId_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getCategoryIdBytes() {
                Object obj = this.categoryId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.categoryId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getCompanyId() {
                Object obj = this.companyId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.companyId_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getCompanyIdBytes() {
                Object obj = this.companyId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.companyId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return StarryLinkEncrypt.internal_static_Starry_DeviceInfo_descriptor;
            }

            public String getModelId() {
                Object obj = this.modelId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.modelId_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getModelIdBytes() {
                Object obj = this.modelId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.modelId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public ByteString getName() {
                return this.name_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StarryLinkEncrypt.internal_static_Starry_DeviceInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DeviceInfo.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setBattery(int i) {
                this.battery_ = i;
                onChanged();
                return this;
            }

            public Builder setBtMac(String str) {
                str.getClass();
                this.btMac_ = str;
                onChanged();
                return this;
            }

            public Builder setBtMacBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.btMac_ = byteString;
                onChanged();
                return this;
            }

            public Builder setBtStatus(BTSTATUS btstatus) {
                btstatus.getClass();
                this.btStatus_ = btstatus.getNumber();
                onChanged();
                return this;
            }

            public Builder setBtStatusValue(int i) {
                this.btStatus_ = i;
                onChanged();
                return this;
            }

            public Builder setCategoryId(String str) {
                str.getClass();
                this.categoryId_ = str;
                onChanged();
                return this;
            }

            public Builder setCategoryIdBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.categoryId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setCompanyId(String str) {
                str.getClass();
                this.companyId_ = str;
                onChanged();
                return this;
            }

            public Builder setCompanyIdBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.companyId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setModelId(String str) {
                str.getClass();
                this.modelId_ = str;
                onChanged();
                return this;
            }

            public Builder setModelIdBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.modelId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setName(ByteString byteString) {
                byteString.getClass();
                this.name_ = byteString;
                onChanged();
                return this;
            }

            private Builder() {
                this.btMac_ = "";
                this.companyId_ = "";
                this.categoryId_ = "";
                this.modelId_ = "";
                this.name_ = ByteString.EMPTY;
                this.btStatus_ = 0;
                maybeForceBuilderInitialization();
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public DeviceInfo build() {
                DeviceInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
            }

            public DeviceInfo buildPartial() {
                DeviceInfo deviceInfo = new DeviceInfo((GeneratedMessageV3.Builder) this);
                Object unused = deviceInfo.btMac_ = this.btMac_;
                Object unused2 = deviceInfo.companyId_ = this.companyId_;
                Object unused3 = deviceInfo.categoryId_ = this.categoryId_;
                Object unused4 = deviceInfo.modelId_ = this.modelId_;
                ByteString unused5 = deviceInfo.name_ = this.name_;
                int unused6 = deviceInfo.battery_ = this.battery_;
                int unused7 = deviceInfo.btStatus_ = this.btStatus_;
                onBuilt();
                return deviceInfo;
            }

            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public DeviceInfo getDefaultInstanceForType() {
                return DeviceInfo.getDefaultInstance();
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
                this.btMac_ = "";
                this.companyId_ = "";
                this.categoryId_ = "";
                this.modelId_ = "";
                this.name_ = ByteString.EMPTY;
                this.battery_ = 0;
                this.btStatus_ = 0;
                return this;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder mergeFrom(Message message) {
                if (message instanceof DeviceInfo) {
                    return mergeFrom((DeviceInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(DeviceInfo deviceInfo) {
                if (deviceInfo == DeviceInfo.getDefaultInstance()) {
                    return this;
                }
                if (!deviceInfo.getBtMac().isEmpty()) {
                    this.btMac_ = deviceInfo.btMac_;
                    onChanged();
                }
                if (!deviceInfo.getCompanyId().isEmpty()) {
                    this.companyId_ = deviceInfo.companyId_;
                    onChanged();
                }
                if (!deviceInfo.getCategoryId().isEmpty()) {
                    this.categoryId_ = deviceInfo.categoryId_;
                    onChanged();
                }
                if (!deviceInfo.getModelId().isEmpty()) {
                    this.modelId_ = deviceInfo.modelId_;
                    onChanged();
                }
                if (deviceInfo.getName() != ByteString.EMPTY) {
                    setName(deviceInfo.getName());
                }
                if (deviceInfo.getBattery() != 0) {
                    setBattery(deviceInfo.getBattery());
                }
                if (deviceInfo.btStatus_ != 0) {
                    setBtStatusValue(deviceInfo.getBtStatusValue());
                }
                mergeUnknownFields(deviceInfo.unknownFields);
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.btMac_ = "";
                this.companyId_ = "";
                this.categoryId_ = "";
                this.modelId_ = "";
                this.name_ = ByteString.EMPTY;
                this.btStatus_ = 0;
                maybeForceBuilderInitialization();
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public Starry.StarryLinkEncrypt.DeviceInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = Starry.StarryLinkEncrypt.DeviceInfo.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    Starry.StarryLinkEncrypt$DeviceInfo r3 = (Starry.StarryLinkEncrypt.DeviceInfo) r3     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    if (r3 == 0) goto L_0x0010
                    r2.mergeFrom((Starry.StarryLinkEncrypt.DeviceInfo) r3)
                L_0x0010:
                    return r2
                L_0x0011:
                    r3 = move-exception
                    goto L_0x0021
                L_0x0013:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x0011 }
                    Starry.StarryLinkEncrypt$DeviceInfo r4 = (Starry.StarryLinkEncrypt.DeviceInfo) r4     // Catch:{ all -> 0x0011 }
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001f }
                    throw r3     // Catch:{ all -> 0x001f }
                L_0x001f:
                    r3 = move-exception
                    r0 = r4
                L_0x0021:
                    if (r0 == 0) goto L_0x0026
                    r2.mergeFrom((Starry.StarryLinkEncrypt.DeviceInfo) r0)
                L_0x0026:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: Starry.StarryLinkEncrypt.DeviceInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):Starry.StarryLinkEncrypt$DeviceInfo$Builder");
            }
        }

        public static Builder newBuilder(DeviceInfo deviceInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(deviceInfo);
        }

        public static DeviceInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private DeviceInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        public static DeviceInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeviceInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static DeviceInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public DeviceInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static DeviceInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        private DeviceInfo() {
            this.memoizedIsInitialized = -1;
            this.btMac_ = "";
            this.companyId_ = "";
            this.categoryId_ = "";
            this.modelId_ = "";
            this.name_ = ByteString.EMPTY;
            this.battery_ = 0;
            this.btStatus_ = 0;
        }

        public static DeviceInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static DeviceInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static DeviceInfo parseFrom(InputStream inputStream) throws IOException {
            return (DeviceInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static DeviceInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeviceInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static DeviceInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DeviceInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static DeviceInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeviceInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        private DeviceInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            this.btMac_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 18) {
                            this.companyId_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 26) {
                            this.categoryId_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 34) {
                            this.modelId_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 42) {
                            this.name_ = codedInputStream.readBytes();
                        } else if (readTag == 48) {
                            this.battery_ = codedInputStream.readInt32();
                        } else if (readTag == 56) {
                            this.btStatus_ = codedInputStream.readEnum();
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
    }

    public interface DeviceInfoOrBuilder extends MessageOrBuilder {
        int getBattery();

        String getBtMac();

        ByteString getBtMacBytes();

        BTSTATUS getBtStatus();

        int getBtStatusValue();

        String getCategoryId();

        ByteString getCategoryIdBytes();

        String getCompanyId();

        ByteString getCompanyIdBytes();

        String getModelId();

        ByteString getModelIdBytes();

        ByteString getName();
    }

    public static final class IOSConnectBt extends GeneratedMessageV3 implements IOSConnectBtOrBuilder {
        public static final int CYCLECOUNT_FIELD_NUMBER = 4;
        private static final IOSConnectBt DEFAULT_INSTANCE = new IOSConnectBt();
        public static final int DEVICENAME_FIELD_NUMBER = 1;
        public static final int ISFIRSTCONNECT_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */
        public static final Parser<IOSConnectBt> PARSER = new AbstractParser<IOSConnectBt>() {
            public IOSConnectBt parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new IOSConnectBt(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int TIMEOUT_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int cycleCount_;
        /* access modifiers changed from: private */
        public volatile Object deviceName_;
        /* access modifiers changed from: private */
        public boolean isFirstConnect_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public int timeout_;

        public static IOSConnectBt getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StarryLinkEncrypt.internal_static_Starry_IOSConnectBt_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static IOSConnectBt parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IOSConnectBt) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static IOSConnectBt parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<IOSConnectBt> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IOSConnectBt)) {
                return super.equals(obj);
            }
            IOSConnectBt iOSConnectBt = (IOSConnectBt) obj;
            return getDeviceName().equals(iOSConnectBt.getDeviceName()) && getIsFirstConnect() == iOSConnectBt.getIsFirstConnect() && getTimeout() == iOSConnectBt.getTimeout() && getCycleCount() == iOSConnectBt.getCycleCount() && this.unknownFields.equals(iOSConnectBt.unknownFields);
        }

        public int getCycleCount() {
            return this.cycleCount_;
        }

        public String getDeviceName() {
            Object obj = this.deviceName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceName_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getDeviceNameBytes() {
            Object obj = this.deviceName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean getIsFirstConnect() {
            return this.isFirstConnect_;
        }

        public Parser<IOSConnectBt> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = !getDeviceNameBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.deviceName_) : 0;
            boolean z = this.isFirstConnect_;
            if (z) {
                computeStringSize += CodedOutputStream.computeBoolSize(2, z);
            }
            int i2 = this.timeout_;
            if (i2 != 0) {
                computeStringSize += CodedOutputStream.computeInt32Size(3, i2);
            }
            int i3 = this.cycleCount_;
            if (i3 != 0) {
                computeStringSize += CodedOutputStream.computeInt32Size(4, i3);
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public int getTimeout() {
            return this.timeout_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getDeviceName().hashCode()) * 37) + 2) * 53) + Internal.hashBoolean(getIsFirstConnect())) * 37) + 3) * 53) + getTimeout()) * 37) + 4) * 53) + getCycleCount()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StarryLinkEncrypt.internal_static_Starry_IOSConnectBt_fieldAccessorTable.ensureFieldAccessorsInitialized(IOSConnectBt.class, Builder.class);
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
            if (!getDeviceNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.deviceName_);
            }
            boolean z = this.isFirstConnect_;
            if (z) {
                codedOutputStream.writeBool(2, z);
            }
            int i = this.timeout_;
            if (i != 0) {
                codedOutputStream.writeInt32(3, i);
            }
            int i2 = this.cycleCount_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(4, i2);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IOSConnectBtOrBuilder {
            private int cycleCount_;
            private Object deviceName_;
            private boolean isFirstConnect_;
            private int timeout_;

            public static final Descriptors.Descriptor getDescriptor() {
                return StarryLinkEncrypt.internal_static_Starry_IOSConnectBt_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearCycleCount() {
                this.cycleCount_ = 0;
                onChanged();
                return this;
            }

            public Builder clearDeviceName() {
                this.deviceName_ = IOSConnectBt.getDefaultInstance().getDeviceName();
                onChanged();
                return this;
            }

            public Builder clearIsFirstConnect() {
                this.isFirstConnect_ = false;
                onChanged();
                return this;
            }

            public Builder clearTimeout() {
                this.timeout_ = 0;
                onChanged();
                return this;
            }

            public int getCycleCount() {
                return this.cycleCount_;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return StarryLinkEncrypt.internal_static_Starry_IOSConnectBt_descriptor;
            }

            public String getDeviceName() {
                Object obj = this.deviceName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.deviceName_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getDeviceNameBytes() {
                Object obj = this.deviceName_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.deviceName_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public boolean getIsFirstConnect() {
                return this.isFirstConnect_;
            }

            public int getTimeout() {
                return this.timeout_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StarryLinkEncrypt.internal_static_Starry_IOSConnectBt_fieldAccessorTable.ensureFieldAccessorsInitialized(IOSConnectBt.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setCycleCount(int i) {
                this.cycleCount_ = i;
                onChanged();
                return this;
            }

            public Builder setDeviceName(String str) {
                str.getClass();
                this.deviceName_ = str;
                onChanged();
                return this;
            }

            public Builder setDeviceNameBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.deviceName_ = byteString;
                onChanged();
                return this;
            }

            public Builder setIsFirstConnect(boolean z) {
                this.isFirstConnect_ = z;
                onChanged();
                return this;
            }

            public Builder setTimeout(int i) {
                this.timeout_ = i;
                onChanged();
                return this;
            }

            private Builder() {
                this.deviceName_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public IOSConnectBt build() {
                IOSConnectBt buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
            }

            public IOSConnectBt buildPartial() {
                IOSConnectBt iOSConnectBt = new IOSConnectBt((GeneratedMessageV3.Builder) this);
                Object unused = iOSConnectBt.deviceName_ = this.deviceName_;
                boolean unused2 = iOSConnectBt.isFirstConnect_ = this.isFirstConnect_;
                int unused3 = iOSConnectBt.timeout_ = this.timeout_;
                int unused4 = iOSConnectBt.cycleCount_ = this.cycleCount_;
                onBuilt();
                return iOSConnectBt;
            }

            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public IOSConnectBt getDefaultInstanceForType() {
                return IOSConnectBt.getDefaultInstance();
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
                this.deviceName_ = "";
                this.isFirstConnect_ = false;
                this.timeout_ = 0;
                this.cycleCount_ = 0;
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.deviceName_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder mergeFrom(Message message) {
                if (message instanceof IOSConnectBt) {
                    return mergeFrom((IOSConnectBt) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(IOSConnectBt iOSConnectBt) {
                if (iOSConnectBt == IOSConnectBt.getDefaultInstance()) {
                    return this;
                }
                if (!iOSConnectBt.getDeviceName().isEmpty()) {
                    this.deviceName_ = iOSConnectBt.deviceName_;
                    onChanged();
                }
                if (iOSConnectBt.getIsFirstConnect()) {
                    setIsFirstConnect(iOSConnectBt.getIsFirstConnect());
                }
                if (iOSConnectBt.getTimeout() != 0) {
                    setTimeout(iOSConnectBt.getTimeout());
                }
                if (iOSConnectBt.getCycleCount() != 0) {
                    setCycleCount(iOSConnectBt.getCycleCount());
                }
                mergeUnknownFields(iOSConnectBt.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public Starry.StarryLinkEncrypt.IOSConnectBt.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = Starry.StarryLinkEncrypt.IOSConnectBt.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    Starry.StarryLinkEncrypt$IOSConnectBt r3 = (Starry.StarryLinkEncrypt.IOSConnectBt) r3     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    if (r3 == 0) goto L_0x0010
                    r2.mergeFrom((Starry.StarryLinkEncrypt.IOSConnectBt) r3)
                L_0x0010:
                    return r2
                L_0x0011:
                    r3 = move-exception
                    goto L_0x0021
                L_0x0013:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x0011 }
                    Starry.StarryLinkEncrypt$IOSConnectBt r4 = (Starry.StarryLinkEncrypt.IOSConnectBt) r4     // Catch:{ all -> 0x0011 }
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001f }
                    throw r3     // Catch:{ all -> 0x001f }
                L_0x001f:
                    r3 = move-exception
                    r0 = r4
                L_0x0021:
                    if (r0 == 0) goto L_0x0026
                    r2.mergeFrom((Starry.StarryLinkEncrypt.IOSConnectBt) r0)
                L_0x0026:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: Starry.StarryLinkEncrypt.IOSConnectBt.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):Starry.StarryLinkEncrypt$IOSConnectBt$Builder");
            }
        }

        public static Builder newBuilder(IOSConnectBt iOSConnectBt) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(iOSConnectBt);
        }

        public static IOSConnectBt parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private IOSConnectBt(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        public static IOSConnectBt parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (IOSConnectBt) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static IOSConnectBt parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public IOSConnectBt getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static IOSConnectBt parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        private IOSConnectBt() {
            this.memoizedIsInitialized = -1;
            this.deviceName_ = "";
            this.isFirstConnect_ = false;
            this.timeout_ = 0;
            this.cycleCount_ = 0;
        }

        public static IOSConnectBt parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static IOSConnectBt parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static IOSConnectBt parseFrom(InputStream inputStream) throws IOException {
            return (IOSConnectBt) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static IOSConnectBt parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (IOSConnectBt) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        private IOSConnectBt(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            this.deviceName_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 16) {
                            this.isFirstConnect_ = codedInputStream.readBool();
                        } else if (readTag == 24) {
                            this.timeout_ = codedInputStream.readInt32();
                        } else if (readTag == 32) {
                            this.cycleCount_ = codedInputStream.readInt32();
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

        public static IOSConnectBt parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (IOSConnectBt) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static IOSConnectBt parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (IOSConnectBt) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    public interface IOSConnectBtOrBuilder extends MessageOrBuilder {
        int getCycleCount();

        String getDeviceName();

        ByteString getDeviceNameBytes();

        boolean getIsFirstConnect();

        int getTimeout();
    }

    public enum IosBleSTATUS implements ProtocolMessageEnum {
        BLE_BONDED(0),
        BLE_BONDING(1),
        BLE_NOBOND(2),
        UNRECOGNIZED(-1);
        
        public static final int BLE_BONDED_VALUE = 0;
        public static final int BLE_BONDING_VALUE = 1;
        public static final int BLE_NOBOND_VALUE = 2;
        private static final IosBleSTATUS[] VALUES = null;
        private static final Internal.EnumLiteMap<IosBleSTATUS> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<IosBleSTATUS>() {
                public IosBleSTATUS findValueByNumber(int i) {
                    return IosBleSTATUS.forNumber(i);
                }
            };
            VALUES = values();
        }

        private IosBleSTATUS(int i) {
            this.value = i;
        }

        public static IosBleSTATUS forNumber(int i) {
            if (i == 0) {
                return BLE_BONDED;
            }
            if (i == 1) {
                return BLE_BONDING;
            }
            if (i != 2) {
                return null;
            }
            return BLE_NOBOND;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return StarryLinkEncrypt.getDescriptor().getEnumTypes().get(2);
        }

        public static Internal.EnumLiteMap<IosBleSTATUS> internalGetValueMap() {
            return internalValueMap;
        }

        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }

        @Deprecated
        public static IosBleSTATUS valueOf(int i) {
            return forNumber(i);
        }

        public static IosBleSTATUS valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[enumValueDescriptor.getIndex()];
            }
        }
    }

    public static final class LinkProtocol extends GeneratedMessageV3 implements LinkProtocolOrBuilder {
        public static final int CMD_FIELD_NUMBER = 2;
        public static final int DATA_FIELD_NUMBER = 3;
        private static final LinkProtocol DEFAULT_INSTANCE = new LinkProtocol();
        public static final int DEVICE_ID_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final Parser<LinkProtocol> PARSER = new AbstractParser<LinkProtocol>() {
            public LinkProtocol parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LinkProtocol(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int cmd_;
        /* access modifiers changed from: private */
        public ByteString data_;
        /* access modifiers changed from: private */
        public ByteString deviceId_;
        private byte memoizedIsInitialized;

        public static LinkProtocol getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StarryLinkEncrypt.internal_static_Starry_LinkProtocol_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static LinkProtocol parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LinkProtocol) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LinkProtocol parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<LinkProtocol> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LinkProtocol)) {
                return super.equals(obj);
            }
            LinkProtocol linkProtocol = (LinkProtocol) obj;
            return getDeviceId().equals(linkProtocol.getDeviceId()) && this.cmd_ == linkProtocol.cmd_ && getData().equals(linkProtocol.getData()) && this.unknownFields.equals(linkProtocol.unknownFields);
        }

        public COMMAND getCmd() {
            COMMAND valueOf = COMMAND.valueOf(this.cmd_);
            return valueOf == null ? COMMAND.UNRECOGNIZED : valueOf;
        }

        public int getCmdValue() {
            return this.cmd_;
        }

        public ByteString getData() {
            return this.data_;
        }

        public ByteString getDeviceId() {
            return this.deviceId_;
        }

        public Parser<LinkProtocol> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = !this.deviceId_.isEmpty() ? CodedOutputStream.computeBytesSize(1, this.deviceId_) : 0;
            if (this.cmd_ != COMMAND.INIT.getNumber()) {
                computeBytesSize += CodedOutputStream.computeEnumSize(2, this.cmd_);
            }
            if (!this.data_.isEmpty()) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, this.data_);
            }
            int serializedSize = computeBytesSize + this.unknownFields.getSerializedSize();
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
            int hashCode = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getDeviceId().hashCode()) * 37) + 2) * 53) + this.cmd_) * 37) + 3) * 53) + getData().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StarryLinkEncrypt.internal_static_Starry_LinkProtocol_fieldAccessorTable.ensureFieldAccessorsInitialized(LinkProtocol.class, Builder.class);
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
            if (!this.deviceId_.isEmpty()) {
                codedOutputStream.writeBytes(1, this.deviceId_);
            }
            if (this.cmd_ != COMMAND.INIT.getNumber()) {
                codedOutputStream.writeEnum(2, this.cmd_);
            }
            if (!this.data_.isEmpty()) {
                codedOutputStream.writeBytes(3, this.data_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LinkProtocolOrBuilder {
            private int cmd_;
            private ByteString data_;
            private ByteString deviceId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return StarryLinkEncrypt.internal_static_Starry_LinkProtocol_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearCmd() {
                this.cmd_ = 0;
                onChanged();
                return this;
            }

            public Builder clearData() {
                this.data_ = LinkProtocol.getDefaultInstance().getData();
                onChanged();
                return this;
            }

            public Builder clearDeviceId() {
                this.deviceId_ = LinkProtocol.getDefaultInstance().getDeviceId();
                onChanged();
                return this;
            }

            public COMMAND getCmd() {
                COMMAND valueOf = COMMAND.valueOf(this.cmd_);
                return valueOf == null ? COMMAND.UNRECOGNIZED : valueOf;
            }

            public int getCmdValue() {
                return this.cmd_;
            }

            public ByteString getData() {
                return this.data_;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return StarryLinkEncrypt.internal_static_Starry_LinkProtocol_descriptor;
            }

            public ByteString getDeviceId() {
                return this.deviceId_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StarryLinkEncrypt.internal_static_Starry_LinkProtocol_fieldAccessorTable.ensureFieldAccessorsInitialized(LinkProtocol.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setCmd(COMMAND command) {
                command.getClass();
                this.cmd_ = command.getNumber();
                onChanged();
                return this;
            }

            public Builder setCmdValue(int i) {
                this.cmd_ = i;
                onChanged();
                return this;
            }

            public Builder setData(ByteString byteString) {
                byteString.getClass();
                this.data_ = byteString;
                onChanged();
                return this;
            }

            public Builder setDeviceId(ByteString byteString) {
                byteString.getClass();
                this.deviceId_ = byteString;
                onChanged();
                return this;
            }

            private Builder() {
                ByteString byteString = ByteString.EMPTY;
                this.deviceId_ = byteString;
                this.cmd_ = 0;
                this.data_ = byteString;
                maybeForceBuilderInitialization();
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public LinkProtocol build() {
                LinkProtocol buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
            }

            public LinkProtocol buildPartial() {
                LinkProtocol linkProtocol = new LinkProtocol((GeneratedMessageV3.Builder) this);
                ByteString unused = linkProtocol.deviceId_ = this.deviceId_;
                int unused2 = linkProtocol.cmd_ = this.cmd_;
                ByteString unused3 = linkProtocol.data_ = this.data_;
                onBuilt();
                return linkProtocol;
            }

            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public LinkProtocol getDefaultInstanceForType() {
                return LinkProtocol.getDefaultInstance();
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
                ByteString byteString = ByteString.EMPTY;
                this.deviceId_ = byteString;
                this.cmd_ = 0;
                this.data_ = byteString;
                return this;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder mergeFrom(Message message) {
                if (message instanceof LinkProtocol) {
                    return mergeFrom((LinkProtocol) message);
                }
                super.mergeFrom(message);
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                ByteString byteString = ByteString.EMPTY;
                this.deviceId_ = byteString;
                this.cmd_ = 0;
                this.data_ = byteString;
                maybeForceBuilderInitialization();
            }

            public Builder mergeFrom(LinkProtocol linkProtocol) {
                if (linkProtocol == LinkProtocol.getDefaultInstance()) {
                    return this;
                }
                ByteString deviceId = linkProtocol.getDeviceId();
                ByteString byteString = ByteString.EMPTY;
                if (deviceId != byteString) {
                    setDeviceId(linkProtocol.getDeviceId());
                }
                if (linkProtocol.cmd_ != 0) {
                    setCmdValue(linkProtocol.getCmdValue());
                }
                if (linkProtocol.getData() != byteString) {
                    setData(linkProtocol.getData());
                }
                mergeUnknownFields(linkProtocol.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public Starry.StarryLinkEncrypt.LinkProtocol.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = Starry.StarryLinkEncrypt.LinkProtocol.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    Starry.StarryLinkEncrypt$LinkProtocol r3 = (Starry.StarryLinkEncrypt.LinkProtocol) r3     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    if (r3 == 0) goto L_0x0010
                    r2.mergeFrom((Starry.StarryLinkEncrypt.LinkProtocol) r3)
                L_0x0010:
                    return r2
                L_0x0011:
                    r3 = move-exception
                    goto L_0x0021
                L_0x0013:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x0011 }
                    Starry.StarryLinkEncrypt$LinkProtocol r4 = (Starry.StarryLinkEncrypt.LinkProtocol) r4     // Catch:{ all -> 0x0011 }
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001f }
                    throw r3     // Catch:{ all -> 0x001f }
                L_0x001f:
                    r3 = move-exception
                    r0 = r4
                L_0x0021:
                    if (r0 == 0) goto L_0x0026
                    r2.mergeFrom((Starry.StarryLinkEncrypt.LinkProtocol) r0)
                L_0x0026:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: Starry.StarryLinkEncrypt.LinkProtocol.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):Starry.StarryLinkEncrypt$LinkProtocol$Builder");
            }
        }

        public static Builder newBuilder(LinkProtocol linkProtocol) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(linkProtocol);
        }

        public static LinkProtocol parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private LinkProtocol(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        public static LinkProtocol parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LinkProtocol) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LinkProtocol parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public LinkProtocol getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static LinkProtocol parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        private LinkProtocol() {
            this.memoizedIsInitialized = -1;
            ByteString byteString = ByteString.EMPTY;
            this.deviceId_ = byteString;
            this.cmd_ = 0;
            this.data_ = byteString;
        }

        public static LinkProtocol parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static LinkProtocol parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LinkProtocol parseFrom(InputStream inputStream) throws IOException {
            return (LinkProtocol) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LinkProtocol parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LinkProtocol) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        private LinkProtocol(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            this.deviceId_ = codedInputStream.readBytes();
                        } else if (readTag == 16) {
                            this.cmd_ = codedInputStream.readEnum();
                        } else if (readTag == 26) {
                            this.data_ = codedInputStream.readBytes();
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

        public static LinkProtocol parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LinkProtocol) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LinkProtocol parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LinkProtocol) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    public interface LinkProtocolOrBuilder extends MessageOrBuilder {
        COMMAND getCmd();

        int getCmdValue();

        ByteString getData();

        ByteString getDeviceId();
    }

    public static final class ReadSwitchInfo extends GeneratedMessageV3 implements ReadSwitchInfoOrBuilder {
        private static final ReadSwitchInfo DEFAULT_INSTANCE = new ReadSwitchInfo();
        public static final int INFO_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final Parser<ReadSwitchInfo> PARSER = new AbstractParser<ReadSwitchInfo>() {
            public ReadSwitchInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ReadSwitchInfo(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public ByteString info_;
        private byte memoizedIsInitialized;

        public static ReadSwitchInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StarryLinkEncrypt.internal_static_Starry_ReadSwitchInfo_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static ReadSwitchInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReadSwitchInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ReadSwitchInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<ReadSwitchInfo> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ReadSwitchInfo)) {
                return super.equals(obj);
            }
            ReadSwitchInfo readSwitchInfo = (ReadSwitchInfo) obj;
            return getInfo().equals(readSwitchInfo.getInfo()) && this.unknownFields.equals(readSwitchInfo.unknownFields);
        }

        public ByteString getInfo() {
            return this.info_;
        }

        public Parser<ReadSwitchInfo> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (!this.info_.isEmpty() ? CodedOutputStream.computeBytesSize(1, this.info_) : 0) + this.unknownFields.getSerializedSize();
            this.memoizedSize = computeBytesSize;
            return computeBytesSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getInfo().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StarryLinkEncrypt.internal_static_Starry_ReadSwitchInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ReadSwitchInfo.class, Builder.class);
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
            if (!this.info_.isEmpty()) {
                codedOutputStream.writeBytes(1, this.info_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ReadSwitchInfoOrBuilder {
            private ByteString info_;

            public static final Descriptors.Descriptor getDescriptor() {
                return StarryLinkEncrypt.internal_static_Starry_ReadSwitchInfo_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearInfo() {
                this.info_ = ReadSwitchInfo.getDefaultInstance().getInfo();
                onChanged();
                return this;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return StarryLinkEncrypt.internal_static_Starry_ReadSwitchInfo_descriptor;
            }

            public ByteString getInfo() {
                return this.info_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StarryLinkEncrypt.internal_static_Starry_ReadSwitchInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ReadSwitchInfo.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setInfo(ByteString byteString) {
                byteString.getClass();
                this.info_ = byteString;
                onChanged();
                return this;
            }

            private Builder() {
                this.info_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public ReadSwitchInfo build() {
                ReadSwitchInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
            }

            public ReadSwitchInfo buildPartial() {
                ReadSwitchInfo readSwitchInfo = new ReadSwitchInfo((GeneratedMessageV3.Builder) this);
                ByteString unused = readSwitchInfo.info_ = this.info_;
                onBuilt();
                return readSwitchInfo;
            }

            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public ReadSwitchInfo getDefaultInstanceForType() {
                return ReadSwitchInfo.getDefaultInstance();
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
                this.info_ = ByteString.EMPTY;
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.info_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder mergeFrom(Message message) {
                if (message instanceof ReadSwitchInfo) {
                    return mergeFrom((ReadSwitchInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(ReadSwitchInfo readSwitchInfo) {
                if (readSwitchInfo == ReadSwitchInfo.getDefaultInstance()) {
                    return this;
                }
                if (readSwitchInfo.getInfo() != ByteString.EMPTY) {
                    setInfo(readSwitchInfo.getInfo());
                }
                mergeUnknownFields(readSwitchInfo.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public Starry.StarryLinkEncrypt.ReadSwitchInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = Starry.StarryLinkEncrypt.ReadSwitchInfo.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    Starry.StarryLinkEncrypt$ReadSwitchInfo r3 = (Starry.StarryLinkEncrypt.ReadSwitchInfo) r3     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    if (r3 == 0) goto L_0x0010
                    r2.mergeFrom((Starry.StarryLinkEncrypt.ReadSwitchInfo) r3)
                L_0x0010:
                    return r2
                L_0x0011:
                    r3 = move-exception
                    goto L_0x0021
                L_0x0013:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x0011 }
                    Starry.StarryLinkEncrypt$ReadSwitchInfo r4 = (Starry.StarryLinkEncrypt.ReadSwitchInfo) r4     // Catch:{ all -> 0x0011 }
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001f }
                    throw r3     // Catch:{ all -> 0x001f }
                L_0x001f:
                    r3 = move-exception
                    r0 = r4
                L_0x0021:
                    if (r0 == 0) goto L_0x0026
                    r2.mergeFrom((Starry.StarryLinkEncrypt.ReadSwitchInfo) r0)
                L_0x0026:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: Starry.StarryLinkEncrypt.ReadSwitchInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):Starry.StarryLinkEncrypt$ReadSwitchInfo$Builder");
            }
        }

        public static Builder newBuilder(ReadSwitchInfo readSwitchInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(readSwitchInfo);
        }

        public static ReadSwitchInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private ReadSwitchInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        public static ReadSwitchInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadSwitchInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ReadSwitchInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public ReadSwitchInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static ReadSwitchInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        private ReadSwitchInfo() {
            this.memoizedIsInitialized = -1;
            this.info_ = ByteString.EMPTY;
        }

        public static ReadSwitchInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static ReadSwitchInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static ReadSwitchInfo parseFrom(InputStream inputStream) throws IOException {
            return (ReadSwitchInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        private ReadSwitchInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            this.info_ = codedInputStream.readBytes();
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

        public static ReadSwitchInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadSwitchInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ReadSwitchInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ReadSwitchInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ReadSwitchInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadSwitchInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ReadSwitchInfoOrBuilder extends MessageOrBuilder {
        ByteString getInfo();
    }

    public static final class ReadSwitchKey extends GeneratedMessageV3 implements ReadSwitchKeyOrBuilder {
        public static final int BTMAC_FIELD_NUMBER = 2;
        private static final ReadSwitchKey DEFAULT_INSTANCE = new ReadSwitchKey();
        public static final int KEY_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final Parser<ReadSwitchKey> PARSER = new AbstractParser<ReadSwitchKey>() {
            public ReadSwitchKey parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ReadSwitchKey(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public ByteString btMac_;
        /* access modifiers changed from: private */
        public ByteString key_;
        private byte memoizedIsInitialized;

        public static ReadSwitchKey getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StarryLinkEncrypt.internal_static_Starry_ReadSwitchKey_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static ReadSwitchKey parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReadSwitchKey) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ReadSwitchKey parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<ReadSwitchKey> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ReadSwitchKey)) {
                return super.equals(obj);
            }
            ReadSwitchKey readSwitchKey = (ReadSwitchKey) obj;
            return getKey().equals(readSwitchKey.getKey()) && getBtMac().equals(readSwitchKey.getBtMac()) && this.unknownFields.equals(readSwitchKey.unknownFields);
        }

        public ByteString getBtMac() {
            return this.btMac_;
        }

        public ByteString getKey() {
            return this.key_;
        }

        public Parser<ReadSwitchKey> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = !this.key_.isEmpty() ? CodedOutputStream.computeBytesSize(1, this.key_) : 0;
            if (!this.btMac_.isEmpty()) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, this.btMac_);
            }
            int serializedSize = computeBytesSize + this.unknownFields.getSerializedSize();
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
            int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getKey().hashCode()) * 37) + 2) * 53) + getBtMac().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StarryLinkEncrypt.internal_static_Starry_ReadSwitchKey_fieldAccessorTable.ensureFieldAccessorsInitialized(ReadSwitchKey.class, Builder.class);
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
            if (!this.key_.isEmpty()) {
                codedOutputStream.writeBytes(1, this.key_);
            }
            if (!this.btMac_.isEmpty()) {
                codedOutputStream.writeBytes(2, this.btMac_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ReadSwitchKeyOrBuilder {
            private ByteString btMac_;
            private ByteString key_;

            public static final Descriptors.Descriptor getDescriptor() {
                return StarryLinkEncrypt.internal_static_Starry_ReadSwitchKey_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearBtMac() {
                this.btMac_ = ReadSwitchKey.getDefaultInstance().getBtMac();
                onChanged();
                return this;
            }

            public Builder clearKey() {
                this.key_ = ReadSwitchKey.getDefaultInstance().getKey();
                onChanged();
                return this;
            }

            public ByteString getBtMac() {
                return this.btMac_;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return StarryLinkEncrypt.internal_static_Starry_ReadSwitchKey_descriptor;
            }

            public ByteString getKey() {
                return this.key_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StarryLinkEncrypt.internal_static_Starry_ReadSwitchKey_fieldAccessorTable.ensureFieldAccessorsInitialized(ReadSwitchKey.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setBtMac(ByteString byteString) {
                byteString.getClass();
                this.btMac_ = byteString;
                onChanged();
                return this;
            }

            public Builder setKey(ByteString byteString) {
                byteString.getClass();
                this.key_ = byteString;
                onChanged();
                return this;
            }

            private Builder() {
                ByteString byteString = ByteString.EMPTY;
                this.key_ = byteString;
                this.btMac_ = byteString;
                maybeForceBuilderInitialization();
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public ReadSwitchKey build() {
                ReadSwitchKey buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
            }

            public ReadSwitchKey buildPartial() {
                ReadSwitchKey readSwitchKey = new ReadSwitchKey((GeneratedMessageV3.Builder) this);
                ByteString unused = readSwitchKey.key_ = this.key_;
                ByteString unused2 = readSwitchKey.btMac_ = this.btMac_;
                onBuilt();
                return readSwitchKey;
            }

            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public ReadSwitchKey getDefaultInstanceForType() {
                return ReadSwitchKey.getDefaultInstance();
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
                ByteString byteString = ByteString.EMPTY;
                this.key_ = byteString;
                this.btMac_ = byteString;
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                ByteString byteString = ByteString.EMPTY;
                this.key_ = byteString;
                this.btMac_ = byteString;
                maybeForceBuilderInitialization();
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder mergeFrom(Message message) {
                if (message instanceof ReadSwitchKey) {
                    return mergeFrom((ReadSwitchKey) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(ReadSwitchKey readSwitchKey) {
                if (readSwitchKey == ReadSwitchKey.getDefaultInstance()) {
                    return this;
                }
                ByteString key = readSwitchKey.getKey();
                ByteString byteString = ByteString.EMPTY;
                if (key != byteString) {
                    setKey(readSwitchKey.getKey());
                }
                if (readSwitchKey.getBtMac() != byteString) {
                    setBtMac(readSwitchKey.getBtMac());
                }
                mergeUnknownFields(readSwitchKey.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public Starry.StarryLinkEncrypt.ReadSwitchKey.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = Starry.StarryLinkEncrypt.ReadSwitchKey.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    Starry.StarryLinkEncrypt$ReadSwitchKey r3 = (Starry.StarryLinkEncrypt.ReadSwitchKey) r3     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    if (r3 == 0) goto L_0x0010
                    r2.mergeFrom((Starry.StarryLinkEncrypt.ReadSwitchKey) r3)
                L_0x0010:
                    return r2
                L_0x0011:
                    r3 = move-exception
                    goto L_0x0021
                L_0x0013:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x0011 }
                    Starry.StarryLinkEncrypt$ReadSwitchKey r4 = (Starry.StarryLinkEncrypt.ReadSwitchKey) r4     // Catch:{ all -> 0x0011 }
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001f }
                    throw r3     // Catch:{ all -> 0x001f }
                L_0x001f:
                    r3 = move-exception
                    r0 = r4
                L_0x0021:
                    if (r0 == 0) goto L_0x0026
                    r2.mergeFrom((Starry.StarryLinkEncrypt.ReadSwitchKey) r0)
                L_0x0026:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: Starry.StarryLinkEncrypt.ReadSwitchKey.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):Starry.StarryLinkEncrypt$ReadSwitchKey$Builder");
            }
        }

        public static Builder newBuilder(ReadSwitchKey readSwitchKey) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(readSwitchKey);
        }

        public static ReadSwitchKey parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private ReadSwitchKey(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        public static ReadSwitchKey parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadSwitchKey) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ReadSwitchKey parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public ReadSwitchKey getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static ReadSwitchKey parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        private ReadSwitchKey() {
            this.memoizedIsInitialized = -1;
            ByteString byteString = ByteString.EMPTY;
            this.key_ = byteString;
            this.btMac_ = byteString;
        }

        public static ReadSwitchKey parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static ReadSwitchKey parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static ReadSwitchKey parseFrom(InputStream inputStream) throws IOException {
            return (ReadSwitchKey) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        private ReadSwitchKey(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            this.key_ = codedInputStream.readBytes();
                        } else if (readTag == 18) {
                            this.btMac_ = codedInputStream.readBytes();
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

        public static ReadSwitchKey parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadSwitchKey) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ReadSwitchKey parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ReadSwitchKey) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ReadSwitchKey parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadSwitchKey) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    public interface ReadSwitchKeyOrBuilder extends MessageOrBuilder {
        ByteString getBtMac();

        ByteString getKey();
    }

    public static final class WifiApInfo extends GeneratedMessageV3 implements WifiApInfoOrBuilder {
        private static final WifiApInfo DEFAULT_INSTANCE = new WifiApInfo();
        public static final int IP_FIELD_NUMBER = 4;
        /* access modifiers changed from: private */
        public static final Parser<WifiApInfo> PARSER = new AbstractParser<WifiApInfo>() {
            public WifiApInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new WifiApInfo(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PORT_FIELD_NUMBER = 3;
        public static final int PSK_FIELD_NUMBER = 2;
        public static final int SSID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public volatile Object ip_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public int port_;
        /* access modifiers changed from: private */
        public volatile Object psk_;
        /* access modifiers changed from: private */
        public volatile Object ssid_;

        public static WifiApInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StarryLinkEncrypt.internal_static_Starry_WifiApInfo_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static WifiApInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WifiApInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static WifiApInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<WifiApInfo> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WifiApInfo)) {
                return super.equals(obj);
            }
            WifiApInfo wifiApInfo = (WifiApInfo) obj;
            return getSsid().equals(wifiApInfo.getSsid()) && getPsk().equals(wifiApInfo.getPsk()) && getPort() == wifiApInfo.getPort() && getIp().equals(wifiApInfo.getIp()) && this.unknownFields.equals(wifiApInfo.unknownFields);
        }

        public String getIp() {
            Object obj = this.ip_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.ip_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getIpBytes() {
            Object obj = this.ip_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ip_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public Parser<WifiApInfo> getParserForType() {
            return PARSER;
        }

        public int getPort() {
            return this.port_;
        }

        public String getPsk() {
            Object obj = this.psk_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.psk_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getPskBytes() {
            Object obj = this.psk_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.psk_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = !getSsidBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.ssid_) : 0;
            if (!getPskBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(2, this.psk_);
            }
            int i2 = this.port_;
            if (i2 != 0) {
                computeStringSize += CodedOutputStream.computeInt32Size(3, i2);
            }
            if (!getIpBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(4, this.ip_);
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public String getSsid() {
            Object obj = this.ssid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.ssid_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getSsidBytes() {
            Object obj = this.ssid_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ssid_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getSsid().hashCode()) * 37) + 2) * 53) + getPsk().hashCode()) * 37) + 3) * 53) + getPort()) * 37) + 4) * 53) + getIp().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StarryLinkEncrypt.internal_static_Starry_WifiApInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiApInfo.class, Builder.class);
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
            if (!getSsidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.ssid_);
            }
            if (!getPskBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.psk_);
            }
            int i = this.port_;
            if (i != 0) {
                codedOutputStream.writeInt32(3, i);
            }
            if (!getIpBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.ip_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WifiApInfoOrBuilder {
            private Object ip_;
            private int port_;
            private Object psk_;
            private Object ssid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return StarryLinkEncrypt.internal_static_Starry_WifiApInfo_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearIp() {
                this.ip_ = WifiApInfo.getDefaultInstance().getIp();
                onChanged();
                return this;
            }

            public Builder clearPort() {
                this.port_ = 0;
                onChanged();
                return this;
            }

            public Builder clearPsk() {
                this.psk_ = WifiApInfo.getDefaultInstance().getPsk();
                onChanged();
                return this;
            }

            public Builder clearSsid() {
                this.ssid_ = WifiApInfo.getDefaultInstance().getSsid();
                onChanged();
                return this;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return StarryLinkEncrypt.internal_static_Starry_WifiApInfo_descriptor;
            }

            public String getIp() {
                Object obj = this.ip_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ip_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getIpBytes() {
                Object obj = this.ip_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ip_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public int getPort() {
                return this.port_;
            }

            public String getPsk() {
                Object obj = this.psk_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.psk_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getPskBytes() {
                Object obj = this.psk_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.psk_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getSsid() {
                Object obj = this.ssid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ssid_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getSsidBytes() {
                Object obj = this.ssid_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ssid_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StarryLinkEncrypt.internal_static_Starry_WifiApInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiApInfo.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setIp(String str) {
                str.getClass();
                this.ip_ = str;
                onChanged();
                return this;
            }

            public Builder setIpBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.ip_ = byteString;
                onChanged();
                return this;
            }

            public Builder setPort(int i) {
                this.port_ = i;
                onChanged();
                return this;
            }

            public Builder setPsk(String str) {
                str.getClass();
                this.psk_ = str;
                onChanged();
                return this;
            }

            public Builder setPskBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.psk_ = byteString;
                onChanged();
                return this;
            }

            public Builder setSsid(String str) {
                str.getClass();
                this.ssid_ = str;
                onChanged();
                return this;
            }

            public Builder setSsidBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.ssid_ = byteString;
                onChanged();
                return this;
            }

            private Builder() {
                this.ssid_ = "";
                this.psk_ = "";
                this.ip_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public WifiApInfo build() {
                WifiApInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
            }

            public WifiApInfo buildPartial() {
                WifiApInfo wifiApInfo = new WifiApInfo((GeneratedMessageV3.Builder) this);
                Object unused = wifiApInfo.ssid_ = this.ssid_;
                Object unused2 = wifiApInfo.psk_ = this.psk_;
                int unused3 = wifiApInfo.port_ = this.port_;
                Object unused4 = wifiApInfo.ip_ = this.ip_;
                onBuilt();
                return wifiApInfo;
            }

            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public WifiApInfo getDefaultInstanceForType() {
                return WifiApInfo.getDefaultInstance();
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
                this.ssid_ = "";
                this.psk_ = "";
                this.port_ = 0;
                this.ip_ = "";
                return this;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder mergeFrom(Message message) {
                if (message instanceof WifiApInfo) {
                    return mergeFrom((WifiApInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.ssid_ = "";
                this.psk_ = "";
                this.ip_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder mergeFrom(WifiApInfo wifiApInfo) {
                if (wifiApInfo == WifiApInfo.getDefaultInstance()) {
                    return this;
                }
                if (!wifiApInfo.getSsid().isEmpty()) {
                    this.ssid_ = wifiApInfo.ssid_;
                    onChanged();
                }
                if (!wifiApInfo.getPsk().isEmpty()) {
                    this.psk_ = wifiApInfo.psk_;
                    onChanged();
                }
                if (wifiApInfo.getPort() != 0) {
                    setPort(wifiApInfo.getPort());
                }
                if (!wifiApInfo.getIp().isEmpty()) {
                    this.ip_ = wifiApInfo.ip_;
                    onChanged();
                }
                mergeUnknownFields(wifiApInfo.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public Starry.StarryLinkEncrypt.WifiApInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = Starry.StarryLinkEncrypt.WifiApInfo.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    Starry.StarryLinkEncrypt$WifiApInfo r3 = (Starry.StarryLinkEncrypt.WifiApInfo) r3     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    if (r3 == 0) goto L_0x0010
                    r2.mergeFrom((Starry.StarryLinkEncrypt.WifiApInfo) r3)
                L_0x0010:
                    return r2
                L_0x0011:
                    r3 = move-exception
                    goto L_0x0021
                L_0x0013:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x0011 }
                    Starry.StarryLinkEncrypt$WifiApInfo r4 = (Starry.StarryLinkEncrypt.WifiApInfo) r4     // Catch:{ all -> 0x0011 }
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001f }
                    throw r3     // Catch:{ all -> 0x001f }
                L_0x001f:
                    r3 = move-exception
                    r0 = r4
                L_0x0021:
                    if (r0 == 0) goto L_0x0026
                    r2.mergeFrom((Starry.StarryLinkEncrypt.WifiApInfo) r0)
                L_0x0026:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: Starry.StarryLinkEncrypt.WifiApInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):Starry.StarryLinkEncrypt$WifiApInfo$Builder");
            }
        }

        public static Builder newBuilder(WifiApInfo wifiApInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(wifiApInfo);
        }

        public static WifiApInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private WifiApInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        public static WifiApInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WifiApInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WifiApInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public WifiApInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static WifiApInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        private WifiApInfo() {
            this.memoizedIsInitialized = -1;
            this.ssid_ = "";
            this.psk_ = "";
            this.port_ = 0;
            this.ip_ = "";
        }

        public static WifiApInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static WifiApInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static WifiApInfo parseFrom(InputStream inputStream) throws IOException {
            return (WifiApInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static WifiApInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WifiApInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        private WifiApInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            this.ssid_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 18) {
                            this.psk_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 24) {
                            this.port_ = codedInputStream.readInt32();
                        } else if (readTag == 34) {
                            this.ip_ = codedInputStream.readStringRequireUtf8();
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

        public static WifiApInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (WifiApInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static WifiApInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WifiApInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    public interface WifiApInfoOrBuilder extends MessageOrBuilder {
        String getIp();

        ByteString getIpBytes();

        int getPort();

        String getPsk();

        ByteString getPskBytes();

        String getSsid();

        ByteString getSsidBytes();
    }

    public static final class WifiGcInfo extends GeneratedMessageV3 implements WifiGcInfoOrBuilder {
        private static final WifiGcInfo DEFAULT_INSTANCE = new WifiGcInfo();
        public static final int ISCONNECTED_FIELD_NUMBER = 2;
        public static final int MAC_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final Parser<WifiGcInfo> PARSER = new AbstractParser<WifiGcInfo>() {
            public WifiGcInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new WifiGcInfo(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public boolean isConnected_;
        /* access modifiers changed from: private */
        public volatile Object mac_;
        private byte memoizedIsInitialized;

        public static WifiGcInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StarryLinkEncrypt.internal_static_Starry_WifiGcInfo_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static WifiGcInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WifiGcInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static WifiGcInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<WifiGcInfo> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WifiGcInfo)) {
                return super.equals(obj);
            }
            WifiGcInfo wifiGcInfo = (WifiGcInfo) obj;
            return getMac().equals(wifiGcInfo.getMac()) && getIsConnected() == wifiGcInfo.getIsConnected() && this.unknownFields.equals(wifiGcInfo.unknownFields);
        }

        public boolean getIsConnected() {
            return this.isConnected_;
        }

        public String getMac() {
            Object obj = this.mac_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.mac_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getMacBytes() {
            Object obj = this.mac_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.mac_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public Parser<WifiGcInfo> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = !getMacBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.mac_) : 0;
            boolean z = this.isConnected_;
            if (z) {
                computeStringSize += CodedOutputStream.computeBoolSize(2, z);
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
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
            int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getMac().hashCode()) * 37) + 2) * 53) + Internal.hashBoolean(getIsConnected())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StarryLinkEncrypt.internal_static_Starry_WifiGcInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiGcInfo.class, Builder.class);
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
            if (!getMacBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.mac_);
            }
            boolean z = this.isConnected_;
            if (z) {
                codedOutputStream.writeBool(2, z);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WifiGcInfoOrBuilder {
            private boolean isConnected_;
            private Object mac_;

            public static final Descriptors.Descriptor getDescriptor() {
                return StarryLinkEncrypt.internal_static_Starry_WifiGcInfo_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearIsConnected() {
                this.isConnected_ = false;
                onChanged();
                return this;
            }

            public Builder clearMac() {
                this.mac_ = WifiGcInfo.getDefaultInstance().getMac();
                onChanged();
                return this;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return StarryLinkEncrypt.internal_static_Starry_WifiGcInfo_descriptor;
            }

            public boolean getIsConnected() {
                return this.isConnected_;
            }

            public String getMac() {
                Object obj = this.mac_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.mac_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getMacBytes() {
                Object obj = this.mac_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mac_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StarryLinkEncrypt.internal_static_Starry_WifiGcInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiGcInfo.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setIsConnected(boolean z) {
                this.isConnected_ = z;
                onChanged();
                return this;
            }

            public Builder setMac(String str) {
                str.getClass();
                this.mac_ = str;
                onChanged();
                return this;
            }

            public Builder setMacBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.mac_ = byteString;
                onChanged();
                return this;
            }

            private Builder() {
                this.mac_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public WifiGcInfo build() {
                WifiGcInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
            }

            public WifiGcInfo buildPartial() {
                WifiGcInfo wifiGcInfo = new WifiGcInfo((GeneratedMessageV3.Builder) this);
                Object unused = wifiGcInfo.mac_ = this.mac_;
                boolean unused2 = wifiGcInfo.isConnected_ = this.isConnected_;
                onBuilt();
                return wifiGcInfo;
            }

            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public WifiGcInfo getDefaultInstanceForType() {
                return WifiGcInfo.getDefaultInstance();
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
                this.mac_ = "";
                this.isConnected_ = false;
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.mac_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder mergeFrom(Message message) {
                if (message instanceof WifiGcInfo) {
                    return mergeFrom((WifiGcInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(WifiGcInfo wifiGcInfo) {
                if (wifiGcInfo == WifiGcInfo.getDefaultInstance()) {
                    return this;
                }
                if (!wifiGcInfo.getMac().isEmpty()) {
                    this.mac_ = wifiGcInfo.mac_;
                    onChanged();
                }
                if (wifiGcInfo.getIsConnected()) {
                    setIsConnected(wifiGcInfo.getIsConnected());
                }
                mergeUnknownFields(wifiGcInfo.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public Starry.StarryLinkEncrypt.WifiGcInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = Starry.StarryLinkEncrypt.WifiGcInfo.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    Starry.StarryLinkEncrypt$WifiGcInfo r3 = (Starry.StarryLinkEncrypt.WifiGcInfo) r3     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    if (r3 == 0) goto L_0x0010
                    r2.mergeFrom((Starry.StarryLinkEncrypt.WifiGcInfo) r3)
                L_0x0010:
                    return r2
                L_0x0011:
                    r3 = move-exception
                    goto L_0x0021
                L_0x0013:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x0011 }
                    Starry.StarryLinkEncrypt$WifiGcInfo r4 = (Starry.StarryLinkEncrypt.WifiGcInfo) r4     // Catch:{ all -> 0x0011 }
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001f }
                    throw r3     // Catch:{ all -> 0x001f }
                L_0x001f:
                    r3 = move-exception
                    r0 = r4
                L_0x0021:
                    if (r0 == 0) goto L_0x0026
                    r2.mergeFrom((Starry.StarryLinkEncrypt.WifiGcInfo) r0)
                L_0x0026:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: Starry.StarryLinkEncrypt.WifiGcInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):Starry.StarryLinkEncrypt$WifiGcInfo$Builder");
            }
        }

        public static Builder newBuilder(WifiGcInfo wifiGcInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(wifiGcInfo);
        }

        public static WifiGcInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private WifiGcInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        public static WifiGcInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WifiGcInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WifiGcInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public WifiGcInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static WifiGcInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        private WifiGcInfo() {
            this.memoizedIsInitialized = -1;
            this.mac_ = "";
            this.isConnected_ = false;
        }

        public static WifiGcInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static WifiGcInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static WifiGcInfo parseFrom(InputStream inputStream) throws IOException {
            return (WifiGcInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        private WifiGcInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            this.mac_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 16) {
                            this.isConnected_ = codedInputStream.readBool();
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

        public static WifiGcInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WifiGcInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WifiGcInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (WifiGcInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static WifiGcInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WifiGcInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    public interface WifiGcInfoOrBuilder extends MessageOrBuilder {
        boolean getIsConnected();

        String getMac();

        ByteString getMacBytes();
    }

    public static final class WifiGoInfo extends GeneratedMessageV3 implements WifiGoInfoOrBuilder {
        public static final int ADDRESS_FIELD_NUMBER = 7;
        private static final WifiGoInfo DEFAULT_INSTANCE = new WifiGoInfo();
        public static final int FREQ_FIELD_NUMBER = 3;
        public static final int GCMAC_FIELD_NUMBER = 6;
        public static final int MAC_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final Parser<WifiGoInfo> PARSER = new AbstractParser<WifiGoInfo>() {
            public WifiGoInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new WifiGoInfo(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PORT_FIELD_NUMBER = 2;
        public static final int PSK_FIELD_NUMBER = 5;
        public static final int SSID_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public volatile Object address_;
        /* access modifiers changed from: private */
        public int freq_;
        /* access modifiers changed from: private */
        public volatile Object gcMac_;
        /* access modifiers changed from: private */
        public volatile Object mac_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public int port_;
        /* access modifiers changed from: private */
        public volatile Object psk_;
        /* access modifiers changed from: private */
        public volatile Object ssid_;

        public static WifiGoInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StarryLinkEncrypt.internal_static_Starry_WifiGoInfo_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static WifiGoInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WifiGoInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static WifiGoInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<WifiGoInfo> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WifiGoInfo)) {
                return super.equals(obj);
            }
            WifiGoInfo wifiGoInfo = (WifiGoInfo) obj;
            return getMac().equals(wifiGoInfo.getMac()) && getPort() == wifiGoInfo.getPort() && getFreq() == wifiGoInfo.getFreq() && getSsid().equals(wifiGoInfo.getSsid()) && getPsk().equals(wifiGoInfo.getPsk()) && getGcMac().equals(wifiGoInfo.getGcMac()) && getAddress().equals(wifiGoInfo.getAddress()) && this.unknownFields.equals(wifiGoInfo.unknownFields);
        }

        public String getAddress() {
            Object obj = this.address_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.address_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getAddressBytes() {
            Object obj = this.address_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.address_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public int getFreq() {
            return this.freq_;
        }

        public String getGcMac() {
            Object obj = this.gcMac_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.gcMac_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getGcMacBytes() {
            Object obj = this.gcMac_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.gcMac_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getMac() {
            Object obj = this.mac_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.mac_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getMacBytes() {
            Object obj = this.mac_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.mac_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public Parser<WifiGoInfo> getParserForType() {
            return PARSER;
        }

        public int getPort() {
            return this.port_;
        }

        public String getPsk() {
            Object obj = this.psk_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.psk_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getPskBytes() {
            Object obj = this.psk_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.psk_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = !getMacBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.mac_) : 0;
            int i2 = this.port_;
            if (i2 != 0) {
                computeStringSize += CodedOutputStream.computeInt32Size(2, i2);
            }
            int i3 = this.freq_;
            if (i3 != 0) {
                computeStringSize += CodedOutputStream.computeInt32Size(3, i3);
            }
            if (!getSsidBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(4, this.ssid_);
            }
            if (!getPskBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(5, this.psk_);
            }
            if (!getGcMacBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(6, this.gcMac_);
            }
            if (!getAddressBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(7, this.address_);
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public String getSsid() {
            Object obj = this.ssid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.ssid_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getSsidBytes() {
            Object obj = this.ssid_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ssid_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = ((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getMac().hashCode()) * 37) + 2) * 53) + getPort()) * 37) + 3) * 53) + getFreq()) * 37) + 4) * 53) + getSsid().hashCode()) * 37) + 5) * 53) + getPsk().hashCode()) * 37) + 6) * 53) + getGcMac().hashCode()) * 37) + 7) * 53) + getAddress().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StarryLinkEncrypt.internal_static_Starry_WifiGoInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiGoInfo.class, Builder.class);
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
            if (!getMacBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.mac_);
            }
            int i = this.port_;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            int i2 = this.freq_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(3, i2);
            }
            if (!getSsidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.ssid_);
            }
            if (!getPskBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.psk_);
            }
            if (!getGcMacBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.gcMac_);
            }
            if (!getAddressBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.address_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WifiGoInfoOrBuilder {
            private Object address_;
            private int freq_;
            private Object gcMac_;
            private Object mac_;
            private int port_;
            private Object psk_;
            private Object ssid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return StarryLinkEncrypt.internal_static_Starry_WifiGoInfo_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearAddress() {
                this.address_ = WifiGoInfo.getDefaultInstance().getAddress();
                onChanged();
                return this;
            }

            public Builder clearFreq() {
                this.freq_ = 0;
                onChanged();
                return this;
            }

            public Builder clearGcMac() {
                this.gcMac_ = WifiGoInfo.getDefaultInstance().getGcMac();
                onChanged();
                return this;
            }

            public Builder clearMac() {
                this.mac_ = WifiGoInfo.getDefaultInstance().getMac();
                onChanged();
                return this;
            }

            public Builder clearPort() {
                this.port_ = 0;
                onChanged();
                return this;
            }

            public Builder clearPsk() {
                this.psk_ = WifiGoInfo.getDefaultInstance().getPsk();
                onChanged();
                return this;
            }

            public Builder clearSsid() {
                this.ssid_ = WifiGoInfo.getDefaultInstance().getSsid();
                onChanged();
                return this;
            }

            public String getAddress() {
                Object obj = this.address_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.address_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getAddressBytes() {
                Object obj = this.address_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.address_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return StarryLinkEncrypt.internal_static_Starry_WifiGoInfo_descriptor;
            }

            public int getFreq() {
                return this.freq_;
            }

            public String getGcMac() {
                Object obj = this.gcMac_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.gcMac_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getGcMacBytes() {
                Object obj = this.gcMac_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.gcMac_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getMac() {
                Object obj = this.mac_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.mac_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getMacBytes() {
                Object obj = this.mac_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mac_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public int getPort() {
                return this.port_;
            }

            public String getPsk() {
                Object obj = this.psk_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.psk_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getPskBytes() {
                Object obj = this.psk_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.psk_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getSsid() {
                Object obj = this.ssid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ssid_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getSsidBytes() {
                Object obj = this.ssid_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ssid_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StarryLinkEncrypt.internal_static_Starry_WifiGoInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiGoInfo.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setAddress(String str) {
                str.getClass();
                this.address_ = str;
                onChanged();
                return this;
            }

            public Builder setAddressBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.address_ = byteString;
                onChanged();
                return this;
            }

            public Builder setFreq(int i) {
                this.freq_ = i;
                onChanged();
                return this;
            }

            public Builder setGcMac(String str) {
                str.getClass();
                this.gcMac_ = str;
                onChanged();
                return this;
            }

            public Builder setGcMacBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.gcMac_ = byteString;
                onChanged();
                return this;
            }

            public Builder setMac(String str) {
                str.getClass();
                this.mac_ = str;
                onChanged();
                return this;
            }

            public Builder setMacBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.mac_ = byteString;
                onChanged();
                return this;
            }

            public Builder setPort(int i) {
                this.port_ = i;
                onChanged();
                return this;
            }

            public Builder setPsk(String str) {
                str.getClass();
                this.psk_ = str;
                onChanged();
                return this;
            }

            public Builder setPskBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.psk_ = byteString;
                onChanged();
                return this;
            }

            public Builder setSsid(String str) {
                str.getClass();
                this.ssid_ = str;
                onChanged();
                return this;
            }

            public Builder setSsidBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.ssid_ = byteString;
                onChanged();
                return this;
            }

            private Builder() {
                this.mac_ = "";
                this.ssid_ = "";
                this.psk_ = "";
                this.gcMac_ = "";
                this.address_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public WifiGoInfo build() {
                WifiGoInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
            }

            public WifiGoInfo buildPartial() {
                WifiGoInfo wifiGoInfo = new WifiGoInfo((GeneratedMessageV3.Builder) this);
                Object unused = wifiGoInfo.mac_ = this.mac_;
                int unused2 = wifiGoInfo.port_ = this.port_;
                int unused3 = wifiGoInfo.freq_ = this.freq_;
                Object unused4 = wifiGoInfo.ssid_ = this.ssid_;
                Object unused5 = wifiGoInfo.psk_ = this.psk_;
                Object unused6 = wifiGoInfo.gcMac_ = this.gcMac_;
                Object unused7 = wifiGoInfo.address_ = this.address_;
                onBuilt();
                return wifiGoInfo;
            }

            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public WifiGoInfo getDefaultInstanceForType() {
                return WifiGoInfo.getDefaultInstance();
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
                this.mac_ = "";
                this.port_ = 0;
                this.freq_ = 0;
                this.ssid_ = "";
                this.psk_ = "";
                this.gcMac_ = "";
                this.address_ = "";
                return this;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder mergeFrom(Message message) {
                if (message instanceof WifiGoInfo) {
                    return mergeFrom((WifiGoInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.mac_ = "";
                this.ssid_ = "";
                this.psk_ = "";
                this.gcMac_ = "";
                this.address_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder mergeFrom(WifiGoInfo wifiGoInfo) {
                if (wifiGoInfo == WifiGoInfo.getDefaultInstance()) {
                    return this;
                }
                if (!wifiGoInfo.getMac().isEmpty()) {
                    this.mac_ = wifiGoInfo.mac_;
                    onChanged();
                }
                if (wifiGoInfo.getPort() != 0) {
                    setPort(wifiGoInfo.getPort());
                }
                if (wifiGoInfo.getFreq() != 0) {
                    setFreq(wifiGoInfo.getFreq());
                }
                if (!wifiGoInfo.getSsid().isEmpty()) {
                    this.ssid_ = wifiGoInfo.ssid_;
                    onChanged();
                }
                if (!wifiGoInfo.getPsk().isEmpty()) {
                    this.psk_ = wifiGoInfo.psk_;
                    onChanged();
                }
                if (!wifiGoInfo.getGcMac().isEmpty()) {
                    this.gcMac_ = wifiGoInfo.gcMac_;
                    onChanged();
                }
                if (!wifiGoInfo.getAddress().isEmpty()) {
                    this.address_ = wifiGoInfo.address_;
                    onChanged();
                }
                mergeUnknownFields(wifiGoInfo.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public Starry.StarryLinkEncrypt.WifiGoInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = Starry.StarryLinkEncrypt.WifiGoInfo.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    Starry.StarryLinkEncrypt$WifiGoInfo r3 = (Starry.StarryLinkEncrypt.WifiGoInfo) r3     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    if (r3 == 0) goto L_0x0010
                    r2.mergeFrom((Starry.StarryLinkEncrypt.WifiGoInfo) r3)
                L_0x0010:
                    return r2
                L_0x0011:
                    r3 = move-exception
                    goto L_0x0021
                L_0x0013:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x0011 }
                    Starry.StarryLinkEncrypt$WifiGoInfo r4 = (Starry.StarryLinkEncrypt.WifiGoInfo) r4     // Catch:{ all -> 0x0011 }
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001f }
                    throw r3     // Catch:{ all -> 0x001f }
                L_0x001f:
                    r3 = move-exception
                    r0 = r4
                L_0x0021:
                    if (r0 == 0) goto L_0x0026
                    r2.mergeFrom((Starry.StarryLinkEncrypt.WifiGoInfo) r0)
                L_0x0026:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: Starry.StarryLinkEncrypt.WifiGoInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):Starry.StarryLinkEncrypt$WifiGoInfo$Builder");
            }
        }

        public static Builder newBuilder(WifiGoInfo wifiGoInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(wifiGoInfo);
        }

        public static WifiGoInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private WifiGoInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        public static WifiGoInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WifiGoInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WifiGoInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public WifiGoInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static WifiGoInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        private WifiGoInfo() {
            this.memoizedIsInitialized = -1;
            this.mac_ = "";
            this.port_ = 0;
            this.freq_ = 0;
            this.ssid_ = "";
            this.psk_ = "";
            this.gcMac_ = "";
            this.address_ = "";
        }

        public static WifiGoInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static WifiGoInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static WifiGoInfo parseFrom(InputStream inputStream) throws IOException {
            return (WifiGoInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static WifiGoInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WifiGoInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WifiGoInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (WifiGoInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static WifiGoInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WifiGoInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        private WifiGoInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            this.mac_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 16) {
                            this.port_ = codedInputStream.readInt32();
                        } else if (readTag == 24) {
                            this.freq_ = codedInputStream.readInt32();
                        } else if (readTag == 34) {
                            this.ssid_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 42) {
                            this.psk_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 50) {
                            this.gcMac_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 58) {
                            this.address_ = codedInputStream.readStringRequireUtf8();
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
    }

    public interface WifiGoInfoOrBuilder extends MessageOrBuilder {
        String getAddress();

        ByteString getAddressBytes();

        int getFreq();

        String getGcMac();

        ByteString getGcMacBytes();

        String getMac();

        ByteString getMacBytes();

        int getPort();

        String getPsk();

        ByteString getPskBytes();

        String getSsid();

        ByteString getSsidBytes();
    }

    public static final class WifiStaInfo extends GeneratedMessageV3 implements WifiStaInfoOrBuilder {
        private static final WifiStaInfo DEFAULT_INSTANCE = new WifiStaInfo();
        public static final int IP_FIELD_NUMBER = 1;
        public static final int MAC_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */
        public static final Parser<WifiStaInfo> PARSER = new AbstractParser<WifiStaInfo>() {
            public WifiStaInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new WifiStaInfo(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public volatile Object ip_;
        /* access modifiers changed from: private */
        public volatile Object mac_;
        private byte memoizedIsInitialized;

        public static WifiStaInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StarryLinkEncrypt.internal_static_Starry_WifiStaInfo_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static WifiStaInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WifiStaInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static WifiStaInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<WifiStaInfo> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WifiStaInfo)) {
                return super.equals(obj);
            }
            WifiStaInfo wifiStaInfo = (WifiStaInfo) obj;
            return getIp().equals(wifiStaInfo.getIp()) && getMac().equals(wifiStaInfo.getMac()) && this.unknownFields.equals(wifiStaInfo.unknownFields);
        }

        public String getIp() {
            Object obj = this.ip_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.ip_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getIpBytes() {
            Object obj = this.ip_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ip_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getMac() {
            Object obj = this.mac_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.mac_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getMacBytes() {
            Object obj = this.mac_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.mac_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public Parser<WifiStaInfo> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = !getIpBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.ip_) : 0;
            if (!getMacBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(2, this.mac_);
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
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
            int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getIp().hashCode()) * 37) + 2) * 53) + getMac().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StarryLinkEncrypt.internal_static_Starry_WifiStaInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiStaInfo.class, Builder.class);
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
            if (!getIpBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.ip_);
            }
            if (!getMacBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.mac_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WifiStaInfoOrBuilder {
            private Object ip_;
            private Object mac_;

            public static final Descriptors.Descriptor getDescriptor() {
                return StarryLinkEncrypt.internal_static_Starry_WifiStaInfo_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearIp() {
                this.ip_ = WifiStaInfo.getDefaultInstance().getIp();
                onChanged();
                return this;
            }

            public Builder clearMac() {
                this.mac_ = WifiStaInfo.getDefaultInstance().getMac();
                onChanged();
                return this;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return StarryLinkEncrypt.internal_static_Starry_WifiStaInfo_descriptor;
            }

            public String getIp() {
                Object obj = this.ip_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ip_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getIpBytes() {
                Object obj = this.ip_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ip_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getMac() {
                Object obj = this.mac_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.mac_ = stringUtf8;
                return stringUtf8;
            }

            public ByteString getMacBytes() {
                Object obj = this.mac_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mac_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StarryLinkEncrypt.internal_static_Starry_WifiStaInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiStaInfo.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setIp(String str) {
                str.getClass();
                this.ip_ = str;
                onChanged();
                return this;
            }

            public Builder setIpBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.ip_ = byteString;
                onChanged();
                return this;
            }

            public Builder setMac(String str) {
                str.getClass();
                this.mac_ = str;
                onChanged();
                return this;
            }

            public Builder setMacBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.mac_ = byteString;
                onChanged();
                return this;
            }

            private Builder() {
                this.ip_ = "";
                this.mac_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public WifiStaInfo build() {
                WifiStaInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
            }

            public WifiStaInfo buildPartial() {
                WifiStaInfo wifiStaInfo = new WifiStaInfo((GeneratedMessageV3.Builder) this);
                Object unused = wifiStaInfo.ip_ = this.ip_;
                Object unused2 = wifiStaInfo.mac_ = this.mac_;
                onBuilt();
                return wifiStaInfo;
            }

            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public WifiStaInfo getDefaultInstanceForType() {
                return WifiStaInfo.getDefaultInstance();
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
                this.ip_ = "";
                this.mac_ = "";
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.ip_ = "";
                this.mac_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder mergeFrom(Message message) {
                if (message instanceof WifiStaInfo) {
                    return mergeFrom((WifiStaInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(WifiStaInfo wifiStaInfo) {
                if (wifiStaInfo == WifiStaInfo.getDefaultInstance()) {
                    return this;
                }
                if (!wifiStaInfo.getIp().isEmpty()) {
                    this.ip_ = wifiStaInfo.ip_;
                    onChanged();
                }
                if (!wifiStaInfo.getMac().isEmpty()) {
                    this.mac_ = wifiStaInfo.mac_;
                    onChanged();
                }
                mergeUnknownFields(wifiStaInfo.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public Starry.StarryLinkEncrypt.WifiStaInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = Starry.StarryLinkEncrypt.WifiStaInfo.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    Starry.StarryLinkEncrypt$WifiStaInfo r3 = (Starry.StarryLinkEncrypt.WifiStaInfo) r3     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    if (r3 == 0) goto L_0x0010
                    r2.mergeFrom((Starry.StarryLinkEncrypt.WifiStaInfo) r3)
                L_0x0010:
                    return r2
                L_0x0011:
                    r3 = move-exception
                    goto L_0x0021
                L_0x0013:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x0011 }
                    Starry.StarryLinkEncrypt$WifiStaInfo r4 = (Starry.StarryLinkEncrypt.WifiStaInfo) r4     // Catch:{ all -> 0x0011 }
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001f }
                    throw r3     // Catch:{ all -> 0x001f }
                L_0x001f:
                    r3 = move-exception
                    r0 = r4
                L_0x0021:
                    if (r0 == 0) goto L_0x0026
                    r2.mergeFrom((Starry.StarryLinkEncrypt.WifiStaInfo) r0)
                L_0x0026:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: Starry.StarryLinkEncrypt.WifiStaInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):Starry.StarryLinkEncrypt$WifiStaInfo$Builder");
            }
        }

        public static Builder newBuilder(WifiStaInfo wifiStaInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(wifiStaInfo);
        }

        public static WifiStaInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private WifiStaInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        public static WifiStaInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WifiStaInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WifiStaInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public WifiStaInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static WifiStaInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        private WifiStaInfo() {
            this.memoizedIsInitialized = -1;
            this.ip_ = "";
            this.mac_ = "";
        }

        public static WifiStaInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static WifiStaInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static WifiStaInfo parseFrom(InputStream inputStream) throws IOException {
            return (WifiStaInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        private WifiStaInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            this.ip_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 18) {
                            this.mac_ = codedInputStream.readStringRequireUtf8();
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

        public static WifiStaInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WifiStaInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WifiStaInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (WifiStaInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static WifiStaInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WifiStaInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    public interface WifiStaInfoOrBuilder extends MessageOrBuilder {
        String getIp();

        ByteString getIpBytes();

        String getMac();

        ByteString getMacBytes();
    }

    public static final class WriteSwitchInfo extends GeneratedMessageV3 implements WriteSwitchInfoOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        private static final WriteSwitchInfo DEFAULT_INSTANCE = new WriteSwitchInfo();
        public static final int INFO_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */
        public static final Parser<WriteSwitchInfo> PARSER = new AbstractParser<WriteSwitchInfo>() {
            public WriteSwitchInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new WriteSwitchInfo(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int code_;
        /* access modifiers changed from: private */
        public ByteString info_;
        private byte memoizedIsInitialized;

        public static WriteSwitchInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StarryLinkEncrypt.internal_static_Starry_WriteSwitchInfo_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static WriteSwitchInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WriteSwitchInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static WriteSwitchInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<WriteSwitchInfo> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WriteSwitchInfo)) {
                return super.equals(obj);
            }
            WriteSwitchInfo writeSwitchInfo = (WriteSwitchInfo) obj;
            return getCode() == writeSwitchInfo.getCode() && getInfo().equals(writeSwitchInfo.getInfo()) && this.unknownFields.equals(writeSwitchInfo.unknownFields);
        }

        public int getCode() {
            return this.code_;
        }

        public ByteString getInfo() {
            return this.info_;
        }

        public Parser<WriteSwitchInfo> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.code_;
            int computeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) : 0;
            if (!this.info_.isEmpty()) {
                computeInt32Size += CodedOutputStream.computeBytesSize(2, this.info_);
            }
            int serializedSize = computeInt32Size + this.unknownFields.getSerializedSize();
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
            int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getCode()) * 37) + 2) * 53) + getInfo().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StarryLinkEncrypt.internal_static_Starry_WriteSwitchInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WriteSwitchInfo.class, Builder.class);
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
            int i = this.code_;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            if (!this.info_.isEmpty()) {
                codedOutputStream.writeBytes(2, this.info_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WriteSwitchInfoOrBuilder {
            private int code_;
            private ByteString info_;

            public static final Descriptors.Descriptor getDescriptor() {
                return StarryLinkEncrypt.internal_static_Starry_WriteSwitchInfo_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearCode() {
                this.code_ = 0;
                onChanged();
                return this;
            }

            public Builder clearInfo() {
                this.info_ = WriteSwitchInfo.getDefaultInstance().getInfo();
                onChanged();
                return this;
            }

            public int getCode() {
                return this.code_;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return StarryLinkEncrypt.internal_static_Starry_WriteSwitchInfo_descriptor;
            }

            public ByteString getInfo() {
                return this.info_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StarryLinkEncrypt.internal_static_Starry_WriteSwitchInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WriteSwitchInfo.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setCode(int i) {
                this.code_ = i;
                onChanged();
                return this;
            }

            public Builder setInfo(ByteString byteString) {
                byteString.getClass();
                this.info_ = byteString;
                onChanged();
                return this;
            }

            private Builder() {
                this.info_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public WriteSwitchInfo build() {
                WriteSwitchInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
            }

            public WriteSwitchInfo buildPartial() {
                WriteSwitchInfo writeSwitchInfo = new WriteSwitchInfo((GeneratedMessageV3.Builder) this);
                int unused = writeSwitchInfo.code_ = this.code_;
                ByteString unused2 = writeSwitchInfo.info_ = this.info_;
                onBuilt();
                return writeSwitchInfo;
            }

            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public WriteSwitchInfo getDefaultInstanceForType() {
                return WriteSwitchInfo.getDefaultInstance();
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
                this.code_ = 0;
                this.info_ = ByteString.EMPTY;
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.info_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder mergeFrom(Message message) {
                if (message instanceof WriteSwitchInfo) {
                    return mergeFrom((WriteSwitchInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(WriteSwitchInfo writeSwitchInfo) {
                if (writeSwitchInfo == WriteSwitchInfo.getDefaultInstance()) {
                    return this;
                }
                if (writeSwitchInfo.getCode() != 0) {
                    setCode(writeSwitchInfo.getCode());
                }
                if (writeSwitchInfo.getInfo() != ByteString.EMPTY) {
                    setInfo(writeSwitchInfo.getInfo());
                }
                mergeUnknownFields(writeSwitchInfo.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public Starry.StarryLinkEncrypt.WriteSwitchInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = Starry.StarryLinkEncrypt.WriteSwitchInfo.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    Starry.StarryLinkEncrypt$WriteSwitchInfo r3 = (Starry.StarryLinkEncrypt.WriteSwitchInfo) r3     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    if (r3 == 0) goto L_0x0010
                    r2.mergeFrom((Starry.StarryLinkEncrypt.WriteSwitchInfo) r3)
                L_0x0010:
                    return r2
                L_0x0011:
                    r3 = move-exception
                    goto L_0x0021
                L_0x0013:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x0011 }
                    Starry.StarryLinkEncrypt$WriteSwitchInfo r4 = (Starry.StarryLinkEncrypt.WriteSwitchInfo) r4     // Catch:{ all -> 0x0011 }
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001f }
                    throw r3     // Catch:{ all -> 0x001f }
                L_0x001f:
                    r3 = move-exception
                    r0 = r4
                L_0x0021:
                    if (r0 == 0) goto L_0x0026
                    r2.mergeFrom((Starry.StarryLinkEncrypt.WriteSwitchInfo) r0)
                L_0x0026:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: Starry.StarryLinkEncrypt.WriteSwitchInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):Starry.StarryLinkEncrypt$WriteSwitchInfo$Builder");
            }
        }

        public static Builder newBuilder(WriteSwitchInfo writeSwitchInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(writeSwitchInfo);
        }

        public static WriteSwitchInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private WriteSwitchInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        public static WriteSwitchInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WriteSwitchInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WriteSwitchInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public WriteSwitchInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static WriteSwitchInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        private WriteSwitchInfo() {
            this.memoizedIsInitialized = -1;
            this.code_ = 0;
            this.info_ = ByteString.EMPTY;
        }

        public static WriteSwitchInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static WriteSwitchInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static WriteSwitchInfo parseFrom(InputStream inputStream) throws IOException {
            return (WriteSwitchInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        private WriteSwitchInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.code_ = codedInputStream.readInt32();
                        } else if (readTag == 18) {
                            this.info_ = codedInputStream.readBytes();
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

        public static WriteSwitchInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WriteSwitchInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WriteSwitchInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (WriteSwitchInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static WriteSwitchInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WriteSwitchInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    public interface WriteSwitchInfoOrBuilder extends MessageOrBuilder {
        int getCode();

        ByteString getInfo();
    }

    public static final class WriteSwitchKey extends GeneratedMessageV3 implements WriteSwitchKeyOrBuilder {
        private static final WriteSwitchKey DEFAULT_INSTANCE = new WriteSwitchKey();
        public static final int INFO_FIELD_NUMBER = 2;
        public static final int KEY_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final Parser<WriteSwitchKey> PARSER = new AbstractParser<WriteSwitchKey>() {
            public WriteSwitchKey parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new WriteSwitchKey(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public ByteString info_;
        /* access modifiers changed from: private */
        public ByteString key_;
        private byte memoizedIsInitialized;

        public static WriteSwitchKey getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StarryLinkEncrypt.internal_static_Starry_WriteSwitchKey_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static WriteSwitchKey parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WriteSwitchKey) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static WriteSwitchKey parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<WriteSwitchKey> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WriteSwitchKey)) {
                return super.equals(obj);
            }
            WriteSwitchKey writeSwitchKey = (WriteSwitchKey) obj;
            return getKey().equals(writeSwitchKey.getKey()) && getInfo().equals(writeSwitchKey.getInfo()) && this.unknownFields.equals(writeSwitchKey.unknownFields);
        }

        public ByteString getInfo() {
            return this.info_;
        }

        public ByteString getKey() {
            return this.key_;
        }

        public Parser<WriteSwitchKey> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = !this.key_.isEmpty() ? CodedOutputStream.computeBytesSize(1, this.key_) : 0;
            if (!this.info_.isEmpty()) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, this.info_);
            }
            int serializedSize = computeBytesSize + this.unknownFields.getSerializedSize();
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
            int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getKey().hashCode()) * 37) + 2) * 53) + getInfo().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StarryLinkEncrypt.internal_static_Starry_WriteSwitchKey_fieldAccessorTable.ensureFieldAccessorsInitialized(WriteSwitchKey.class, Builder.class);
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
            if (!this.key_.isEmpty()) {
                codedOutputStream.writeBytes(1, this.key_);
            }
            if (!this.info_.isEmpty()) {
                codedOutputStream.writeBytes(2, this.info_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WriteSwitchKeyOrBuilder {
            private ByteString info_;
            private ByteString key_;

            public static final Descriptors.Descriptor getDescriptor() {
                return StarryLinkEncrypt.internal_static_Starry_WriteSwitchKey_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearInfo() {
                this.info_ = WriteSwitchKey.getDefaultInstance().getInfo();
                onChanged();
                return this;
            }

            public Builder clearKey() {
                this.key_ = WriteSwitchKey.getDefaultInstance().getKey();
                onChanged();
                return this;
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return StarryLinkEncrypt.internal_static_Starry_WriteSwitchKey_descriptor;
            }

            public ByteString getInfo() {
                return this.info_;
            }

            public ByteString getKey() {
                return this.key_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StarryLinkEncrypt.internal_static_Starry_WriteSwitchKey_fieldAccessorTable.ensureFieldAccessorsInitialized(WriteSwitchKey.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setInfo(ByteString byteString) {
                byteString.getClass();
                this.info_ = byteString;
                onChanged();
                return this;
            }

            public Builder setKey(ByteString byteString) {
                byteString.getClass();
                this.key_ = byteString;
                onChanged();
                return this;
            }

            private Builder() {
                ByteString byteString = ByteString.EMPTY;
                this.key_ = byteString;
                this.info_ = byteString;
                maybeForceBuilderInitialization();
            }

            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public WriteSwitchKey build() {
                WriteSwitchKey buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
            }

            public WriteSwitchKey buildPartial() {
                WriteSwitchKey writeSwitchKey = new WriteSwitchKey((GeneratedMessageV3.Builder) this);
                ByteString unused = writeSwitchKey.key_ = this.key_;
                ByteString unused2 = writeSwitchKey.info_ = this.info_;
                onBuilt();
                return writeSwitchKey;
            }

            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public WriteSwitchKey getDefaultInstanceForType() {
                return WriteSwitchKey.getDefaultInstance();
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
                ByteString byteString = ByteString.EMPTY;
                this.key_ = byteString;
                this.info_ = byteString;
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                ByteString byteString = ByteString.EMPTY;
                this.key_ = byteString;
                this.info_ = byteString;
                maybeForceBuilderInitialization();
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder mergeFrom(Message message) {
                if (message instanceof WriteSwitchKey) {
                    return mergeFrom((WriteSwitchKey) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(WriteSwitchKey writeSwitchKey) {
                if (writeSwitchKey == WriteSwitchKey.getDefaultInstance()) {
                    return this;
                }
                ByteString key = writeSwitchKey.getKey();
                ByteString byteString = ByteString.EMPTY;
                if (key != byteString) {
                    setKey(writeSwitchKey.getKey());
                }
                if (writeSwitchKey.getInfo() != byteString) {
                    setInfo(writeSwitchKey.getInfo());
                }
                mergeUnknownFields(writeSwitchKey.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public Starry.StarryLinkEncrypt.WriteSwitchKey.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = Starry.StarryLinkEncrypt.WriteSwitchKey.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    Starry.StarryLinkEncrypt$WriteSwitchKey r3 = (Starry.StarryLinkEncrypt.WriteSwitchKey) r3     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                    if (r3 == 0) goto L_0x0010
                    r2.mergeFrom((Starry.StarryLinkEncrypt.WriteSwitchKey) r3)
                L_0x0010:
                    return r2
                L_0x0011:
                    r3 = move-exception
                    goto L_0x0021
                L_0x0013:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x0011 }
                    Starry.StarryLinkEncrypt$WriteSwitchKey r4 = (Starry.StarryLinkEncrypt.WriteSwitchKey) r4     // Catch:{ all -> 0x0011 }
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001f }
                    throw r3     // Catch:{ all -> 0x001f }
                L_0x001f:
                    r3 = move-exception
                    r0 = r4
                L_0x0021:
                    if (r0 == 0) goto L_0x0026
                    r2.mergeFrom((Starry.StarryLinkEncrypt.WriteSwitchKey) r0)
                L_0x0026:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: Starry.StarryLinkEncrypt.WriteSwitchKey.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):Starry.StarryLinkEncrypt$WriteSwitchKey$Builder");
            }
        }

        public static Builder newBuilder(WriteSwitchKey writeSwitchKey) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(writeSwitchKey);
        }

        public static WriteSwitchKey parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private WriteSwitchKey(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        public static WriteSwitchKey parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WriteSwitchKey) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WriteSwitchKey parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public WriteSwitchKey getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static WriteSwitchKey parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        private WriteSwitchKey() {
            this.memoizedIsInitialized = -1;
            ByteString byteString = ByteString.EMPTY;
            this.key_ = byteString;
            this.info_ = byteString;
        }

        public static WriteSwitchKey parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static WriteSwitchKey parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static WriteSwitchKey parseFrom(InputStream inputStream) throws IOException {
            return (WriteSwitchKey) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        private WriteSwitchKey(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            this.key_ = codedInputStream.readBytes();
                        } else if (readTag == 18) {
                            this.info_ = codedInputStream.readBytes();
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

        public static WriteSwitchKey parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WriteSwitchKey) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WriteSwitchKey parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (WriteSwitchKey) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static WriteSwitchKey parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WriteSwitchKey) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    public interface WriteSwitchKeyOrBuilder extends MessageOrBuilder {
        ByteString getInfo();

        ByteString getKey();
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019starry_link_encrypt.proto\u0012\u0006Starry\"M\n\fLinkProtocol\u0012\u0011\n\tdevice_id\u0018\u0001 \u0001(\f\u0012\u001c\n\u0003cmd\u0018\u0002 \u0001(\u000e2\u000f.Starry.COMMAND\u0012\f\n\u0004data\u0018\u0003 \u0001(\f\"+\n\rReadSwitchKey\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\f\u0012\r\n\u0005btMac\u0018\u0002 \u0001(\f\"+\n\u000eWriteSwitchKey\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\f\u0012\f\n\u0004info\u0018\u0002 \u0001(\f\"\u001e\n\u000eReadSwitchInfo\u0012\f\n\u0004info\u0018\u0001 \u0001(\f\"-\n\u000fWriteSwitchInfo\u0012\f\n\u0004code\u0018\u0001 \u0001(\u0005\u0012\f\n\u0004info\u0018\u0002 \u0001(\f\"\u0001\n\nDeviceInfo\u0012\r\n\u0005btMac\u0018\u0001 \u0001(\t\u0012\u0011\n\tcompanyId\u0018\u0002 \u0001(\t\u0012\u0012\n\ncategoryId\u0018\u0003 \u0001(\t\u0012\u000f\n\u0007modelId\u0018\u0004 \u0001(\t\u0012\f\n\u0004name\u0018\u0005 \u0001(\f\u0012\u000f\n\u0007battery\u0018\u0006 \u0001(\u0005\u0012\"\n\bbtStatus\u0018\u0007 \u0001(\u000e2\u0010.Starry.BTSTATUS\"5\n\u000fBTConnectStatus\u0012\"\n\bbtStatus\u0018\u0001 \u0001(\u000e2\u0010.Starry.BTSTATUS\":\n\u0010BLEConnectStatus\u0012&\n\bbtStatus\u0018\u0001 \u0001(\u000e2\u0014.Starry.IosBleSTATUS\".\n\nWifiGcInfo\u0012\u000b\n\u0003mac\u0018\u0001 \u0001(\t\u0012\u0013\n\u000bisConnected\u0018\u0002 \u0001(\b\"p\n\nWifiGoInfo\u0012\u000b\n\u0003mac\u0018\u0001 \u0001(\t\u0012\f\n\u0004port\u0018\u0002 \u0001(\u0005\u0012\f\n\u0004freq\u0018\u0003 \u0001(\u0005\u0012\f\n\u0004ssid\u0018\u0004 \u0001(\t\u0012\u000b\n\u0003psk\u0018\u0005 \u0001(\t\u0012\r\n\u0005gcMac\u0018\u0006 \u0001(\t\u0012\u000f\n\u0007address\u0018\u0007 \u0001(\t\"A\n\nWifiApInfo\u0012\f\n\u0004ssid\u0018\u0001 \u0001(\t\u0012\u000b\n\u0003psk\u0018\u0002 \u0001(\t\u0012\f\n\u0004port\u0018\u0003 \u0001(\u0005\u0012\n\n\u0002ip\u0018\u0004 \u0001(\t\"&\n\u000bWifiStaInfo\u0012\n\n\u0002ip\u0018\u0001 \u0001(\t\u0012\u000b\n\u0003mac\u0018\u0002 \u0001(\t\"_\n\fIOSConnectBt\u0012\u0012\n\ndeviceName\u0018\u0001 \u0001(\t\u0012\u0016\n\u000eisFirstConnect\u0018\u0002 \u0001(\b\u0012\u000f\n\u0007timeout\u0018\u0003 \u0001(\u0005\u0012\u0012\n\ncycleCount\u0018\u0004 \u0001(\u0005*á\u0006\n\u0007COMMAND\u0012\b\n\u0004INIT\u0010\u0000\u0012\n\n\u0006ENSURE\u0010\u0001\u0012\r\n\tUN_BONDED\u0010\u0002\u0012\u000e\n\nCONNECT_GO\u0010\u0003\u0012\u000e\n\nCONNECT_GC\u0010\u0004\u0012\u0012\n\u000eDISCONNECT_P2P\u0010\u0005\u0012\u0019\n\u0015DISCONNECT_P2P_ACTIVE\u0010\u0006\u0012\u0013\n\u000fREAD_SWITCH_KEY\u0010\n\u0012\u0014\n\u0010WRITE_SWITCH_KEY\u0010\u000b\u0012\u0014\n\u0010READ_SWITCH_INFO\u0010\f\u0012\u0015\n\u0011WRITE_SWITCH_INFO\u0010\r\u0012\u0013\n\u000fBOND_MSG_CHANGE\u0010\u000e\u0012\u000f\n\u000bCANCEL_AUTH\u0010\u0011\u0012\u000f\n\u000bAUTH_STATUE\u0010\u0012\u0012\u0010\n\fAUTH_MESSAGE\u0010\u0013\u0012\r\n\tCREATE_AP\u0010\u0014\u0012\u000e\n\nCONNECT_AP\u0010\u0015\u0012\u0010\n\fCONNECTED_AP\u0010\u0016\u0012\u0011\n\rDISCONNECT_AP\u0010\u0017\u0012\u0013\n\u000fDISCONNECTED_AP\u0010\u0018\u0012\u0013\n\u000fCONNECT_AP_FAIL\u0010\u0019\u0012.\n*SEVER_REQUEST_CLIENT_DISCONNECT_CONNECTION\u0010\u001a\u0012\u0012\n\u000eDISCONNECT_BLE\u0010\u001e\u0012\u0016\n\u0012PEERS_DISABLE_WIFI\u0010\u001f\u0012\u0012\n\u000eIOS_CONNECT_BT\u0010 \u0012\u0015\n\u0011IOS_DISCONNECT_BT\u0010!\u0012\u0013\n\u000fBT_STATE_CHANGE\u0010\"\u0012\u0015\n\u0011REQUEST_STATUS_BT\u0010#\u0012\u0015\n\u0011BLE_STATUS_CHANGE\u0010$\u0012\u0010\n\fSYNC_3RD_MAC\u0010(\u0012\u000e\n\nSYNC_GC_IP\u0010)\u0012\u0015\n\u0011PEERS_NAME_CHANGE\u00102\u0012\u001b\n\u0017EXTERNAL_MESSAGE_NORMAL\u0010<\u0012\u001c\n\u0018EXTERNAL_MESSAGE_ENCRYPT\u0010=\u0012\u0018\n\u0014SPP_SERVER_UUID_SYNC\u0010F\u0012\u001e\n\u001aSPP_SERVER_REQUEST_CONNECT\u0010G\u0012!\n\u001dSPP_SERVER_REQUEST_STATE_OPEN\u0010H\u0012\"\n\u001eSPP_SERVER_REQUEST_STATE_CLOSE\u0010I\u0012\u0014\n\u0010STARRY_NET_STACK\u0010P*á\u0001\n\bBTSTATUS\u0012\u000b\n\u0007DEFAULT\u0010\u0000\u0012\b\n\u0004BOND\u0010\u0001\u0012\u000b\n\u0007BONDING\u0010\u0002\u0012\n\n\u0006NOBOND\u0010\u0003\u0012\u0011\n\rCONNECTED_ACL\u0010\u0004\u0012\u0011\n\rCONNECTED_HFP\u0010\u0005\u0012\u0012\n\u000eCONNECTED_A2DP\u0010\u0006\u0012\u0010\n\fDISCONNECTED\u0010\u0007\u0012\u0013\n\u000fNO_CONNECTED_BT\u0010\b\u0012\u0016\n\u0012EXIST_CONNECTED_BT\u0010\t\u0012\u0010\n\fCONNECT_FAIL\u0010\n\u0012\u001a\n\u0016BOND_CANCEL_OR_TIMEOUT\u0010\u000b*?\n\fIosBleSTATUS\u0012\u000e\n\nBLE_BONDED\u0010\u0000\u0012\u000f\n\u000bBLE_BONDING\u0010\u0001\u0012\u000e\n\nBLE_NOBOND\u0010\u0002b\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = StarryLinkEncrypt.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_Starry_LinkProtocol_descriptor = descriptor2;
        internal_static_Starry_LinkProtocol_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"DeviceId", "Cmd", "Data"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_Starry_ReadSwitchKey_descriptor = descriptor3;
        internal_static_Starry_ReadSwitchKey_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Key", "BtMac"});
        Descriptors.Descriptor descriptor4 = getDescriptor().getMessageTypes().get(2);
        internal_static_Starry_WriteSwitchKey_descriptor = descriptor4;
        internal_static_Starry_WriteSwitchKey_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Key", "Info"});
        Descriptors.Descriptor descriptor5 = getDescriptor().getMessageTypes().get(3);
        internal_static_Starry_ReadSwitchInfo_descriptor = descriptor5;
        internal_static_Starry_ReadSwitchInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"Info"});
        Descriptors.Descriptor descriptor6 = getDescriptor().getMessageTypes().get(4);
        internal_static_Starry_WriteSwitchInfo_descriptor = descriptor6;
        internal_static_Starry_WriteSwitchInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor6, new String[]{"Code", "Info"});
        Descriptors.Descriptor descriptor7 = getDescriptor().getMessageTypes().get(5);
        internal_static_Starry_DeviceInfo_descriptor = descriptor7;
        internal_static_Starry_DeviceInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor7, new String[]{"BtMac", "CompanyId", "CategoryId", RingSecurityPair.KEY_MODELID, "Name", "Battery", "BtStatus"});
        Descriptors.Descriptor descriptor8 = getDescriptor().getMessageTypes().get(6);
        internal_static_Starry_BTConnectStatus_descriptor = descriptor8;
        internal_static_Starry_BTConnectStatus_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor8, new String[]{"BtStatus"});
        Descriptors.Descriptor descriptor9 = getDescriptor().getMessageTypes().get(7);
        internal_static_Starry_BLEConnectStatus_descriptor = descriptor9;
        internal_static_Starry_BLEConnectStatus_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor9, new String[]{"BtStatus"});
        Descriptors.Descriptor descriptor10 = getDescriptor().getMessageTypes().get(8);
        internal_static_Starry_WifiGcInfo_descriptor = descriptor10;
        internal_static_Starry_WifiGcInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor10, new String[]{"Mac", "IsConnected"});
        Descriptors.Descriptor descriptor11 = getDescriptor().getMessageTypes().get(9);
        internal_static_Starry_WifiGoInfo_descriptor = descriptor11;
        internal_static_Starry_WifiGoInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor11, new String[]{"Mac", "Port", "Freq", "Ssid", "Psk", "GcMac", "Address"});
        Descriptors.Descriptor descriptor12 = getDescriptor().getMessageTypes().get(10);
        internal_static_Starry_WifiApInfo_descriptor = descriptor12;
        internal_static_Starry_WifiApInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor12, new String[]{"Ssid", "Psk", "Port", "Ip"});
        Descriptors.Descriptor descriptor13 = getDescriptor().getMessageTypes().get(11);
        internal_static_Starry_WifiStaInfo_descriptor = descriptor13;
        internal_static_Starry_WifiStaInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor13, new String[]{"Ip", "Mac"});
        Descriptors.Descriptor descriptor14 = getDescriptor().getMessageTypes().get(12);
        internal_static_Starry_IOSConnectBt_descriptor = descriptor14;
        internal_static_Starry_IOSConnectBt_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor14, new String[]{"DeviceName", "IsFirstConnect", "Timeout", "CycleCount"});
    }

    private StarryLinkEncrypt() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }
}
