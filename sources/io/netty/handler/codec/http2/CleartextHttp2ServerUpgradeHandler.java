package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpServerUpgradeHandler;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

public final class CleartextHttp2ServerUpgradeHandler extends ByteToMessageDecoder {
    private static final ByteBuf CONNECTION_PREFACE = Unpooled.unreleasableBuffer(Http2CodecUtil.connectionPrefaceBuf()).asReadOnly();
    private final ChannelHandler http2ServerHandler;
    private final HttpServerCodec httpServerCodec;
    private final HttpServerUpgradeHandler httpServerUpgradeHandler;

    public static final class PriorKnowledgeUpgradeEvent {
        /* access modifiers changed from: private */
        public static final PriorKnowledgeUpgradeEvent INSTANCE = new PriorKnowledgeUpgradeEvent();

        private PriorKnowledgeUpgradeEvent() {
        }
    }

    public CleartextHttp2ServerUpgradeHandler(HttpServerCodec httpServerCodec2, HttpServerUpgradeHandler httpServerUpgradeHandler2, ChannelHandler channelHandler) {
        this.httpServerCodec = (HttpServerCodec) ObjectUtil.checkNotNull(httpServerCodec2, "httpServerCodec");
        this.httpServerUpgradeHandler = (HttpServerUpgradeHandler) ObjectUtil.checkNotNull(httpServerUpgradeHandler2, "httpServerUpgradeHandler");
        this.http2ServerHandler = (ChannelHandler) ObjectUtil.checkNotNull(channelHandler, "http2ServerHandler");
    }

    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        ByteBuf byteBuf2 = CONNECTION_PREFACE;
        int readableBytes = byteBuf2.readableBytes();
        int min = Math.min(byteBuf.readableBytes(), readableBytes);
        if (!ByteBufUtil.equals(byteBuf2, byteBuf2.readerIndex(), byteBuf, byteBuf.readerIndex(), min)) {
            channelHandlerContext.pipeline().remove((ChannelHandler) this);
        } else if (min == readableBytes) {
            channelHandlerContext.pipeline().remove((ChannelHandler) this.httpServerCodec).remove((ChannelHandler) this.httpServerUpgradeHandler);
            channelHandlerContext.pipeline().addAfter(channelHandlerContext.name(), (String) null, this.http2ServerHandler);
            channelHandlerContext.pipeline().remove((ChannelHandler) this);
            channelHandlerContext.fireUserEventTriggered(PriorKnowledgeUpgradeEvent.INSTANCE);
        }
    }

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.pipeline().addAfter(channelHandlerContext.name(), (String) null, this.httpServerUpgradeHandler).addAfter(channelHandlerContext.name(), (String) null, this.httpServerCodec);
    }
}
