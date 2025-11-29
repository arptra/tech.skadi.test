package org.java_websocket.server;

import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import javax.net.ssl.SSLEngine;
import org.java_websocket.SSLSocketChannel2;

public class CustomSSLWebSocketServerFactory extends DefaultSSLWebSocketServerFactory {
    public final String[] c;
    public final String[] d;

    public ByteChannel b(SocketChannel socketChannel, SelectionKey selectionKey) {
        SSLEngine createSSLEngine = this.f3403a.createSSLEngine();
        String[] strArr = this.c;
        if (strArr != null) {
            createSSLEngine.setEnabledProtocols(strArr);
        }
        String[] strArr2 = this.d;
        if (strArr2 != null) {
            createSSLEngine.setEnabledCipherSuites(strArr2);
        }
        createSSLEngine.setUseClientMode(false);
        return new SSLSocketChannel2(socketChannel, createSSLEngine, this.b, selectionKey);
    }
}
