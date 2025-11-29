package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.GeoBox;
import com.here.sdk.core.GeoPolyline;
import com.here.sdk.core.LanguageCode;
import com.here.sdk.transport.TransportMode;
import com.here.time.Duration;
import java.util.List;

public final class Route extends NativeBase {
    private GeoPolyline cache_getGeometry;
    private List<RouteRailwayCrossing> cache_getRailwayCrossings;
    private List<Section> cache_getSections;
    private boolean is_cached_getGeometry = false;
    private boolean is_cached_getRailwayCrossings = false;
    private boolean is_cached_getSections = false;

    public Route(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Route.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private native GeoPolyline getGeometry_private();

    private native List<RouteRailwayCrossing> getRailwayCrossings_private();

    private native List<Section> getSections_private();

    @NonNull
    public native GeoBox getBoundingBox();

    @NonNull
    public native Duration getDuration();

    @Nullable
    public native EVDetails getEVDetails();

    @NonNull
    public GeoPolyline getGeometry() {
        if (!this.is_cached_getGeometry) {
            this.cache_getGeometry = getGeometry_private();
            this.is_cached_getGeometry = true;
        }
        return this.cache_getGeometry;
    }

    @NonNull
    public native LanguageCode getLanguage();

    public native int getLengthInMeters();

    @NonNull
    public native OptimizationMode getOptimizationMode();

    @NonNull
    public List<RouteRailwayCrossing> getRailwayCrossings() {
        if (!this.is_cached_getRailwayCrossings) {
            this.cache_getRailwayCrossings = getRailwayCrossings_private();
            this.is_cached_getRailwayCrossings = true;
        }
        return this.cache_getRailwayCrossings;
    }

    @NonNull
    public native TransportMode getRequestedTransportMode();

    @Nullable
    public native RouteHandle getRouteHandle();

    @NonNull
    public List<Section> getSections() {
        if (!this.is_cached_getSections) {
            this.cache_getSections = getSections_private();
            this.is_cached_getSections = true;
        }
        return this.cache_getSections;
    }

    @NonNull
    public native Duration getTrafficDelay();
}
