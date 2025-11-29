package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public final class DefaultHttp2GoAwayFrame extends DefaultByteBufHolder implements Http2GoAwayFrame {
    private final long errorCode;
    private int extraStreamIds;
    private final int lastStreamId;

    public DefaultHttp2GoAwayFrame(Http2Error http2Error) {
        this(http2Error.code());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttp2GoAwayFrame)) {
            return false;
        }
        DefaultHttp2GoAwayFrame defaultHttp2GoAwayFrame = (DefaultHttp2GoAwayFrame) obj;
        return this.errorCode == defaultHttp2GoAwayFrame.errorCode && this.extraStreamIds == defaultHttp2GoAwayFrame.extraStreamIds && super.equals(defaultHttp2GoAwayFrame);
    }

    public long errorCode() {
        return this.errorCode;
    }

    public int extraStreamIds() {
        return this.extraStreamIds;
    }

    public int hashCode() {
        long j = this.errorCode;
        return (((super.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.extraStreamIds;
    }

    public int lastStreamId() {
        return this.lastStreamId;
    }

    public String name() {
        return "GOAWAY";
    }

    public Http2GoAwayFrame setExtraStreamIds(int i) {
        ObjectUtil.checkPositiveOrZero(i, "extraStreamIds");
        this.extraStreamIds = i;
        return this;
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + "(errorCode=" + this.errorCode + ", content=" + content() + ", extraStreamIds=" + this.extraStreamIds + ", lastStreamId=" + this.lastStreamId + ')';
    }

    public DefaultHttp2GoAwayFrame(long j) {
        this(j, Unpooled.EMPTY_BUFFER);
    }

    public Http2GoAwayFrame copy() {
        return new DefaultHttp2GoAwayFrame(this.lastStreamId, this.errorCode, content().copy());
    }

    public Http2GoAwayFrame duplicate() {
        return (Http2GoAwayFrame) super.duplicate();
    }

    public Http2GoAwayFrame replace(ByteBuf byteBuf) {
        return new DefaultHttp2GoAwayFrame(this.errorCode, byteBuf).setExtraStreamIds(this.extraStreamIds);
    }

    public Http2GoAwayFrame retainedDuplicate() {
        return (Http2GoAwayFrame) super.retainedDuplicate();
    }

    public DefaultHttp2GoAwayFrame(Http2Error http2Error, ByteBuf byteBuf) {
        this(http2Error.code(), byteBuf);
    }

    public DefaultHttp2GoAwayFrame(long j, ByteBuf byteBuf) {
        this(-1, j, byteBuf);
    }

    public DefaultHttp2GoAwayFrame(int i, long j, ByteBuf byteBuf) {
        super(byteBuf);
        this.errorCode = j;
        this.lastStreamId = i;
    }

    public Http2GoAwayFrame retain() {
        super.retain();
        return this;
    }

    public Http2GoAwayFrame touch() {
        super.touch();
        return this;
    }

    public Http2GoAwayFrame retain(int i) {
        super.retain(i);
        return this;
    }

    public Http2GoAwayFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
