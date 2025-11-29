package com.here.sdk.routing;

public enum WalkAttributes {
    STAIRS(0),
    PARK(1),
    INDOOR(2),
    OPEN(3),
    NO_THROUGH(4),
    TOLL_ROAD(5);
    
    public final int value;

    private WalkAttributes(int i) {
        this.value = i;
    }
}
