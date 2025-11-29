package com.here.sdk.routing;

public enum TransitDepartureStatus {
    SCHEDULED(0),
    CANCELLED(1),
    ADDITIONAL(2),
    REPLACED(3);
    
    public final int value;

    private TransitDepartureStatus(int i) {
        this.value = i;
    }
}
