package com.here.sdk.transport;

public enum TransportMode {
    CAR(0),
    TRUCK(1),
    PEDESTRIAN(2),
    SCOOTER(3),
    BICYCLE(4),
    PUBLIC_TRANSIT(5),
    TAXI(6),
    BUS(7),
    PRIVATE_BUS(8);
    
    public final int value;

    private TransportMode(int i) {
        this.value = i;
    }
}
