package com.upuphone.starrynet.core.ble.channel.packet;

import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public abstract class Packet {
    public static final String ACK = "ack";
    public static final String CTR = "ctr";
    public static final String DATA = "data";
    public static final String FAST_ACK = "fast_ack";
    public static final String FAST_CTR = "fast_ctr";
    public static final String MIX_CTR = "mix_ctr";
    public static final String MNG_ACK = "mng_ack";
    public static final String MNG_CMD = "mng";
    public static final String SINGLE_ACK = "single_ack";
    public static final String SINGLE_CMD = "single_ctr";
    public static final String SINGLE_CMD_NO_ACK = "single_no_ack_ctr";
    static final int SN_CTR = 0;
    public static final int TYPE_ACK = 1;
    public static final int TYPE_CMD = 0;
    public static final int TYPE_FAST_ACK = 7;
    public static final int TYPE_FAST_CTR = 6;
    public static final int TYPE_MIX_CTR = 8;
    public static final int TYPE_MNG = 4;
    public static final int TYPE_MNG_ACK = 5;
    public static final int TYPE_SINGLE_ACK = 3;
    public static final int TYPE_SINGLE_CMD = 2;
    public static final int TYPE_SINGLE_CMD_NO_ACK = 9;

    public static class Bytes {
        int end;
        int start;
        byte[] value;

        public Bytes(byte[] bArr, int i) {
            this(bArr, i, bArr.length);
        }

        public int getSize() {
            return this.end - this.start;
        }

        public Bytes(byte[] bArr, int i, int i2) {
            this.value = bArr;
            this.start = i;
            this.end = i2;
        }
    }

    public static class Header {
        int command;
        List<Short> parameters;
        int sn;
        int type;
        byte[] value;

        private Header() {
            this.parameters = new ArrayList();
        }
    }

    private static Packet getDataPacket(Header header) {
        return new DataPacket(header.sn, new Bytes(header.value, 2));
    }

    private static Packet getFlowPacket(Header header) {
        List<Short> list = header.parameters;
        switch (header.type) {
            case 0:
                return new CTRPacket(list.get(0).shortValue(), header.command);
            case 1:
                return new ACKPacket(header.command, list);
            case 2:
                return new SinglePacket(header.command, ByteUtils.get(header.value, 4));
            case 3:
                return new SingleACKPacket(header.command);
            case 6:
                return new FastCTRPacket(list.get(0).shortValue(), header.command);
            case 7:
                return new FastAckPacket(header.command);
            case 8:
                return new MixCTRPacket(list.get(0).shortValue(), header.command, header.value);
            case 9:
                return new SingleNoAckPacket(header.command, ByteUtils.get(header.value, 4));
            default:
                return new InvalidPacket();
        }
    }

    public static Packet getPacket(byte[] bArr) {
        Header header;
        try {
            header = parse(bArr);
        } catch (BufferUnderflowException e) {
            StLog.e("Packet", "getPacket BufferUnderflowException", (Throwable) e);
            header = null;
        }
        return header != null ? header.sn == 0 ? getFlowPacket(header) : getDataPacket(header) : new InvalidPacket();
    }

    private static Header parse(byte[] bArr) throws BufferUnderflowException {
        Header header = new Header();
        int length = bArr.length;
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        short s = order.getShort();
        header.sn = s;
        header.value = bArr;
        if (s == 0) {
            header.type = order.get();
            header.command = order.get();
            if (header.type == 8) {
                header.parameters.add(Short.valueOf(order.getShort()));
                byte[] bArr2 = new byte[(length - 6)];
                order.get(bArr2);
                header.value = bArr2;
            } else {
                while (order.hasRemaining()) {
                    try {
                        header.parameters.add(Short.valueOf(order.getShort()));
                    } catch (BufferUnderflowException unused) {
                    }
                }
            }
        }
        return header;
    }

    public abstract String getName();

    public abstract byte[] toBytes();
}
