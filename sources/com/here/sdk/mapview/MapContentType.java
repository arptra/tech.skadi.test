package com.here.sdk.mapview;

public enum MapContentType {
    POINT(0),
    SCREEN_POINT(1),
    LINE(2),
    LINE_SHIFTABLE(3),
    POLYGON(4),
    RASTER_IMAGE(5),
    MESH(6);
    
    public final int value;

    private MapContentType(int i) {
        this.value = i;
    }
}
