package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.transport.HazardousMaterial;
import com.here.sdk.transport.TruckRoadType;
import com.here.sdk.transport.TruckSpecifications;
import com.here.sdk.transport.TunnelCategory;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class EVTruckOptions {
    @NonNull
    public AvoidanceOptions avoidanceOptions = new AvoidanceOptions();
    @NonNull
    public List<TruckRoadType> avoidedTruckRoadTypes = new ArrayList();
    @NonNull
    public EVConsumptionModel consumptionModel = new EVConsumptionModel();
    @NonNull
    public List<HazardousMaterial> hazardousMaterials = new ArrayList();
    @Nullable
    public TunnelCategory linkTunnelCategory = null;
    @NonNull
    public List<MaxSpeedOnSegment> maxSpeedOnSegments = new ArrayList();
    @NonNull
    public RouteOptions routeOptions = new RouteOptions();
    @NonNull
    public RouteTextOptions textOptions = new RouteTextOptions();
    @NonNull
    public TruckSpecifications truckSpecifications = new TruckSpecifications();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EVTruckOptions)) {
            return false;
        }
        EVTruckOptions eVTruckOptions = (EVTruckOptions) obj;
        return Objects.equals(this.routeOptions, eVTruckOptions.routeOptions) && Objects.equals(this.textOptions, eVTruckOptions.textOptions) && Objects.equals(this.avoidanceOptions, eVTruckOptions.avoidanceOptions) && Objects.equals(this.maxSpeedOnSegments, eVTruckOptions.maxSpeedOnSegments) && Objects.equals(this.truckSpecifications, eVTruckOptions.truckSpecifications) && Objects.equals(this.linkTunnelCategory, eVTruckOptions.linkTunnelCategory) && Objects.equals(this.hazardousMaterials, eVTruckOptions.hazardousMaterials) && Objects.equals(this.avoidedTruckRoadTypes, eVTruckOptions.avoidedTruckRoadTypes) && Objects.equals(this.consumptionModel, eVTruckOptions.consumptionModel);
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
        TruckSpecifications truckSpecifications2 = this.truckSpecifications;
        int hashCode5 = (hashCode4 + (truckSpecifications2 != null ? truckSpecifications2.hashCode() : 0)) * 31;
        TunnelCategory tunnelCategory = this.linkTunnelCategory;
        int hashCode6 = (hashCode5 + (tunnelCategory != null ? tunnelCategory.hashCode() : 0)) * 31;
        List<HazardousMaterial> list2 = this.hazardousMaterials;
        int hashCode7 = (hashCode6 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<TruckRoadType> list3 = this.avoidedTruckRoadTypes;
        int hashCode8 = (hashCode7 + (list3 != null ? list3.hashCode() : 0)) * 31;
        EVConsumptionModel eVConsumptionModel = this.consumptionModel;
        if (eVConsumptionModel != null) {
            i = eVConsumptionModel.hashCode();
        }
        return hashCode8 + i;
    }
}
