package com.here.sdk.routing;

public enum RoutePlaceType {
    PLACE(0),
    CHARGING_STATION(1),
    INDOOR(2),
    STATION(3),
    ACCESS_POINT(4);
    
    public final int value;

    private RoutePlaceType(int i) {
        this.value = i;
    }
}
