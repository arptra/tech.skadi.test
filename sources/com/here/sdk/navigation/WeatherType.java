package com.here.sdk.navigation;

public enum WeatherType {
    UNKNOWN(0),
    RAIN(1),
    SNOW(2),
    FOG(3);
    
    public final int value;

    private WeatherType(int i) {
        this.value = i;
    }
}
