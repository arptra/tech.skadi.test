package io.netty.handler.codec.redis;

import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.Collections;
import java.util.List;

public class ArrayRedisMessage extends AbstractReferenceCounted implements RedisMessage {
    public static final ArrayRedisMessage EMPTY_INSTANCE = new ArrayRedisMessage() {
        public boolean release() {
            return false;
        }

        public ArrayRedisMessage retain() {
            return this;
        }

        public String toString() {
            return "EmptyArrayRedisMessage";
        }

        public ArrayRedisMessage touch() {
            return this;
        }

        public boolean release(int i) {
            return false;
        }

        public ArrayRedisMessage retain(int i) {
            return this;
        }

        public ArrayRedisMessage touch(Object obj) {
            return this;
        }
    };
    public static final ArrayRedisMessage NULL_INSTANCE = new ArrayRedisMessage() {
        public boolean isNull() {
            return true;
        }

        public boolean release() {
            return false;
        }

        public ArrayRedisMessage retain() {
            return this;
        }

        public String toString() {
            return "NullArrayRedisMessage";
        }

        public ArrayRedisMessage touch() {
            return this;
        }

        public boolean release(int i) {
            return false;
        }

        public ArrayRedisMessage retain(int i) {
            return this;
        }

        public ArrayRedisMessage touch(Object obj) {
            return this;
        }
    };
    private final List<RedisMessage> children;

    public final List<RedisMessage> children() {
        return this.children;
    }

    public void deallocate() {
        for (RedisMessage release : this.children) {
            ReferenceCountUtil.release(release);
        }
    }

    public boolean isNull() {
        return false;
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + '[' + "children=" + this.children.size() + ']';
    }

    private ArrayRedisMessage() {
        this.children = Collections.emptyList();
    }

    public ArrayRedisMessage touch(Object obj) {
        for (RedisMessage redisMessage : this.children) {
            ReferenceCountUtil.touch(redisMessage);
        }
        return this;
    }

    public ArrayRedisMessage(List<RedisMessage> list) {
        this.children = (List) ObjectUtil.checkNotNull(list, "children");
    }
}
