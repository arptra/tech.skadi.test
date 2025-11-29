package com.here.sdk.location;

public enum LocationFeature {
    CELLULAR_POSITIONING(0),
    WIFI_POSITIONING_2D(1),
    HD_GNSS_POSITIONING(2),
    UNDEFINED(3);
    
    public final int value;

    private LocationFeature(int i) {
        this.value = i;
    }
}
