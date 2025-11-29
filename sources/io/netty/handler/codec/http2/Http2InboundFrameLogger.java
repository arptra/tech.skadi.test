package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2FrameLogger;
import io.netty.handler.codec.http2.Http2FrameReader;
import io.netty.util.internal.ObjectUtil;

public class Http2InboundFrameLogger implements Http2FrameReader {
    /* access modifiers changed from: private */
    public final Http2FrameLogger logger;
    private final Http2FrameReader reader;

    public Http2InboundFrameLogger(Http2FrameReader http2FrameReader, Http2FrameLogger http2FrameLogger) {
        this.reader = (Http2FrameReader) ObjectUtil.checkNotNull(http2FrameReader, "reader");
        this.logger = (Http2FrameLogger) ObjectUtil.checkNotNull(http2FrameLogger, "logger");
    }

    public void close() {
        this.reader.close();
    }

    public Http2FrameReader.Configuration configuration() {
        return this.reader.configuration();
    }

    public void readFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, final Http2FrameListener http2FrameListener) throws Http2Exception {
        this.reader.readFrame(channelHandlerContext, byteBuf, new Http2FrameListener() {
            public int onDataRead(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logData(Http2FrameLogger.Direction.INBOUND, channelHandlerContext, i, byteBuf, i2, z);
                return http2FrameListener.onDataRead(channelHandlerContext, i, byteBuf, i2, z);
            }

            public void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logGoAway(Http2FrameLogger.Direction.INBOUND, channelHandlerContext, i, j, byteBuf);
                http2FrameListener.onGoAwayRead(channelHandlerContext, i, j, byteBuf);
            }

            public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logHeaders(Http2FrameLogger.Direction.INBOUND, channelHandlerContext, i, http2Headers, i2, z);
                http2FrameListener.onHeadersRead(channelHandlerContext, i, http2Headers, i2, z);
            }

            public void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logPingAck(Http2FrameLogger.Direction.INBOUND, channelHandlerContext, j);
                http2FrameListener.onPingAckRead(channelHandlerContext, j);
            }

            public void onPingRead(ChannelHandlerContext channelHandlerContext, long j) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logPing(Http2FrameLogger.Direction.INBOUND, channelHandlerContext, j);
                http2FrameListener.onPingRead(channelHandlerContext, j);
            }

            public void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i, int i2, short s, boolean z) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logPriority(Http2FrameLogger.Direction.INBOUND, channelHandlerContext, i, i2, s, z);
                http2FrameListener.onPriorityRead(channelHandlerContext, i, i2, s, z);
            }

            public void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i, int i2, Http2Headers http2Headers, int i3) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logPushPromise(Http2FrameLogger.Direction.INBOUND, channelHandlerContext, i, i2, http2Headers, i3);
                http2FrameListener.onPushPromiseRead(channelHandlerContext, i, i2, http2Headers, i3);
            }

            public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i, long j) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logRstStream(Http2FrameLogger.Direction.INBOUND, channelHandlerContext, i, j);
                http2FrameListener.onRstStreamRead(channelHandlerContext, i, j);
            }

            public void onSettingsAckRead(ChannelHandlerContext channelHandlerContext) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logSettingsAck(Http2FrameLogger.Direction.INBOUND, channelHandlerContext);
                http2FrameListener.onSettingsAckRead(channelHandlerContext);
            }

            public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logSettings(Http2FrameLogger.Direction.INBOUND, channelHandlerContext, http2Settings);
                http2FrameListener.onSettingsRead(channelHandlerContext, http2Settings);
            }

            public void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b, int i, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logUnknownFrame(Http2FrameLogger.Direction.INBOUND, channelHandlerContext, b, i, http2Flags, byteBuf);
                http2FrameListener.onUnknownFrame(channelHandlerContext, b, i, http2Flags, byteBuf);
            }

            public void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i, int i2) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logWindowsUpdate(Http2FrameLogger.Direction.INBOUND, channelHandlerContext, i, i2);
                http2FrameListener.onWindowUpdateRead(channelHandlerContext, i, i2);
            }

            public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i3, boolean z2) throws Http2Exception {
                Http2InboundFrameLogger.this.logger.logHeaders(Http2FrameLogger.Direction.INBOUND, channelHandlerContext, i, http2Headers, i2, s, z, i3, z2);
                http2FrameListener.onHeadersRead(channelHandlerContext, i, http2Headers, i2, s, z, i3, z2);
            }
        });
    }
}
