package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class BinaryMemcacheRequestDecoder extends AbstractBinaryMemcacheDecoder<BinaryMemcacheRequest> {
    public BinaryMemcacheRequestDecoder() {
        this(8192);
    }

    public BinaryMemcacheRequestDecoder(int i) {
        super(i);
    }

    public BinaryMemcacheRequest buildInvalidMessage() {
        ByteBuf byteBuf = Unpooled.EMPTY_BUFFER;
        return new DefaultBinaryMemcacheRequest(byteBuf, byteBuf);
    }

    public BinaryMemcacheRequest decodeHeader(ByteBuf byteBuf) {
        DefaultBinaryMemcacheRequest defaultBinaryMemcacheRequest = new DefaultBinaryMemcacheRequest();
        defaultBinaryMemcacheRequest.setMagic(byteBuf.readByte());
        defaultBinaryMemcacheRequest.setOpcode(byteBuf.readByte());
        defaultBinaryMemcacheRequest.setKeyLength(byteBuf.readShort());
        defaultBinaryMemcacheRequest.setExtrasLength(byteBuf.readByte());
        defaultBinaryMemcacheRequest.setDataType(byteBuf.readByte());
        defaultBinaryMemcacheRequest.setReserved(byteBuf.readShort());
        defaultBinaryMemcacheRequest.setTotalBodyLength(byteBuf.readInt());
        defaultBinaryMemcacheRequest.setOpaque(byteBuf.readInt());
        defaultBinaryMemcacheRequest.setCas(byteBuf.readLong());
        return defaultBinaryMemcacheRequest;
    }
}
