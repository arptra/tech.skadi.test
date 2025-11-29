package com.here.sdk.routing;

public enum WaypointType {
    STOPOVER(0),
    PASS_THROUGH(1);
    
    public final int value;

    private WaypointType(int i) {
        this.value = i;
    }
}
