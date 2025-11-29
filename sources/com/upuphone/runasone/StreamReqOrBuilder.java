package com.upuphone.runasone;

import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface StreamReqOrBuilder extends MessageOrBuilder {
    Any getAbilityMsg();

    AnyOrBuilder getAbilityMsgOrBuilder();

    ByteString getBypass();

    String getCategory();

    ByteString getCategoryBytes();

    long getDeltaSysTime();

    String getDeviceId();

    ByteString getDeviceIdBytes();

    String getDstId();

    ByteString getDstIdBytes();

    String getIpAddress();

    ByteString getIpAddressBytes();

    boolean getIsRetransmission();

    String getProtocolVersion();

    ByteString getProtocolVersionBytes();

    QosLevel getQos();

    int getQosValue();

    long getReqId();

    String getReqInfo();

    ByteString getReqInfoBytes();

    long getRetransmissionLen();

    String getSession();

    ByteString getSessionBytes();

    String getSrcId();

    ByteString getSrcIdBytes();

    int getTcpPort();

    String getTimeStamp();

    ByteString getTimeStampBytes();

    StreamType getType();

    int getTypeValue();

    int getUdpPort();

    boolean hasAbilityMsg();
}
