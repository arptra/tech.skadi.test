package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionDecoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilter;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

abstract class DeflateDecoder extends WebSocketExtensionDecoder {
    static final ByteBuf EMPTY_DEFLATE_BLOCK = Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(new byte[]{0})).asReadOnly();
    static final ByteBuf FRAME_TAIL = Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(new byte[]{0, 0, -1, -1})).asReadOnly();
    private EmbeddedChannel decoder;
    private final WebSocketExtensionFilter extensionDecoderFilter;
    private final boolean noContext;

    public DeflateDecoder(boolean z, WebSocketExtensionFilter webSocketExtensionFilter) {
        this.noContext = z;
        this.extensionDecoderFilter = (WebSocketExtensionFilter) ObjectUtil.checkNotNull(webSocketExtensionFilter, "extensionDecoderFilter");
    }

    private void cleanup() {
        EmbeddedChannel embeddedChannel = this.decoder;
        if (embeddedChannel != null) {
            embeddedChannel.finishAndReleaseAll();
            this.decoder = null;
        }
    }

    private ByteBuf decompressContent(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame) {
        if (this.decoder == null) {
            if ((webSocketFrame instanceof TextWebSocketFrame) || (webSocketFrame instanceof BinaryWebSocketFrame)) {
                this.decoder = new EmbeddedChannel(ZlibCodecFactory.newZlibDecoder(ZlibWrapper.NONE));
            } else {
                throw new CodecException("unexpected initial frame type: " + webSocketFrame.getClass().getName());
            }
        }
        boolean isReadable = webSocketFrame.content().isReadable();
        boolean equals = EMPTY_DEFLATE_BLOCK.equals(webSocketFrame.content());
        this.decoder.writeInbound(webSocketFrame.content().retain());
        if (appendFrameTail(webSocketFrame)) {
            this.decoder.writeInbound(FRAME_TAIL.duplicate());
        }
        CompositeByteBuf compositeBuffer = channelHandlerContext.alloc().compositeBuffer();
        while (true) {
            ByteBuf byteBuf = (ByteBuf) this.decoder.readInbound();
            if (byteBuf == null) {
                break;
            } else if (!byteBuf.isReadable()) {
                byteBuf.release();
            } else {
                compositeBuffer.addComponent(true, byteBuf);
            }
        }
        if (equals || !isReadable || compositeBuffer.numComponents() > 0 || (webSocketFrame instanceof ContinuationWebSocketFrame)) {
            if (webSocketFrame.isFinalFragment() && this.noContext) {
                cleanup();
            }
            return compositeBuffer;
        }
        compositeBuffer.release();
        throw new CodecException("cannot read uncompressed buffer");
    }

    public abstract boolean appendFrameTail(WebSocketFrame webSocketFrame);

    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        cleanup();
        super.channelInactive(channelHandlerContext);
    }

    public WebSocketExtensionFilter extensionDecoderFilter() {
        return this.extensionDecoderFilter;
    }

    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        cleanup();
        super.handlerRemoved(channelHandlerContext);
    }

    public abstract int newRsv(WebSocketFrame webSocketFrame);

    public void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        Object obj;
        ByteBuf decompressContent = decompressContent(channelHandlerContext, webSocketFrame);
        if (webSocketFrame instanceof TextWebSocketFrame) {
            obj = new TextWebSocketFrame(webSocketFrame.isFinalFragment(), newRsv(webSocketFrame), decompressContent);
        } else if (webSocketFrame instanceof BinaryWebSocketFrame) {
            obj = new BinaryWebSocketFrame(webSocketFrame.isFinalFragment(), newRsv(webSocketFrame), decompressContent);
        } else if (webSocketFrame instanceof ContinuationWebSocketFrame) {
            obj = new ContinuationWebSocketFrame(webSocketFrame.isFinalFragment(), newRsv(webSocketFrame), decompressContent);
        } else {
            throw new CodecException("unexpected frame type: " + webSocketFrame.getClass().getName());
        }
        list.add(obj);
    }
}
