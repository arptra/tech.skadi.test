package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;

final class PcapHeaders {
    private static final byte[] GLOBAL_HEADER = {-95, -78, -61, -44, 0, 2, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, 0, 1};

    private PcapHeaders() {
    }

    public static void writeGlobalHeader(ByteBuf byteBuf) {
        byteBuf.writeBytes(GLOBAL_HEADER);
    }

    public static void writePacketHeader(ByteBuf byteBuf, int i, int i2, int i3, int i4) {
        byteBuf.writeInt(i);
        byteBuf.writeInt(i2);
        byteBuf.writeInt(i3);
        byteBuf.writeInt(i4);
    }
}
