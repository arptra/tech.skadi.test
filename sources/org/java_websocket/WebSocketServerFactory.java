package org.java_websocket;

import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;

public interface WebSocketServerFactory extends WebSocketFactory {
    WebSocketImpl a(WebSocketAdapter webSocketAdapter, List list);

    ByteChannel b(SocketChannel socketChannel, SelectionKey selectionKey);

    void close();
}
