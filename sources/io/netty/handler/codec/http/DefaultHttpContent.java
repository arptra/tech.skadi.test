package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultHttpContent extends DefaultHttpObject implements HttpContent {
    private final ByteBuf content;

    public DefaultHttpContent(ByteBuf byteBuf) {
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
    }

    public ByteBuf content() {
        return this.content;
    }

    public int refCnt() {
        return this.content.refCnt();
    }

    public boolean release() {
        return this.content.release();
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + "(data: " + content() + ", decoderResult: " + decoderResult() + ')';
    }

    public HttpContent copy() {
        return replace(this.content.copy());
    }

    public HttpContent duplicate() {
        return replace(this.content.duplicate());
    }

    public boolean release(int i) {
        return this.content.release(i);
    }

    public HttpContent replace(ByteBuf byteBuf) {
        return new DefaultHttpContent(byteBuf);
    }

    public HttpContent retainedDuplicate() {
        return replace(this.content.retainedDuplicate());
    }

    public HttpContent retain() {
        this.content.retain();
        return this;
    }

    public HttpContent touch() {
        this.content.touch();
        return this;
    }

    public HttpContent retain(int i) {
        this.content.retain(i);
        return this;
    }

    public HttpContent touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}
