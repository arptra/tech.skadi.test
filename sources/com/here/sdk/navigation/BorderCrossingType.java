package com.here.sdk.navigation;

public enum BorderCrossingType {
    COUNTRY(0),
    STATE(1);
    
    public final int value;

    private BorderCrossingType(int i) {
        this.value = i;
    }
}
