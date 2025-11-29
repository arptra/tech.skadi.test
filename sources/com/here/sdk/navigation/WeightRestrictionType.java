package com.here.sdk.navigation;

public enum WeightRestrictionType {
    TRUCK_WEIGHT(0),
    WEIGHT_PER_AXLE(1),
    PAYLOAD_CAPACITY(2);
    
    public final int value;

    private WeightRestrictionType(int i) {
        this.value = i;
    }
}
