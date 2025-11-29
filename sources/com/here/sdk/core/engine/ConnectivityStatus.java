package com.here.sdk.core.engine;

enum ConnectivityStatus {
    REACHABLE(1),
    NOT_REACHABLE(2);
    
    final int value;

    private ConnectivityStatus(int i) {
        this.value = i;
    }
}
