package com.upuphone.starrynet.core.ble.channel.packet;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class CTRPacket extends Packet {
    protected static final int BUFFER_SIZE = 6;
    public static final int CMD_COMMON_DATA = 0;
    public static final int CMD_COMMON_DATA_CRC32 = 1;
    public static final int CMD_COMMON_STARRY_DATA = 16;
    public static final int CMD_COMMON_STARRY_DATA_INIT = 17;
    protected int frameCount;
    protected int packageType;

    public CTRPacket(int i, int i2) {
        this.frameCount = i;
        this.packageType = i2;
    }

    public int getFrameCount() {
        return this.frameCount;
    }

    public String getName() {
        return Packet.CTR;
    }

    public int getPackageType() {
        return this.packageType;
    }

    public byte[] toBytes() {
        ByteBuffer order = ByteBuffer.wrap(new byte[6]).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort(0);
        order.put((byte) 0);
        order.put((byte) this.packageType);
        order.putShort((short) this.frameCount);
        return order.array();
    }

    public String toString() {
        return "FlowPacket{frameCount=" + this.frameCount + "packageType=" + this.packageType + '}';
    }
}
