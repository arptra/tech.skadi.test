package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;

public class DefaultLastStompContentSubframe extends DefaultStompContentSubframe implements LastStompContentSubframe {
    public DefaultLastStompContentSubframe(ByteBuf byteBuf) {
        super(byteBuf);
    }

    public String toString() {
        return "DefaultLastStompContent{decoderResult=" + decoderResult() + '}';
    }

    public LastStompContentSubframe copy() {
        return (LastStompContentSubframe) super.copy();
    }

    public LastStompContentSubframe duplicate() {
        return (LastStompContentSubframe) super.duplicate();
    }

    public LastStompContentSubframe replace(ByteBuf byteBuf) {
        return new DefaultLastStompContentSubframe(byteBuf);
    }

    public LastStompContentSubframe retainedDuplicate() {
        return (LastStompContentSubframe) super.retainedDuplicate();
    }

    public LastStompContentSubframe touch() {
        super.touch();
        return this;
    }

    public DefaultLastStompContentSubframe retain() {
        super.retain();
        return this;
    }

    public LastStompContentSubframe touch(Object obj) {
        super.touch(obj);
        return this;
    }

    public LastStompContentSubframe retain(int i) {
        super.retain(i);
        return this;
    }
}
