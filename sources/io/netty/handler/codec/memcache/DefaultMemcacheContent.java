package io.netty.handler.codec.memcache;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultMemcacheContent extends AbstractMemcacheObject implements MemcacheContent {
    private final ByteBuf content;

    public DefaultMemcacheContent(ByteBuf byteBuf) {
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
    }

    public ByteBuf content() {
        return this.content;
    }

    public void deallocate() {
        this.content.release();
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + "(data: " + content() + ", decoderResult: " + decoderResult() + ')';
    }

    public MemcacheContent copy() {
        return replace(this.content.copy());
    }

    public MemcacheContent duplicate() {
        return replace(this.content.duplicate());
    }

    public MemcacheContent replace(ByteBuf byteBuf) {
        return new DefaultMemcacheContent(byteBuf);
    }

    public MemcacheContent retainedDuplicate() {
        return replace(this.content.retainedDuplicate());
    }

    public MemcacheContent retain() {
        super.retain();
        return this;
    }

    public MemcacheContent touch() {
        super.touch();
        return this;
    }

    public MemcacheContent retain(int i) {
        super.retain(i);
        return this;
    }

    public MemcacheContent touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}
