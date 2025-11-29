package com.here.sdk.routing;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class BicycleOptions {
    @NonNull
    public AvoidanceOptions avoidanceOptions = new AvoidanceOptions();
    @NonNull
    public RouteOptions routeOptions = new RouteOptions();
    @NonNull
    public RouteTextOptions textOptions = new RouteTextOptions();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BicycleOptions)) {
            return false;
        }
        BicycleOptions bicycleOptions = (BicycleOptions) obj;
        return Objects.equals(this.routeOptions, bicycleOptions.routeOptions) && Objects.equals(this.textOptions, bicycleOptions.textOptions) && Objects.equals(this.avoidanceOptions, bicycleOptions.avoidanceOptions);
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
        return hashCode2 + i;
    }
}
