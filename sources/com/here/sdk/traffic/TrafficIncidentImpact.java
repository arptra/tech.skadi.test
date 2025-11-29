package com.here.sdk.traffic;

public enum TrafficIncidentImpact {
    CRITICAL(0),
    MAJOR(1),
    MINOR(2),
    LOW(3),
    UNKNOWN(4);
    
    public final int value;

    private TrafficIncidentImpact(int i) {
        this.value = i;
    }
}
