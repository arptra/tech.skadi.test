package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

public interface Http2UnknownFrame extends Http2StreamFrame, ByteBufHolder {
    Http2UnknownFrame copy();

    Http2UnknownFrame duplicate();

    Http2Flags flags();

    byte frameType();

    Http2UnknownFrame replace(ByteBuf byteBuf);

    Http2UnknownFrame retain();

    Http2UnknownFrame retain(int i);

    Http2UnknownFrame retainedDuplicate();

    Http2FrameStream stream();

    Http2UnknownFrame stream(Http2FrameStream http2FrameStream);

    Http2UnknownFrame touch();

    Http2UnknownFrame touch(Object obj);
}
