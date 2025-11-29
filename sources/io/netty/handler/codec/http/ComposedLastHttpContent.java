package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DecoderResult;

final class ComposedLastHttpContent implements LastHttpContent {
    private DecoderResult result;
    private final HttpHeaders trailingHeaders;

    public ComposedLastHttpContent(HttpHeaders httpHeaders) {
        this.trailingHeaders = httpHeaders;
    }

    public ByteBuf content() {
        return Unpooled.EMPTY_BUFFER;
    }

    public DecoderResult decoderResult() {
        return this.result;
    }

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

    public void setDecoderResult(DecoderResult decoderResult) {
        this.result = decoderResult;
    }

    public LastHttpContent touch() {
        return this;
    }

    public HttpHeaders trailingHeaders() {
        return this.trailingHeaders;
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

    public ComposedLastHttpContent(HttpHeaders httpHeaders, DecoderResult decoderResult) {
        this(httpHeaders);
        this.result = decoderResult;
    }

    public LastHttpContent copy() {
        DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER);
        defaultLastHttpContent.trailingHeaders().set(trailingHeaders());
        return defaultLastHttpContent;
    }

    public LastHttpContent duplicate() {
        return copy();
    }

    public LastHttpContent replace(ByteBuf byteBuf) {
        DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent(byteBuf);
        defaultLastHttpContent.trailingHeaders().setAll(trailingHeaders());
        return defaultLastHttpContent;
    }

    public LastHttpContent retainedDuplicate() {
        return copy();
    }
}
