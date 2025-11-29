package com.here.sdk.routing;

public enum FunctionalRoadClass {
    FUNCTIONAL_ROAD_CLASS_1(0),
    FUNCTIONAL_ROAD_CLASS_2(1),
    FUNCTIONAL_ROAD_CLASS_3(2),
    FUNCTIONAL_ROAD_CLASS_4(3),
    FUNCTIONAL_ROAD_CLASS_5(4);
    
    public final int value;

    private FunctionalRoadClass(int i) {
        this.value = i;
    }
}
