package com.here.sdk.transport;

public enum TruckRoadType {
    ET4(0),
    ET2(1),
    A4(2),
    A2(3),
    B4(4),
    B2(5),
    C(6),
    D(7),
    BK1(8),
    BK2(9),
    BK3(10),
    BK4(11);
    
    public final int value;

    private TruckRoadType(int i) {
        this.value = i;
    }
}
