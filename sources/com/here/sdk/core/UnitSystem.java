package com.here.sdk.core;

public enum UnitSystem {
    METRIC(0),
    IMPERIAL_UK(1),
    IMPERIAL_US(2);
    
    public final int value;

    private UnitSystem(int i) {
        this.value = i;
    }
}
