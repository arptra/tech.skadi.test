package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;

public class DefaultBinaryMemcacheResponse extends AbstractBinaryMemcacheMessage implements BinaryMemcacheResponse {
    public static final byte RESPONSE_MAGIC_BYTE = -127;
    private short status;

    public DefaultBinaryMemcacheResponse() {
        this((ByteBuf) null, (ByteBuf) null);
    }

    public void copyMeta(DefaultBinaryMemcacheResponse defaultBinaryMemcacheResponse) {
        super.copyMeta(defaultBinaryMemcacheResponse);
        defaultBinaryMemcacheResponse.status = this.status;
    }

    public BinaryMemcacheResponse setStatus(short s) {
        this.status = s;
        return this;
    }

    public short status() {
        return this.status;
    }

    public DefaultBinaryMemcacheResponse(ByteBuf byteBuf) {
        this(byteBuf, (ByteBuf) null);
    }

    public DefaultBinaryMemcacheResponse(ByteBuf byteBuf, ByteBuf byteBuf2) {
        super(byteBuf, byteBuf2);
        setMagic(RESPONSE_MAGIC_BYTE);
    }

    public BinaryMemcacheResponse retain() {
        super.retain();
        return this;
    }

    public BinaryMemcacheResponse touch() {
        super.touch();
        return this;
    }

    public BinaryMemcacheResponse retain(int i) {
        super.retain(i);
        return this;
    }

    public BinaryMemcacheResponse touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
