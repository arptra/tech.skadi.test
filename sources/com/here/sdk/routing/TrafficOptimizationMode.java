package com.here.sdk.routing;

public enum TrafficOptimizationMode {
    TIME_DEPENDENT(0),
    LONG_TERM_CLOSURES_ONLY(1),
    DISABLED(2);
    
    public final int value;

    private TrafficOptimizationMode(int i) {
        this.value = i;
    }
}
