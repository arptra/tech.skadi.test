package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;

final class UDPPacket {
    private static final short UDP_HEADER_SIZE = 8;

    private UDPPacket() {
    }

    public static void writePacket(ByteBuf byteBuf, ByteBuf byteBuf2, int i, int i2) {
        byteBuf.writeShort(i);
        byteBuf.writeShort(i2);
        byteBuf.writeShort(byteBuf2.readableBytes() + 8);
        byteBuf.writeShort(1);
        byteBuf.writeBytes(byteBuf2);
    }
}
