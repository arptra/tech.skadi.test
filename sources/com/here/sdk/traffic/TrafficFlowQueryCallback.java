package com.here.sdk.traffic;

import androidx.annotation.Nullable;
import java.util.List;

@FunctionalInterface
public interface TrafficFlowQueryCallback {
    void onTrafficFlowFetched(@Nullable TrafficQueryError trafficQueryError, @Nullable List<TrafficFlow> list);
}
