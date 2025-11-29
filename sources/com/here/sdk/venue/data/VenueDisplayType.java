package com.here.sdk.venue.data;

enum VenueDisplayType {
    STANDARD(0),
    FLATTEN(1);
    
    final int value;

    private VenueDisplayType(int i) {
        this.value = i;
    }
}
