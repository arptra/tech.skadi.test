package io.netty.handler.codec.memcache;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class DefaultLastMemcacheContent extends DefaultMemcacheContent implements LastMemcacheContent {
    public DefaultLastMemcacheContent() {
        super(Unpooled.buffer());
    }

    public DefaultLastMemcacheContent(ByteBuf byteBuf) {
        super(byteBuf);
    }

    public LastMemcacheContent copy() {
        return replace(content().copy());
    }

    public LastMemcacheContent duplicate() {
        return replace(content().duplicate());
    }

    public LastMemcacheContent replace(ByteBuf byteBuf) {
        return new DefaultLastMemcacheContent(byteBuf);
    }

    public LastMemcacheContent retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    public LastMemcacheContent retain() {
        super.retain();
        return this;
    }

    public LastMemcacheContent touch() {
        super.touch();
        return this;
    }

    public LastMemcacheContent retain(int i) {
        super.retain(i);
        return this;
    }

    public LastMemcacheContent touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
