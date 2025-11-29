package com.here.sdk.traffic;

import androidx.annotation.Nullable;
import java.util.List;

@FunctionalInterface
public interface TrafficIncidentsQueryCallback {
    void onTrafficIncidentsFetched(@Nullable TrafficQueryError trafficQueryError, @Nullable List<TrafficIncident> list);
}
