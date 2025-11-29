package com.here.sdk.animation;

public enum KeyframeInterpolationMode {
    STEP(0),
    LINEAR(1),
    SMOOTH(2);
    
    public final int value;

    private KeyframeInterpolationMode(int i) {
        this.value = i;
    }
}
