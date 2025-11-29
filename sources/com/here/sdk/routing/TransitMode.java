package com.here.sdk.routing;

public enum TransitMode {
    HIGH_SPEED_TRAIN(0),
    INTERCITY_TRAIN(1),
    INTER_REGIONAL_TRAIN(2),
    REGIONAL_TRAIN(3),
    CITY_TRAIN(4),
    BUS(5),
    FERRY(6),
    SUBWAY(7),
    LIGHT_RAIL(8),
    PRIVATE_BUS(9),
    INCLINED(10),
    AERIAL(11),
    BUS_RAPID(12),
    MONORAIL(13),
    FLIGHT(14);
    
    public final int value;

    private TransitMode(int i) {
        this.value = i;
    }
}
