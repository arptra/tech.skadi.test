package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DecoderResult;

public interface LastStompContentSubframe extends StompContentSubframe {
    public static final LastStompContentSubframe EMPTY_LAST_CONTENT = new LastStompContentSubframe() {
        public ByteBuf content() {
            return Unpooled.EMPTY_BUFFER;
        }

        public DecoderResult decoderResult() {
            return DecoderResult.SUCCESS;
        }

        public LastStompContentSubframe duplicate() {
            return this;
        }

        public int refCnt() {
            return 1;
        }

        public boolean release() {
            return false;
        }

        public LastStompContentSubframe retain() {
            return this;
        }

        public LastStompContentSubframe retainedDuplicate() {
            return this;
        }

        public void setDecoderResult(DecoderResult decoderResult) {
            throw new UnsupportedOperationException("read only");
        }

        public LastStompContentSubframe touch() {
            return this;
        }

        public boolean release(int i) {
            return false;
        }

        public LastStompContentSubframe retain(int i) {
            return this;
        }

        public LastStompContentSubframe touch(Object obj) {
            return this;
        }

        public LastStompContentSubframe copy() {
            return LastStompContentSubframe.EMPTY_LAST_CONTENT;
        }

        public LastStompContentSubframe replace(ByteBuf byteBuf) {
            return new DefaultLastStompContentSubframe(byteBuf);
        }
    };

    LastStompContentSubframe copy();

    LastStompContentSubframe duplicate();

    LastStompContentSubframe replace(ByteBuf byteBuf);

    LastStompContentSubframe retain();

    LastStompContentSubframe retain(int i);

    LastStompContentSubframe retainedDuplicate();

    LastStompContentSubframe touch();

    LastStompContentSubframe touch(Object obj);
}
