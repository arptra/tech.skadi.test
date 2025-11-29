package com.upuphone.runasone.channel.linker.websocket;

public class TextMessage {
    public static final int TYPE_ST_DEVICE = 1;
    private String message;
    private int type;

    public String getMessage() {
        return this.message;
    }

    public int getType() {
        return this.type;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
