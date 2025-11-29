package com.here.sdk.core.engine;

public enum EngineBaseURL {
    SEARCH_ENGINE(0),
    ROUTING_ENGINE(1),
    AUTHENTICATION(2),
    DS_PROXY(3),
    TRAFFIC_DATA(4),
    TRAFFIC_VECTOR_TILE_SERVICE(5);
    
    public final int value;

    private EngineBaseURL(int i) {
        this.value = i;
    }
}
