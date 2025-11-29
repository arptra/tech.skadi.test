package org.java_websocket;

import org.java_websocket.framing.Framedata;

public interface WebSocket {
    void c(Framedata framedata);

    void close(int i, String str);

    void p(int i);

    void q(int i, String str);
}
