package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.Http2Connection;

public class Http2ConnectionAdapter implements Http2Connection.Listener {
    public void onGoAwayReceived(int i, long j, ByteBuf byteBuf) {
    }

    public void onGoAwaySent(int i, long j, ByteBuf byteBuf) {
    }

    public void onStreamActive(Http2Stream http2Stream) {
    }

    public void onStreamAdded(Http2Stream http2Stream) {
    }

    public void onStreamClosed(Http2Stream http2Stream) {
    }

    public void onStreamHalfClosed(Http2Stream http2Stream) {
    }

    public void onStreamRemoved(Http2Stream http2Stream) {
    }
}
