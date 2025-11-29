package com.here.sdk.core;

public enum RouteType {
    TYPE_UNKNOWN(0),
    LEVEL_1_ROAD(1),
    LEVEL_2_ROAD(2),
    LEVEL_3_ROAD(3),
    LEVEL_4_ROAD(4),
    LEVEL_5_ROAD(5),
    LEVEL_6_ROAD(6);
    
    public final int value;

    private RouteType(int i) {
        this.value = i;
    }
}
