package com.here.sdk.mapview;

public enum MapRenderMode {
    SURFACE(0),
    TEXTURE(1);
    
    public final int value;

    private MapRenderMode(int i) {
        this.value = i;
    }
}
