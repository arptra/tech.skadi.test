package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpResponse;

public final class WebSocketClientHandshakeException extends WebSocketHandshakeException {
    private static final long serialVersionUID = 1;
    private final HttpResponse response;

    public WebSocketClientHandshakeException(String str) {
        this(str, (HttpResponse) null);
    }

    public HttpResponse response() {
        return this.response;
    }

    public WebSocketClientHandshakeException(String str, HttpResponse httpResponse) {
        super(str);
        if (httpResponse != null) {
            this.response = new DefaultHttpResponse(httpResponse.protocolVersion(), httpResponse.status(), httpResponse.headers());
        } else {
            this.response = null;
        }
    }
}
