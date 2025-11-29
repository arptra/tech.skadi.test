package com.here.sdk.transport;

public enum EmissionStandard {
    EURO2(0),
    EURO3(1),
    EURO4(2),
    EURO5(3),
    EURO6(4);
    
    public final int value;

    private EmissionStandard(int i) {
        this.value = i;
    }
}
