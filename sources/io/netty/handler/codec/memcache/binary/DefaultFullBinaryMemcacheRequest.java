package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;

public class DefaultFullBinaryMemcacheRequest extends DefaultBinaryMemcacheRequest implements FullBinaryMemcacheRequest {
    private final ByteBuf content;

    public DefaultFullBinaryMemcacheRequest(ByteBuf byteBuf, ByteBuf byteBuf2) {
        this(byteBuf, byteBuf2, Unpooled.buffer(0));
    }

    private DefaultFullBinaryMemcacheRequest newInstance(ByteBuf byteBuf, ByteBuf byteBuf2, ByteBuf byteBuf3) {
        DefaultFullBinaryMemcacheRequest defaultFullBinaryMemcacheRequest = new DefaultFullBinaryMemcacheRequest(byteBuf, byteBuf2, byteBuf3);
        copyMeta(defaultFullBinaryMemcacheRequest);
        return defaultFullBinaryMemcacheRequest;
    }

    public ByteBuf content() {
        return this.content;
    }

    public void deallocate() {
        super.deallocate();
        this.content.release();
    }

    public DefaultFullBinaryMemcacheRequest(ByteBuf byteBuf, ByteBuf byteBuf2, ByteBuf byteBuf3) {
        super(byteBuf, byteBuf2);
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf3, "content");
        setTotalBodyLength(keyLength() + extrasLength() + byteBuf3.readableBytes());
    }

    public FullBinaryMemcacheRequest copy() {
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

    public FullBinaryMemcacheRequest duplicate() {
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

    public FullBinaryMemcacheRequest replace(ByteBuf byteBuf) {
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

    public FullBinaryMemcacheRequest retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    public FullBinaryMemcacheRequest retain() {
        super.retain();
        return this;
    }

    public FullBinaryMemcacheRequest touch() {
        super.touch();
        return this;
    }

    public FullBinaryMemcacheRequest retain(int i) {
        super.retain(i);
        return this;
    }

    public FullBinaryMemcacheRequest touch(Object obj) {
        super.touch(obj);
        this.content.touch(obj);
        return this;
    }
}
