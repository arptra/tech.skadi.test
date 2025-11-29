package com.upuphone.runasone;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class StreamReq extends GeneratedMessageV3 implements StreamReqOrBuilder {
    public static final int ABILITYMSG_FIELD_NUMBER = 5;
    public static final int BYPASS_FIELD_NUMBER = 6;
    public static final int CATEGORY_FIELD_NUMBER = 2;
    private static final StreamReq DEFAULT_INSTANCE = new StreamReq();
    public static final int DELTASYSTIME_FIELD_NUMBER = 12;
    public static final int DEVICEID_FIELD_NUMBER = 3;
    public static final int DSTID_FIELD_NUMBER = 15;
    public static final int IPADDRESS_FIELD_NUMBER = 17;
    public static final int ISRETRANSMISSION_FIELD_NUMBER = 11;
    /* access modifiers changed from: private */
    public static final Parser<StreamReq> PARSER = new AbstractParser<StreamReq>() {
        public StreamReq parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new StreamReq(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int PROTOCOLVERSION_FIELD_NUMBER = 7;
    public static final int QOS_FIELD_NUMBER = 13;
    public static final int REQID_FIELD_NUMBER = 8;
    public static final int REQINFO_FIELD_NUMBER = 4;
    public static final int RETRANSMISSIONLEN_FIELD_NUMBER = 10;
    public static final int SESSION_FIELD_NUMBER = 14;
    public static final int SRCID_FIELD_NUMBER = 16;
    public static final int TCPPORT_FIELD_NUMBER = 18;
    public static final int TIMESTAMP_FIELD_NUMBER = 9;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int UDPPORT_FIELD_NUMBER = 19;
    private static final long serialVersionUID = 0;
    /* access modifiers changed from: private */
    public Any abilityMsg_;
    /* access modifiers changed from: private */
    public ByteString bypass_;
    /* access modifiers changed from: private */
    public volatile Object category_;
    /* access modifiers changed from: private */
    public long deltaSysTime_;
    /* access modifiers changed from: private */
    public volatile Object deviceId_;
    /* access modifiers changed from: private */
    public volatile Object dstId_;
    /* access modifiers changed from: private */
    public volatile Object ipAddress_;
    /* access modifiers changed from: private */
    public boolean isRetransmission_;
    private byte memoizedIsInitialized;
    /* access modifiers changed from: private */
    public volatile Object protocolVersion_;
    /* access modifiers changed from: private */
    public int qos_;
    /* access modifiers changed from: private */
    public long reqId_;
    /* access modifiers changed from: private */
    public volatile Object reqInfo_;
    /* access modifiers changed from: private */
    public long retransmissionLen_;
    /* access modifiers changed from: private */
    public volatile Object session_;
    /* access modifiers changed from: private */
    public volatile Object srcId_;
    /* access modifiers changed from: private */
    public int tcpPort_;
    /* access modifiers changed from: private */
    public volatile Object timeStamp_;
    /* access modifiers changed from: private */
    public int type_;
    /* access modifiers changed from: private */
    public int udpPort_;

    public static StreamReq getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return RunAsOneProto.internal_static_StreamReq_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static StreamReq parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (StreamReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static StreamReq parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<StreamReq> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StreamReq)) {
            return super.equals(obj);
        }
        StreamReq streamReq = (StreamReq) obj;
        boolean z = this.type_ == streamReq.type_ && getCategory().equals(streamReq.getCategory()) && getDeviceId().equals(streamReq.getDeviceId()) && getReqInfo().equals(streamReq.getReqInfo()) && hasAbilityMsg() == streamReq.hasAbilityMsg();
        if (hasAbilityMsg()) {
            z = z && getAbilityMsg().equals(streamReq.getAbilityMsg());
        }
        return ((((((((((((((z && getBypass().equals(streamReq.getBypass())) && getProtocolVersion().equals(streamReq.getProtocolVersion())) && (getReqId() > streamReq.getReqId() ? 1 : (getReqId() == streamReq.getReqId() ? 0 : -1)) == 0) && getTimeStamp().equals(streamReq.getTimeStamp())) && (getRetransmissionLen() > streamReq.getRetransmissionLen() ? 1 : (getRetransmissionLen() == streamReq.getRetransmissionLen() ? 0 : -1)) == 0) && getIsRetransmission() == streamReq.getIsRetransmission()) && (getDeltaSysTime() > streamReq.getDeltaSysTime() ? 1 : (getDeltaSysTime() == streamReq.getDeltaSysTime() ? 0 : -1)) == 0) && this.qos_ == streamReq.qos_) && getSession().equals(streamReq.getSession())) && getDstId().equals(streamReq.getDstId())) && getSrcId().equals(streamReq.getSrcId())) && getIpAddress().equals(streamReq.getIpAddress())) && getTcpPort() == streamReq.getTcpPort()) && getUdpPort() == streamReq.getUdpPort()) && this.unknownFields.equals(streamReq.unknownFields);
    }

    public Any getAbilityMsg() {
        Any any = this.abilityMsg_;
        return any == null ? Any.getDefaultInstance() : any;
    }

    public AnyOrBuilder getAbilityMsgOrBuilder() {
        return getAbilityMsg();
    }

    public ByteString getBypass() {
        return this.bypass_;
    }

    public String getCategory() {
        Object obj = this.category_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.category_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getCategoryBytes() {
        Object obj = this.category_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.category_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public long getDeltaSysTime() {
        return this.deltaSysTime_;
    }

    public String getDeviceId() {
        Object obj = this.deviceId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.deviceId_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getDeviceIdBytes() {
        Object obj = this.deviceId_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.deviceId_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public String getDstId() {
        Object obj = this.dstId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.dstId_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getDstIdBytes() {
        Object obj = this.dstId_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.dstId_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public String getIpAddress() {
        Object obj = this.ipAddress_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.ipAddress_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getIpAddressBytes() {
        Object obj = this.ipAddress_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.ipAddress_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public boolean getIsRetransmission() {
        return this.isRetransmission_;
    }

    public Parser<StreamReq> getParserForType() {
        return PARSER;
    }

    public String getProtocolVersion() {
        Object obj = this.protocolVersion_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.protocolVersion_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getProtocolVersionBytes() {
        Object obj = this.protocolVersion_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.protocolVersion_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public QosLevel getQos() {
        QosLevel valueOf = QosLevel.valueOf(this.qos_);
        return valueOf == null ? QosLevel.UNRECOGNIZED : valueOf;
    }

    public int getQosValue() {
        return this.qos_;
    }

    public long getReqId() {
        return this.reqId_;
    }

    public String getReqInfo() {
        Object obj = this.reqInfo_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.reqInfo_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getReqInfoBytes() {
        Object obj = this.reqInfo_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.reqInfo_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public long getRetransmissionLen() {
        return this.retransmissionLen_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int computeEnumSize = this.type_ != StreamType.AUTH.getNumber() ? CodedOutputStream.computeEnumSize(1, this.type_) : 0;
        if (!getCategoryBytes().isEmpty()) {
            computeEnumSize += GeneratedMessageV3.computeStringSize(2, this.category_);
        }
        if (!getDeviceIdBytes().isEmpty()) {
            computeEnumSize += GeneratedMessageV3.computeStringSize(3, this.deviceId_);
        }
        if (!getReqInfoBytes().isEmpty()) {
            computeEnumSize += GeneratedMessageV3.computeStringSize(4, this.reqInfo_);
        }
        if (this.abilityMsg_ != null) {
            computeEnumSize += CodedOutputStream.computeMessageSize(5, getAbilityMsg());
        }
        if (!this.bypass_.isEmpty()) {
            computeEnumSize += CodedOutputStream.computeBytesSize(6, this.bypass_);
        }
        if (!getProtocolVersionBytes().isEmpty()) {
            computeEnumSize += GeneratedMessageV3.computeStringSize(7, this.protocolVersion_);
        }
        long j = this.reqId_;
        if (j != 0) {
            computeEnumSize += CodedOutputStream.computeUInt64Size(8, j);
        }
        if (!getTimeStampBytes().isEmpty()) {
            computeEnumSize += GeneratedMessageV3.computeStringSize(9, this.timeStamp_);
        }
        long j2 = this.retransmissionLen_;
        if (j2 != 0) {
            computeEnumSize += CodedOutputStream.computeUInt64Size(10, j2);
        }
        boolean z = this.isRetransmission_;
        if (z) {
            computeEnumSize += CodedOutputStream.computeBoolSize(11, z);
        }
        long j3 = this.deltaSysTime_;
        if (j3 != 0) {
            computeEnumSize += CodedOutputStream.computeUInt64Size(12, j3);
        }
        if (this.qos_ != QosLevel.QOS_0.getNumber()) {
            computeEnumSize += CodedOutputStream.computeEnumSize(13, this.qos_);
        }
        if (!getSessionBytes().isEmpty()) {
            computeEnumSize += GeneratedMessageV3.computeStringSize(14, this.session_);
        }
        if (!getDstIdBytes().isEmpty()) {
            computeEnumSize += GeneratedMessageV3.computeStringSize(15, this.dstId_);
        }
        if (!getSrcIdBytes().isEmpty()) {
            computeEnumSize += GeneratedMessageV3.computeStringSize(16, this.srcId_);
        }
        if (!getIpAddressBytes().isEmpty()) {
            computeEnumSize += GeneratedMessageV3.computeStringSize(17, this.ipAddress_);
        }
        int i2 = this.tcpPort_;
        if (i2 != 0) {
            computeEnumSize += CodedOutputStream.computeUInt32Size(18, i2);
        }
        int i3 = this.udpPort_;
        if (i3 != 0) {
            computeEnumSize += CodedOutputStream.computeUInt32Size(19, i3);
        }
        int serializedSize = computeEnumSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public String getSession() {
        Object obj = this.session_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.session_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getSessionBytes() {
        Object obj = this.session_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.session_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public String getSrcId() {
        Object obj = this.srcId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.srcId_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getSrcIdBytes() {
        Object obj = this.srcId_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.srcId_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public int getTcpPort() {
        return this.tcpPort_;
    }

    public String getTimeStamp() {
        Object obj = this.timeStamp_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.timeStamp_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getTimeStampBytes() {
        Object obj = this.timeStamp_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.timeStamp_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public StreamType getType() {
        StreamType valueOf = StreamType.valueOf(this.type_);
        return valueOf == null ? StreamType.UNRECOGNIZED : valueOf;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public int getUdpPort() {
        return this.udpPort_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasAbilityMsg() {
        return this.abilityMsg_ != null;
    }

    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = ((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.type_) * 37) + 2) * 53) + getCategory().hashCode()) * 37) + 3) * 53) + getDeviceId().hashCode()) * 37) + 4) * 53) + getReqInfo().hashCode();
        if (hasAbilityMsg()) {
            hashCode = (((hashCode * 37) + 5) * 53) + getAbilityMsg().hashCode();
        }
        int hashCode2 = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 37) + 6) * 53) + getBypass().hashCode()) * 37) + 7) * 53) + getProtocolVersion().hashCode()) * 37) + 8) * 53) + Internal.hashLong(getReqId())) * 37) + 9) * 53) + getTimeStamp().hashCode()) * 37) + 10) * 53) + Internal.hashLong(getRetransmissionLen())) * 37) + 11) * 53) + Internal.hashBoolean(getIsRetransmission())) * 37) + 12) * 53) + Internal.hashLong(getDeltaSysTime())) * 37) + 13) * 53) + this.qos_) * 37) + 14) * 53) + getSession().hashCode()) * 37) + 15) * 53) + getDstId().hashCode()) * 37) + 16) * 53) + getSrcId().hashCode()) * 37) + 17) * 53) + getIpAddress().hashCode()) * 37) + 18) * 53) + getTcpPort()) * 37) + 19) * 53) + getUdpPort()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return RunAsOneProto.internal_static_StreamReq_fieldAccessorTable.ensureFieldAccessorsInitialized(StreamReq.class, Builder.class);
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
        if (this.type_ != StreamType.AUTH.getNumber()) {
            codedOutputStream.writeEnum(1, this.type_);
        }
        if (!getCategoryBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.category_);
        }
        if (!getDeviceIdBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.deviceId_);
        }
        if (!getReqInfoBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.reqInfo_);
        }
        if (this.abilityMsg_ != null) {
            codedOutputStream.writeMessage(5, getAbilityMsg());
        }
        if (!this.bypass_.isEmpty()) {
            codedOutputStream.writeBytes(6, this.bypass_);
        }
        if (!getProtocolVersionBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.protocolVersion_);
        }
        long j = this.reqId_;
        if (j != 0) {
            codedOutputStream.writeUInt64(8, j);
        }
        if (!getTimeStampBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 9, this.timeStamp_);
        }
        long j2 = this.retransmissionLen_;
        if (j2 != 0) {
            codedOutputStream.writeUInt64(10, j2);
        }
        boolean z = this.isRetransmission_;
        if (z) {
            codedOutputStream.writeBool(11, z);
        }
        long j3 = this.deltaSysTime_;
        if (j3 != 0) {
            codedOutputStream.writeUInt64(12, j3);
        }
        if (this.qos_ != QosLevel.QOS_0.getNumber()) {
            codedOutputStream.writeEnum(13, this.qos_);
        }
        if (!getSessionBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 14, this.session_);
        }
        if (!getDstIdBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 15, this.dstId_);
        }
        if (!getSrcIdBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 16, this.srcId_);
        }
        if (!getIpAddressBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 17, this.ipAddress_);
        }
        int i = this.tcpPort_;
        if (i != 0) {
            codedOutputStream.writeUInt32(18, i);
        }
        int i2 = this.udpPort_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(19, i2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StreamReqOrBuilder {
        private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> abilityMsgBuilder_;
        private Any abilityMsg_;
        private ByteString bypass_;
        private Object category_;
        private long deltaSysTime_;
        private Object deviceId_;
        private Object dstId_;
        private Object ipAddress_;
        private boolean isRetransmission_;
        private Object protocolVersion_;
        private int qos_;
        private long reqId_;
        private Object reqInfo_;
        private long retransmissionLen_;
        private Object session_;
        private Object srcId_;
        private int tcpPort_;
        private Object timeStamp_;
        private int type_;
        private int udpPort_;

        private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getAbilityMsgFieldBuilder() {
            if (this.abilityMsgBuilder_ == null) {
                this.abilityMsgBuilder_ = new SingleFieldBuilderV3<>(getAbilityMsg(), getParentForChildren(), isClean());
                this.abilityMsg_ = null;
            }
            return this.abilityMsgBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return RunAsOneProto.internal_static_StreamReq_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public Builder clearAbilityMsg() {
            if (this.abilityMsgBuilder_ == null) {
                this.abilityMsg_ = null;
                onChanged();
            } else {
                this.abilityMsg_ = null;
                this.abilityMsgBuilder_ = null;
            }
            return this;
        }

        public Builder clearBypass() {
            this.bypass_ = StreamReq.getDefaultInstance().getBypass();
            onChanged();
            return this;
        }

        public Builder clearCategory() {
            this.category_ = StreamReq.getDefaultInstance().getCategory();
            onChanged();
            return this;
        }

        public Builder clearDeltaSysTime() {
            this.deltaSysTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDeviceId() {
            this.deviceId_ = StreamReq.getDefaultInstance().getDeviceId();
            onChanged();
            return this;
        }

        public Builder clearDstId() {
            this.dstId_ = StreamReq.getDefaultInstance().getDstId();
            onChanged();
            return this;
        }

        public Builder clearIpAddress() {
            this.ipAddress_ = StreamReq.getDefaultInstance().getIpAddress();
            onChanged();
            return this;
        }

        public Builder clearIsRetransmission() {
            this.isRetransmission_ = false;
            onChanged();
            return this;
        }

        public Builder clearProtocolVersion() {
            this.protocolVersion_ = StreamReq.getDefaultInstance().getProtocolVersion();
            onChanged();
            return this;
        }

        public Builder clearQos() {
            this.qos_ = 0;
            onChanged();
            return this;
        }

        public Builder clearReqId() {
            this.reqId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearReqInfo() {
            this.reqInfo_ = StreamReq.getDefaultInstance().getReqInfo();
            onChanged();
            return this;
        }

        public Builder clearRetransmissionLen() {
            this.retransmissionLen_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSession() {
            this.session_ = StreamReq.getDefaultInstance().getSession();
            onChanged();
            return this;
        }

        public Builder clearSrcId() {
            this.srcId_ = StreamReq.getDefaultInstance().getSrcId();
            onChanged();
            return this;
        }

        public Builder clearTcpPort() {
            this.tcpPort_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTimeStamp() {
            this.timeStamp_ = StreamReq.getDefaultInstance().getTimeStamp();
            onChanged();
            return this;
        }

        public Builder clearType() {
            this.type_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUdpPort() {
            this.udpPort_ = 0;
            onChanged();
            return this;
        }

        public Any getAbilityMsg() {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.abilityMsgBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessage();
            }
            Any any = this.abilityMsg_;
            return any == null ? Any.getDefaultInstance() : any;
        }

        public Any.Builder getAbilityMsgBuilder() {
            onChanged();
            return getAbilityMsgFieldBuilder().getBuilder();
        }

        public AnyOrBuilder getAbilityMsgOrBuilder() {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.abilityMsgBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Any any = this.abilityMsg_;
            return any == null ? Any.getDefaultInstance() : any;
        }

        public ByteString getBypass() {
            return this.bypass_;
        }

        public String getCategory() {
            Object obj = this.category_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.category_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getCategoryBytes() {
            Object obj = this.category_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.category_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public long getDeltaSysTime() {
            return this.deltaSysTime_;
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return RunAsOneProto.internal_static_StreamReq_descriptor;
        }

        public String getDeviceId() {
            Object obj = this.deviceId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceId_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getDeviceIdBytes() {
            Object obj = this.deviceId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getDstId() {
            Object obj = this.dstId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.dstId_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getDstIdBytes() {
            Object obj = this.dstId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.dstId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getIpAddress() {
            Object obj = this.ipAddress_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.ipAddress_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getIpAddressBytes() {
            Object obj = this.ipAddress_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ipAddress_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean getIsRetransmission() {
            return this.isRetransmission_;
        }

        public String getProtocolVersion() {
            Object obj = this.protocolVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.protocolVersion_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getProtocolVersionBytes() {
            Object obj = this.protocolVersion_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.protocolVersion_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public QosLevel getQos() {
            QosLevel valueOf = QosLevel.valueOf(this.qos_);
            return valueOf == null ? QosLevel.UNRECOGNIZED : valueOf;
        }

        public int getQosValue() {
            return this.qos_;
        }

        public long getReqId() {
            return this.reqId_;
        }

        public String getReqInfo() {
            Object obj = this.reqInfo_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.reqInfo_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getReqInfoBytes() {
            Object obj = this.reqInfo_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.reqInfo_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public long getRetransmissionLen() {
            return this.retransmissionLen_;
        }

        public String getSession() {
            Object obj = this.session_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.session_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getSessionBytes() {
            Object obj = this.session_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.session_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getSrcId() {
            Object obj = this.srcId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.srcId_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getSrcIdBytes() {
            Object obj = this.srcId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.srcId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public int getTcpPort() {
            return this.tcpPort_;
        }

        public String getTimeStamp() {
            Object obj = this.timeStamp_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.timeStamp_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getTimeStampBytes() {
            Object obj = this.timeStamp_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.timeStamp_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public StreamType getType() {
            StreamType valueOf = StreamType.valueOf(this.type_);
            return valueOf == null ? StreamType.UNRECOGNIZED : valueOf;
        }

        public int getTypeValue() {
            return this.type_;
        }

        public int getUdpPort() {
            return this.udpPort_;
        }

        public boolean hasAbilityMsg() {
            return (this.abilityMsgBuilder_ == null && this.abilityMsg_ == null) ? false : true;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RunAsOneProto.internal_static_StreamReq_fieldAccessorTable.ensureFieldAccessorsInitialized(StreamReq.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeAbilityMsg(Any any) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.abilityMsgBuilder_;
            if (singleFieldBuilderV3 == null) {
                Any any2 = this.abilityMsg_;
                if (any2 != null) {
                    this.abilityMsg_ = Any.newBuilder(any2).mergeFrom(any).buildPartial();
                } else {
                    this.abilityMsg_ = any;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(any);
            }
            return this;
        }

        public Builder setAbilityMsg(Any any) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.abilityMsgBuilder_;
            if (singleFieldBuilderV3 == null) {
                any.getClass();
                this.abilityMsg_ = any;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(any);
            }
            return this;
        }

        public Builder setBypass(ByteString byteString) {
            byteString.getClass();
            this.bypass_ = byteString;
            onChanged();
            return this;
        }

        public Builder setCategory(String str) {
            str.getClass();
            this.category_ = str;
            onChanged();
            return this;
        }

        public Builder setCategoryBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.category_ = byteString;
            onChanged();
            return this;
        }

        public Builder setDeltaSysTime(long j) {
            this.deltaSysTime_ = j;
            onChanged();
            return this;
        }

        public Builder setDeviceId(String str) {
            str.getClass();
            this.deviceId_ = str;
            onChanged();
            return this;
        }

        public Builder setDeviceIdBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.deviceId_ = byteString;
            onChanged();
            return this;
        }

        public Builder setDstId(String str) {
            str.getClass();
            this.dstId_ = str;
            onChanged();
            return this;
        }

        public Builder setDstIdBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.dstId_ = byteString;
            onChanged();
            return this;
        }

        public Builder setIpAddress(String str) {
            str.getClass();
            this.ipAddress_ = str;
            onChanged();
            return this;
        }

        public Builder setIpAddressBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.ipAddress_ = byteString;
            onChanged();
            return this;
        }

        public Builder setIsRetransmission(boolean z) {
            this.isRetransmission_ = z;
            onChanged();
            return this;
        }

        public Builder setProtocolVersion(String str) {
            str.getClass();
            this.protocolVersion_ = str;
            onChanged();
            return this;
        }

        public Builder setProtocolVersionBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.protocolVersion_ = byteString;
            onChanged();
            return this;
        }

        public Builder setQos(QosLevel qosLevel) {
            qosLevel.getClass();
            this.qos_ = qosLevel.getNumber();
            onChanged();
            return this;
        }

        public Builder setQosValue(int i) {
            this.qos_ = i;
            onChanged();
            return this;
        }

        public Builder setReqId(long j) {
            this.reqId_ = j;
            onChanged();
            return this;
        }

        public Builder setReqInfo(String str) {
            str.getClass();
            this.reqInfo_ = str;
            onChanged();
            return this;
        }

        public Builder setReqInfoBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.reqInfo_ = byteString;
            onChanged();
            return this;
        }

        public Builder setRetransmissionLen(long j) {
            this.retransmissionLen_ = j;
            onChanged();
            return this;
        }

        public Builder setSession(String str) {
            str.getClass();
            this.session_ = str;
            onChanged();
            return this;
        }

        public Builder setSessionBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.session_ = byteString;
            onChanged();
            return this;
        }

        public Builder setSrcId(String str) {
            str.getClass();
            this.srcId_ = str;
            onChanged();
            return this;
        }

        public Builder setSrcIdBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.srcId_ = byteString;
            onChanged();
            return this;
        }

        public Builder setTcpPort(int i) {
            this.tcpPort_ = i;
            onChanged();
            return this;
        }

        public Builder setTimeStamp(String str) {
            str.getClass();
            this.timeStamp_ = str;
            onChanged();
            return this;
        }

        public Builder setTimeStampBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.timeStamp_ = byteString;
            onChanged();
            return this;
        }

        public Builder setType(StreamType streamType) {
            streamType.getClass();
            this.type_ = streamType.getNumber();
            onChanged();
            return this;
        }

        public Builder setTypeValue(int i) {
            this.type_ = i;
            onChanged();
            return this;
        }

        public Builder setUdpPort(int i) {
            this.udpPort_ = i;
            onChanged();
            return this;
        }

        private Builder() {
            this.type_ = 0;
            this.category_ = "";
            this.deviceId_ = "";
            this.reqInfo_ = "";
            this.abilityMsg_ = null;
            this.bypass_ = ByteString.EMPTY;
            this.protocolVersion_ = "";
            this.timeStamp_ = "";
            this.qos_ = 0;
            this.session_ = "";
            this.dstId_ = "";
            this.srcId_ = "";
            this.ipAddress_ = "";
            maybeForceBuilderInitialization();
        }

        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public StreamReq build() {
            StreamReq buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException(buildPartial);
        }

        public StreamReq buildPartial() {
            StreamReq streamReq = new StreamReq((GeneratedMessageV3.Builder) this);
            int unused = streamReq.type_ = this.type_;
            Object unused2 = streamReq.category_ = this.category_;
            Object unused3 = streamReq.deviceId_ = this.deviceId_;
            Object unused4 = streamReq.reqInfo_ = this.reqInfo_;
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.abilityMsgBuilder_;
            if (singleFieldBuilderV3 == null) {
                Any unused5 = streamReq.abilityMsg_ = this.abilityMsg_;
            } else {
                Any unused6 = streamReq.abilityMsg_ = singleFieldBuilderV3.build();
            }
            ByteString unused7 = streamReq.bypass_ = this.bypass_;
            Object unused8 = streamReq.protocolVersion_ = this.protocolVersion_;
            long unused9 = streamReq.reqId_ = this.reqId_;
            Object unused10 = streamReq.timeStamp_ = this.timeStamp_;
            long unused11 = streamReq.retransmissionLen_ = this.retransmissionLen_;
            boolean unused12 = streamReq.isRetransmission_ = this.isRetransmission_;
            long unused13 = streamReq.deltaSysTime_ = this.deltaSysTime_;
            int unused14 = streamReq.qos_ = this.qos_;
            Object unused15 = streamReq.session_ = this.session_;
            Object unused16 = streamReq.dstId_ = this.dstId_;
            Object unused17 = streamReq.srcId_ = this.srcId_;
            Object unused18 = streamReq.ipAddress_ = this.ipAddress_;
            int unused19 = streamReq.tcpPort_ = this.tcpPort_;
            int unused20 = streamReq.udpPort_ = this.udpPort_;
            onBuilt();
            return streamReq;
        }

        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public StreamReq getDefaultInstanceForType() {
            return StreamReq.getDefaultInstance();
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
            this.type_ = 0;
            this.category_ = "";
            this.deviceId_ = "";
            this.reqInfo_ = "";
            if (this.abilityMsgBuilder_ == null) {
                this.abilityMsg_ = null;
            } else {
                this.abilityMsg_ = null;
                this.abilityMsgBuilder_ = null;
            }
            this.bypass_ = ByteString.EMPTY;
            this.protocolVersion_ = "";
            this.reqId_ = 0;
            this.timeStamp_ = "";
            this.retransmissionLen_ = 0;
            this.isRetransmission_ = false;
            this.deltaSysTime_ = 0;
            this.qos_ = 0;
            this.session_ = "";
            this.dstId_ = "";
            this.srcId_ = "";
            this.ipAddress_ = "";
            this.tcpPort_ = 0;
            this.udpPort_ = 0;
            return this;
        }

        public Builder setAbilityMsg(Any.Builder builder) {
            SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.abilityMsgBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.abilityMsg_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder clone() {
            return (Builder) super.clone();
        }

        public Builder mergeFrom(Message message) {
            if (message instanceof StreamReq) {
                return mergeFrom((StreamReq) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(StreamReq streamReq) {
            if (streamReq == StreamReq.getDefaultInstance()) {
                return this;
            }
            if (streamReq.type_ != 0) {
                setTypeValue(streamReq.getTypeValue());
            }
            if (!streamReq.getCategory().isEmpty()) {
                this.category_ = streamReq.category_;
                onChanged();
            }
            if (!streamReq.getDeviceId().isEmpty()) {
                this.deviceId_ = streamReq.deviceId_;
                onChanged();
            }
            if (!streamReq.getReqInfo().isEmpty()) {
                this.reqInfo_ = streamReq.reqInfo_;
                onChanged();
            }
            if (streamReq.hasAbilityMsg()) {
                mergeAbilityMsg(streamReq.getAbilityMsg());
            }
            if (streamReq.getBypass() != ByteString.EMPTY) {
                setBypass(streamReq.getBypass());
            }
            if (!streamReq.getProtocolVersion().isEmpty()) {
                this.protocolVersion_ = streamReq.protocolVersion_;
                onChanged();
            }
            if (streamReq.getReqId() != 0) {
                setReqId(streamReq.getReqId());
            }
            if (!streamReq.getTimeStamp().isEmpty()) {
                this.timeStamp_ = streamReq.timeStamp_;
                onChanged();
            }
            if (streamReq.getRetransmissionLen() != 0) {
                setRetransmissionLen(streamReq.getRetransmissionLen());
            }
            if (streamReq.getIsRetransmission()) {
                setIsRetransmission(streamReq.getIsRetransmission());
            }
            if (streamReq.getDeltaSysTime() != 0) {
                setDeltaSysTime(streamReq.getDeltaSysTime());
            }
            if (streamReq.qos_ != 0) {
                setQosValue(streamReq.getQosValue());
            }
            if (!streamReq.getSession().isEmpty()) {
                this.session_ = streamReq.session_;
                onChanged();
            }
            if (!streamReq.getDstId().isEmpty()) {
                this.dstId_ = streamReq.dstId_;
                onChanged();
            }
            if (!streamReq.getSrcId().isEmpty()) {
                this.srcId_ = streamReq.srcId_;
                onChanged();
            }
            if (!streamReq.getIpAddress().isEmpty()) {
                this.ipAddress_ = streamReq.ipAddress_;
                onChanged();
            }
            if (streamReq.getTcpPort() != 0) {
                setTcpPort(streamReq.getTcpPort());
            }
            if (streamReq.getUdpPort() != 0) {
                setUdpPort(streamReq.getUdpPort());
            }
            mergeUnknownFields(streamReq.unknownFields);
            onChanged();
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.type_ = 0;
            this.category_ = "";
            this.deviceId_ = "";
            this.reqInfo_ = "";
            this.abilityMsg_ = null;
            this.bypass_ = ByteString.EMPTY;
            this.protocolVersion_ = "";
            this.timeStamp_ = "";
            this.qos_ = 0;
            this.session_ = "";
            this.dstId_ = "";
            this.srcId_ = "";
            this.ipAddress_ = "";
            maybeForceBuilderInitialization();
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.upuphone.runasone.StreamReq.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.upuphone.runasone.StreamReq.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r3, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                com.upuphone.runasone.StreamReq r3 = (com.upuphone.runasone.StreamReq) r3     // Catch:{ InvalidProtocolBufferException -> 0x0013 }
                if (r3 == 0) goto L_0x0010
                r2.mergeFrom((com.upuphone.runasone.StreamReq) r3)
            L_0x0010:
                return r2
            L_0x0011:
                r3 = move-exception
                goto L_0x0021
            L_0x0013:
                r3 = move-exception
                com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch:{ all -> 0x0011 }
                com.upuphone.runasone.StreamReq r4 = (com.upuphone.runasone.StreamReq) r4     // Catch:{ all -> 0x0011 }
                java.io.IOException r3 = r3.unwrapIOException()     // Catch:{ all -> 0x001f }
                throw r3     // Catch:{ all -> 0x001f }
            L_0x001f:
                r3 = move-exception
                r0 = r4
            L_0x0021:
                if (r0 == 0) goto L_0x0026
                r2.mergeFrom((com.upuphone.runasone.StreamReq) r0)
            L_0x0026:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.StreamReq.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.upuphone.runasone.StreamReq$Builder");
        }
    }

    public static Builder newBuilder(StreamReq streamReq) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(streamReq);
    }

    public static StreamReq parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private StreamReq(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
    }

    public static StreamReq parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StreamReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static StreamReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public StreamReq getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static StreamReq parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public Builder newBuilderForType() {
        return newBuilder();
    }

    private StreamReq() {
        this.memoizedIsInitialized = -1;
        this.type_ = 0;
        this.category_ = "";
        this.deviceId_ = "";
        this.reqInfo_ = "";
        this.bypass_ = ByteString.EMPTY;
        this.protocolVersion_ = "";
        this.reqId_ = 0;
        this.timeStamp_ = "";
        this.retransmissionLen_ = 0;
        this.isRetransmission_ = false;
        this.deltaSysTime_ = 0;
        this.qos_ = 0;
        this.session_ = "";
        this.dstId_ = "";
        this.srcId_ = "";
        this.ipAddress_ = "";
        this.tcpPort_ = 0;
        this.udpPort_ = 0;
    }

    public static StreamReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static StreamReq parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static StreamReq parseFrom(InputStream inputStream) throws IOException {
        return (StreamReq) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static StreamReq parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StreamReq) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static StreamReq parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (StreamReq) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static StreamReq parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StreamReq) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    private StreamReq(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        extensionRegistryLite.getClass();
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        while (!z) {
            try {
                int readTag = codedInputStream.readTag();
                switch (readTag) {
                    case 0:
                        z = true;
                        break;
                    case 8:
                        this.type_ = codedInputStream.readEnum();
                        break;
                    case 18:
                        this.category_ = codedInputStream.readStringRequireUtf8();
                        break;
                    case 26:
                        this.deviceId_ = codedInputStream.readStringRequireUtf8();
                        break;
                    case 34:
                        this.reqInfo_ = codedInputStream.readStringRequireUtf8();
                        break;
                    case 42:
                        Any any = this.abilityMsg_;
                        Any.Builder builder = any != null ? any.toBuilder() : null;
                        Any any2 = (Any) codedInputStream.readMessage(Any.parser(), extensionRegistryLite);
                        this.abilityMsg_ = any2;
                        if (builder == null) {
                            break;
                        } else {
                            builder.mergeFrom(any2);
                            this.abilityMsg_ = builder.buildPartial();
                            break;
                        }
                    case 50:
                        this.bypass_ = codedInputStream.readBytes();
                        break;
                    case 58:
                        this.protocolVersion_ = codedInputStream.readStringRequireUtf8();
                        break;
                    case 64:
                        this.reqId_ = codedInputStream.readUInt64();
                        break;
                    case 74:
                        this.timeStamp_ = codedInputStream.readStringRequireUtf8();
                        break;
                    case 80:
                        this.retransmissionLen_ = codedInputStream.readUInt64();
                        break;
                    case 88:
                        this.isRetransmission_ = codedInputStream.readBool();
                        break;
                    case 96:
                        this.deltaSysTime_ = codedInputStream.readUInt64();
                        break;
                    case 104:
                        this.qos_ = codedInputStream.readEnum();
                        break;
                    case 114:
                        this.session_ = codedInputStream.readStringRequireUtf8();
                        break;
                    case 122:
                        this.dstId_ = codedInputStream.readStringRequireUtf8();
                        break;
                    case 130:
                        this.srcId_ = codedInputStream.readStringRequireUtf8();
                        break;
                    case 138:
                        this.ipAddress_ = codedInputStream.readStringRequireUtf8();
                        break;
                    case AdvPackConstants.ADV_MODE_ACTIVE_NO_WINDOW /*144*/:
                        this.tcpPort_ = codedInputStream.readUInt32();
                        break;
                    case 152:
                        this.udpPort_ = codedInputStream.readUInt32();
                        break;
                    default:
                        if (parseUnknownFieldProto3(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            break;
                        }
                        z = true;
                        break;
                }
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
