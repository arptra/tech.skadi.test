package com.upuphone.starrynet.core.ble.channel.packet;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SingleNoAckPacket extends Packet {
    int mPackageType;
    byte[] params;

    public SingleNoAckPacket(int i, byte[] bArr) {
        this.params = bArr;
        this.mPackageType = i;
    }

    public byte[] getData() {
        return this.params;
    }

    public String getName() {
        return Packet.SINGLE_CMD_NO_ACK;
    }

    public int getPackageType() {
        return this.mPackageType;
    }

    public byte[] toBytes() {
        ByteBuffer order = ByteBuffer.allocate(this.params.length + 4).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort(0);
        order.put((byte) 9);
        order.put((byte) this.mPackageType);
        order.put(this.params);
        return order.array();
    }
}
