package com.here.sdk.trafficawarenavigation;

import androidx.annotation.NonNull;
import com.here.sdk.routing.Route;
import com.here.sdk.routing.RoutingError;

public interface DynamicRoutingListener {
    void onBetterRouteFound(@NonNull Route route, int i, int i2);

    void onRoutingError(@NonNull RoutingError routingError);
}
