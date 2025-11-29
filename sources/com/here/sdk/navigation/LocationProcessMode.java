package com.here.sdk.navigation;

enum LocationProcessMode {
    NORMAL(0),
    OPTIMIZED(1);
    
    final int value;

    private LocationProcessMode(int i) {
        this.value = i;
    }
}
