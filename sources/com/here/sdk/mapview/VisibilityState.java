package com.here.sdk.mapview;

public enum VisibilityState {
    VISIBLE(0),
    HIDDEN(1);
    
    public final int value;

    private VisibilityState(int i) {
        this.value = i;
    }
}
