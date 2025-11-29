package com.here.sdk.routing;

public enum OptimizationMode {
    FASTEST(0),
    SHORTEST(1);
    
    public final int value;

    private OptimizationMode(int i) {
        this.value = i;
    }
}
