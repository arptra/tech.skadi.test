package com.upuphone.starrynet.core.ble.channel.packet;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class MixCTRPacket extends CTRPacket {
    private byte[] data;

    public MixCTRPacket(int i, int i2, byte[] bArr) {
        super(i, i2);
        this.data = bArr;
    }

    public byte[] getData() {
        return this.data;
    }

    public String getName() {
        return Packet.MIX_CTR;
    }

    public byte[] toBytes() {
        ByteBuffer order = ByteBuffer.wrap(new byte[(this.data.length + 6)]).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort(0);
        order.put((byte) 8);
        order.put((byte) this.packageType);
        order.putShort((short) this.frameCount);
        order.put(this.data);
        return order.array();
    }

    public String toString() {
        return "MixCTRPacket{frameCount=" + this.frameCount + ",packageType=" + this.packageType + ",data length =" + this.data.length + '}';
    }
}
