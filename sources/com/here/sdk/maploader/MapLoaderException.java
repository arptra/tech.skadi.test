package com.here.sdk.maploader;

public final class MapLoaderException extends Exception {
    public final MapLoaderError error;

    public MapLoaderException(MapLoaderError mapLoaderError) {
        super(mapLoaderError.toString());
        this.error = mapLoaderError;
    }
}
