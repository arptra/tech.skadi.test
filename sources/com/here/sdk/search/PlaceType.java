package com.here.sdk.search;

public enum PlaceType {
    POI(0),
    ADDRESS(1),
    AREA(2),
    STREET(3),
    INTERSECTION(4),
    UNKNOWN(5);
    
    public final int value;

    private PlaceType(int i) {
        this.value = i;
    }
}
