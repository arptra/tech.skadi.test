package com.here.sdk.maploader.initializer;

public final class ExternalMapDataSourceException extends Exception {
    public final ExternalMapDataSourceErrorCode error;

    public ExternalMapDataSourceException(ExternalMapDataSourceErrorCode externalMapDataSourceErrorCode) {
        super(externalMapDataSourceErrorCode.toString());
        this.error = externalMapDataSourceErrorCode;
    }
}
