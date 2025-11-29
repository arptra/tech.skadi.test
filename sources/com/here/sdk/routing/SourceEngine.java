package com.here.sdk.routing;

enum SourceEngine {
    ROUTING(0),
    INDOOR(1),
    OFFLINE_ROUTING(2),
    RETURN_TO_ROUTE(3),
    PUBLIC_TRANSIT(4);
    
    final int value;

    private SourceEngine(int i) {
        this.value = i;
    }
}
