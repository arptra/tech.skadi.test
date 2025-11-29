package com.here.sdk.routing;

public enum SectionTransportMode {
    CAR(0),
    TRUCK(1),
    PEDESTRIAN(2),
    FERRY(3),
    CAR_SHUTTLE_TRAIN(4),
    SCOOTER(5),
    BICYCLE(6),
    PUBLIC_TRANSIT(7),
    TAXI(8),
    BUS(9),
    PRIVATE_BUS(10);
    
    public final int value;

    private SectionTransportMode(int i) {
        this.value = i;
    }
}
