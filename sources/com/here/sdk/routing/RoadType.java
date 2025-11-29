package com.here.sdk.routing;

public enum RoadType {
    HIGHWAY(0),
    RURAL(1),
    URBAN(2),
    UNKNOWN(3);
    
    public final int value;

    private RoadType(int i) {
        this.value = i;
    }
}
