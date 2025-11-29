package com.here.sdk.venue.control;

public enum VenueErrorCode {
    NO_NETWORK(1),
    NO_META_DATA_FOUND(2),
    HRN_MISSING(3),
    HRN_MISMATCH(4),
    NO_DEFAULT_COLLECTION(5),
    MAP_ID_NOT_FOUND(6),
    MAP_DATA_INCORRECT(7),
    INTERNAL_SERVER_ERROR(8),
    SERVICE_UNAVAILABLE(9),
    TOKEN_INVALID(10),
    NO_MAP_IN_COLLECTION(11);
    
    public final int value;

    private VenueErrorCode(int i) {
        this.value = i;
    }
}
