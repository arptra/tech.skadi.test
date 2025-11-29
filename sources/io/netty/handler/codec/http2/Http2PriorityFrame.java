package io.netty.handler.codec.http2;

public interface Http2PriorityFrame extends Http2StreamFrame {
    boolean exclusive();

    Http2PriorityFrame stream(Http2FrameStream http2FrameStream);

    int streamDependency();

    short weight();
}
