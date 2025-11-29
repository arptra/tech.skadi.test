package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

public class DecoratingHttp2ConnectionDecoder implements Http2ConnectionDecoder {
    private final Http2ConnectionDecoder delegate;

    public DecoratingHttp2ConnectionDecoder(Http2ConnectionDecoder http2ConnectionDecoder) {
        this.delegate = (Http2ConnectionDecoder) ObjectUtil.checkNotNull(http2ConnectionDecoder, "delegate");
    }

    public void close() {
        this.delegate.close();
    }

    public Http2Connection connection() {
        return this.delegate.connection();
    }

    public void decodeFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Http2Exception {
        this.delegate.decodeFrame(channelHandlerContext, byteBuf, list);
    }

    public Http2LocalFlowController flowController() {
        return this.delegate.flowController();
    }

    public void frameListener(Http2FrameListener http2FrameListener) {
        this.delegate.frameListener(http2FrameListener);
    }

    public void lifecycleManager(Http2LifecycleManager http2LifecycleManager) {
        this.delegate.lifecycleManager(http2LifecycleManager);
    }

    public Http2Settings localSettings() {
        return this.delegate.localSettings();
    }

    public boolean prefaceReceived() {
        return this.delegate.prefaceReceived();
    }

    public Http2FrameListener frameListener() {
        return this.delegate.frameListener();
    }
}
