package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.StringUtil;

public class FullBulkStringRedisMessage extends DefaultByteBufHolder implements LastBulkStringRedisContent {
    public static final FullBulkStringRedisMessage EMPTY_INSTANCE = new FullBulkStringRedisMessage() {
        public ByteBuf content() {
            return Unpooled.EMPTY_BUFFER;
        }

        public FullBulkStringRedisMessage copy() {
            return this;
        }

        public FullBulkStringRedisMessage duplicate() {
            return this;
        }

        public int refCnt() {
            return 1;
        }

        public boolean release() {
            return false;
        }

        public FullBulkStringRedisMessage retain() {
            return this;
        }

        public FullBulkStringRedisMessage retainedDuplicate() {
            return this;
        }

        public FullBulkStringRedisMessage touch() {
            return this;
        }

        public boolean release(int i) {
            return false;
        }

        public FullBulkStringRedisMessage retain(int i) {
            return this;
        }

        public FullBulkStringRedisMessage touch(Object obj) {
            return this;
        }
    };
    public static final FullBulkStringRedisMessage NULL_INSTANCE = new FullBulkStringRedisMessage() {
        public ByteBuf content() {
            return Unpooled.EMPTY_BUFFER;
        }

        public FullBulkStringRedisMessage copy() {
            return this;
        }

        public FullBulkStringRedisMessage duplicate() {
            return this;
        }

        public boolean isNull() {
            return true;
        }

        public int refCnt() {
            return 1;
        }

        public boolean release() {
            return false;
        }

        public FullBulkStringRedisMessage retain() {
            return this;
        }

        public FullBulkStringRedisMessage retainedDuplicate() {
            return this;
        }

        public FullBulkStringRedisMessage touch() {
            return this;
        }

        public boolean release(int i) {
            return false;
        }

        public FullBulkStringRedisMessage retain(int i) {
            return this;
        }

        public FullBulkStringRedisMessage touch(Object obj) {
            return this;
        }
    };

    public boolean isNull() {
        return false;
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + '[' + "content=" + content() + ']';
    }

    private FullBulkStringRedisMessage() {
        this(Unpooled.EMPTY_BUFFER);
    }

    public FullBulkStringRedisMessage(ByteBuf byteBuf) {
        super(byteBuf);
    }

    public FullBulkStringRedisMessage copy() {
        return (FullBulkStringRedisMessage) super.copy();
    }

    public FullBulkStringRedisMessage duplicate() {
        return (FullBulkStringRedisMessage) super.duplicate();
    }

    public FullBulkStringRedisMessage replace(ByteBuf byteBuf) {
        return new FullBulkStringRedisMessage(byteBuf);
    }

    public FullBulkStringRedisMessage retainedDuplicate() {
        return (FullBulkStringRedisMessage) super.retainedDuplicate();
    }

    public FullBulkStringRedisMessage retain() {
        super.retain();
        return this;
    }

    public FullBulkStringRedisMessage touch() {
        super.touch();
        return this;
    }

    public FullBulkStringRedisMessage retain(int i) {
        super.retain(i);
        return this;
    }

    public FullBulkStringRedisMessage touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
