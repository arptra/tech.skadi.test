package com.ucar.protocol;

public enum CmdCategory {
    NONE(0),
    CONTROL(1),
    SENSOR(2),
    AUTH(3),
    AUDIO(4),
    VIDEO(5),
    CERT(6),
    ACK(7);
    
    private final int mValue;

    private CmdCategory(int i) {
        this.mValue = i;
    }

    public final int getValue() {
        return this.mValue;
    }
}
