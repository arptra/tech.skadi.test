package org.java_websocket;

import java.nio.ByteBuffer;
import org.java_websocket.drafts.Draft;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.PingFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;

public interface WebSocketListener {
    void a(WebSocket webSocket, int i, String str, boolean z);

    void b(WebSocket webSocket, ClientHandshake clientHandshake);

    void d(WebSocket webSocket);

    void e(WebSocket webSocket, int i, String str);

    void f(WebSocket webSocket, Exception exc);

    void g(WebSocket webSocket, String str);

    void h(WebSocket webSocket, int i, String str, boolean z);

    void i(WebSocket webSocket, ByteBuffer byteBuffer);

    PingFrame j(WebSocket webSocket);

    ServerHandshakeBuilder k(WebSocket webSocket, Draft draft, ClientHandshake clientHandshake);

    void l(WebSocket webSocket, ClientHandshake clientHandshake, ServerHandshake serverHandshake);

    void m(WebSocket webSocket, Framedata framedata);

    void n(WebSocket webSocket, Framedata framedata);

    void o(WebSocket webSocket, Handshakedata handshakedata);
}
