package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class ScooterOptions {
    public boolean allowHighway = false;
    @NonNull
    public AvoidanceOptions avoidanceOptions = new AvoidanceOptions();
    @Nullable
    public Integer engineSizeInCubicCentimeters = null;
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
        if (!(obj instanceof ScooterOptions)) {
            return false;
        }
        ScooterOptions scooterOptions = (ScooterOptions) obj;
        return Objects.equals(this.routeOptions, scooterOptions.routeOptions) && Objects.equals(this.textOptions, scooterOptions.textOptions) && Objects.equals(this.avoidanceOptions, scooterOptions.avoidanceOptions) && Objects.equals(this.maxSpeedOnSegments, scooterOptions.maxSpeedOnSegments) && this.allowHighway == scooterOptions.allowHighway && Objects.equals(this.engineSizeInCubicCentimeters, scooterOptions.engineSizeInCubicCentimeters);
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
        int hashCode4 = (((hashCode3 + (list != null ? list.hashCode() : 0)) * 31) + (this.allowHighway ? 79 : 97)) * 31;
        Integer num = this.engineSizeInCubicCentimeters;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode4 + i;
    }
}
