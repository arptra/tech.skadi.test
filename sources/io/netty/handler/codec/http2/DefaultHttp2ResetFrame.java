package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public final class DefaultHttp2ResetFrame extends AbstractHttp2StreamFrame implements Http2ResetFrame {
    private final long errorCode;

    public DefaultHttp2ResetFrame(Http2Error http2Error) {
        this.errorCode = ((Http2Error) ObjectUtil.checkNotNull(http2Error, "error")).code();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttp2ResetFrame)) {
            return false;
        }
        return super.equals(obj) && this.errorCode == ((DefaultHttp2ResetFrame) obj).errorCode;
    }

    public long errorCode() {
        return this.errorCode;
    }

    public int hashCode() {
        long j = this.errorCode;
        return (super.hashCode() * 31) + ((int) (j ^ (j >>> 32)));
    }

    public String name() {
        return "RST_STREAM";
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + "(stream=" + stream() + ", errorCode=" + this.errorCode + ')';
    }

    public DefaultHttp2ResetFrame(long j) {
        this.errorCode = j;
    }

    public DefaultHttp2ResetFrame stream(Http2FrameStream http2FrameStream) {
        super.stream(http2FrameStream);
        return this;
    }
}
