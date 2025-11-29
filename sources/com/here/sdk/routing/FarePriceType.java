package com.here.sdk.routing;

public enum FarePriceType {
    VALUE(0),
    RANGE(1);
    
    public final int value;

    private FarePriceType(int i) {
        this.value = i;
    }
}
