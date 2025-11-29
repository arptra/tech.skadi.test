package com.here.sdk.consent;

public enum ConsentState {
    UNKNOWN(0),
    REQUESTING(1),
    GRANTED(2),
    NOT_GRANTED(3),
    PENDING_GRANTED(4),
    PENDING_NOT_GRANTED(5);
    
    public final int value;

    private ConsentState(int i) {
        this.value = i;
    }
}
