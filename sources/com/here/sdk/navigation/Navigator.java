package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.LanguageCode;
import com.here.sdk.core.Location;
import com.here.sdk.core.TransportProfile;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.routing.Maneuver;
import com.here.sdk.routing.RoadType;
import com.here.sdk.routing.Route;
import com.here.sdk.transport.TransportMode;
import java.util.List;

public final class Navigator extends NativeBase implements NavigatorInterface {
    public Navigator() throws InstantiationErrorException {
        this(make(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native List<LanguageCode> getAvailableLanguagesForManeuverNotifications();

    private static native long make() throws InstantiationErrorException;

    private static native long make(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException;

    private static native long make(@NonNull SDKNativeEngine sDKNativeEngine, @NonNull WallClock wallClock, @NonNull LocationProcessMode locationProcessMode) throws InstantiationErrorException;

    @Nullable
    public native Integer calculateRemainingDistanceInMeters(@NonNull GeoCoordinates geoCoordinates);

    @Nullable
    public native BorderCrossingWarningListener getBorderCrossingWarningListener();

    @NonNull
    public native BorderCrossingWarningOptions getBorderCrossingWarningOptions();

    @Nullable
    public native CurrentSituationLaneAssistanceViewListener getCurrentSituationLaneAssistanceViewListener();

    @Nullable
    public native DangerZoneWarningListener getDangerZoneWarningListener();

    @NonNull
    public native DangerZoneWarningOptions getDangerZoneWarningOptions();

    @Nullable
    public native DestinationReachedListener getDestinationReachedListener();

    @Nullable
    public native EnvironmentalZoneWarningListener getEnvironmentalZoneWarningListener();

    @NonNull
    public native EnvironmentalZoneWarningOptions getEnvironmentalZoneWarningOptions();

    @Nullable
    public native JunctionViewLaneAssistanceListener getJunctionViewLaneAssistanceListener();

    @Nullable
    public native Maneuver getManeuver(int i);

    @Nullable
    public native ManeuverNotificationListener getManeuverNotificationListener();

    @NonNull
    public native ManeuverNotificationOptions getManeuverNotificationOptions();

    @NonNull
    public native ManeuverNotificationTimingOptions getManeuverNotificationTimingOptions(@NonNull TransportMode transportMode, @NonNull RoadType roadType);

    @Nullable
    public native ManeuverViewLaneAssistanceListener getManeuverViewLaneAssistanceListener();

    @Nullable
    public native MilestoneStatusListener getMilestoneStatusListener();

    @Nullable
    public native NavigableLocationListener getNavigableLocationListener();

    @Nullable
    public native OffRoadDestinationReachedListener getOffRoadDestinationReachedListener();

    @Nullable
    public native OffRoadProgressListener getOffRoadProgressListener();

    @Nullable
    public native PostActionListener getPostActionListener();

    @Nullable
    public native RealisticViewWarningListener getRealisticViewWarningListener();

    @NonNull
    public native RealisticViewWarningOptions getRealisticViewWarningOptions();

    @Nullable
    public native RoadAttributesListener getRoadAttributesListener();

    @Nullable
    public native RoadSignWarningListener getRoadSignWarningListener();

    @NonNull
    public native RoadSignWarningOptions getRoadSignWarningOptions();

    @Nullable
    public native RoadTextsListener getRoadTextsListener();

    @Nullable
    public native Route getRoute();

    @Nullable
    public native RouteDeviationListener getRouteDeviationListener();

    @Nullable
    public native RouteProgressListener getRouteProgressListener();

    @Nullable
    public native SafetyCameraWarningListener getSafetyCameraWarningListener();

    @Nullable
    public native SchoolZoneWarningListener getSchoolZoneWarningListener();

    @NonNull
    public native SchoolZoneWarningOptions getSchoolZoneWarningOptions();

    @Nullable
    public native SpatialManeuverAzimuthListener getSpatialManeuverAzimuthListener();

    @Nullable
    public native SpatialManeuverNotificationListener getSpatialManeuverNotificationListener();

    @Nullable
    public native SpeedLimitListener getSpeedLimitListener();

    @Nullable
    public native SpeedWarningListener getSpeedWarningListener();

    @NonNull
    public native SpeedWarningOptions getSpeedWarningOptions();

    @Nullable
    public native TollStopWarningListener getTollStopWarningListener();

    @Nullable
    public native TransportProfile getTrackingTransportProfile();

    @Nullable
    public native TruckRestrictionsWarningListener getTruckRestrictionsWarningListener();

    @NonNull
    public native TruckRestrictionsWarningOptions getTruckRestrictionsWarningOptions();

    public native boolean isEnableTunnelExtrapolation();

    public native boolean isPassthroughWaypointsHandlingEnabled();

    public native void onLocationUpdated(@NonNull Location location);

    public native void repeatLastManeuverNotification();

    public native void setBorderCrossingWarningListener(@Nullable BorderCrossingWarningListener borderCrossingWarningListener);

    public native void setBorderCrossingWarningOptions(@NonNull BorderCrossingWarningOptions borderCrossingWarningOptions);

    public native void setCurrentSituationLaneAssistanceViewListener(@Nullable CurrentSituationLaneAssistanceViewListener currentSituationLaneAssistanceViewListener);

    public native void setCustomOption(@NonNull String str, @NonNull String str2);

    public native void setDangerZoneWarningListener(@Nullable DangerZoneWarningListener dangerZoneWarningListener);

    public native void setDangerZoneWarningOptions(@NonNull DangerZoneWarningOptions dangerZoneWarningOptions);

    public native void setDestinationReachedListener(@Nullable DestinationReachedListener destinationReachedListener);

    public native void setEnableTunnelExtrapolation(boolean z);

    public native void setEnvironmentalZoneWarningListener(@Nullable EnvironmentalZoneWarningListener environmentalZoneWarningListener);

    public native void setEnvironmentalZoneWarningOptions(@NonNull EnvironmentalZoneWarningOptions environmentalZoneWarningOptions);

    public native void setJunctionViewLaneAssistanceListener(@Nullable JunctionViewLaneAssistanceListener junctionViewLaneAssistanceListener);

    public native void setManeuverNotificationListener(@Nullable ManeuverNotificationListener maneuverNotificationListener);

    public native void setManeuverNotificationOptions(@NonNull ManeuverNotificationOptions maneuverNotificationOptions);

    public native boolean setManeuverNotificationTimingOptions(@NonNull TransportMode transportMode, @NonNull RoadType roadType, @NonNull ManeuverNotificationTimingOptions maneuverNotificationTimingOptions);

    public native void setManeuverViewLaneAssistanceListener(@Nullable ManeuverViewLaneAssistanceListener maneuverViewLaneAssistanceListener);

    public native void setMilestoneStatusListener(@Nullable MilestoneStatusListener milestoneStatusListener);

    public native void setNavigableLocationListener(@Nullable NavigableLocationListener navigableLocationListener);

    public native void setOffRoadDestinationReachedListener(@Nullable OffRoadDestinationReachedListener offRoadDestinationReachedListener);

    public native void setOffRoadProgressListener(@Nullable OffRoadProgressListener offRoadProgressListener);

    public native void setPassthroughWaypointsHandlingEnabled(boolean z);

    public native void setPostActionListener(@Nullable PostActionListener postActionListener);

    public native void setRealisticViewWarningListener(@Nullable RealisticViewWarningListener realisticViewWarningListener);

    public native void setRealisticViewWarningOptions(@NonNull RealisticViewWarningOptions realisticViewWarningOptions);

    public native void setRoadAttributesListener(@Nullable RoadAttributesListener roadAttributesListener);

    public native void setRoadSignWarningListener(@Nullable RoadSignWarningListener roadSignWarningListener);

    public native void setRoadSignWarningOptions(@NonNull RoadSignWarningOptions roadSignWarningOptions);

    public native void setRoadTextsListener(@Nullable RoadTextsListener roadTextsListener);

    public native void setRoute(@Nullable Route route);

    public native void setRouteDeviationListener(@Nullable RouteDeviationListener routeDeviationListener);

    public native void setRouteProgressListener(@Nullable RouteProgressListener routeProgressListener);

    public native void setSafetyCameraWarningListener(@Nullable SafetyCameraWarningListener safetyCameraWarningListener);

    public native void setSchoolZoneWarningListener(@Nullable SchoolZoneWarningListener schoolZoneWarningListener);

    public native void setSchoolZoneWarningOptions(@NonNull SchoolZoneWarningOptions schoolZoneWarningOptions);

    public native void setSpatialManeuverAzimuthListener(@Nullable SpatialManeuverAzimuthListener spatialManeuverAzimuthListener);

    public native void setSpatialManeuverNotificationListener(@Nullable SpatialManeuverNotificationListener spatialManeuverNotificationListener);

    public native void setSpeedLimitListener(@Nullable SpeedLimitListener speedLimitListener);

    public native void setSpeedWarningListener(@Nullable SpeedWarningListener speedWarningListener);

    public native void setSpeedWarningOptions(@NonNull SpeedWarningOptions speedWarningOptions);

    public native void setTollStopWarningListener(@Nullable TollStopWarningListener tollStopWarningListener);

    public native void setTrackingTransportProfile(@Nullable TransportProfile transportProfile);

    public native void setTruckRestrictionsWarningListener(@Nullable TruckRestrictionsWarningListener truckRestrictionsWarningListener);

    public native void setTruckRestrictionsWarningOptions(@NonNull TruckRestrictionsWarningOptions truckRestrictionsWarningOptions);

    public Navigator(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException {
        this(make(sDKNativeEngine), (Object) null);
        cacheThisInstance();
    }

    public Navigator(@NonNull SDKNativeEngine sDKNativeEngine, @NonNull WallClock wallClock, @NonNull LocationProcessMode locationProcessMode) throws InstantiationErrorException {
        this(make(sDKNativeEngine, wallClock, locationProcessMode), (Object) null);
        cacheThisInstance();
    }

    public Navigator(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Navigator.disposeNativeHandle(j);
            }
        });
    }
}
