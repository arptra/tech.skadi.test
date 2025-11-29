package org.java_websocket.server;

import io.netty.handler.ssl.Ciphers;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import org.java_websocket.SSLSocketChannel2;
import org.java_websocket.WebSocketAdapter;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.WebSocketListener;
import org.java_websocket.WebSocketServerFactory;

public class DefaultSSLWebSocketServerFactory implements WebSocketServerFactory {

    /* renamed from: a  reason: collision with root package name */
    public SSLContext f3403a;
    public ExecutorService b;

    public WebSocketImpl a(WebSocketAdapter webSocketAdapter, List list) {
        return new WebSocketImpl((WebSocketListener) webSocketAdapter, list);
    }

    public ByteChannel b(SocketChannel socketChannel, SelectionKey selectionKey) {
        SSLEngine createSSLEngine = this.f3403a.createSSLEngine();
        ArrayList arrayList = new ArrayList(Arrays.asList(createSSLEngine.getEnabledCipherSuites()));
        arrayList.remove(Ciphers.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256);
        createSSLEngine.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        createSSLEngine.setUseClientMode(false);
        return new SSLSocketChannel2(socketChannel, createSSLEngine, this.b, selectionKey);
    }

    public void close() {
        this.b.shutdown();
    }
}
