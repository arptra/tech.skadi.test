package com.here.sdk.mapview;

public enum ShadowQuality {
    VERY_LOW(0),
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    VERY_HIGH(4);
    
    public final int value;

    private ShadowQuality(int i) {
        this.value = i;
    }
}
