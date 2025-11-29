package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.LocationListener;
import com.here.sdk.core.TransportProfile;
import com.here.sdk.routing.Maneuver;
import com.here.sdk.routing.RoadType;
import com.here.sdk.routing.Route;
import com.here.sdk.transport.TransportMode;

public interface NavigatorInterface extends LocationListener {
    @Nullable
    Integer calculateRemainingDistanceInMeters(@NonNull GeoCoordinates geoCoordinates);

    @Nullable
    BorderCrossingWarningListener getBorderCrossingWarningListener();

    @NonNull
    BorderCrossingWarningOptions getBorderCrossingWarningOptions();

    @Nullable
    CurrentSituationLaneAssistanceViewListener getCurrentSituationLaneAssistanceViewListener();

    @Nullable
    DangerZoneWarningListener getDangerZoneWarningListener();

    @NonNull
    DangerZoneWarningOptions getDangerZoneWarningOptions();

    @Nullable
    DestinationReachedListener getDestinationReachedListener();

    @Nullable
    EnvironmentalZoneWarningListener getEnvironmentalZoneWarningListener();

    @NonNull
    EnvironmentalZoneWarningOptions getEnvironmentalZoneWarningOptions();

    @Nullable
    JunctionViewLaneAssistanceListener getJunctionViewLaneAssistanceListener();

    @Nullable
    Maneuver getManeuver(int i);

    @Nullable
    ManeuverNotificationListener getManeuverNotificationListener();

    @NonNull
    ManeuverNotificationOptions getManeuverNotificationOptions();

    @NonNull
    ManeuverNotificationTimingOptions getManeuverNotificationTimingOptions(@NonNull TransportMode transportMode, @NonNull RoadType roadType);

    @Nullable
    ManeuverViewLaneAssistanceListener getManeuverViewLaneAssistanceListener();

    @Nullable
    MilestoneStatusListener getMilestoneStatusListener();

    @Nullable
    NavigableLocationListener getNavigableLocationListener();

    @Nullable
    OffRoadDestinationReachedListener getOffRoadDestinationReachedListener();

    @Nullable
    OffRoadProgressListener getOffRoadProgressListener();

    @Nullable
    PostActionListener getPostActionListener();

    @Nullable
    RealisticViewWarningListener getRealisticViewWarningListener();

    @NonNull
    RealisticViewWarningOptions getRealisticViewWarningOptions();

    @Nullable
    RoadAttributesListener getRoadAttributesListener();

    @Nullable
    RoadSignWarningListener getRoadSignWarningListener();

    @NonNull
    RoadSignWarningOptions getRoadSignWarningOptions();

    @Nullable
    RoadTextsListener getRoadTextsListener();

    @Nullable
    Route getRoute();

    @Nullable
    RouteDeviationListener getRouteDeviationListener();

    @Nullable
    RouteProgressListener getRouteProgressListener();

    @Nullable
    SafetyCameraWarningListener getSafetyCameraWarningListener();

    @Nullable
    SchoolZoneWarningListener getSchoolZoneWarningListener();

    @NonNull
    SchoolZoneWarningOptions getSchoolZoneWarningOptions();

    @Nullable
    SpatialManeuverAzimuthListener getSpatialManeuverAzimuthListener();

    @Nullable
    SpatialManeuverNotificationListener getSpatialManeuverNotificationListener();

    @Nullable
    SpeedLimitListener getSpeedLimitListener();

    @Nullable
    SpeedWarningListener getSpeedWarningListener();

    @NonNull
    SpeedWarningOptions getSpeedWarningOptions();

    @Nullable
    TollStopWarningListener getTollStopWarningListener();

    @Nullable
    TransportProfile getTrackingTransportProfile();

    @Nullable
    TruckRestrictionsWarningListener getTruckRestrictionsWarningListener();

    @NonNull
    TruckRestrictionsWarningOptions getTruckRestrictionsWarningOptions();

    boolean isEnableTunnelExtrapolation();

    boolean isPassthroughWaypointsHandlingEnabled();

    void repeatLastManeuverNotification();

    void setBorderCrossingWarningListener(@Nullable BorderCrossingWarningListener borderCrossingWarningListener);

    void setBorderCrossingWarningOptions(@NonNull BorderCrossingWarningOptions borderCrossingWarningOptions);

    void setCurrentSituationLaneAssistanceViewListener(@Nullable CurrentSituationLaneAssistanceViewListener currentSituationLaneAssistanceViewListener);

    void setCustomOption(@NonNull String str, @NonNull String str2);

    void setDangerZoneWarningListener(@Nullable DangerZoneWarningListener dangerZoneWarningListener);

    void setDangerZoneWarningOptions(@NonNull DangerZoneWarningOptions dangerZoneWarningOptions);

    void setDestinationReachedListener(@Nullable DestinationReachedListener destinationReachedListener);

    void setEnableTunnelExtrapolation(boolean z);

    void setEnvironmentalZoneWarningListener(@Nullable EnvironmentalZoneWarningListener environmentalZoneWarningListener);

    void setEnvironmentalZoneWarningOptions(@NonNull EnvironmentalZoneWarningOptions environmentalZoneWarningOptions);

    void setJunctionViewLaneAssistanceListener(@Nullable JunctionViewLaneAssistanceListener junctionViewLaneAssistanceListener);

    void setManeuverNotificationListener(@Nullable ManeuverNotificationListener maneuverNotificationListener);

    void setManeuverNotificationOptions(@NonNull ManeuverNotificationOptions maneuverNotificationOptions);

    boolean setManeuverNotificationTimingOptions(@NonNull TransportMode transportMode, @NonNull RoadType roadType, @NonNull ManeuverNotificationTimingOptions maneuverNotificationTimingOptions);

    void setManeuverViewLaneAssistanceListener(@Nullable ManeuverViewLaneAssistanceListener maneuverViewLaneAssistanceListener);

    void setMilestoneStatusListener(@Nullable MilestoneStatusListener milestoneStatusListener);

    void setNavigableLocationListener(@Nullable NavigableLocationListener navigableLocationListener);

    void setOffRoadDestinationReachedListener(@Nullable OffRoadDestinationReachedListener offRoadDestinationReachedListener);

    void setOffRoadProgressListener(@Nullable OffRoadProgressListener offRoadProgressListener);

    void setPassthroughWaypointsHandlingEnabled(boolean z);

    void setPostActionListener(@Nullable PostActionListener postActionListener);

    void setRealisticViewWarningListener(@Nullable RealisticViewWarningListener realisticViewWarningListener);

    void setRealisticViewWarningOptions(@NonNull RealisticViewWarningOptions realisticViewWarningOptions);

    void setRoadAttributesListener(@Nullable RoadAttributesListener roadAttributesListener);

    void setRoadSignWarningListener(@Nullable RoadSignWarningListener roadSignWarningListener);

    void setRoadSignWarningOptions(@NonNull RoadSignWarningOptions roadSignWarningOptions);

    void setRoadTextsListener(@Nullable RoadTextsListener roadTextsListener);

    void setRoute(@Nullable Route route);

    void setRouteDeviationListener(@Nullable RouteDeviationListener routeDeviationListener);

    void setRouteProgressListener(@Nullable RouteProgressListener routeProgressListener);

    void setSafetyCameraWarningListener(@Nullable SafetyCameraWarningListener safetyCameraWarningListener);

    void setSchoolZoneWarningListener(@Nullable SchoolZoneWarningListener schoolZoneWarningListener);

    void setSchoolZoneWarningOptions(@NonNull SchoolZoneWarningOptions schoolZoneWarningOptions);

    void setSpatialManeuverAzimuthListener(@Nullable SpatialManeuverAzimuthListener spatialManeuverAzimuthListener);

    void setSpatialManeuverNotificationListener(@Nullable SpatialManeuverNotificationListener spatialManeuverNotificationListener);

    void setSpeedLimitListener(@Nullable SpeedLimitListener speedLimitListener);

    void setSpeedWarningListener(@Nullable SpeedWarningListener speedWarningListener);

    void setSpeedWarningOptions(@NonNull SpeedWarningOptions speedWarningOptions);

    void setTollStopWarningListener(@Nullable TollStopWarningListener tollStopWarningListener);

    void setTrackingTransportProfile(@Nullable TransportProfile transportProfile);

    void setTruckRestrictionsWarningListener(@Nullable TruckRestrictionsWarningListener truckRestrictionsWarningListener);

    void setTruckRestrictionsWarningOptions(@NonNull TruckRestrictionsWarningOptions truckRestrictionsWarningOptions);
}
