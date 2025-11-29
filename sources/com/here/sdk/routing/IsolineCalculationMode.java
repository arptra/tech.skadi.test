package com.here.sdk.routing;

public enum IsolineCalculationMode {
    QUALITY(0),
    PERFORMANCE(1),
    BALANCED(2);
    
    public final int value;

    private IsolineCalculationMode(int i) {
        this.value = i;
    }
}
