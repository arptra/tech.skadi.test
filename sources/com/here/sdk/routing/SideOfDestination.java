package com.here.sdk.routing;

public enum SideOfDestination {
    UNDEFINED(0),
    LEFT(1),
    RIGHT(2);
    
    public final int value;

    private SideOfDestination(int i) {
        this.value = i;
    }
}
