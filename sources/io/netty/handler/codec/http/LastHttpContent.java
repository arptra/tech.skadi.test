package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DecoderResult;

public interface LastHttpContent extends HttpContent {
    public static final LastHttpContent EMPTY_LAST_CONTENT = new LastHttpContent() {
        public ByteBuf content() {
            return Unpooled.EMPTY_BUFFER;
        }

        public DecoderResult decoderResult() {
            return DecoderResult.SUCCESS;
        }

        public LastHttpContent duplicate() {
            return this;
        }

        @Deprecated
        public DecoderResult getDecoderResult() {
            return decoderResult();
        }

        public int refCnt() {
            return 1;
        }

        public boolean release() {
            return false;
        }

        public LastHttpContent retain() {
            return this;
        }

        public LastHttpContent retainedDuplicate() {
            return this;
        }

        public void setDecoderResult(DecoderResult decoderResult) {
            throw new UnsupportedOperationException("read only");
        }

        public String toString() {
            return "EmptyLastHttpContent";
        }

        public LastHttpContent touch() {
            return this;
        }

        public HttpHeaders trailingHeaders() {
            return EmptyHttpHeaders.INSTANCE;
        }

        public boolean release(int i) {
            return false;
        }

        public LastHttpContent retain(int i) {
            return this;
        }

        public LastHttpContent touch(Object obj) {
            return this;
        }

        public LastHttpContent copy() {
            return LastHttpContent.EMPTY_LAST_CONTENT;
        }

        public LastHttpContent replace(ByteBuf byteBuf) {
            return new DefaultLastHttpContent(byteBuf);
        }
    };

    LastHttpContent copy();

    LastHttpContent duplicate();

    LastHttpContent replace(ByteBuf byteBuf);

    LastHttpContent retain();

    LastHttpContent retain(int i);

    LastHttpContent retainedDuplicate();

    LastHttpContent touch();

    LastHttpContent touch(Object obj);

    HttpHeaders trailingHeaders();
}
