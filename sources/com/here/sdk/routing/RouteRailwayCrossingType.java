package com.here.sdk.routing;

public enum RouteRailwayCrossingType {
    UNKNOWN(0),
    PROTECTED_WITH_BARRIER(1),
    UNPROTECTED_WITH_BARRIER(2);
    
    public final int value;

    private RouteRailwayCrossingType(int i) {
        this.value = i;
    }
}
