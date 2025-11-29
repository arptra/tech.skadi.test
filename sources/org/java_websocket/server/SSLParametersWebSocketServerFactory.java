package org.java_websocket.server;

import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import org.java_websocket.SSLSocketChannel2;

public class SSLParametersWebSocketServerFactory extends DefaultSSLWebSocketServerFactory {
    public final SSLParameters c;

    public ByteChannel b(SocketChannel socketChannel, SelectionKey selectionKey) {
        SSLEngine createSSLEngine = this.f3403a.createSSLEngine();
        createSSLEngine.setUseClientMode(false);
        createSSLEngine.setSSLParameters(this.c);
        return new SSLSocketChannel2(socketChannel, createSSLEngine, this.b, selectionKey);
    }
}
