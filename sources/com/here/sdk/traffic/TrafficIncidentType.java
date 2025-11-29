package com.here.sdk.traffic;

public enum TrafficIncidentType {
    ACCIDENT(0),
    CONGESTION(1),
    CONSTRUCTION(2),
    DISABLED_VEHICLE(3),
    MASS_TRANSIT(4),
    PLANNED_EVENT(5),
    ROAD_HAZARD(6),
    WEATHER(7),
    ROAD_CLOSURE(8),
    LANE_RESTRICTION(9),
    OTHER(10),
    UNKNOWN(11);
    
    public final int value;

    private TrafficIncidentType(int i) {
        this.value = i;
    }
}
