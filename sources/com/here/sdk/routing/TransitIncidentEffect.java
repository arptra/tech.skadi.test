package com.here.sdk.routing;

public enum TransitIncidentEffect {
    CANCELLED_SERVICE(0),
    REDUCED_SERVICE(1),
    ADDITIONAL_SERVICE(2),
    MODIFIED_SERVICE(3),
    DELAYS(4),
    DETOUR(5),
    STOP_MOVED(6);
    
    public final int value;

    private TransitIncidentEffect(int i) {
        this.value = i;
    }
}
