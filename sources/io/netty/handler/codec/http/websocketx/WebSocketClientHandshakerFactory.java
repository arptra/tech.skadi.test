package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.HttpHeaders;
import java.net.URI;

public final class WebSocketClientHandshakerFactory {
    private WebSocketClientHandshakerFactory() {
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z, HttpHeaders httpHeaders) {
        return newHandshaker(uri, webSocketVersion, str, z, httpHeaders, 65536);
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z, HttpHeaders httpHeaders, int i) {
        return newHandshaker(uri, webSocketVersion, str, z, httpHeaders, i, true, false);
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z, HttpHeaders httpHeaders, int i, boolean z2, boolean z3) {
        return newHandshaker(uri, webSocketVersion, str, z, httpHeaders, i, z2, z3, -1);
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z, HttpHeaders httpHeaders, int i, boolean z2, boolean z3, long j) {
        WebSocketVersion webSocketVersion2 = webSocketVersion;
        WebSocketVersion webSocketVersion3 = WebSocketVersion.V13;
        if (webSocketVersion2 == webSocketVersion3) {
            return new WebSocketClientHandshaker13(uri, webSocketVersion3, str, z, httpHeaders, i, z2, z3, j);
        }
        WebSocketVersion webSocketVersion4 = WebSocketVersion.V08;
        if (webSocketVersion2 == webSocketVersion4) {
            return new WebSocketClientHandshaker08(uri, webSocketVersion4, str, z, httpHeaders, i, z2, z3, j);
        }
        WebSocketVersion webSocketVersion5 = WebSocketVersion.V07;
        if (webSocketVersion2 == webSocketVersion5) {
            return new WebSocketClientHandshaker07(uri, webSocketVersion5, str, z, httpHeaders, i, z2, z3, j);
        }
        WebSocketVersion webSocketVersion6 = WebSocketVersion.V00;
        if (webSocketVersion2 == webSocketVersion6) {
            return new WebSocketClientHandshaker00(uri, webSocketVersion6, str, httpHeaders, i, j);
        }
        throw new WebSocketClientHandshakeException("Protocol version " + webSocketVersion2 + " not supported.");
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z, HttpHeaders httpHeaders, int i, boolean z2, boolean z3, long j, boolean z4) {
        WebSocketVersion webSocketVersion2 = webSocketVersion;
        WebSocketVersion webSocketVersion3 = WebSocketVersion.V13;
        if (webSocketVersion2 == webSocketVersion3) {
            return new WebSocketClientHandshaker13(uri, webSocketVersion3, str, z, httpHeaders, i, z2, z3, j, z4);
        }
        WebSocketVersion webSocketVersion4 = WebSocketVersion.V08;
        if (webSocketVersion2 == webSocketVersion4) {
            return new WebSocketClientHandshaker08(uri, webSocketVersion4, str, z, httpHeaders, i, z2, z3, j, z4);
        }
        WebSocketVersion webSocketVersion5 = WebSocketVersion.V07;
        if (webSocketVersion2 == webSocketVersion5) {
            return new WebSocketClientHandshaker07(uri, webSocketVersion5, str, z, httpHeaders, i, z2, z3, j, z4);
        }
        WebSocketVersion webSocketVersion6 = WebSocketVersion.V00;
        if (webSocketVersion2 == webSocketVersion6) {
            return new WebSocketClientHandshaker00(uri, webSocketVersion6, str, httpHeaders, i, j, z4);
        }
        throw new WebSocketClientHandshakeException("Protocol version " + webSocketVersion2 + " not supported.");
    }
}
