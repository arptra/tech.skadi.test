package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;

public final class DefaultLastBulkStringRedisContent extends DefaultBulkStringRedisContent implements LastBulkStringRedisContent {
    public DefaultLastBulkStringRedisContent(ByteBuf byteBuf) {
        super(byteBuf);
    }

    public LastBulkStringRedisContent copy() {
        return (LastBulkStringRedisContent) super.copy();
    }

    public LastBulkStringRedisContent duplicate() {
        return (LastBulkStringRedisContent) super.duplicate();
    }

    public LastBulkStringRedisContent replace(ByteBuf byteBuf) {
        return new DefaultLastBulkStringRedisContent(byteBuf);
    }

    public LastBulkStringRedisContent retainedDuplicate() {
        return (LastBulkStringRedisContent) super.retainedDuplicate();
    }

    public LastBulkStringRedisContent retain() {
        super.retain();
        return this;
    }

    public LastBulkStringRedisContent touch() {
        super.touch();
        return this;
    }

    public LastBulkStringRedisContent retain(int i) {
        super.retain(i);
        return this;
    }

    public LastBulkStringRedisContent touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
