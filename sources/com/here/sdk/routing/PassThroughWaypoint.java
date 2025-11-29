package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

public final class PassThroughWaypoint {
    @Nullable
    public Integer offset = null;
    @NonNull
    public RoutePlace place;

    public PassThroughWaypoint(@NonNull RoutePlace routePlace) {
        this.place = routePlace;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PassThroughWaypoint)) {
            return false;
        }
        PassThroughWaypoint passThroughWaypoint = (PassThroughWaypoint) obj;
        return Objects.equals(this.place, passThroughWaypoint.place) && Objects.equals(this.offset, passThroughWaypoint.offset);
    }

    public int hashCode() {
        RoutePlace routePlace = this.place;
        int i = 0;
        int hashCode = (217 + (routePlace != null ? routePlace.hashCode() : 0)) * 31;
        Integer num = this.offset;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }
}
