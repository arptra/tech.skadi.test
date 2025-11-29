package com.here.sdk.routing;

public enum TravelDirection {
    POSITIVE(0),
    NEGATIVE(1),
    BIDIRECTIONAL(2);
    
    public final int value;

    private TravelDirection(int i) {
        this.value = i;
    }
}
