package com.here.sdk.routing;

public enum IsolineRangeType {
    DISTANCE_IN_METERS(0),
    TIME_IN_SECONDS(1),
    CONSUMPTION_IN_WATT_HOURS(2);
    
    public final int value;

    private IsolineRangeType(int i) {
        this.value = i;
    }
}
