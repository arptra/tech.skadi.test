package com.here.sdk.transport;

public enum TruckClass {
    LIGHT_CLASS(1),
    MEDIUM_CLASS(2),
    HEAVY_CLASS(3);
    
    public final int value;

    private TruckClass(int i) {
        this.value = i;
    }
}
