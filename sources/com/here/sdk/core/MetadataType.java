package com.here.sdk.core;

public enum MetadataType {
    CUSTOM(0),
    DOUBLE(1),
    GEO_COORDINATES(2),
    INTEGER(3),
    STRING(4);
    
    public final int value;

    private MetadataType(int i) {
        this.value = i;
    }
}
