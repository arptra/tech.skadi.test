package com.here.sdk.search;

public final class PlaceSerializationException extends Exception {
    public final PlaceSerializationError error;

    public PlaceSerializationException(PlaceSerializationError placeSerializationError) {
        super(placeSerializationError.toString());
        this.error = placeSerializationError;
    }
}
