package com.here.sdk.navigation;

public enum SpeedWarningStatus {
    SPEED_LIMIT_EXCEEDED(0),
    SPEED_LIMIT_RESTORED(1);
    
    public final int value;

    private SpeedWarningStatus(int i) {
        this.value = i;
    }
}
