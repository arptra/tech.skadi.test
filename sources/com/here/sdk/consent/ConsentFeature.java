package com.here.sdk.consent;

public enum ConsentFeature {
    HERE_CERTIFIED(0),
    POSITIONING_CONTRIBUTE(1);
    
    public final int value;

    private ConsentFeature(int i) {
        this.value = i;
    }
}
