package com.upuphone.xr.interconnect.entity;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface StarryNetMessageDataOrBuilder extends MessageLiteOrBuilder {
    ByteString getData();

    int getIdentifier();

    String getMessage();

    ByteString getMessageBytes();

    String getReceiverPkg();

    ByteString getReceiverPkgBytes();

    String getSenderPkg();

    ByteString getSenderPkgBytes();
}
