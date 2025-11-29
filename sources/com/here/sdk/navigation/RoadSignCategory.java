package com.here.sdk.navigation;

public enum RoadSignCategory {
    UNKNOWN(0),
    REGULATORY_SIGN(1),
    INFORMATIVE_SIGN(2),
    WARNING_SIGN(3);
    
    public final int value;

    private RoadSignCategory(int i) {
        this.value = i;
    }
}
