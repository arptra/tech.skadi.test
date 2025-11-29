package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import java.nio.ByteBuffer;

final class CompressionUtil {
    private CompressionUtil() {
    }

    public static void checkChecksum(ByteBufChecksum byteBufChecksum, ByteBuf byteBuf, int i) {
        byteBufChecksum.reset();
        byteBufChecksum.update(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
        int value = (int) byteBufChecksum.getValue();
        if (value != i) {
            throw new DecompressionException(String.format("stream corrupted: mismatching checksum: %d (expected: %d)", new Object[]{Integer.valueOf(value), Integer.valueOf(i)}));
        }
    }

    public static ByteBuffer safeNioBuffer(ByteBuf byteBuf) {
        if (byteBuf.nioBufferCount() == 1) {
            return byteBuf.internalNioBuffer(byteBuf.readerIndex(), byteBuf.readableBytes());
        }
        return byteBuf.nioBuffer();
    }

    public static ByteBuffer safeNioBuffer(ByteBuf byteBuf, int i, int i2) {
        if (byteBuf.nioBufferCount() == 1) {
            return byteBuf.internalNioBuffer(i, i2);
        }
        return byteBuf.nioBuffer(i, i2);
    }
}
