package com.here.sdk.search;

public enum PlaceSerializationError {
    UNKNOWN(0);
    
    public final int value;

    private PlaceSerializationError(int i) {
        this.value = i;
    }
}
