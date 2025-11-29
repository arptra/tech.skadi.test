package com.ucar.protocol;

public enum MessageType {
    SEND(0),
    REQ(1),
    RES(2),
    SEND_SYNC(3);
    
    private final int mValue;

    private MessageType(int i) {
        this.mValue = i;
    }

    public final int getValue() {
        return this.mValue;
    }
}
