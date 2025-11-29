package io.netty.handler.codec.memcache;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DecoderResult;

public interface LastMemcacheContent extends MemcacheContent {
    public static final LastMemcacheContent EMPTY_LAST_CONTENT = new LastMemcacheContent() {
        public ByteBuf content() {
            return Unpooled.EMPTY_BUFFER;
        }

        public DecoderResult decoderResult() {
            return DecoderResult.SUCCESS;
        }

        public LastMemcacheContent duplicate() {
            return this;
        }

        public int refCnt() {
            return 1;
        }

        public boolean release() {
            return false;
        }

        public LastMemcacheContent retain() {
            return this;
        }

        public LastMemcacheContent retainedDuplicate() {
            return this;
        }

        public void setDecoderResult(DecoderResult decoderResult) {
            throw new UnsupportedOperationException("read only");
        }

        public LastMemcacheContent touch() {
            return this;
        }

        public boolean release(int i) {
            return false;
        }

        public LastMemcacheContent retain(int i) {
            return this;
        }

        public LastMemcacheContent touch(Object obj) {
            return this;
        }

        public LastMemcacheContent copy() {
            return LastMemcacheContent.EMPTY_LAST_CONTENT;
        }

        public LastMemcacheContent replace(ByteBuf byteBuf) {
            return new DefaultLastMemcacheContent(byteBuf);
        }
    };

    LastMemcacheContent copy();

    LastMemcacheContent duplicate();

    LastMemcacheContent replace(ByteBuf byteBuf);

    LastMemcacheContent retain();

    LastMemcacheContent retain(int i);

    LastMemcacheContent retainedDuplicate();

    LastMemcacheContent touch();

    LastMemcacheContent touch(Object obj);
}
