package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.memcache.AbstractMemcacheObjectEncoder;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage;

public abstract class AbstractBinaryMemcacheEncoder<M extends BinaryMemcacheMessage> extends AbstractMemcacheObjectEncoder<M> {
    private static final int MINIMUM_HEADER_SIZE = 24;

    private static void encodeExtras(ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (byteBuf2 != null && byteBuf2.isReadable()) {
            byteBuf.writeBytes(byteBuf2);
        }
    }

    private static void encodeKey(ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (byteBuf2 != null && byteBuf2.isReadable()) {
            byteBuf.writeBytes(byteBuf2);
        }
    }

    public abstract void encodeHeader(ByteBuf byteBuf, M m);

    public ByteBuf encodeMessage(ChannelHandlerContext channelHandlerContext, M m) {
        ByteBuf buffer = channelHandlerContext.alloc().buffer(m.extrasLength() + 24 + m.keyLength());
        encodeHeader(buffer, m);
        encodeExtras(buffer, m.extras());
        encodeKey(buffer, m.key());
        return buffer;
    }
}
