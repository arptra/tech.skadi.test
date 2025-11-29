package io.netty.handler.codec.redis;

import io.netty.util.internal.StringUtil;

public final class IntegerRedisMessage implements RedisMessage {
    private final long value;

    public IntegerRedisMessage(long j) {
        this.value = j;
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + '[' + "value=" + this.value + ']';
    }

    public long value() {
        return this.value;
    }
}
