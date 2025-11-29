package com.here.sdk.navigation;

public enum MilestoneStatus {
    REACHED(0),
    MISSED(1);
    
    public final int value;

    private MilestoneStatus(int i) {
        this.value = i;
    }
}
