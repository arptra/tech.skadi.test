package com.here.posclient;

public enum ActivityType {
    Unknown(0),
    Stationary(1),
    Walking(2);
    
    public final int value;

    private ActivityType(int i) {
        this.value = i;
    }

    public static ActivityType fromInt(int i) {
        for (ActivityType activityType : values()) {
            if (activityType.value == i) {
                return activityType;
            }
        }
        throw new RuntimeException("Unknown ActivityType: " + i);
    }
}
