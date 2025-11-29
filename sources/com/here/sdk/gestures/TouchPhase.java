package com.here.sdk.gestures;

enum TouchPhase {
    BEGIN(0),
    MOVE(1),
    STATIONARY(2),
    END(3),
    CANCEL(4);
    
    final int value;

    private TouchPhase(int i) {
        this.value = i;
    }
}
