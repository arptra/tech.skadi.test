package com.here.sdk.navigation;

public enum DistanceType {
    AHEAD(0),
    PASSED(1),
    REACHED(2);
    
    public final int value;

    private DistanceType(int i) {
        this.value = i;
    }
}
