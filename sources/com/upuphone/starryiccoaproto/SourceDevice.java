package com.upuphone.starryiccoaproto;

public enum SourceDevice {
    CAR(0),
    PHONE(1);
    
    private final int mValue;

    private SourceDevice(int i) {
        this.mValue = i;
    }

    public final int getValue() {
        return this.mValue;
    }
}
