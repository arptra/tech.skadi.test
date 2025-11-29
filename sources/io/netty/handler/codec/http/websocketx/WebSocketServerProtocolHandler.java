package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AttributeKey;
import io.netty.util.internal.ObjectUtil;
import java.net.SocketAddress;
import java.util.List;

public class WebSocketServerProtocolHandler extends WebSocketProtocolHandler {
    private static final AttributeKey<WebSocketServerHandshaker> HANDSHAKER_ATTR_KEY = AttributeKey.valueOf(WebSocketServerHandshaker.class, "HANDSHAKER");
    private final WebSocketServerProtocolConfig serverConfig;

    public static final class HandshakeComplete {
        private final HttpHeaders requestHeaders;
        private final String requestUri;
        private final String selectedSubprotocol;

        public HandshakeComplete(String str, HttpHeaders httpHeaders, String str2) {
            this.requestUri = str;
            this.requestHeaders = httpHeaders;
            this.selectedSubprotocol = str2;
        }

        public HttpHeaders requestHeaders() {
            return this.requestHeaders;
        }

        public String requestUri() {
            return this.requestUri;
        }

        public String selectedSubprotocol() {
            return this.selectedSubprotocol;
        }
    }

    public enum ServerHandshakeStateEvent {
        HANDSHAKE_COMPLETE,
        HANDSHAKE_TIMEOUT
    }

    public WebSocketServerProtocolHandler(WebSocketServerProtocolConfig webSocketServerProtocolConfig) {
        super(((WebSocketServerProtocolConfig) ObjectUtil.checkNotNull(webSocketServerProtocolConfig, "serverConfig")).dropPongFrames(), webSocketServerProtocolConfig.sendCloseFrame(), webSocketServerProtocolConfig.forceCloseTimeoutMillis());
        this.serverConfig = webSocketServerProtocolConfig;
    }

    public static WebSocketServerHandshaker getHandshaker(Channel channel) {
        return channel.attr(HANDSHAKER_ATTR_KEY).get();
    }

    public static void setHandshaker(Channel channel, WebSocketServerHandshaker webSocketServerHandshaker) {
        channel.attr(HANDSHAKER_ATTR_KEY).set(webSocketServerHandshaker);
    }

    public /* bridge */ /* synthetic */ void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        super.bind(channelHandlerContext, socketAddress, channelPromise);
    }

    public /* bridge */ /* synthetic */ void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        super.close(channelHandlerContext, channelPromise);
    }

    public /* bridge */ /* synthetic */ void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        super.connect(channelHandlerContext, socketAddress, socketAddress2, channelPromise);
    }

    public /* bridge */ /* synthetic */ void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        super.deregister(channelHandlerContext, channelPromise);
    }

    public /* bridge */ /* synthetic */ void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        super.disconnect(channelHandlerContext, channelPromise);
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        if (th instanceof WebSocketHandshakeException) {
            channelHandlerContext.channel().writeAndFlush(new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST, Unpooled.wrappedBuffer(th.getMessage().getBytes()))).addListener(ChannelFutureListener.CLOSE);
            return;
        }
        channelHandlerContext.fireExceptionCaught(th);
        channelHandlerContext.close();
    }

    public /* bridge */ /* synthetic */ void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.flush(channelHandlerContext);
    }

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        ChannelPipeline pipeline = channelHandlerContext.pipeline();
        Class cls = WebSocketServerProtocolHandshakeHandler.class;
        if (pipeline.get(cls) == null) {
            pipeline.addBefore(channelHandlerContext.name(), cls.getName(), new WebSocketServerProtocolHandshakeHandler(this.serverConfig));
        }
        if (this.serverConfig.decoderConfig().withUTF8Validator()) {
            Class cls2 = Utf8FrameValidator.class;
            if (pipeline.get(cls2) == null) {
                pipeline.addBefore(channelHandlerContext.name(), cls2.getName(), new Utf8FrameValidator(this.serverConfig.decoderConfig().closeOnProtocolViolation()));
            }
        }
    }

    public /* bridge */ /* synthetic */ void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.read(channelHandlerContext);
    }

    public /* bridge */ /* synthetic */ void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        super.write(channelHandlerContext, obj, channelPromise);
    }

    public WebSocketServerHandshakeException buildHandshakeException(String str) {
        return new WebSocketServerHandshakeException(str);
    }

    public void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        if (!this.serverConfig.handleCloseFrames() || !(webSocketFrame instanceof CloseWebSocketFrame)) {
            super.decode(channelHandlerContext, webSocketFrame, list);
            return;
        }
        WebSocketServerHandshaker handshaker = getHandshaker(channelHandlerContext.channel());
        if (handshaker != null) {
            webSocketFrame.retain();
            ChannelPromise newPromise = channelHandlerContext.newPromise();
            closeSent(newPromise);
            handshaker.close(channelHandlerContext, (CloseWebSocketFrame) webSocketFrame, newPromise);
            return;
        }
        channelHandlerContext.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }

    public WebSocketServerProtocolHandler(String str) {
        this(str, 10000);
    }

    public WebSocketServerProtocolHandler(String str, long j) {
        this(str, false, j);
    }

    public WebSocketServerProtocolHandler(String str, boolean z) {
        this(str, z, 10000);
    }

    public WebSocketServerProtocolHandler(String str, boolean z, long j) {
        this(str, (String) null, false, 65536, false, z, j);
    }

    public WebSocketServerProtocolHandler(String str, String str2) {
        this(str, str2, 10000);
    }

    public WebSocketServerProtocolHandler(String str, String str2, long j) {
        this(str, str2, false, j);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z) {
        this(str, str2, z, 10000);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z, long j) {
        this(str, str2, z, 65536, j);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z, int i) {
        this(str, str2, z, i, 10000);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z, int i, long j) {
        this(str, str2, z, i, false, j);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z, int i, boolean z2) {
        this(str, str2, z, i, z2, 10000);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z, int i, boolean z2, long j) {
        this(str, str2, z, i, z2, false, j);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z, int i, boolean z2, boolean z3) {
        this(str, str2, z, i, z2, z3, 10000);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z, int i, boolean z2, boolean z3, long j) {
        this(str, str2, z, i, z2, z3, true, j);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z, int i, boolean z2, boolean z3, boolean z4) {
        this(str, str2, z, i, z2, z3, z4, 10000);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WebSocketServerProtocolHandler(String str, String str2, boolean z, int i, boolean z2, boolean z3, boolean z4, long j) {
        this(str, str2, z3, z4, j, WebSocketDecoderConfig.newBuilder().maxFramePayloadLength(i).allowMaskMismatch(z2).allowExtensions(z).build());
        int i2 = i;
        boolean z5 = z2;
        boolean z6 = z;
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z, boolean z2, long j, WebSocketDecoderConfig webSocketDecoderConfig) {
        this(WebSocketServerProtocolConfig.newBuilder().websocketPath(str).subprotocols(str2).checkStartsWith(z).handshakeTimeoutMillis(j).dropPongFrames(z2).decoderConfig(webSocketDecoderConfig).build());
    }
}
