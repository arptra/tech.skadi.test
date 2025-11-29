package com.here.sdk.location;

public enum LocationEngineStatus {
    ENGINE_STARTED(0),
    ALREADY_STARTED(1),
    ENGINE_STOPPED(2),
    START_FAILED(3),
    USER_CONSENT_NOT_HANDLED(4),
    MISSING_PERMISSIONS(5),
    AUTHENTICATION_FAILED(6),
    NOT_SUPPORTED(7),
    NOT_ALLOWED(8),
    NOT_READY(9),
    LOCATION_SERVICES_DISABLED(10),
    OK(11);
    
    public final int value;

    private LocationEngineStatus(int i) {
        this.value = i;
    }
}
