package com.here.sdk.routing;

public enum TransitIncidentType {
    TECHNICAL_PROBLEM(0),
    STRIKE(1),
    DEMONSTRATION(2),
    ACCIDENT(3),
    HOLIDAY(4),
    WEATHER(5),
    MAINTENANCE(6),
    CONSTRUCTION(7),
    POLICE_ACTIVITY(8),
    MEDICAL_EMERGENCY(9);
    
    public final int value;

    private TransitIncidentType(int i) {
        this.value = i;
    }
}
