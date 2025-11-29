package com.here.sdk.routing;

import androidx.annotation.Nullable;
import java.util.List;

@FunctionalInterface
public interface CalculateIsolineCallback {
    void onIsolineCalculated(@Nullable RoutingError routingError, @Nullable List<Isoline> list);
}
