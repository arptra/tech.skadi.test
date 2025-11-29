package com.here.sdk.venue.service;

public enum VenueServiceInitStatus {
    ONLINE_SUCCESS(0),
    ONLINE_FAILED(1),
    NOT_STARTED(2),
    IN_PROGRESS(3);
    
    public final int value;

    private VenueServiceInitStatus(int i) {
        this.value = i;
    }
}
