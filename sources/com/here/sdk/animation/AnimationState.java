package com.here.sdk.animation;

public enum AnimationState {
    STARTED(0),
    COMPLETED(1),
    CANCELLED(2);
    
    public final int value;

    private AnimationState(int i) {
        this.value = i;
    }
}
