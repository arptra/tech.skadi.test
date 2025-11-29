package com.here.sdk.consent;

public enum ConsentStatus {
    OK(0),
    PENDING(1),
    ERR_NOT_ALLOWED(2),
    ERR_ILLEGAL_ARGUMENT(3),
    ERR_FAILED(4),
    ERR_NOT_READY(5);
    
    public final int value;

    private ConsentStatus(int i) {
        this.value = i;
    }
}
