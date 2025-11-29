package io.netty.handler.codec.redis;

import com.here.posclient.UpdateOptions;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.ReferenceCountUtil;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public final class RedisArrayAggregator extends MessageToMessageDecoder<RedisMessage> {
    private final Deque<AggregateState> depths = new ArrayDeque(4);

    public static final class AggregateState {
        /* access modifiers changed from: private */
        public final List<RedisMessage> children;
        /* access modifiers changed from: private */
        public final int length;

        public AggregateState(int i) {
            this.length = i;
            this.children = new ArrayList(i);
        }
    }

    private RedisMessage decodeRedisArrayHeader(ArrayHeaderRedisMessage arrayHeaderRedisMessage) {
        if (arrayHeaderRedisMessage.isNull()) {
            return ArrayRedisMessage.NULL_INSTANCE;
        }
        if (arrayHeaderRedisMessage.length() == 0) {
            return ArrayRedisMessage.EMPTY_INSTANCE;
        }
        if (arrayHeaderRedisMessage.length() <= 0) {
            throw new CodecException("bad length: " + arrayHeaderRedisMessage.length());
        } else if (arrayHeaderRedisMessage.length() <= UpdateOptions.SOURCE_ANY) {
            this.depths.push(new AggregateState((int) arrayHeaderRedisMessage.length()));
            return null;
        } else {
            throw new CodecException("this codec doesn't support longer length than 2147483647");
        }
    }

    public void decode(ChannelHandlerContext channelHandlerContext, RedisMessage redisMessage, List<Object> list) throws Exception {
        if (redisMessage instanceof ArrayHeaderRedisMessage) {
            redisMessage = decodeRedisArrayHeader((ArrayHeaderRedisMessage) redisMessage);
            if (redisMessage == null) {
                return;
            }
        } else {
            ReferenceCountUtil.retain(redisMessage);
        }
        while (!this.depths.isEmpty()) {
            AggregateState peek = this.depths.peek();
            peek.children.add(redisMessage);
            if (peek.children.size() == peek.length) {
                redisMessage = new ArrayRedisMessage((List<RedisMessage>) peek.children);
                this.depths.pop();
            } else {
                return;
            }
        }
        list.add(redisMessage);
    }
}
