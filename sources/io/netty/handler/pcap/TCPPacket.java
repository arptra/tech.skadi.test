package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;

final class TCPPacket {
    private static final short OFFSET = 20480;

    public enum TCPFlag {
        FIN(1),
        SYN(2),
        RST(4),
        PSH(8),
        ACK(16),
        URG(32),
        ECE(64),
        CWR(128);
        
        private final int value;

        private TCPFlag(int i) {
            this.value = i;
        }

        public static int getFlag(TCPFlag... tCPFlagArr) {
            int i = 0;
            for (TCPFlag tCPFlag : tCPFlagArr) {
                i |= tCPFlag.value;
            }
            return i;
        }
    }

    private TCPPacket() {
    }

    public static void writePacket(ByteBuf byteBuf, ByteBuf byteBuf2, int i, int i2, int i3, int i4, TCPFlag... tCPFlagArr) {
        byteBuf.writeShort(i3);
        byteBuf.writeShort(i4);
        byteBuf.writeInt(i);
        byteBuf.writeInt(i2);
        byteBuf.writeShort(TCPFlag.getFlag(tCPFlagArr) | 20480);
        byteBuf.writeShort(65535);
        byteBuf.writeShort(1);
        byteBuf.writeShort(0);
        if (byteBuf2 != null) {
            byteBuf.writeBytes(byteBuf2);
        }
    }
}
