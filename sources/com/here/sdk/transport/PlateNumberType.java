package com.here.sdk.transport;

public enum PlateNumberType {
    ODD(0),
    EVEN(1);
    
    public final int value;

    private PlateNumberType(int i) {
        this.value = i;
    }
}
