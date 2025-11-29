package com.here.sdk.transport;

public enum TunnelCategory {
    B(0),
    C(1),
    D(2),
    E(3);
    
    public final int value;

    private TunnelCategory(int i) {
        this.value = i;
    }
}
