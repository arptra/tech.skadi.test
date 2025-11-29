package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public final class DefaultHttp2HeadersFrame extends AbstractHttp2StreamFrame implements Http2HeadersFrame {
    private final boolean endStream;
    private final Http2Headers headers;
    private final int padding;

    public DefaultHttp2HeadersFrame(Http2Headers http2Headers) {
        this(http2Headers, false);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttp2HeadersFrame)) {
            return false;
        }
        DefaultHttp2HeadersFrame defaultHttp2HeadersFrame = (DefaultHttp2HeadersFrame) obj;
        return super.equals(defaultHttp2HeadersFrame) && this.headers.equals(defaultHttp2HeadersFrame.headers) && this.endStream == defaultHttp2HeadersFrame.endStream && this.padding == defaultHttp2HeadersFrame.padding;
    }

    public int hashCode() {
        return (((((super.hashCode() * 31) + this.headers.hashCode()) * 31) + (this.endStream ^ true ? 1 : 0)) * 31) + this.padding;
    }

    public Http2Headers headers() {
        return this.headers;
    }

    public boolean isEndStream() {
        return this.endStream;
    }

    public String name() {
        return "HEADERS";
    }

    public int padding() {
        return this.padding;
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + "(stream=" + stream() + ", headers=" + this.headers + ", endStream=" + this.endStream + ", padding=" + this.padding + ')';
    }

    public DefaultHttp2HeadersFrame(Http2Headers http2Headers, boolean z) {
        this(http2Headers, z, 0);
    }

    public DefaultHttp2HeadersFrame(Http2Headers http2Headers, boolean z, int i) {
        this.headers = (Http2Headers) ObjectUtil.checkNotNull(http2Headers, "headers");
        this.endStream = z;
        Http2CodecUtil.verifyPadding(i);
        this.padding = i;
    }

    public DefaultHttp2HeadersFrame stream(Http2FrameStream http2FrameStream) {
        super.stream(http2FrameStream);
        return this;
    }
}
