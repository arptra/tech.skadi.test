package com.here.sdk.mapview.datasource;

public enum RasterDataSourceError {
    INVALID_CONFIGURATION(0),
    AUTHENTICATION_ERROR(1);
    
    public final int value;

    private RasterDataSourceError(int i) {
        this.value = i;
    }
}
