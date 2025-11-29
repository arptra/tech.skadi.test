package io.netty.handler.codec.http2;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

final class Http2ControlFrameLimitEncoder extends DecoratingHttp2ConnectionEncoder {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Http2ControlFrameLimitEncoder.class);
    private Http2LifecycleManager lifecycleManager;
    private boolean limitReached;
    private final int maxOutstandingControlFrames;
    private int outstandingControlFrames;
    private final ChannelFutureListener outstandingControlFramesListener = new ChannelFutureListener() {
        public void operationComplete(ChannelFuture channelFuture) {
            Http2ControlFrameLimitEncoder.access$010(Http2ControlFrameLimitEncoder.this);
        }
    };

    public Http2ControlFrameLimitEncoder(Http2ConnectionEncoder http2ConnectionEncoder, int i) {
        super(http2ConnectionEncoder);
        this.maxOutstandingControlFrames = ObjectUtil.checkPositive(i, "maxOutstandingControlFrames");
    }

    public static /* synthetic */ int access$010(Http2ControlFrameLimitEncoder http2ControlFrameLimitEncoder) {
        int i = http2ControlFrameLimitEncoder.outstandingControlFrames;
        http2ControlFrameLimitEncoder.outstandingControlFrames = i - 1;
        return i;
    }

    private ChannelPromise handleOutstandingControlFrames(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        if (this.limitReached) {
            return channelPromise;
        }
        if (this.outstandingControlFrames == this.maxOutstandingControlFrames) {
            channelHandlerContext.flush();
        }
        int i = this.outstandingControlFrames;
        int i2 = this.maxOutstandingControlFrames;
        if (i == i2) {
            this.limitReached = true;
            Http2Exception connectionError = Http2Exception.connectionError(Http2Error.ENHANCE_YOUR_CALM, "Maximum number %d of outstanding control frames reached", Integer.valueOf(i2));
            logger.info("Maximum number {} of outstanding control frames reached. Closing channel {}", Integer.valueOf(this.maxOutstandingControlFrames), channelHandlerContext.channel(), connectionError);
            this.lifecycleManager.onError(channelHandlerContext, true, connectionError);
            channelHandlerContext.close();
        }
        this.outstandingControlFrames++;
        return channelPromise.unvoid().addListener(this.outstandingControlFramesListener);
    }

    public void lifecycleManager(Http2LifecycleManager http2LifecycleManager) {
        this.lifecycleManager = http2LifecycleManager;
        super.lifecycleManager(http2LifecycleManager);
    }

    public ChannelFuture writePing(ChannelHandlerContext channelHandlerContext, boolean z, long j, ChannelPromise channelPromise) {
        if (!z) {
            return super.writePing(channelHandlerContext, z, j, channelPromise);
        }
        ChannelPromise handleOutstandingControlFrames = handleOutstandingControlFrames(channelHandlerContext, channelPromise);
        return handleOutstandingControlFrames == null ? channelPromise : super.writePing(channelHandlerContext, z, j, handleOutstandingControlFrames);
    }

    public ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i, long j, ChannelPromise channelPromise) {
        ChannelPromise handleOutstandingControlFrames = handleOutstandingControlFrames(channelHandlerContext, channelPromise);
        return handleOutstandingControlFrames == null ? channelPromise : super.writeRstStream(channelHandlerContext, i, j, handleOutstandingControlFrames);
    }

    public ChannelFuture writeSettingsAck(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        ChannelPromise handleOutstandingControlFrames = handleOutstandingControlFrames(channelHandlerContext, channelPromise);
        return handleOutstandingControlFrames == null ? channelPromise : super.writeSettingsAck(channelHandlerContext, handleOutstandingControlFrames);
    }
}
