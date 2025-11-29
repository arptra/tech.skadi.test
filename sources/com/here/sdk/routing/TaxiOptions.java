package com.here.sdk.routing;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class TaxiOptions {
    public boolean allowDriveThroughTaxiRoads;
    @NonNull
    public AvoidanceOptions avoidanceOptions;
    @NonNull
    public List<MaxSpeedOnSegment> maxSpeedOnSegments;
    @NonNull
    public RouteOptions routeOptions;
    @NonNull
    public RouteTextOptions textOptions;

    public TaxiOptions() {
        this.routeOptions = new RouteOptions();
        this.textOptions = new RouteTextOptions();
        this.avoidanceOptions = new AvoidanceOptions();
        this.maxSpeedOnSegments = new ArrayList();
        this.allowDriveThroughTaxiRoads = true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiOptions)) {
            return false;
        }
        TaxiOptions taxiOptions = (TaxiOptions) obj;
        return Objects.equals(this.routeOptions, taxiOptions.routeOptions) && Objects.equals(this.textOptions, taxiOptions.textOptions) && Objects.equals(this.avoidanceOptions, taxiOptions.avoidanceOptions) && Objects.equals(this.maxSpeedOnSegments, taxiOptions.maxSpeedOnSegments) && this.allowDriveThroughTaxiRoads == taxiOptions.allowDriveThroughTaxiRoads;
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
        return ((hashCode3 + i) * 31) + (this.allowDriveThroughTaxiRoads ? 79 : 97);
    }

    public TaxiOptions(@NonNull RouteOptions routeOptions2, @NonNull RouteTextOptions routeTextOptions, @NonNull AvoidanceOptions avoidanceOptions2) {
        this.routeOptions = routeOptions2;
        this.textOptions = routeTextOptions;
        this.avoidanceOptions = avoidanceOptions2;
        this.maxSpeedOnSegments = new ArrayList();
        this.allowDriveThroughTaxiRoads = true;
    }
}
