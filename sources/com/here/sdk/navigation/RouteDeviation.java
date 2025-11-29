package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

public final class RouteDeviation {
    @NonNull
    public NavigableLocation currentLocation;
    @Deprecated
    public double fractionTraveled;
    @Nullable
    public NavigableLocation lastLocationOnRoute;
    public int lastTraveledSectionIndex;
    public int traveledDistanceOnLastSectionInMeters;

    @Deprecated
    public RouteDeviation(@Nullable NavigableLocation navigableLocation, @Deprecated double d, @NonNull NavigableLocation navigableLocation2) {
        this.lastLocationOnRoute = navigableLocation;
        this.fractionTraveled = d;
        this.currentLocation = navigableLocation2;
        this.lastTraveledSectionIndex = 0;
        this.traveledDistanceOnLastSectionInMeters = 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RouteDeviation)) {
            return false;
        }
        RouteDeviation routeDeviation = (RouteDeviation) obj;
        return Objects.equals(this.lastLocationOnRoute, routeDeviation.lastLocationOnRoute) && Double.compare(this.fractionTraveled, routeDeviation.fractionTraveled) == 0 && this.lastTraveledSectionIndex == routeDeviation.lastTraveledSectionIndex && this.traveledDistanceOnLastSectionInMeters == routeDeviation.traveledDistanceOnLastSectionInMeters && Objects.equals(this.currentLocation, routeDeviation.currentLocation);
    }

    public int hashCode() {
        NavigableLocation navigableLocation = this.lastLocationOnRoute;
        int i = 0;
        int hashCode = (((((((217 + (navigableLocation != null ? navigableLocation.hashCode() : 0)) * 31) + ((int) (Double.doubleToLongBits(this.fractionTraveled) ^ (Double.doubleToLongBits(this.fractionTraveled) >>> 32)))) * 31) + this.lastTraveledSectionIndex) * 31) + this.traveledDistanceOnLastSectionInMeters) * 31;
        NavigableLocation navigableLocation2 = this.currentLocation;
        if (navigableLocation2 != null) {
            i = navigableLocation2.hashCode();
        }
        return hashCode + i;
    }

    public RouteDeviation(@Nullable NavigableLocation navigableLocation, int i, int i2, @NonNull NavigableLocation navigableLocation2) {
        this.lastLocationOnRoute = navigableLocation;
        this.lastTraveledSectionIndex = i;
        this.traveledDistanceOnLastSectionInMeters = i2;
        this.currentLocation = navigableLocation2;
        this.fractionTraveled = 0.0d;
    }
}
