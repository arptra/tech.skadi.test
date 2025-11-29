package com.upuphone.xr.interconnect.entity;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface ConnectMsgOrBuilder extends MessageLiteOrBuilder {
    ByteString getData();
}
