package com.here.sdk.routing;

public enum NoticeSeverity {
    CRITICAL(0),
    INFO(1);
    
    public final int value;

    private NoticeSeverity(int i) {
        this.value = i;
    }
}
