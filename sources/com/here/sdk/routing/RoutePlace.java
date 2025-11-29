package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.GeoCoordinates;
import java.util.Objects;

public final class RoutePlace {
    @Nullable
    public Double chargeInKilowattHours;
    @Nullable
    public ChargingStation chargingStation;
    @Nullable
    public String id;
    @Nullable
    IndoorLocationDataInternal indoorLocation;
    @NonNull
    public GeoCoordinates mapMatchedCoordinates;
    @Nullable
    public String name;
    @Nullable
    public GeoCoordinates originalCoordinates;
    @Nullable
    public String platform;
    @Nullable
    public SideOfDestination sideOfDestination;
    @NonNull
    public RoutePlaceType type;
    @Nullable
    public Integer waypointIndex;

    public RoutePlace(@NonNull RoutePlaceType routePlaceType, @Nullable Integer num, @Nullable GeoCoordinates geoCoordinates, @NonNull GeoCoordinates geoCoordinates2, @Nullable Double d, @Nullable ChargingStation chargingStation2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable SideOfDestination sideOfDestination2, @Nullable IndoorLocationDataInternal indoorLocationDataInternal) {
        this.type = routePlaceType;
        this.waypointIndex = num;
        this.originalCoordinates = geoCoordinates;
        this.mapMatchedCoordinates = geoCoordinates2;
        this.chargeInKilowattHours = d;
        this.chargingStation = chargingStation2;
        this.name = str;
        this.id = str2;
        this.platform = str3;
        this.sideOfDestination = sideOfDestination2;
        this.indoorLocation = indoorLocationDataInternal;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RoutePlace)) {
            return false;
        }
        RoutePlace routePlace = (RoutePlace) obj;
        return Objects.equals(this.type, routePlace.type) && Objects.equals(this.waypointIndex, routePlace.waypointIndex) && Objects.equals(this.originalCoordinates, routePlace.originalCoordinates) && Objects.equals(this.mapMatchedCoordinates, routePlace.mapMatchedCoordinates) && Objects.equals(this.chargeInKilowattHours, routePlace.chargeInKilowattHours) && Objects.equals(this.chargingStation, routePlace.chargingStation) && Objects.equals(this.name, routePlace.name) && Objects.equals(this.id, routePlace.id) && Objects.equals(this.platform, routePlace.platform) && Objects.equals(this.sideOfDestination, routePlace.sideOfDestination) && Objects.equals(this.indoorLocation, routePlace.indoorLocation);
    }

    public int hashCode() {
        RoutePlaceType routePlaceType = this.type;
        int i = 0;
        int hashCode = (217 + (routePlaceType != null ? routePlaceType.hashCode() : 0)) * 31;
        Integer num = this.waypointIndex;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        GeoCoordinates geoCoordinates = this.originalCoordinates;
        int hashCode3 = (hashCode2 + (geoCoordinates != null ? geoCoordinates.hashCode() : 0)) * 31;
        GeoCoordinates geoCoordinates2 = this.mapMatchedCoordinates;
        int hashCode4 = (hashCode3 + (geoCoordinates2 != null ? geoCoordinates2.hashCode() : 0)) * 31;
        Double d = this.chargeInKilowattHours;
        int hashCode5 = (hashCode4 + (d != null ? d.hashCode() : 0)) * 31;
        ChargingStation chargingStation2 = this.chargingStation;
        int hashCode6 = (hashCode5 + (chargingStation2 != null ? chargingStation2.hashCode() : 0)) * 31;
        String str = this.name;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.id;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.platform;
        int hashCode9 = (hashCode8 + (str3 != null ? str3.hashCode() : 0)) * 31;
        SideOfDestination sideOfDestination2 = this.sideOfDestination;
        int hashCode10 = (hashCode9 + (sideOfDestination2 != null ? sideOfDestination2.hashCode() : 0)) * 31;
        IndoorLocationDataInternal indoorLocationDataInternal = this.indoorLocation;
        if (indoorLocationDataInternal != null) {
            i = indoorLocationDataInternal.hashCode();
        }
        return hashCode10 + i;
    }

    public native boolean isOffRoad();
}
