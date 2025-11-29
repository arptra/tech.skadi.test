package com.here.sdk.transport;

public enum VehicleType {
    CAR(0),
    TRUCK(1),
    BICYCLE(2),
    BUS(3),
    MOTORCYCLE(4),
    SCOOTER(5),
    PRIVATE_BUS(6);
    
    public final int value;

    private VehicleType(int i) {
        this.value = i;
    }
}
