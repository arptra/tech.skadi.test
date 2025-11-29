package com.here.sdk.routing;

import androidx.annotation.NonNull;
import com.here.sdk.transport.BusSpecifications;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class BusOptions {
    @NonNull
    public AvoidanceOptions avoidanceOptions = new AvoidanceOptions();
    @NonNull
    public BusSpecifications busSpecifications = new BusSpecifications();
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
        if (!(obj instanceof BusOptions)) {
            return false;
        }
        BusOptions busOptions = (BusOptions) obj;
        return Objects.equals(this.routeOptions, busOptions.routeOptions) && Objects.equals(this.textOptions, busOptions.textOptions) && Objects.equals(this.avoidanceOptions, busOptions.avoidanceOptions) && Objects.equals(this.maxSpeedOnSegments, busOptions.maxSpeedOnSegments) && Objects.equals(this.busSpecifications, busOptions.busSpecifications);
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
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        BusSpecifications busSpecifications2 = this.busSpecifications;
        if (busSpecifications2 != null) {
            i = busSpecifications2.hashCode();
        }
        return hashCode4 + i;
    }
}
