package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;

public class BinaryMemcacheResponseEncoder extends AbstractBinaryMemcacheEncoder<BinaryMemcacheResponse> {
    public void encodeHeader(ByteBuf byteBuf, BinaryMemcacheResponse binaryMemcacheResponse) {
        byteBuf.writeByte(binaryMemcacheResponse.magic());
        byteBuf.writeByte(binaryMemcacheResponse.opcode());
        byteBuf.writeShort(binaryMemcacheResponse.keyLength());
        byteBuf.writeByte(binaryMemcacheResponse.extrasLength());
        byteBuf.writeByte(binaryMemcacheResponse.dataType());
        byteBuf.writeShort(binaryMemcacheResponse.status());
        byteBuf.writeInt(binaryMemcacheResponse.totalBodyLength());
        byteBuf.writeInt(binaryMemcacheResponse.opaque());
        byteBuf.writeLong(binaryMemcacheResponse.cas());
    }
}
