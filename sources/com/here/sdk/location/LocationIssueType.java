package com.here.sdk.location;

public enum LocationIssueType {
    HDGNSS_DEVICE_NOT_SUPPORTED(0),
    HDGNSS_OS_VERSION_NOT_SUPPORTED(1),
    HDGNSS_CONNECTION_NOT_AVAILABLE(2),
    HDGNSS_DEGRADED_MEASUREMENT_QUALITY(3),
    HDGNSS_INSUFFICIENT_MEASUREMENT_QUALITY(4),
    FEATURE_NOT_LICENSED(5),
    FEATURE_NOT_INCLUDED(6);
    
    public final int value;

    private LocationIssueType(int i) {
        this.value = i;
    }
}
