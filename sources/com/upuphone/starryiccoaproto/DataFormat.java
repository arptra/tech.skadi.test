package com.upuphone.starryiccoaproto;

public enum DataFormat {
    RAW(0),
    PB3(1);
    
    private final int mValue;

    private DataFormat(int i) {
        this.mValue = i;
    }

    public final int getValue() {
        return this.mValue;
    }
}
