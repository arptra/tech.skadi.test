package com.upuphone.starrynet.strategy.channel.spp.coder;

import com.upuphone.starrynet.api.bean.StMessage;
import com.upuphone.starrynet.strategy.message.StarryMessage;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SppMessageCoder {
    public static final byte CATEGORY_EXTERNAL_MESSAGE = 0;
    public static final byte CATEGORY_INTERNAL_MESSAGE = 1;
    public static final int MESSAGE_HEADER_LENGTH = 2;
    public static final byte MSG_TYPE_NORMAL = 1;
    public static final byte MSG_TYPE_TLV = 2;
    public static final byte MSG_TYPE_URGENT = 4;
    public static final String TAG = "SppMessageCoder";

    public static StMessage decode(byte[] bArr, String str) {
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        if (order.get() == 1) {
            return null;
        }
        byte b = order.get();
        byte[] bArr2 = new byte[(bArr.length - 2)];
        order.get(bArr2);
        StMessage buildReceiveStMessage = (b & 2) != 0 ? StMessage.buildReceiveStMessage(str, bArr2, false, 2) : StMessage.buildReceiveStMessage(str, bArr2, false, 3);
        buildReceiveStMessage.setTargetChannel(32);
        return buildReceiveStMessage;
    }

    public static byte[] encode(StarryMessage starryMessage) {
        ByteBuffer order = ByteBuffer.allocate(starryMessage.getContent().length + 2).order(ByteOrder.LITTLE_ENDIAN);
        order.put(starryMessage.isInternalMessage() ? (byte) 1 : 0);
        order.put(starryMessage.getSppMsgType());
        order.put(starryMessage.getContent());
        return order.array();
    }
}
