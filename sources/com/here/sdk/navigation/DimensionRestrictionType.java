package com.here.sdk.navigation;

public enum DimensionRestrictionType {
    TRUCK_HEIGHT(0),
    TRUCK_WIDTH(1),
    TRUCK_LENGTH(2);
    
    public final int value;

    private DimensionRestrictionType(int i) {
        this.value = i;
    }
}
