package org.java_websocket.handshake;

public class HandshakeImpl1Server extends HandshakedataImpl1 implements ServerHandshakeBuilder {
    public short c;
    public String d;

    public String b() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public short f() {
        return this.c;
    }

    public void j(short s) {
        this.c = s;
    }
}
