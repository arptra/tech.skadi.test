package com.here.sdk.transport;

public enum FuelCategory {
    ETHANOL(0),
    GASOLINE(1),
    DIESEL(2),
    BIODIESEL(3),
    NATURAL_GAS(4),
    HYDROGEN(5);
    
    public final int value;

    private FuelCategory(int i) {
        this.value = i;
    }
}
