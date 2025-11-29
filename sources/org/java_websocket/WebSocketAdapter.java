package org.java_websocket;

import org.java_websocket.drafts.Draft;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.PingFrame;
import org.java_websocket.framing.PongFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.HandshakeImpl1Server;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;

public abstract class WebSocketAdapter implements WebSocketListener {

    /* renamed from: a  reason: collision with root package name */
    public PingFrame f3391a;

    public void b(WebSocket webSocket, ClientHandshake clientHandshake) {
    }

    public PingFrame j(WebSocket webSocket) {
        if (this.f3391a == null) {
            this.f3391a = new PingFrame();
        }
        return this.f3391a;
    }

    public ServerHandshakeBuilder k(WebSocket webSocket, Draft draft, ClientHandshake clientHandshake) {
        return new HandshakeImpl1Server();
    }

    public void l(WebSocket webSocket, ClientHandshake clientHandshake, ServerHandshake serverHandshake) {
    }

    public void m(WebSocket webSocket, Framedata framedata) {
    }

    public void n(WebSocket webSocket, Framedata framedata) {
        webSocket.c(new PongFrame((PingFrame) framedata));
    }
}
