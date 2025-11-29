package com.upuphone.starrynet.core.ble.channel.packet;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class FastCTRPacket extends CTRPacket {
    public FastCTRPacket(int i, int i2) {
        super(i, i2);
    }

    public String getName() {
        return Packet.FAST_CTR;
    }

    public byte[] toBytes() {
        ByteBuffer order = ByteBuffer.wrap(new byte[6]).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort(0);
        order.put((byte) 6);
        order.put((byte) this.packageType);
        order.putShort((short) this.frameCount);
        return order.array();
    }

    public String toString() {
        return "FastCTRPacket{frameCount=" + this.frameCount + "packageType=" + this.packageType + '}';
    }
}
