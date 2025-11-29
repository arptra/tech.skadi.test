package com.here.sdk.mapdata;

public enum SegmentDataLoaderErrorCode {
    INTERNAL_ERROR(1),
    INVALID_PARAMETERS(2);
    
    public final int value;

    private SegmentDataLoaderErrorCode(int i) {
        this.value = i;
    }
}
