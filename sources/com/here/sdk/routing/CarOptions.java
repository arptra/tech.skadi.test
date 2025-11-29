package com.here.sdk.routing;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class CarOptions {
    @NonNull
    public AvoidanceOptions avoidanceOptions = new AvoidanceOptions();
    @NonNull
    public List<MaxSpeedOnSegment> maxSpeedOnSegments = new ArrayList();
    @NonNull
    public RouteOptions routeOptions = new RouteOptions();
    @NonNull
    public RouteTextOptions textOptions = new RouteTextOptions();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CarOptions)) {
            return false;
        }
        CarOptions carOptions = (CarOptions) obj;
        return Objects.equals(this.routeOptions, carOptions.routeOptions) && Objects.equals(this.textOptions, carOptions.textOptions) && Objects.equals(this.avoidanceOptions, carOptions.avoidanceOptions) && Objects.equals(this.maxSpeedOnSegments, carOptions.maxSpeedOnSegments);
    }

    public int hashCode() {
        RouteOptions routeOptions2 = this.routeOptions;
        int i = 0;
        int hashCode = (217 + (routeOptions2 != null ? routeOptions2.hashCode() : 0)) * 31;
        RouteTextOptions routeTextOptions = this.textOptions;
        int hashCode2 = (hashCode + (routeTextOptions != null ? routeTextOptions.hashCode() : 0)) * 31;
        AvoidanceOptions avoidanceOptions2 = this.avoidanceOptions;
        int hashCode3 = (hashCode2 + (avoidanceOptions2 != null ? avoidanceOptions2.hashCode() : 0)) * 31;
        List<MaxSpeedOnSegment> list = this.maxSpeedOnSegments;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }
}
