package com.here.sdk.traffic;

public enum Traversability {
    OPEN(0),
    CLOSED(1),
    REVERSIBLE_NOT_ROUTABLE(2);
    
    public final int value;

    private Traversability(int i) {
        this.value = i;
    }
}
