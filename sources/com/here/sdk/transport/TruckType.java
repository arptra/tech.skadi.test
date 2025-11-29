package com.here.sdk.transport;

public enum TruckType {
    STRAIGHT(0),
    TRACTOR(1);
    
    public final int value;

    private TruckType(int i) {
        this.value = i;
    }
}
