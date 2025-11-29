package io.netty.handler.codec.http2;

public abstract class AbstractHttp2StreamFrame implements Http2StreamFrame {
    private Http2FrameStream stream;

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r3 = r3.stream;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof io.netty.handler.codec.http2.Http2StreamFrame
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            io.netty.handler.codec.http2.Http2StreamFrame r4 = (io.netty.handler.codec.http2.Http2StreamFrame) r4
            io.netty.handler.codec.http2.Http2FrameStream r0 = r3.stream
            io.netty.handler.codec.http2.Http2FrameStream r2 = r4.stream()
            if (r0 == r2) goto L_0x001e
            io.netty.handler.codec.http2.Http2FrameStream r3 = r3.stream
            if (r3 == 0) goto L_0x001f
            io.netty.handler.codec.http2.Http2FrameStream r4 = r4.stream()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x001f
        L_0x001e:
            r1 = 1
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.AbstractHttp2StreamFrame.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Http2FrameStream http2FrameStream = this.stream;
        return http2FrameStream == null ? super.hashCode() : http2FrameStream.hashCode();
    }

    public AbstractHttp2StreamFrame stream(Http2FrameStream http2FrameStream) {
        this.stream = http2FrameStream;
        return this;
    }

    public Http2FrameStream stream() {
        return this.stream;
    }
}
