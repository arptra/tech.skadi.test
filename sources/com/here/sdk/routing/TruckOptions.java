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

public final class TruckOptions {
    @NonNull
    public AvoidanceOptions avoidanceOptions = new AvoidanceOptions();
    @NonNull
    public List<TruckRoadType> avoidedTruckRoadTypes = new ArrayList();
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
        if (!(obj instanceof TruckOptions)) {
            return false;
        }
        TruckOptions truckOptions = (TruckOptions) obj;
        return Objects.equals(this.routeOptions, truckOptions.routeOptions) && Objects.equals(this.textOptions, truckOptions.textOptions) && Objects.equals(this.avoidanceOptions, truckOptions.avoidanceOptions) && Objects.equals(this.maxSpeedOnSegments, truckOptions.maxSpeedOnSegments) && Objects.equals(this.truckSpecifications, truckOptions.truckSpecifications) && Objects.equals(this.linkTunnelCategory, truckOptions.linkTunnelCategory) && Objects.equals(this.hazardousMaterials, truckOptions.hazardousMaterials) && Objects.equals(this.avoidedTruckRoadTypes, truckOptions.avoidedTruckRoadTypes);
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
        if (list3 != null) {
            i = list3.hashCode();
        }
        return hashCode7 + i;
    }
}
