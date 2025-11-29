package com.here.sdk.mapview;

public enum LineCap {
    ROUND(0),
    SQUARE(1),
    BUTT(2);
    
    public final int value;

    private LineCap(int i) {
        this.value = i;
    }
}
