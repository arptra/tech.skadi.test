package com.here.sdk.navigation;

public enum RoadSignVehicleType {
    TRUCKS(0),
    HEAVY_TRUCKS(1),
    BUS(2),
    AUTO_TRAILER(3),
    MOTORHOME(4),
    MOTORCYCLE(5);
    
    public final int value;

    private RoadSignVehicleType(int i) {
        this.value = i;
    }
}
