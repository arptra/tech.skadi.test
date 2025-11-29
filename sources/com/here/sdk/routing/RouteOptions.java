package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Date;
import java.util.Objects;

public final class RouteOptions {
    public int alternatives;
    @Nullable
    public Date arrivalTime;
    @Nullable
    public Date departureTime;
    public boolean enableRouteHandle;
    public boolean enableTolls;
    @Deprecated
    public boolean enableTrafficOptimization;
    public int occupantsNumber;
    @NonNull
    public OptimizationMode optimizationMode;
    public boolean optimizeWaypointsOrder;
    @Nullable
    public Double speedCapInMetersPerSecond;
    @NonNull
    public TrafficOptimizationMode trafficOptimizationMode;

    public RouteOptions() {
        this.optimizationMode = OptimizationMode.FASTEST;
        this.alternatives = 0;
        this.departureTime = null;
        this.arrivalTime = null;
        this.speedCapInMetersPerSecond = null;
        this.enableRouteHandle = false;
        this.enableTrafficOptimization = true;
        this.trafficOptimizationMode = TrafficOptimizationMode.TIME_DEPENDENT;
        this.enableTolls = false;
        this.occupantsNumber = 1;
        this.optimizeWaypointsOrder = false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RouteOptions)) {
            return false;
        }
        RouteOptions routeOptions = (RouteOptions) obj;
        return Objects.equals(this.optimizationMode, routeOptions.optimizationMode) && this.alternatives == routeOptions.alternatives && Objects.equals(this.departureTime, routeOptions.departureTime) && Objects.equals(this.arrivalTime, routeOptions.arrivalTime) && Objects.equals(this.speedCapInMetersPerSecond, routeOptions.speedCapInMetersPerSecond) && this.enableRouteHandle == routeOptions.enableRouteHandle && this.enableTrafficOptimization == routeOptions.enableTrafficOptimization && Objects.equals(this.trafficOptimizationMode, routeOptions.trafficOptimizationMode) && this.enableTolls == routeOptions.enableTolls && this.occupantsNumber == routeOptions.occupantsNumber && this.optimizeWaypointsOrder == routeOptions.optimizeWaypointsOrder;
    }

    public int hashCode() {
        OptimizationMode optimizationMode2 = this.optimizationMode;
        int i = 0;
        int hashCode = (((217 + (optimizationMode2 != null ? optimizationMode2.hashCode() : 0)) * 31) + this.alternatives) * 31;
        Date date = this.departureTime;
        int hashCode2 = (hashCode + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.arrivalTime;
        int hashCode3 = (hashCode2 + (date2 != null ? date2.hashCode() : 0)) * 31;
        Double d = this.speedCapInMetersPerSecond;
        int i2 = 97;
        int hashCode4 = (((((hashCode3 + (d != null ? d.hashCode() : 0)) * 31) + (this.enableRouteHandle ? 79 : 97)) * 31) + (this.enableTrafficOptimization ? 79 : 97)) * 31;
        TrafficOptimizationMode trafficOptimizationMode2 = this.trafficOptimizationMode;
        if (trafficOptimizationMode2 != null) {
            i = trafficOptimizationMode2.hashCode();
        }
        int i3 = (((((hashCode4 + i) * 31) + (this.enableTolls ? 79 : 97)) * 31) + this.occupantsNumber) * 31;
        if (this.optimizeWaypointsOrder) {
            i2 = 79;
        }
        return i3 + i2;
    }

    public RouteOptions(@NonNull OptimizationMode optimizationMode2) {
        this.optimizationMode = optimizationMode2;
        this.alternatives = 0;
        this.departureTime = null;
        this.arrivalTime = null;
        this.speedCapInMetersPerSecond = null;
        this.enableRouteHandle = false;
        this.enableTrafficOptimization = true;
        this.trafficOptimizationMode = TrafficOptimizationMode.TIME_DEPENDENT;
        this.enableTolls = false;
        this.occupantsNumber = 1;
        this.optimizeWaypointsOrder = false;
    }

    public RouteOptions(@NonNull OptimizationMode optimizationMode2, int i) {
        this.optimizationMode = optimizationMode2;
        this.alternatives = i;
        this.departureTime = null;
        this.arrivalTime = null;
        this.speedCapInMetersPerSecond = null;
        this.enableRouteHandle = false;
        this.enableTrafficOptimization = true;
        this.trafficOptimizationMode = TrafficOptimizationMode.TIME_DEPENDENT;
        this.enableTolls = false;
        this.occupantsNumber = 1;
        this.optimizeWaypointsOrder = false;
    }

    public RouteOptions(@NonNull OptimizationMode optimizationMode2, int i, @Nullable Date date) {
        this.optimizationMode = optimizationMode2;
        this.alternatives = i;
        this.departureTime = date;
        this.arrivalTime = null;
        this.speedCapInMetersPerSecond = null;
        this.enableRouteHandle = false;
        this.enableTrafficOptimization = true;
        this.trafficOptimizationMode = TrafficOptimizationMode.TIME_DEPENDENT;
        this.enableTolls = false;
        this.occupantsNumber = 1;
        this.optimizeWaypointsOrder = false;
    }

    public RouteOptions(@NonNull OptimizationMode optimizationMode2, int i, @Nullable Date date, @Nullable Date date2) {
        this.optimizationMode = optimizationMode2;
        this.alternatives = i;
        this.departureTime = date;
        this.arrivalTime = date2;
        this.speedCapInMetersPerSecond = null;
        this.enableRouteHandle = false;
        this.enableTrafficOptimization = true;
        this.trafficOptimizationMode = TrafficOptimizationMode.TIME_DEPENDENT;
        this.enableTolls = false;
        this.occupantsNumber = 1;
        this.optimizeWaypointsOrder = false;
    }

    public RouteOptions(@NonNull OptimizationMode optimizationMode2, int i, @Nullable Date date, @Nullable Date date2, @Nullable Double d) {
        this.optimizationMode = optimizationMode2;
        this.alternatives = i;
        this.departureTime = date;
        this.arrivalTime = date2;
        this.speedCapInMetersPerSecond = d;
        this.enableRouteHandle = false;
        this.enableTrafficOptimization = true;
        this.trafficOptimizationMode = TrafficOptimizationMode.TIME_DEPENDENT;
        this.enableTolls = false;
        this.occupantsNumber = 1;
        this.optimizeWaypointsOrder = false;
    }

    public RouteOptions(@NonNull OptimizationMode optimizationMode2, int i, @Nullable Date date, @Nullable Date date2, @Nullable Double d, boolean z) {
        this.optimizationMode = optimizationMode2;
        this.alternatives = i;
        this.departureTime = date;
        this.arrivalTime = date2;
        this.speedCapInMetersPerSecond = d;
        this.enableRouteHandle = z;
        this.enableTrafficOptimization = true;
        this.trafficOptimizationMode = TrafficOptimizationMode.TIME_DEPENDENT;
        this.enableTolls = false;
        this.occupantsNumber = 1;
        this.optimizeWaypointsOrder = false;
    }

    public RouteOptions(@NonNull OptimizationMode optimizationMode2, int i, @Nullable Date date, @Nullable Date date2, @Nullable Double d, boolean z, @Deprecated boolean z2) {
        this.optimizationMode = optimizationMode2;
        this.alternatives = i;
        this.departureTime = date;
        this.arrivalTime = date2;
        this.speedCapInMetersPerSecond = d;
        this.enableRouteHandle = z;
        this.enableTrafficOptimization = z2;
        this.trafficOptimizationMode = TrafficOptimizationMode.TIME_DEPENDENT;
        this.enableTolls = false;
        this.occupantsNumber = 1;
        this.optimizeWaypointsOrder = false;
    }

    public RouteOptions(@NonNull OptimizationMode optimizationMode2, int i, @Nullable Date date, @Nullable Date date2, @Nullable Double d, boolean z, @Deprecated boolean z2, @NonNull TrafficOptimizationMode trafficOptimizationMode2) {
        this.optimizationMode = optimizationMode2;
        this.alternatives = i;
        this.departureTime = date;
        this.arrivalTime = date2;
        this.speedCapInMetersPerSecond = d;
        this.enableRouteHandle = z;
        this.enableTrafficOptimization = z2;
        this.trafficOptimizationMode = trafficOptimizationMode2;
        this.enableTolls = false;
        this.occupantsNumber = 1;
        this.optimizeWaypointsOrder = false;
    }

    public RouteOptions(@NonNull OptimizationMode optimizationMode2, int i, @Nullable Date date, @Nullable Date date2, @Nullable Double d, boolean z, @Deprecated boolean z2, @NonNull TrafficOptimizationMode trafficOptimizationMode2, boolean z3) {
        this.optimizationMode = optimizationMode2;
        this.alternatives = i;
        this.departureTime = date;
        this.arrivalTime = date2;
        this.speedCapInMetersPerSecond = d;
        this.enableRouteHandle = z;
        this.enableTrafficOptimization = z2;
        this.trafficOptimizationMode = trafficOptimizationMode2;
        this.enableTolls = z3;
        this.occupantsNumber = 1;
        this.optimizeWaypointsOrder = false;
    }

    public RouteOptions(@NonNull OptimizationMode optimizationMode2, int i, @Nullable Date date, @Nullable Date date2, @Nullable Double d, boolean z, @Deprecated boolean z2, @NonNull TrafficOptimizationMode trafficOptimizationMode2, boolean z3, int i2) {
        this.optimizationMode = optimizationMode2;
        this.alternatives = i;
        this.departureTime = date;
        this.arrivalTime = date2;
        this.speedCapInMetersPerSecond = d;
        this.enableRouteHandle = z;
        this.enableTrafficOptimization = z2;
        this.trafficOptimizationMode = trafficOptimizationMode2;
        this.enableTolls = z3;
        this.occupantsNumber = i2;
        this.optimizeWaypointsOrder = false;
    }

    public RouteOptions(@NonNull OptimizationMode optimizationMode2, int i, @Nullable Date date, @Nullable Date date2, @Nullable Double d, boolean z, @Deprecated boolean z2, @NonNull TrafficOptimizationMode trafficOptimizationMode2, boolean z3, int i2, boolean z4) {
        this.optimizationMode = optimizationMode2;
        this.alternatives = i;
        this.departureTime = date;
        this.arrivalTime = date2;
        this.speedCapInMetersPerSecond = d;
        this.enableRouteHandle = z;
        this.enableTrafficOptimization = z2;
        this.trafficOptimizationMode = trafficOptimizationMode2;
        this.enableTolls = z3;
        this.occupantsNumber = i2;
        this.optimizeWaypointsOrder = z4;
    }
}
