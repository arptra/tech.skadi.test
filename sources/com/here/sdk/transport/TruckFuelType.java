package com.here.sdk.transport;

public enum TruckFuelType {
    CNG(1),
    DIESEL(2),
    HYDROGEN(3),
    LNG(4);
    
    public final int value;

    private TruckFuelType(int i) {
        this.value = i;
    }
}
