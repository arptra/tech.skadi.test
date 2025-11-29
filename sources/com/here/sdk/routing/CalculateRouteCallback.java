package com.here.sdk.routing;

import androidx.annotation.Nullable;
import java.util.List;

@FunctionalInterface
public interface CalculateRouteCallback {
    void onRouteCalculated(@Nullable RoutingError routingError, @Nullable List<Route> list);
}
