package io.netty.handler.codec.redis;

public final class ErrorRedisMessage extends AbstractStringRedisMessage {
    public ErrorRedisMessage(String str) {
        super(str);
    }
}
