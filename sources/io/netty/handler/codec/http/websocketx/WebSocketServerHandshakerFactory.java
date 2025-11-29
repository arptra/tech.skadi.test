package io.netty.handler.codec.http.websocketx;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.internal.ObjectUtil;

public class WebSocketServerHandshakerFactory {
    private final WebSocketDecoderConfig decoderConfig;
    private final String subprotocols;
    private final String webSocketURL;

    public WebSocketServerHandshakerFactory(String str, String str2, boolean z) {
        this(str, str2, z, 65536);
    }

    public static ChannelFuture sendUnsupportedVersionResponse(Channel channel) {
        return sendUnsupportedVersionResponse(channel, channel.newPromise());
    }

    @Deprecated
    public static void sendUnsupportedWebSocketVersionResponse(Channel channel) {
        sendUnsupportedVersionResponse(channel);
    }

    public WebSocketServerHandshaker newHandshaker(HttpRequest httpRequest) {
        String str = httpRequest.headers().get((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_VERSION);
        if (str == null) {
            return new WebSocketServerHandshaker00(this.webSocketURL, this.subprotocols, this.decoderConfig);
        }
        if (str.equals(WebSocketVersion.V13.toHttpHeaderValue())) {
            return new WebSocketServerHandshaker13(this.webSocketURL, this.subprotocols, this.decoderConfig);
        }
        if (str.equals(WebSocketVersion.V08.toHttpHeaderValue())) {
            return new WebSocketServerHandshaker08(this.webSocketURL, this.subprotocols, this.decoderConfig);
        }
        if (str.equals(WebSocketVersion.V07.toHttpHeaderValue())) {
            return new WebSocketServerHandshaker07(this.webSocketURL, this.subprotocols, this.decoderConfig);
        }
        return null;
    }

    public WebSocketServerHandshakerFactory(String str, String str2, boolean z, int i) {
        this(str, str2, z, i, false);
    }

    public static ChannelFuture sendUnsupportedVersionResponse(Channel channel, ChannelPromise channelPromise) {
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.UPGRADE_REQUIRED, channel.alloc().buffer(0));
        defaultFullHttpResponse.headers().set((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_VERSION, (Object) WebSocketVersion.V13.toHttpHeaderValue());
        HttpUtil.setContentLength(defaultFullHttpResponse, 0);
        return channel.writeAndFlush(defaultFullHttpResponse, channelPromise);
    }

    public WebSocketServerHandshakerFactory(String str, String str2, boolean z, int i, boolean z2) {
        this(str, str2, WebSocketDecoderConfig.newBuilder().allowExtensions(z).maxFramePayloadLength(i).allowMaskMismatch(z2).build());
    }

    public WebSocketServerHandshakerFactory(String str, String str2, WebSocketDecoderConfig webSocketDecoderConfig) {
        this.webSocketURL = str;
        this.subprotocols = str2;
        this.decoderConfig = (WebSocketDecoderConfig) ObjectUtil.checkNotNull(webSocketDecoderConfig, "decoderConfig");
    }
}
