package io.netty.handler.codec.redis;

public final class InlineCommandRedisMessage extends AbstractStringRedisMessage {
    public InlineCommandRedisMessage(String str) {
        super(str);
    }
}
