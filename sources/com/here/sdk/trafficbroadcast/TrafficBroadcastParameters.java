package com.here.sdk.trafficbroadcast;

import androidx.annotation.NonNull;
import com.here.sdk.core.Location;

public final class TrafficBroadcastParameters {
    @NonNull
    public Location location;
    @NonNull
    public TMCServiceInterface tmcService;

    public TrafficBroadcastParameters(@NonNull TMCServiceInterface tMCServiceInterface, @NonNull Location location2) {
        this.tmcService = tMCServiceInterface;
        this.location = location2;
    }
}
