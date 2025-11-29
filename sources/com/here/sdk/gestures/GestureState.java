package com.here.sdk.gestures;

public enum GestureState {
    BEGIN(0),
    UPDATE(1),
    END(2),
    CANCEL(3);
    
    public final int value;

    private GestureState(int i) {
        this.value = i;
    }
}
