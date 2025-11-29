package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;

public class DefaultFullBinaryMemcacheResponse extends DefaultBinaryMemcacheResponse implements FullBinaryMemcacheResponse {
    private final ByteBuf content;

    public DefaultFullBinaryMemcacheResponse(ByteBuf byteBuf, ByteBuf byteBuf2) {
        this(byteBuf, byteBuf2, Unpooled.buffer(0));
    }

    private FullBinaryMemcacheResponse newInstance(ByteBuf byteBuf, ByteBuf byteBuf2, ByteBuf byteBuf3) {
        DefaultFullBinaryMemcacheResponse defaultFullBinaryMemcacheResponse = new DefaultFullBinaryMemcacheResponse(byteBuf, byteBuf2, byteBuf3);
        copyMeta(defaultFullBinaryMemcacheResponse);
        return defaultFullBinaryMemcacheResponse;
    }

    public ByteBuf content() {
        return this.content;
    }

    public void deallocate() {
        super.deallocate();
        this.content.release();
    }

    public DefaultFullBinaryMemcacheResponse(ByteBuf byteBuf, ByteBuf byteBuf2, ByteBuf byteBuf3) {
        super(byteBuf, byteBuf2);
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf3, "content");
        setTotalBodyLength(keyLength() + extrasLength() + byteBuf3.readableBytes());
    }

    public FullBinaryMemcacheResponse copy() {
        ByteBuf key = key();
        if (key != null) {
            key = key.copy();
        }
        ByteBuf extras = extras();
        if (extras != null) {
            extras = extras.copy();
        }
        return newInstance(key, extras, content().copy());
    }

    public FullBinaryMemcacheResponse duplicate() {
        ByteBuf key = key();
        if (key != null) {
            key = key.duplicate();
        }
        ByteBuf extras = extras();
        if (extras != null) {
            extras = extras.duplicate();
        }
        return newInstance(key, extras, content().duplicate());
    }

    public FullBinaryMemcacheResponse replace(ByteBuf byteBuf) {
        ByteBuf key = key();
        if (key != null) {
            key = key.retainedDuplicate();
        }
        ByteBuf extras = extras();
        if (extras != null) {
            extras = extras.retainedDuplicate();
        }
        return newInstance(key, extras, byteBuf);
    }

    public FullBinaryMemcacheResponse retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    public FullBinaryMemcacheResponse retain() {
        super.retain();
        return this;
    }

    public FullBinaryMemcacheResponse touch() {
        super.touch();
        return this;
    }

    public FullBinaryMemcacheResponse retain(int i) {
        super.retain(i);
        return this;
    }

    public FullBinaryMemcacheResponse touch(Object obj) {
        super.touch(obj);
        this.content.touch(obj);
        return this;
    }
}
