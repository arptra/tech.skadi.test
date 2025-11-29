package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;

public class BinaryMemcacheRequestEncoder extends AbstractBinaryMemcacheEncoder<BinaryMemcacheRequest> {
    public void encodeHeader(ByteBuf byteBuf, BinaryMemcacheRequest binaryMemcacheRequest) {
        byteBuf.writeByte(binaryMemcacheRequest.magic());
        byteBuf.writeByte(binaryMemcacheRequest.opcode());
        byteBuf.writeShort(binaryMemcacheRequest.keyLength());
        byteBuf.writeByte(binaryMemcacheRequest.extrasLength());
        byteBuf.writeByte(binaryMemcacheRequest.dataType());
        byteBuf.writeShort(binaryMemcacheRequest.reserved());
        byteBuf.writeInt(binaryMemcacheRequest.totalBodyLength());
        byteBuf.writeInt(binaryMemcacheRequest.opaque());
        byteBuf.writeLong(binaryMemcacheRequest.cas());
    }
}
