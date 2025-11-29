package com.here.sdk.navigation;

public enum NaturalGuidanceType {
    STOP_SIGN(0),
    TRAFFIC_LIGHT(1);
    
    public final int value;

    private NaturalGuidanceType(int i) {
        this.value = i;
    }
}
