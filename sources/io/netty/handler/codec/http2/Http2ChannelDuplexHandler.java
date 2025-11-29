package io.netty.handler.codec.http2;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.StringUtil;

public abstract class Http2ChannelDuplexHandler extends ChannelDuplexHandler {
    private volatile Http2FrameCodec frameCodec;

    private static Http2FrameCodec requireHttp2FrameCodec(ChannelHandlerContext channelHandlerContext) {
        Class<Http2FrameCodec> cls = Http2FrameCodec.class;
        ChannelHandlerContext context = channelHandlerContext.pipeline().context((Class<? extends ChannelHandler>) cls);
        if (context != null) {
            return (Http2FrameCodec) context.handler();
        }
        throw new IllegalArgumentException(cls.getSimpleName() + " was not found in the channel pipeline.");
    }

    public final void forEachActiveStream(Http2FrameStreamVisitor http2FrameStreamVisitor) throws Http2Exception {
        this.frameCodec.forEachActiveStream(http2FrameStreamVisitor);
    }

    public final void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.frameCodec = requireHttp2FrameCodec(channelHandlerContext);
        handlerAdded0(channelHandlerContext);
    }

    public void handlerAdded0(ChannelHandlerContext channelHandlerContext) throws Exception {
    }

    public final void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            handlerRemoved0(channelHandlerContext);
        } finally {
            this.frameCodec = null;
        }
    }

    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
    }

    public final Http2FrameStream newStream() {
        Http2FrameCodec http2FrameCodec = this.frameCodec;
        if (http2FrameCodec != null) {
            return http2FrameCodec.newStream();
        }
        throw new IllegalStateException(StringUtil.simpleClassName((Class<?>) Http2FrameCodec.class) + " not found. Has the handler been added to a pipeline?");
    }
}
