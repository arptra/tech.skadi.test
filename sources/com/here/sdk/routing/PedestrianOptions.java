package com.here.sdk.routing;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class PedestrianOptions {
    @NonNull
    public AvoidanceOptions avoidanceOptions = new AvoidanceOptions();
    @NonNull
    public RouteOptions routeOptions = new RouteOptions();
    @NonNull
    public RouteTextOptions textOptions = new RouteTextOptions();
    public double walkSpeedInMetersPerSecond = 1.0d;

    @NonNull
    public static native PedestrianOptions fromDefaultParameterConfiguration();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PedestrianOptions)) {
            return false;
        }
        PedestrianOptions pedestrianOptions = (PedestrianOptions) obj;
        return Objects.equals(this.routeOptions, pedestrianOptions.routeOptions) && Objects.equals(this.textOptions, pedestrianOptions.textOptions) && Objects.equals(this.avoidanceOptions, pedestrianOptions.avoidanceOptions) && Double.compare(this.walkSpeedInMetersPerSecond, pedestrianOptions.walkSpeedInMetersPerSecond) == 0;
    }

    public int hashCode() {
        RouteOptions routeOptions2 = this.routeOptions;
        int i = 0;
        int hashCode = (217 + (routeOptions2 != null ? routeOptions2.hashCode() : 0)) * 31;
        RouteTextOptions routeTextOptions = this.textOptions;
        int hashCode2 = (hashCode + (routeTextOptions != null ? routeTextOptions.hashCode() : 0)) * 31;
        AvoidanceOptions avoidanceOptions2 = this.avoidanceOptions;
        if (avoidanceOptions2 != null) {
            i = avoidanceOptions2.hashCode();
        }
        return ((hashCode2 + i) * 31) + ((int) (Double.doubleToLongBits(this.walkSpeedInMetersPerSecond) ^ (Double.doubleToLongBits(this.walkSpeedInMetersPerSecond) >>> 32)));
    }
}
