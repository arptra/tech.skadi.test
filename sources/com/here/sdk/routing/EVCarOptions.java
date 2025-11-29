package com.here.sdk.routing;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class EVCarOptions {
    @NonNull
    public AvoidanceOptions avoidanceOptions = new AvoidanceOptions();
    @NonNull
    public BatterySpecifications batterySpecifications = new BatterySpecifications();
    @NonNull
    public EVConsumptionModel consumptionModel = new EVConsumptionModel();
    public boolean ensureReachability = false;
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
        if (!(obj instanceof EVCarOptions)) {
            return false;
        }
        EVCarOptions eVCarOptions = (EVCarOptions) obj;
        return Objects.equals(this.routeOptions, eVCarOptions.routeOptions) && Objects.equals(this.textOptions, eVCarOptions.textOptions) && Objects.equals(this.avoidanceOptions, eVCarOptions.avoidanceOptions) && Objects.equals(this.maxSpeedOnSegments, eVCarOptions.maxSpeedOnSegments) && this.ensureReachability == eVCarOptions.ensureReachability && Objects.equals(this.consumptionModel, eVCarOptions.consumptionModel) && Objects.equals(this.batterySpecifications, eVCarOptions.batterySpecifications);
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
        int hashCode4 = (((hashCode3 + (list != null ? list.hashCode() : 0)) * 31) + (this.ensureReachability ? 79 : 97)) * 31;
        EVConsumptionModel eVConsumptionModel = this.consumptionModel;
        int hashCode5 = (hashCode4 + (eVConsumptionModel != null ? eVConsumptionModel.hashCode() : 0)) * 31;
        BatterySpecifications batterySpecifications2 = this.batterySpecifications;
        if (batterySpecifications2 != null) {
            i = batterySpecifications2.hashCode();
        }
        return hashCode5 + i;
    }
}
