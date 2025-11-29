package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.GeoPolyline;
import com.here.sdk.core.LocalizedTexts;
import com.here.time.Duration;
import java.util.List;

public final class Span extends NativeBase {
    public Span(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Span.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native Duration getBaseDuration();

    @NonNull
    public native List<AccessAttributes> getCarAttributes();

    @Nullable
    public native Double getConsumptionInKilowattHours();

    @Nullable
    public native String getCountryCode();

    @NonNull
    public native Duration getDuration();

    @Nullable
    public native DynamicSpeedInfo getDynamicSpeedInfo();

    @Nullable
    public native FunctionalRoadClass getFunctionalRoadClass();

    @NonNull
    public native GeoPolyline getGeometry();

    public native int getLengthInMeters();

    @NonNull
    public native List<Integer> getNoticeIndexes();

    @NonNull
    @Deprecated
    public native List<GeoCoordinates> getPolyline();

    @Nullable
    public native RouteRailwayCrossingType getRailwayCrossingType();

    @NonNull
    public native LocalizedRoadNumbers getRoadNumbers();

    @NonNull
    public native List<AccessAttributes> getScooterAttributes();

    public native int getSectionPolylineOffset();

    @NonNull
    public native SegmentReference getSegmentReference();

    @NonNull
    public native String getShieldText(@NonNull LocalizedRoadNumber localizedRoadNumber);

    @Nullable
    public native Double getSpeedLimitInMetersPerSecond();

    @Nullable
    public native String getStateCode();

    @NonNull
    public native List<StreetAttributes> getStreetAttributes();

    @NonNull
    public native LocalizedTexts getStreetNames();

    @NonNull
    public native List<Integer> getTrafficIncidentIndexes();

    @NonNull
    public native TrafficSpeed getTrafficSpeed();

    @NonNull
    public native List<AccessAttributes> getTruckAttributes();

    @NonNull
    public native List<WalkAttributes> getWalkAttributes();
}
