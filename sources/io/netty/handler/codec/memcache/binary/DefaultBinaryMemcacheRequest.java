package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;

public class DefaultBinaryMemcacheRequest extends AbstractBinaryMemcacheMessage implements BinaryMemcacheRequest {
    public static final byte REQUEST_MAGIC_BYTE = Byte.MIN_VALUE;
    private short reserved;

    public DefaultBinaryMemcacheRequest() {
        this((ByteBuf) null, (ByteBuf) null);
    }

    public void copyMeta(DefaultBinaryMemcacheRequest defaultBinaryMemcacheRequest) {
        super.copyMeta(defaultBinaryMemcacheRequest);
        defaultBinaryMemcacheRequest.reserved = this.reserved;
    }

    public short reserved() {
        return this.reserved;
    }

    public BinaryMemcacheRequest setReserved(short s) {
        this.reserved = s;
        return this;
    }

    public DefaultBinaryMemcacheRequest(ByteBuf byteBuf) {
        this(byteBuf, (ByteBuf) null);
    }

    public DefaultBinaryMemcacheRequest(ByteBuf byteBuf, ByteBuf byteBuf2) {
        super(byteBuf, byteBuf2);
        setMagic(Byte.MIN_VALUE);
    }

    public BinaryMemcacheRequest retain() {
        super.retain();
        return this;
    }

    public BinaryMemcacheRequest touch() {
        super.touch();
        return this;
    }

    public BinaryMemcacheRequest retain(int i) {
        super.retain(i);
        return this;
    }

    public BinaryMemcacheRequest touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
