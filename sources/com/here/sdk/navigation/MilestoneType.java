package com.here.sdk.navigation;

public enum MilestoneType {
    STOPOVER(0),
    PASSTHROUGH(1);
    
    public final int value;

    private MilestoneType(int i) {
        this.value = i;
    }
}
