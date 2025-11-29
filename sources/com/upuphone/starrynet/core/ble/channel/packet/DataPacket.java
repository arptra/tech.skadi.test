package com.upuphone.starrynet.core.ble.channel.packet;

import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.core.ble.channel.packet.Packet;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class DataPacket extends Packet {
    private static final int BUFFER_SIZE = 20;
    private Packet.Bytes bytes;
    private int seq;

    public DataPacket(int i, Packet.Bytes bytes2) {
        this.seq = i;
        this.bytes = bytes2;
    }

    public void fillByteBuffer(ByteBuffer byteBuffer) {
        Packet.Bytes bytes2 = this.bytes;
        byteBuffer.put(bytes2.value, bytes2.start, getDataLength());
    }

    public int getDataLength() {
        return this.bytes.getSize();
    }

    public String getName() {
        return "data";
    }

    public int getSeq() {
        return this.seq;
    }

    public byte[] toBytes() {
        ByteBuffer byteBuffer;
        int dataLength = getDataLength() + 2;
        if (dataLength == 20) {
            byte[] bArr = new byte[20];
            Arrays.fill(bArr, (byte) 0);
            byteBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        } else {
            byteBuffer = ByteBuffer.allocate(dataLength).order(ByteOrder.LITTLE_ENDIAN);
        }
        byteBuffer.putShort((short) this.seq);
        fillByteBuffer(byteBuffer);
        return byteBuffer.array();
    }

    public String toString() {
        return "DataPacket{seq=" + this.seq + ", size=" + this.bytes.getSize() + ", value=0x" + ByteUtils.byteToString(this.bytes.value) + '}';
    }

    public DataPacket(int i, byte[] bArr, int i2, int i3) {
        this(i, new Packet.Bytes(bArr, i2, i3));
    }
}
