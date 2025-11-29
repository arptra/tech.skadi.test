package org.java_websocket.server;

import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;
import org.java_websocket.WebSocketAdapter;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.WebSocketListener;
import org.java_websocket.WebSocketServerFactory;

public class DefaultWebSocketServerFactory implements WebSocketServerFactory {
    public WebSocketImpl a(WebSocketAdapter webSocketAdapter, List list) {
        return new WebSocketImpl((WebSocketListener) webSocketAdapter, list);
    }

    /* renamed from: c */
    public SocketChannel b(SocketChannel socketChannel, SelectionKey selectionKey) {
        return socketChannel;
    }

    public void close() {
    }
}
