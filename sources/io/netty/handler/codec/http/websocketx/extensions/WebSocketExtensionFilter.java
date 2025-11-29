package io.netty.handler.codec.http.websocketx.extensions;

import io.netty.handler.codec.http.websocketx.WebSocketFrame;

public interface WebSocketExtensionFilter {
    public static final WebSocketExtensionFilter ALWAYS_SKIP = new WebSocketExtensionFilter() {
        public boolean mustSkip(WebSocketFrame webSocketFrame) {
            return true;
        }
    };
    public static final WebSocketExtensionFilter NEVER_SKIP = new WebSocketExtensionFilter() {
        public boolean mustSkip(WebSocketFrame webSocketFrame) {
            return false;
        }
    };

    boolean mustSkip(WebSocketFrame webSocketFrame);
}
