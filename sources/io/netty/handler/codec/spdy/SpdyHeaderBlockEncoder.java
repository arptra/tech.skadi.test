package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.PlatformDependent;

public abstract class SpdyHeaderBlockEncoder {
    public static SpdyHeaderBlockEncoder newInstance(SpdyVersion spdyVersion, int i, int i2, int i3) {
        return PlatformDependent.javaVersion() >= 7 ? new SpdyHeaderBlockZlibEncoder(spdyVersion, i) : new SpdyHeaderBlockJZlibEncoder(spdyVersion, i, i2, i3);
    }

    public abstract ByteBuf encode(ByteBufAllocator byteBufAllocator, SpdyHeadersFrame spdyHeadersFrame) throws Exception;

    public abstract void end();
}
