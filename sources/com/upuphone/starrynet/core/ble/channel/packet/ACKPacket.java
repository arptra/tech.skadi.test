package com.upuphone.starrynet.core.ble.channel.packet;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collections;
import java.util.List;

public class ACKPacket extends Packet {
    public static final int BUSY = 2;
    public static final int CANCEL = 4;
    public static final int READY = 1;
    public static final int SUCCESS = 0;
    public static final int SYNC = 5;
    public static final int TIMEOUT = 3;
    private List<Short> lostSeqs = Collections.emptyList();
    protected int status;

    public ACKPacket(int i) {
        this.status = i;
    }

    public String getName() {
        return Packet.ACK;
    }

    public List<Short> getSeq() {
        return this.lostSeqs;
    }

    public int getStatus() {
        return this.status;
    }

    public byte[] toBytes() {
        ByteBuffer order = ByteBuffer.allocate((this.lostSeqs.size() * 2) + 4).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort(0);
        order.put((byte) 1);
        order.put((byte) this.status);
        if (!this.lostSeqs.isEmpty()) {
            for (Short shortValue : this.lostSeqs) {
                order.putShort(shortValue.shortValue());
            }
        }
        return order.array();
    }

    public String toString() {
        return "ACKPacket{status=" + this.status + ", seq=" + this.lostSeqs.toString() + '}';
    }

    public ACKPacket(int i, List<Short> list) {
        this.status = i;
        if (list != null && !list.isEmpty()) {
            this.lostSeqs = list;
        }
    }
}
