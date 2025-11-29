package com.here.sdk.traffic;

public enum TrafficQueryError {
    FAILED_TO_RETRIEVE_RESULT(0),
    AUTHENTICATION_FAILED(1),
    FORBIDDEN(2),
    SERVER_UNREACHABLE(3),
    TIMED_OUT(4),
    OFFLINE(5),
    HTTP_ERROR(6),
    INVALID_GEOMETRY(7),
    INVALID_INCIDENT_ID(8),
    INVALID_FILTER_OPTIONS(9),
    OPERATION_CANCELLED(10),
    PROXY_AUTHENTICATION_FAILED(11),
    PROXY_SERVER_UNREACHABLE(12),
    BAD_REQUEST(13),
    TOO_MANY_REQUESTS(14);
    
    public final int value;

    private TrafficQueryError(int i) {
        this.value = i;
    }
}
