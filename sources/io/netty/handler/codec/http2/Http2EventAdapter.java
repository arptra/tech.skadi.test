package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2Connection;

public class Http2EventAdapter implements Http2Connection.Listener, Http2FrameListener {
    public int onDataRead(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z) throws Http2Exception {
        return byteBuf.readableBytes() + i2;
    }

    public void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf) throws Http2Exception {
    }

    public void onGoAwayReceived(int i, long j, ByteBuf byteBuf) {
    }

    public void onGoAwaySent(int i, long j, ByteBuf byteBuf) {
    }

    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i3, boolean z2) throws Http2Exception {
    }

    public void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j) throws Http2Exception {
    }

    public void onPingRead(ChannelHandlerContext channelHandlerContext, long j) throws Http2Exception {
    }

    public void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i, int i2, short s, boolean z) throws Http2Exception {
    }

    public void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i, int i2, Http2Headers http2Headers, int i3) throws Http2Exception {
    }

    public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i, long j) throws Http2Exception {
    }

    public void onSettingsAckRead(ChannelHandlerContext channelHandlerContext) throws Http2Exception {
    }

    public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) throws Http2Exception {
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

    public void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b, int i, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception {
    }

    public void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i, int i2) throws Http2Exception {
    }

    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z) throws Http2Exception {
    }
}
