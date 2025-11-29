package com.here.sdk.core.engine;

public enum PassThroughFeature {
    TRAFFIC_DATA(0),
    TRAFFIC_TILES_FLOW(1),
    TRAFFIC_TILES_INCIDENTS(2);
    
    public final int value;

    private PassThroughFeature(int i) {
        this.value = i;
    }
}
