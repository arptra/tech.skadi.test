package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.GeoBox;
import com.here.sdk.core.GeoPolyline;
import com.here.sdk.core.LocationTime;
import com.here.time.Duration;
import java.util.List;

public final class Section extends NativeBase {
    private GeoPolyline cache_getGeometry;
    private List<Maneuver> cache_getManeuvers;
    private List<PostAction> cache_getPostActions;
    private List<PreAction> cache_getPreActions;
    private List<SectionNotice> cache_getSectionNotices;
    private List<Span> cache_getSpans;
    private List<Toll> cache_getTolls;
    private List<TrafficIncidentOnRoute> cache_getTrafficIncidents;
    private boolean is_cached_getGeometry = false;
    private boolean is_cached_getManeuvers = false;
    private boolean is_cached_getPostActions = false;
    private boolean is_cached_getPreActions = false;
    private boolean is_cached_getSectionNotices = false;
    private boolean is_cached_getSpans = false;
    private boolean is_cached_getTolls = false;
    private boolean is_cached_getTrafficIncidents = false;

    public Section(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Section.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private native GeoPolyline getGeometry_private();

    private native List<Maneuver> getManeuvers_private();

    private native List<PostAction> getPostActions_private();

    private native List<PreAction> getPreActions_private();

    private native List<SectionNotice> getSectionNotices_private();

    private native List<Span> getSpans_private();

    private native List<Toll> getTolls_private();

    private native List<TrafficIncidentOnRoute> getTrafficIncidents_private();

    @Nullable
    public native LocationTime getArrivalLocationTime();

    @NonNull
    public native RoutePlace getArrivalPlace();

    @NonNull
    public native GeoBox getBoundingBox();

    @Nullable
    public native LocationTime getDepartureLocationTime();

    @NonNull
    public native RoutePlace getDeparturePlace();

    @NonNull
    public native Duration getDuration();

    @Nullable
    public native EVDetails getEvDetails();

    @NonNull
    public GeoPolyline getGeometry() {
        if (!this.is_cached_getGeometry) {
            this.cache_getGeometry = getGeometry_private();
            this.is_cached_getGeometry = true;
        }
        return this.cache_getGeometry;
    }

    public native int getLengthInMeters();

    @NonNull
    public List<Maneuver> getManeuvers() {
        if (!this.is_cached_getManeuvers) {
            this.cache_getManeuvers = getManeuvers_private();
            this.is_cached_getManeuvers = true;
        }
        return this.cache_getManeuvers;
    }

    @NonNull
    public native List<PassThroughWaypoint> getPassthroughWaypoints();

    @NonNull
    public List<PostAction> getPostActions() {
        if (!this.is_cached_getPostActions) {
            this.cache_getPostActions = getPostActions_private();
            this.is_cached_getPostActions = true;
        }
        return this.cache_getPostActions;
    }

    @NonNull
    public List<PreAction> getPreActions() {
        if (!this.is_cached_getPreActions) {
            this.cache_getPreActions = getPreActions_private();
            this.is_cached_getPreActions = true;
        }
        return this.cache_getPreActions;
    }

    @NonNull
    public List<SectionNotice> getSectionNotices() {
        if (!this.is_cached_getSectionNotices) {
            this.cache_getSectionNotices = getSectionNotices_private();
            this.is_cached_getSectionNotices = true;
        }
        return this.cache_getSectionNotices;
    }

    @NonNull
    public native SectionTransportMode getSectionTransportMode();

    @NonNull
    public native SourceEngine getSourceEngine();

    @NonNull
    public List<Span> getSpans() {
        if (!this.is_cached_getSpans) {
            this.cache_getSpans = getSpans_private();
            this.is_cached_getSpans = true;
        }
        return this.cache_getSpans;
    }

    @NonNull
    public List<Toll> getTolls() {
        if (!this.is_cached_getTolls) {
            this.cache_getTolls = getTolls_private();
            this.is_cached_getTolls = true;
        }
        return this.cache_getTolls;
    }

    @NonNull
    public native Duration getTrafficDelay();

    @NonNull
    public List<TrafficIncidentOnRoute> getTrafficIncidents() {
        if (!this.is_cached_getTrafficIncidents) {
            this.cache_getTrafficIncidents = getTrafficIncidents_private();
            this.is_cached_getTrafficIncidents = true;
        }
        return this.cache_getTrafficIncidents;
    }

    @Nullable
    public native TransitSectionDetails getTransitDetails();
}
