package com.here.sdk.routing;

import androidx.annotation.NonNull;
import com.here.sdk.core.GeoCoordinates;

public final class RouteRailwayCrossing {
    @NonNull
    public GeoCoordinates coordinates;
    @NonNull
    public RouteOffset routeOffset;
    @NonNull
    public RouteRailwayCrossingType type;

    public RouteRailwayCrossing(@NonNull RouteRailwayCrossingType routeRailwayCrossingType, @NonNull GeoCoordinates geoCoordinates, @NonNull RouteOffset routeOffset2) {
        this.type = routeRailwayCrossingType;
        this.coordinates = geoCoordinates;
        this.routeOffset = routeOffset2;
    }
}
