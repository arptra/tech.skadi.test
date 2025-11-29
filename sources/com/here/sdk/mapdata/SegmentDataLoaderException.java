package com.here.sdk.mapdata;

public final class SegmentDataLoaderException extends Exception {
    public final SegmentDataLoaderErrorCode error;

    public SegmentDataLoaderException(SegmentDataLoaderErrorCode segmentDataLoaderErrorCode) {
        super(segmentDataLoaderErrorCode.toString());
        this.error = segmentDataLoaderErrorCode;
    }
}
