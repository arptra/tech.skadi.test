package com.here.sdk.search;

public enum SearchError {
    AUTHENTICATION_FAILED(1),
    MAX_ITEMS_OUT_OF_RANGE(2),
    POLYLINE_TOO_LONG(3),
    PARSING_ERROR(4),
    NO_RESULTS_FOUND(5),
    HTTP_ERROR(6),
    SERVER_UNREACHABLE(7),
    INVALID_PARAMETER(8),
    FORBIDDEN(9),
    EXCEEDED_USAGE_LIMIT(10),
    OPERATION_FAILED(11),
    OPERATION_CANCELLED(12),
    TIMED_OUT(13),
    OFFLINE(14),
    QUERY_TOO_LONG(15),
    FILTER_TOO_LONG(16),
    PROXY_AUTHENTICATION_FAILED(17),
    PROXY_SERVER_UNREACHABLE(18);
    
    public final int value;

    private SearchError(int i) {
        this.value = i;
    }
}
