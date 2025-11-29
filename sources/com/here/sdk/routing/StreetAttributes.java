package com.here.sdk.routing;

public enum StreetAttributes {
    RIGHT_DRIVING_SIDE(0),
    DIRT_ROAD(1),
    TUNNEL(2),
    BRIDGE(3),
    RAMP(4),
    CONTROLLED_ACCESS(5),
    ROUNDABOUT(6),
    UNDER_CONSTRUCTION(7),
    DIVIDED_ROAD(8),
    MOTORWAY(9),
    PRIVATE_ROAD(10),
    BUILT_UP_AREA(11),
    CONTROLLED_ACCESS_HIGHWAY(12);
    
    public final int value;

    private StreetAttributes(int i) {
        this.value = i;
    }
}
