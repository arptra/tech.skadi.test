package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.StringUtil;

public final class DefaultHttp2UnknownFrame extends DefaultByteBufHolder implements Http2UnknownFrame {
    private final Http2Flags flags;
    private final byte frameType;
    private Http2FrameStream stream;

    public DefaultHttp2UnknownFrame(byte b, Http2Flags http2Flags) {
        this(b, http2Flags, Unpooled.EMPTY_BUFFER);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttp2UnknownFrame)) {
            return false;
        }
        DefaultHttp2UnknownFrame defaultHttp2UnknownFrame = (DefaultHttp2UnknownFrame) obj;
        Http2FrameStream stream2 = defaultHttp2UnknownFrame.stream();
        Http2FrameStream http2FrameStream = this.stream;
        return (http2FrameStream == stream2 || (stream2 != null && stream2.equals(http2FrameStream))) && this.flags.equals(defaultHttp2UnknownFrame.flags()) && this.frameType == defaultHttp2UnknownFrame.frameType() && super.equals(defaultHttp2UnknownFrame);
    }

    public Http2Flags flags() {
        return this.flags;
    }

    public byte frameType() {
        return this.frameType;
    }

    public int hashCode() {
        int hashCode = (((super.hashCode() * 31) + this.frameType) * 31) + this.flags.hashCode();
        Http2FrameStream http2FrameStream = this.stream;
        return http2FrameStream != null ? (hashCode * 31) + http2FrameStream.hashCode() : hashCode;
    }

    public String name() {
        return "UNKNOWN";
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + "(frameType=" + this.frameType + ", stream=" + this.stream + ", flags=" + this.flags + ", content=" + contentToString() + ')';
    }

    public DefaultHttp2UnknownFrame(byte b, Http2Flags http2Flags, ByteBuf byteBuf) {
        super(byteBuf);
        this.frameType = b;
        this.flags = http2Flags;
    }

    public DefaultHttp2UnknownFrame copy() {
        return replace(content().copy());
    }

    public DefaultHttp2UnknownFrame duplicate() {
        return replace(content().duplicate());
    }

    public DefaultHttp2UnknownFrame replace(ByteBuf byteBuf) {
        return new DefaultHttp2UnknownFrame(this.frameType, this.flags, byteBuf).stream(this.stream);
    }

    public DefaultHttp2UnknownFrame retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    public Http2FrameStream stream() {
        return this.stream;
    }

    public DefaultHttp2UnknownFrame stream(Http2FrameStream http2FrameStream) {
        this.stream = http2FrameStream;
        return this;
    }

    public DefaultHttp2UnknownFrame retain() {
        super.retain();
        return this;
    }

    public DefaultHttp2UnknownFrame touch() {
        super.touch();
        return this;
    }

    public DefaultHttp2UnknownFrame retain(int i) {
        super.retain(i);
        return this;
    }

    public DefaultHttp2UnknownFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
