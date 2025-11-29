package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
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
import io.netty.util.internal.PlatformDependent;
import java.net.URI;
import java.nio.ByteBuffer;

public class WebSocketClientHandshaker00 extends WebSocketClientHandshaker {
    private ByteBuf expectedChallengeResponseBytes;

    public WebSocketClientHandshaker00(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i) {
        this(uri, webSocketVersion, str, httpHeaders, i, 10000);
    }

    private static String insertRandomCharacters(String str) {
        int randomNumber = WebSocketUtil.randomNumber(1, 12);
        char[] cArr = new char[randomNumber];
        int i = 0;
        while (i < randomNumber) {
            int nextInt = PlatformDependent.threadLocalRandom().nextInt(126) + 33;
            if ((33 < nextInt && nextInt < 47) || (58 < nextInt && nextInt < 126)) {
                cArr[i] = (char) nextInt;
                i++;
            }
        }
        for (int i2 = 0; i2 < randomNumber; i2++) {
            int randomNumber2 = WebSocketUtil.randomNumber(0, str.length());
            str = str.substring(0, randomNumber2) + cArr[i2] + str.substring(randomNumber2);
        }
        return str;
    }

    private static String insertSpaces(String str, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int randomNumber = WebSocketUtil.randomNumber(1, str.length() - 1);
            str = str.substring(0, randomNumber) + ' ' + str.substring(randomNumber);
        }
        return str;
    }

    public FullHttpRequest newHandshakeRequest() {
        int randomNumber = WebSocketUtil.randomNumber(1, 12);
        int randomNumber2 = WebSocketUtil.randomNumber(1, 12);
        int randomNumber3 = WebSocketUtil.randomNumber(0, Integer.MAX_VALUE / randomNumber);
        int randomNumber4 = WebSocketUtil.randomNumber(0, Integer.MAX_VALUE / randomNumber2);
        String num = Integer.toString(randomNumber3 * randomNumber);
        String num2 = Integer.toString(randomNumber4 * randomNumber2);
        String insertRandomCharacters = insertRandomCharacters(num);
        String insertRandomCharacters2 = insertRandomCharacters(num2);
        String insertSpaces = insertSpaces(insertRandomCharacters, randomNumber);
        String insertSpaces2 = insertSpaces(insertRandomCharacters2, randomNumber2);
        byte[] randomBytes = WebSocketUtil.randomBytes(8);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(randomNumber3);
        byte[] array = allocate.array();
        ByteBuffer allocate2 = ByteBuffer.allocate(4);
        allocate2.putInt(randomNumber4);
        byte[] array2 = allocate2.array();
        byte[] bArr = new byte[16];
        System.arraycopy(array, 0, bArr, 0, 4);
        System.arraycopy(array2, 0, bArr, 4, 4);
        System.arraycopy(randomBytes, 0, bArr, 8, 8);
        this.expectedChallengeResponseBytes = Unpooled.wrappedBuffer(WebSocketUtil.md5(bArr));
        URI uri = uri();
        DefaultFullHttpRequest defaultFullHttpRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, upgradeUrl(uri), Unpooled.wrappedBuffer(randomBytes));
        HttpHeaders headers = defaultFullHttpRequest.headers();
        HttpHeaders httpHeaders = this.customHeaders;
        if (httpHeaders != null) {
            headers.add(httpHeaders);
        }
        headers.set((CharSequence) HttpHeaderNames.UPGRADE, (Object) HttpHeaderValues.WEBSOCKET).set((CharSequence) HttpHeaderNames.CONNECTION, (Object) HttpHeaderValues.UPGRADE).set((CharSequence) HttpHeaderNames.HOST, (Object) WebSocketClientHandshaker.websocketHostValue(uri)).set((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_KEY1, (Object) insertSpaces).set((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_KEY2, (Object) insertSpaces2);
        AsciiString asciiString = HttpHeaderNames.ORIGIN;
        if (!headers.contains((CharSequence) asciiString)) {
            headers.set((CharSequence) asciiString, (Object) WebSocketClientHandshaker.websocketOriginValue(uri));
        }
        String expectedSubprotocol = expectedSubprotocol();
        if (expectedSubprotocol != null && !expectedSubprotocol.isEmpty()) {
            headers.set((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL, (Object) expectedSubprotocol);
        }
        headers.set((CharSequence) HttpHeaderNames.CONTENT_LENGTH, (Object) Integer.valueOf(randomBytes.length));
        return defaultFullHttpRequest;
    }

    public WebSocketFrameEncoder newWebSocketEncoder() {
        return new WebSocket00FrameEncoder();
    }

    public WebSocketFrameDecoder newWebsocketDecoder() {
        return new WebSocket00FrameDecoder(maxFramePayloadLength());
    }

    public void verify(FullHttpResponse fullHttpResponse) {
        HttpResponseStatus status = fullHttpResponse.status();
        if (HttpResponseStatus.SWITCHING_PROTOCOLS.equals(status)) {
            HttpHeaders headers = fullHttpResponse.headers();
            String str = headers.get((CharSequence) HttpHeaderNames.UPGRADE);
            if (HttpHeaderValues.WEBSOCKET.contentEqualsIgnoreCase(str)) {
                AsciiString asciiString = HttpHeaderNames.CONNECTION;
                if (!headers.containsValue(asciiString, HttpHeaderValues.UPGRADE, true)) {
                    throw new WebSocketClientHandshakeException("Invalid handshake response connection: " + headers.get((CharSequence) asciiString), fullHttpResponse);
                } else if (!fullHttpResponse.content().equals(this.expectedChallengeResponseBytes)) {
                    throw new WebSocketClientHandshakeException("Invalid challenge", fullHttpResponse);
                }
            } else {
                throw new WebSocketClientHandshakeException("Invalid handshake response upgrade: " + str, fullHttpResponse);
            }
        } else {
            throw new WebSocketClientHandshakeException("Invalid handshake response getStatus: " + status, fullHttpResponse);
        }
    }

    public WebSocketClientHandshaker00(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i, long j) {
        this(uri, webSocketVersion, str, httpHeaders, i, j, false);
    }

    public WebSocketClientHandshaker00 setForceCloseTimeoutMillis(long j) {
        super.setForceCloseTimeoutMillis(j);
        return this;
    }

    public WebSocketClientHandshaker00(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i, long j, boolean z) {
        super(uri, webSocketVersion, str, httpHeaders, i, j, z);
    }
}
