package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;

final class Http2EmptyDataFrameListener extends Http2FrameListenerDecorator {
    private int emptyDataFrames;
    private final int maxConsecutiveEmptyFrames;
    private boolean violationDetected;

    public Http2EmptyDataFrameListener(Http2FrameListener http2FrameListener, int i) {
        super(http2FrameListener);
        this.maxConsecutiveEmptyFrames = ObjectUtil.checkPositive(i, "maxConsecutiveEmptyFrames");
    }

    public int onDataRead(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z) throws Http2Exception {
        if (z || byteBuf.isReadable()) {
            this.emptyDataFrames = 0;
        } else {
            int i3 = this.emptyDataFrames;
            this.emptyDataFrames = i3 + 1;
            int i4 = this.maxConsecutiveEmptyFrames;
            if (i3 == i4 && !this.violationDetected) {
                this.violationDetected = true;
                throw Http2Exception.connectionError(Http2Error.ENHANCE_YOUR_CALM, "Maximum number %d of empty data frames without end_of_stream flag received", Integer.valueOf(i4));
            }
        }
        return super.onDataRead(channelHandlerContext, i, byteBuf, i2, z);
    }

    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z) throws Http2Exception {
        this.emptyDataFrames = 0;
        super.onHeadersRead(channelHandlerContext, i, http2Headers, i2, z);
    }

    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i3, boolean z2) throws Http2Exception {
        this.emptyDataFrames = 0;
        super.onHeadersRead(channelHandlerContext, i, http2Headers, i2, s, z, i3, z2);
    }
}
