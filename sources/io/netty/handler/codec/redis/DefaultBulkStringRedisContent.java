package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.util.internal.StringUtil;

public class DefaultBulkStringRedisContent extends DefaultByteBufHolder implements BulkStringRedisContent {
    public DefaultBulkStringRedisContent(ByteBuf byteBuf) {
        super(byteBuf);
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + '[' + "content=" + content() + ']';
    }

    public BulkStringRedisContent copy() {
        return (BulkStringRedisContent) super.copy();
    }

    public BulkStringRedisContent duplicate() {
        return (BulkStringRedisContent) super.duplicate();
    }

    public BulkStringRedisContent replace(ByteBuf byteBuf) {
        return new DefaultBulkStringRedisContent(byteBuf);
    }

    public BulkStringRedisContent retainedDuplicate() {
        return (BulkStringRedisContent) super.retainedDuplicate();
    }

    public BulkStringRedisContent retain() {
        super.retain();
        return this;
    }

    public BulkStringRedisContent touch() {
        super.touch();
        return this;
    }

    public BulkStringRedisContent retain(int i) {
        super.retain(i);
        return this;
    }

    public BulkStringRedisContent touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
