package com.here.sdk.routing;

public enum RoutePlaceDirection {
    DEPARTURE(0),
    ARRIVAL(1);
    
    public final int value;

    private RoutePlaceDirection(int i) {
        this.value = i;
    }
}
