package com.here.sdk.maploader.initializer;

public enum ExternalMapDataSourceErrorCode {
    INTERNAL_ERROR(1),
    ADD_CATALOG_ERROR(2);
    
    public final int value;

    private ExternalMapDataSourceErrorCode(int i) {
        this.value = i;
    }
}
