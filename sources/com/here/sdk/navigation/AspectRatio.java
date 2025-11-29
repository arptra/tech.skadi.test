package com.here.sdk.navigation;

public enum AspectRatio {
    ASPECT_RATIO_3_X_4(0),
    ASPECT_RATIO_16_X_9(1);
    
    public final int value;

    private AspectRatio(int i) {
        this.value = i;
    }
}
