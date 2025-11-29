package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AsciiString;
import io.netty.util.internal.logging.InternalLogger;
import java.util.regex.Pattern;

public class WebSocketServerHandshaker00 extends WebSocketServerHandshaker {
    private static final Pattern BEGINNING_DIGIT = Pattern.compile("[^0-9]");
    private static final Pattern BEGINNING_SPACE = Pattern.compile("[^ ]");

    public WebSocketServerHandshaker00(String str, String str2, int i) {
        this(str, str2, WebSocketDecoderConfig.newBuilder().maxFramePayloadLength(i).build());
    }

    public ChannelFuture close(Channel channel, CloseWebSocketFrame closeWebSocketFrame, ChannelPromise channelPromise) {
        return channel.writeAndFlush(closeWebSocketFrame, channelPromise);
    }

    public FullHttpResponse newHandshakeResponse(FullHttpRequest fullHttpRequest, HttpHeaders httpHeaders) {
        HttpHeaders headers = fullHttpRequest.headers();
        AsciiString asciiString = HttpHeaderNames.CONNECTION;
        AsciiString asciiString2 = HttpHeaderValues.UPGRADE;
        boolean z = true;
        if (headers.containsValue(asciiString, asciiString2, true)) {
            AsciiString asciiString3 = HttpHeaderValues.WEBSOCKET;
            HttpHeaders headers2 = fullHttpRequest.headers();
            AsciiString asciiString4 = HttpHeaderNames.UPGRADE;
            if (asciiString3.contentEqualsIgnoreCase(headers2.get((CharSequence) asciiString4))) {
                HttpHeaders headers3 = fullHttpRequest.headers();
                AsciiString asciiString5 = HttpHeaderNames.SEC_WEBSOCKET_KEY1;
                if (!headers3.contains((CharSequence) asciiString5) || !fullHttpRequest.headers().contains((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_KEY2)) {
                    z = false;
                }
                String str = fullHttpRequest.headers().get((CharSequence) HttpHeaderNames.ORIGIN);
                if (str != null || z) {
                    DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, new HttpResponseStatus(101, z ? "WebSocket Protocol Handshake" : "Web Socket Protocol Handshake"), fullHttpRequest.content().alloc().buffer(0));
                    if (httpHeaders != null) {
                        defaultFullHttpResponse.headers().add(httpHeaders);
                    }
                    defaultFullHttpResponse.headers().set((CharSequence) asciiString4, (Object) asciiString3).set((CharSequence) asciiString, (Object) asciiString2);
                    if (z) {
                        defaultFullHttpResponse.headers().add((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_ORIGIN, (Object) str);
                        defaultFullHttpResponse.headers().add((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_LOCATION, (Object) uri());
                        HttpHeaders headers4 = fullHttpRequest.headers();
                        AsciiString asciiString6 = HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL;
                        String str2 = headers4.get((CharSequence) asciiString6);
                        if (str2 != null) {
                            String selectSubprotocol = selectSubprotocol(str2);
                            if (selectSubprotocol == null) {
                                InternalLogger internalLogger = WebSocketServerHandshaker.logger;
                                if (internalLogger.isDebugEnabled()) {
                                    internalLogger.debug("Requested subprotocol(s) not supported: {}", (Object) str2);
                                }
                            } else {
                                defaultFullHttpResponse.headers().set((CharSequence) asciiString6, (Object) selectSubprotocol);
                            }
                        }
                        String str3 = fullHttpRequest.headers().get((CharSequence) asciiString5);
                        String str4 = fullHttpRequest.headers().get((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_KEY2);
                        Pattern pattern = BEGINNING_DIGIT;
                        long parseLong = Long.parseLong(pattern.matcher(str3).replaceAll(""));
                        Pattern pattern2 = BEGINNING_SPACE;
                        int length = (int) (parseLong / ((long) pattern2.matcher(str3).replaceAll("").length()));
                        long readLong = fullHttpRequest.content().readLong();
                        ByteBuf index = Unpooled.wrappedBuffer(new byte[16]).setIndex(0, 0);
                        index.writeInt(length);
                        index.writeInt((int) (Long.parseLong(pattern.matcher(str4).replaceAll("")) / ((long) pattern2.matcher(str4).replaceAll("").length())));
                        index.writeLong(readLong);
                        defaultFullHttpResponse.content().writeBytes(WebSocketUtil.md5(index.array()));
                    } else {
                        defaultFullHttpResponse.headers().add((CharSequence) HttpHeaderNames.WEBSOCKET_ORIGIN, (Object) str);
                        defaultFullHttpResponse.headers().add((CharSequence) HttpHeaderNames.WEBSOCKET_LOCATION, (Object) uri());
                        HttpHeaders headers5 = fullHttpRequest.headers();
                        AsciiString asciiString7 = HttpHeaderNames.WEBSOCKET_PROTOCOL;
                        String str5 = headers5.get((CharSequence) asciiString7);
                        if (str5 != null) {
                            defaultFullHttpResponse.headers().set((CharSequence) asciiString7, (Object) selectSubprotocol(str5));
                        }
                    }
                    return defaultFullHttpResponse;
                }
                throw new WebSocketServerHandshakeException("Missing origin header, got only " + fullHttpRequest.headers().names(), fullHttpRequest);
            }
        }
        throw new WebSocketServerHandshakeException("not a WebSocket handshake request: missing upgrade", fullHttpRequest);
    }

    public WebSocketFrameEncoder newWebSocketEncoder() {
        return new WebSocket00FrameEncoder();
    }

    public WebSocketFrameDecoder newWebsocketDecoder() {
        return new WebSocket00FrameDecoder(decoderConfig());
    }

    public ChannelFuture close(ChannelHandlerContext channelHandlerContext, CloseWebSocketFrame closeWebSocketFrame, ChannelPromise channelPromise) {
        return channelHandlerContext.writeAndFlush(closeWebSocketFrame, channelPromise);
    }

    public WebSocketServerHandshaker00(String str, String str2, WebSocketDecoderConfig webSocketDecoderConfig) {
        super(WebSocketVersion.V00, str, str2, webSocketDecoderConfig);
    }
}
