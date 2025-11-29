package com.upuphone.starrynet.core.ble.channel.packet;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SingleACKPacket extends Packet {
    private static final int BUFFER_SIZE = 4;
    public static final int RESP_DEVICE_BUSY = 2;
    public static final int RESP_SUCCESS = 0;
    private int mStatus;

    public SingleACKPacket(int i) {
        this.mStatus = i;
    }

    public String getName() {
        return Packet.SINGLE_ACK;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public byte[] toBytes() {
        ByteBuffer order = ByteBuffer.wrap(new byte[4]).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort(0);
        order.put((byte) 3);
        order.put((byte) this.mStatus);
        return order.array();
    }
}
