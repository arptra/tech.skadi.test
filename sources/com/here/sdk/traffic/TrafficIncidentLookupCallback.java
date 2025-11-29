package com.here.sdk.traffic;

import androidx.annotation.Nullable;

@FunctionalInterface
public interface TrafficIncidentLookupCallback {
    void onTrafficIncidentFetched(@Nullable TrafficQueryError trafficQueryError, @Nullable TrafficIncident trafficIncident);
}
