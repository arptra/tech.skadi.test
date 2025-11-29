package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.URI;

public class WebSocketClientHandshaker07 extends WebSocketClientHandshaker {
    public static final String MAGIC_GUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) WebSocketClientHandshaker07.class);
    private final boolean allowExtensions;
    private final boolean allowMaskMismatch;
    private String expectedChallengeResponseString;
    private final boolean performMasking;

    public WebSocketClientHandshaker07(URI uri, WebSocketVersion webSocketVersion, String str, boolean z, HttpHeaders httpHeaders, int i) {
        this(uri, webSocketVersion, str, z, httpHeaders, i, true, false);
    }

    public FullHttpRequest newHandshakeRequest() {
        URI uri = uri();
        String base64 = WebSocketUtil.base64(WebSocketUtil.randomBytes(16));
        this.expectedChallengeResponseString = WebSocketUtil.base64(WebSocketUtil.sha1((base64 + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes(CharsetUtil.US_ASCII)));
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("WebSocket version 07 client handshake key: {}, expected response: {}", base64, this.expectedChallengeResponseString);
        }
        DefaultFullHttpRequest defaultFullHttpRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, upgradeUrl(uri), Unpooled.EMPTY_BUFFER);
        HttpHeaders headers = defaultFullHttpRequest.headers();
        HttpHeaders httpHeaders = this.customHeaders;
        if (httpHeaders != null) {
            headers.add(httpHeaders);
            AsciiString asciiString = HttpHeaderNames.HOST;
            if (!headers.contains((CharSequence) asciiString)) {
                headers.set((CharSequence) asciiString, (Object) WebSocketClientHandshaker.websocketHostValue(uri));
            }
        } else {
            headers.set((CharSequence) HttpHeaderNames.HOST, (Object) WebSocketClientHandshaker.websocketHostValue(uri));
        }
        headers.set((CharSequence) HttpHeaderNames.UPGRADE, (Object) HttpHeaderValues.WEBSOCKET).set((CharSequence) HttpHeaderNames.CONNECTION, (Object) HttpHeaderValues.UPGRADE).set((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_KEY, (Object) base64);
        AsciiString asciiString2 = HttpHeaderNames.SEC_WEBSOCKET_ORIGIN;
        if (!headers.contains((CharSequence) asciiString2)) {
            headers.set((CharSequence) asciiString2, (Object) WebSocketClientHandshaker.websocketOriginValue(uri));
        }
        String expectedSubprotocol = expectedSubprotocol();
        if (expectedSubprotocol != null && !expectedSubprotocol.isEmpty()) {
            headers.set((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL, (Object) expectedSubprotocol);
        }
        headers.set((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_VERSION, (Object) version().toAsciiString());
        return defaultFullHttpRequest;
    }

    public WebSocketFrameEncoder newWebSocketEncoder() {
        return new WebSocket07FrameEncoder(this.performMasking);
    }

    public WebSocketFrameDecoder newWebsocketDecoder() {
        return new WebSocket07FrameDecoder(false, this.allowExtensions, maxFramePayloadLength(), this.allowMaskMismatch);
    }

    public void verify(FullHttpResponse fullHttpResponse) {
        HttpResponseStatus status = fullHttpResponse.status();
        if (HttpResponseStatus.SWITCHING_PROTOCOLS.equals(status)) {
            HttpHeaders headers = fullHttpResponse.headers();
            String str = headers.get((CharSequence) HttpHeaderNames.UPGRADE);
            if (HttpHeaderValues.WEBSOCKET.contentEqualsIgnoreCase(str)) {
                AsciiString asciiString = HttpHeaderNames.CONNECTION;
                if (headers.containsValue(asciiString, HttpHeaderValues.UPGRADE, true)) {
                    String str2 = headers.get((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_ACCEPT);
                    if (str2 == null || !str2.equals(this.expectedChallengeResponseString)) {
                        throw new WebSocketClientHandshakeException(String.format("Invalid challenge. Actual: %s. Expected: %s", new Object[]{str2, this.expectedChallengeResponseString}), fullHttpResponse);
                    }
                    return;
                }
                throw new WebSocketClientHandshakeException("Invalid handshake response connection: " + headers.get((CharSequence) asciiString), fullHttpResponse);
            }
            throw new WebSocketClientHandshakeException("Invalid handshake response upgrade: " + str, fullHttpResponse);
        }
        throw new WebSocketClientHandshakeException("Invalid handshake response getStatus: " + status, fullHttpResponse);
    }

    public WebSocketClientHandshaker07(URI uri, WebSocketVersion webSocketVersion, String str, boolean z, HttpHeaders httpHeaders, int i, boolean z2, boolean z3) {
        this(uri, webSocketVersion, str, z, httpHeaders, i, z2, z3, 10000);
    }

    public WebSocketClientHandshaker07 setForceCloseTimeoutMillis(long j) {
        super.setForceCloseTimeoutMillis(j);
        return this;
    }

    public WebSocketClientHandshaker07(URI uri, WebSocketVersion webSocketVersion, String str, boolean z, HttpHeaders httpHeaders, int i, boolean z2, boolean z3, long j) {
        this(uri, webSocketVersion, str, z, httpHeaders, i, z2, z3, j, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebSocketClientHandshaker07(URI uri, WebSocketVersion webSocketVersion, String str, boolean z, HttpHeaders httpHeaders, int i, boolean z2, boolean z3, long j, boolean z4) {
        super(uri, webSocketVersion, str, httpHeaders, i, j, z4);
        this.allowExtensions = z;
        this.performMasking = z2;
        this.allowMaskMismatch = z3;
    }
}
