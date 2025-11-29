package com.here.sdk.location;

public enum LocationAccuracy {
    BEST_AVAILABLE(0),
    SUB_METER_NAVIGATION(1),
    NAVIGATION(2),
    TENS_OF_METERS(3),
    HUNDREDS_OF_METERS(4),
    KILOMETERS(5);
    
    public final int value;

    private LocationAccuracy(int i) {
        this.value = i;
    }
}
