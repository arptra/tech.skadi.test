package com.here.sdk.routing;

public enum FareReason {
    RIDE(0),
    PARKING(1);
    
    public final int value;

    private FareReason(int i) {
        this.value = i;
    }
}
