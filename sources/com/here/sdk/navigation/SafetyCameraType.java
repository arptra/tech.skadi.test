package com.here.sdk.navigation;

public enum SafetyCameraType {
    BUS_LANE(0),
    DISTANCE(1),
    RED_LIGHT(2),
    RED_LIGHT_AND_SPEED(3),
    SECTION_END(4),
    SECTION_START(5),
    SPEED(6);
    
    public final int value;

    private SafetyCameraType(int i) {
        this.value = i;
    }
}
