package com.here.sdk.mapview;

public enum WatermarkStyle {
    DARK(0),
    LIGHT(1);
    
    public final int value;

    private WatermarkStyle(int i) {
        this.value = i;
    }
}
