package com.here.sdk.routing;

public enum PostActionType {
    CHARGING_SETUP(0),
    CHARGING(1),
    DEBOARD(2),
    WAIT(3);
    
    public final int value;

    private PostActionType(int i) {
        this.value = i;
    }
}
