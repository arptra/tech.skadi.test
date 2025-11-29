package com.here.sdk.core;

public enum LocationTechnology {
    CELLULAR(0),
    GNSS(1),
    HD_GNSS(2),
    WIFI(3);
    
    public final int value;

    private LocationTechnology(int i) {
        this.value = i;
    }
}
