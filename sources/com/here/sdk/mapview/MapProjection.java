package com.here.sdk.mapview;

public enum MapProjection {
    GLOBE(0),
    WEB_MERCATOR(1);
    
    public final int value;

    private MapProjection(int i) {
        this.value = i;
    }
}
