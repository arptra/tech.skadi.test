package com.here.sdk.routing;

public enum RoadFeatures {
    SEASONAL_CLOSURE(0),
    TOLL_ROAD(1),
    CONTROLLED_ACCESS_HIGHWAY(2),
    FERRY(3),
    CAR_SHUTTLE_TRAIN(4),
    TUNNEL(5),
    DIRT_ROAD(6),
    U_TURNS(7);
    
    public final int value;

    private RoadFeatures(int i) {
        this.value = i;
    }
}
