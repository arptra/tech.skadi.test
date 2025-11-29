package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.handler.codec.DecoderResult;

public class DefaultStompContentSubframe extends DefaultByteBufHolder implements StompContentSubframe {
    private DecoderResult decoderResult = DecoderResult.SUCCESS;

    public DefaultStompContentSubframe(ByteBuf byteBuf) {
        super(byteBuf);
    }

    public DecoderResult decoderResult() {
        return this.decoderResult;
    }

    public void setDecoderResult(DecoderResult decoderResult2) {
        this.decoderResult = decoderResult2;
    }

    public String toString() {
        return "DefaultStompContent{decoderResult=" + this.decoderResult + '}';
    }

    public StompContentSubframe copy() {
        return (StompContentSubframe) super.copy();
    }

    public StompContentSubframe duplicate() {
        return (StompContentSubframe) super.duplicate();
    }

    public StompContentSubframe replace(ByteBuf byteBuf) {
        return new DefaultStompContentSubframe(byteBuf);
    }

    public StompContentSubframe retainedDuplicate() {
        return (StompContentSubframe) super.retainedDuplicate();
    }

    public StompContentSubframe retain() {
        super.retain();
        return this;
    }

    public StompContentSubframe touch() {
        super.touch();
        return this;
    }

    public StompContentSubframe retain(int i) {
        super.retain(i);
        return this;
    }

    public StompContentSubframe touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
