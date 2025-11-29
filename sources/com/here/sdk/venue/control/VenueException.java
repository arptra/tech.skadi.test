package com.here.sdk.venue.control;

public final class VenueException extends Exception {
    public final VenueErrorCode error;

    public VenueException(VenueErrorCode venueErrorCode) {
        super(venueErrorCode.toString());
        this.error = venueErrorCode;
    }
}
