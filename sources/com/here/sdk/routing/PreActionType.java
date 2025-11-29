package com.here.sdk.routing;

public enum PreActionType {
    BOARD(0),
    WAIT(1);
    
    public final int value;

    private PreActionType(int i) {
        this.value = i;
    }
}
