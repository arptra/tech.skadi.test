package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;
import java.util.Set;

public class SpdyFrameEncoder {
    private final int version;

    public SpdyFrameEncoder(SpdyVersion spdyVersion) {
        this.version = ((SpdyVersion) ObjectUtil.checkNotNull(spdyVersion, "spdyVersion")).getVersion();
    }

    private void writeControlFrameHeader(ByteBuf byteBuf, int i, byte b, int i2) {
        byteBuf.writeShort(this.version | 32768);
        byteBuf.writeShort(i);
        byteBuf.writeByte(b);
        byteBuf.writeMedium(i2);
    }

    public ByteBuf encodeDataFrame(ByteBufAllocator byteBufAllocator, int i, boolean z, ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        ByteBuf order = byteBufAllocator.ioBuffer(readableBytes + 8).order(ByteOrder.BIG_ENDIAN);
        order.writeInt(i & Integer.MAX_VALUE);
        order.writeByte(z ? 1 : 0);
        order.writeMedium(readableBytes);
        order.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
        return order;
    }

    public ByteBuf encodeGoAwayFrame(ByteBufAllocator byteBufAllocator, int i, int i2) {
        ByteBuf order = byteBufAllocator.ioBuffer(16).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 7, (byte) 0, 8);
        order.writeInt(i);
        order.writeInt(i2);
        return order;
    }

    public ByteBuf encodeHeadersFrame(ByteBufAllocator byteBufAllocator, int i, boolean z, ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        ByteBuf order = byteBufAllocator.ioBuffer(readableBytes + 12).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 8, z ? (byte) 1 : 0, readableBytes + 4);
        order.writeInt(i);
        order.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
        return order;
    }

    public ByteBuf encodePingFrame(ByteBufAllocator byteBufAllocator, int i) {
        ByteBuf order = byteBufAllocator.ioBuffer(12).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 6, (byte) 0, 4);
        order.writeInt(i);
        return order;
    }

    public ByteBuf encodeRstStreamFrame(ByteBufAllocator byteBufAllocator, int i, int i2) {
        ByteBuf order = byteBufAllocator.ioBuffer(16).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 3, (byte) 0, 8);
        order.writeInt(i);
        order.writeInt(i2);
        return order;
    }

    public ByteBuf encodeSettingsFrame(ByteBufAllocator byteBufAllocator, SpdySettingsFrame spdySettingsFrame) {
        Set<Integer> ids = spdySettingsFrame.ids();
        int size = ids.size();
        boolean clearPreviouslyPersistedSettings = spdySettingsFrame.clearPreviouslyPersistedSettings();
        int i = size * 8;
        ByteBuf order = byteBufAllocator.ioBuffer(i + 12).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 4, clearPreviouslyPersistedSettings ? (byte) 1 : 0, i + 4);
        order.writeInt(size);
        for (Integer next : ids) {
            byte b = spdySettingsFrame.isPersistValue(next.intValue()) ? (byte) 1 : 0;
            if (spdySettingsFrame.isPersisted(next.intValue())) {
                b = (byte) (b | 2);
            }
            order.writeByte(b);
            order.writeMedium(next.intValue());
            order.writeInt(spdySettingsFrame.getValue(next.intValue()));
        }
        return order;
    }

    public ByteBuf encodeSynReplyFrame(ByteBufAllocator byteBufAllocator, int i, boolean z, ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        ByteBuf order = byteBufAllocator.ioBuffer(readableBytes + 12).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 2, z ? (byte) 1 : 0, readableBytes + 4);
        order.writeInt(i);
        order.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
        return order;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.netty.buffer.ByteBuf encodeSynStreamFrame(io.netty.buffer.ByteBufAllocator r3, int r4, int r5, byte r6, boolean r7, boolean r8, io.netty.buffer.ByteBuf r9) {
        /*
            r2 = this;
            int r0 = r9.readableBytes()
            if (r8 == 0) goto L_0x0009
            r7 = r7 | 2
            byte r7 = (byte) r7
        L_0x0009:
            int r8 = r0 + 10
            int r1 = r0 + 18
            io.netty.buffer.ByteBuf r3 = r3.ioBuffer(r1)
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            io.netty.buffer.ByteBuf r3 = r3.order(r1)
            r1 = 1
            r2.writeControlFrameHeader(r3, r1, r7, r8)
            r3.writeInt(r4)
            r3.writeInt(r5)
            r2 = r6 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 13
            r3.writeShort(r2)
            int r2 = r9.readerIndex()
            r3.writeBytes((io.netty.buffer.ByteBuf) r9, (int) r2, (int) r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.spdy.SpdyFrameEncoder.encodeSynStreamFrame(io.netty.buffer.ByteBufAllocator, int, int, byte, boolean, boolean, io.netty.buffer.ByteBuf):io.netty.buffer.ByteBuf");
    }

    public ByteBuf encodeWindowUpdateFrame(ByteBufAllocator byteBufAllocator, int i, int i2) {
        ByteBuf order = byteBufAllocator.ioBuffer(16).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 9, (byte) 0, 8);
        order.writeInt(i);
        order.writeInt(i2);
        return order;
    }
}
