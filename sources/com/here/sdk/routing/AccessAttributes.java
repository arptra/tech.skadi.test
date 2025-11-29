package com.here.sdk.routing;

public enum AccessAttributes {
    OPEN(0),
    NO_THROUGH(1),
    TOLL_ROAD(2);
    
    public final int value;

    private AccessAttributes(int i) {
        this.value = i;
    }
}
