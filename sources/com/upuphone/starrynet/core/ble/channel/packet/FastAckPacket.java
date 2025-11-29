package com.upuphone.starrynet.core.ble.channel.packet;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class FastAckPacket extends ACKPacket {
    public FastAckPacket(int i) {
        super(i);
    }

    public String getName() {
        return Packet.FAST_ACK;
    }

    public byte[] toBytes() {
        ByteBuffer order = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort(0);
        order.put((byte) 7);
        order.put((byte) this.status);
        return order.array();
    }

    public String toString() {
        return "FastAckPacket{status=" + this.status;
    }
}
