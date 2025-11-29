package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.HttpRequest;

public final class WebSocketServerHandshakeException extends WebSocketHandshakeException {
    private static final long serialVersionUID = 1;
    private final HttpRequest request;

    public WebSocketServerHandshakeException(String str) {
        this(str, (HttpRequest) null);
    }

    public HttpRequest request() {
        return this.request;
    }

    public WebSocketServerHandshakeException(String str, HttpRequest httpRequest) {
        super(str);
        if (httpRequest != null) {
            this.request = new DefaultHttpRequest(httpRequest.protocolVersion(), httpRequest.method(), httpRequest.uri(), httpRequest.headers());
        } else {
            this.request = null;
        }
    }
}
