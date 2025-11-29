package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class BinaryMemcacheResponseDecoder extends AbstractBinaryMemcacheDecoder<BinaryMemcacheResponse> {
    public BinaryMemcacheResponseDecoder() {
        this(8192);
    }

    public BinaryMemcacheResponseDecoder(int i) {
        super(i);
    }

    public BinaryMemcacheResponse buildInvalidMessage() {
        ByteBuf byteBuf = Unpooled.EMPTY_BUFFER;
        return new DefaultBinaryMemcacheResponse(byteBuf, byteBuf);
    }

    public BinaryMemcacheResponse decodeHeader(ByteBuf byteBuf) {
        DefaultBinaryMemcacheResponse defaultBinaryMemcacheResponse = new DefaultBinaryMemcacheResponse();
        defaultBinaryMemcacheResponse.setMagic(byteBuf.readByte());
        defaultBinaryMemcacheResponse.setOpcode(byteBuf.readByte());
        defaultBinaryMemcacheResponse.setKeyLength(byteBuf.readShort());
        defaultBinaryMemcacheResponse.setExtrasLength(byteBuf.readByte());
        defaultBinaryMemcacheResponse.setDataType(byteBuf.readByte());
        defaultBinaryMemcacheResponse.setStatus(byteBuf.readShort());
        defaultBinaryMemcacheResponse.setTotalBodyLength(byteBuf.readInt());
        defaultBinaryMemcacheResponse.setOpaque(byteBuf.readInt());
        defaultBinaryMemcacheResponse.setCas(byteBuf.readLong());
        return defaultBinaryMemcacheResponse;
    }
}
