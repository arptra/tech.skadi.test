package com.here.sdk.core;

public enum AuthenticationError {
    INVALID_PARAMETER(1),
    AUTHENTICATION_FAILED(2),
    NO_CONNECTION(3),
    OPERATION_AFTER_DISPOSE(4);
    
    public final int value;

    private AuthenticationError(int i) {
        this.value = i;
    }
}
