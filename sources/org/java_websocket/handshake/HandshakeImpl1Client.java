package org.java_websocket.handshake;

public class HandshakeImpl1Client extends HandshakedataImpl1 implements ClientHandshakeBuilder {
    public String c = "*";

    public void c(String str) {
        if (str != null) {
            this.c = str;
            return;
        }
        throw new IllegalArgumentException("http resource descriptor must not be null");
    }

    public String h() {
        return this.c;
    }
}
