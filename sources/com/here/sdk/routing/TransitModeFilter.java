package com.here.sdk.routing;

public enum TransitModeFilter {
    INCLUDE(0),
    EXCLUDE(1);
    
    public final int value;

    private TransitModeFilter(int i) {
        this.value = i;
    }
}
