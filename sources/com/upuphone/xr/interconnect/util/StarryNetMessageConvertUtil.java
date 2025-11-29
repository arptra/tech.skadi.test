package com.upuphone.xr.interconnect.util;

import com.google.protobuf.ByteString;
import com.google.protobuf.Internal;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.entity.StarryNetMessageData;

public final class StarryNetMessageConvertUtil {
    private StarryNetMessageConvertUtil() {
    }

    public static StarryNetMessage convert(StarryNetMessageData starryNetMessageData) {
        StarryNetMessage starryNetMessage = new StarryNetMessage();
        starryNetMessage.setId(String.valueOf(starryNetMessageData.getIdentifier()));
        starryNetMessage.setSenderPkg(starryNetMessageData.getSenderPkg());
        starryNetMessage.setReceiverPkg(starryNetMessageData.getReceiverPkg());
        starryNetMessage.setMessage(starryNetMessageData.getMessage());
        starryNetMessage.setData(starryNetMessageData.getData().toByteArray());
        return starryNetMessage;
    }

    public static StarryNetMessageData parse(StarryNetMessage starryNetMessage) {
        if (starryNetMessage.getId() == null) {
            starryNetMessage.setId(IdGenerator.generateIdStr());
        }
        if (starryNetMessage.getData() == null) {
            starryNetMessage.setData(Internal.EMPTY_BYTE_ARRAY);
        }
        return (StarryNetMessageData) StarryNetMessageData.newBuilder().setSenderPkg(starryNetMessage.getSenderPkg()).setReceiverPkg(starryNetMessage.getReceiverPkg()).setMessage(starryNetMessage.getMessage()).setData(ByteString.copyFrom(starryNetMessage.getData())).build();
    }
}
