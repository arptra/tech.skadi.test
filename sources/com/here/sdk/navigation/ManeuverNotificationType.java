package com.here.sdk.navigation;

public enum ManeuverNotificationType {
    RANGE(0),
    REMINDER(1),
    DISTANCE(2),
    ACTION(3);
    
    public final int value;

    private ManeuverNotificationType(int i) {
        this.value = i;
    }
}
