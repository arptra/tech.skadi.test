package com.here.sdk.navigation;

public enum TruckRestrictionWarningType {
    GENERAL(0),
    WEIGHT(1),
    DIMENSION(2);
    
    public final int value;

    private TruckRestrictionWarningType(int i) {
        this.value = i;
    }
}
