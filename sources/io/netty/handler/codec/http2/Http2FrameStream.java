package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2Stream;

public interface Http2FrameStream {
    int id();

    Http2Stream.State state();
}
