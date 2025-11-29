package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.GeoCoordinates;
import com.here.time.Duration;
import java.util.Objects;

public final class Waypoint {
    @NonNull
    public GeoCoordinates coordinates;
    @NonNull
    public Duration duration;
    @Nullable
    public Double headingInDegrees;
    @Nullable
    public MatchSideOfStreet matchSideOfStreet;
    @Nullable
    public Integer minCourseDistanceInMeters;
    @Nullable
    public String nameHint;
    @Nullable
    public Integer onRoadThresholdInMeters;
    @Nullable
    public SegmentReference segmentHint;
    @Nullable
    public GeoCoordinates sideOfStreetHint;
    public int transitRadiusInMeters;
    @NonNull
    public WaypointType type;

    public Waypoint(@NonNull GeoCoordinates geoCoordinates) {
        this.coordinates = geoCoordinates;
        this.type = WaypointType.STOPOVER;
        this.transitRadiusInMeters = 0;
        this.headingInDegrees = null;
        this.sideOfStreetHint = null;
        this.minCourseDistanceInMeters = null;
        this.nameHint = null;
        this.matchSideOfStreet = null;
        this.duration = Duration.ofSeconds(0);
        this.segmentHint = null;
        this.onRoadThresholdInMeters = null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Waypoint)) {
            return false;
        }
        Waypoint waypoint = (Waypoint) obj;
        return Objects.equals(this.coordinates, waypoint.coordinates) && Objects.equals(this.type, waypoint.type) && this.transitRadiusInMeters == waypoint.transitRadiusInMeters && Objects.equals(this.headingInDegrees, waypoint.headingInDegrees) && Objects.equals(this.sideOfStreetHint, waypoint.sideOfStreetHint) && Objects.equals(this.minCourseDistanceInMeters, waypoint.minCourseDistanceInMeters) && Objects.equals(this.nameHint, waypoint.nameHint) && Objects.equals(this.matchSideOfStreet, waypoint.matchSideOfStreet) && Objects.equals(this.duration, waypoint.duration) && Objects.equals(this.segmentHint, waypoint.segmentHint) && Objects.equals(this.onRoadThresholdInMeters, waypoint.onRoadThresholdInMeters);
    }

    public int hashCode() {
        GeoCoordinates geoCoordinates = this.coordinates;
        int i = 0;
        int hashCode = (217 + (geoCoordinates != null ? geoCoordinates.hashCode() : 0)) * 31;
        WaypointType waypointType = this.type;
        int hashCode2 = (((hashCode + (waypointType != null ? waypointType.hashCode() : 0)) * 31) + this.transitRadiusInMeters) * 31;
        Double d = this.headingInDegrees;
        int hashCode3 = (hashCode2 + (d != null ? d.hashCode() : 0)) * 31;
        GeoCoordinates geoCoordinates2 = this.sideOfStreetHint;
        int hashCode4 = (hashCode3 + (geoCoordinates2 != null ? geoCoordinates2.hashCode() : 0)) * 31;
        Integer num = this.minCourseDistanceInMeters;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.nameHint;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 31;
        MatchSideOfStreet matchSideOfStreet2 = this.matchSideOfStreet;
        int hashCode7 = (hashCode6 + (matchSideOfStreet2 != null ? matchSideOfStreet2.hashCode() : 0)) * 31;
        Duration duration2 = this.duration;
        int hashCode8 = (hashCode7 + (duration2 != null ? duration2.hashCode() : 0)) * 31;
        SegmentReference segmentReference = this.segmentHint;
        int hashCode9 = (hashCode8 + (segmentReference != null ? segmentReference.hashCode() : 0)) * 31;
        Integer num2 = this.onRoadThresholdInMeters;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode9 + i;
    }

    public Waypoint(@NonNull GeoCoordinates geoCoordinates, @NonNull WaypointType waypointType, int i, @Nullable Double d, @Nullable GeoCoordinates geoCoordinates2, @Nullable Integer num, @NonNull Duration duration2) {
        this.coordinates = geoCoordinates;
        this.type = waypointType;
        this.transitRadiusInMeters = i;
        this.headingInDegrees = d;
        this.sideOfStreetHint = geoCoordinates2;
        this.minCourseDistanceInMeters = num;
        this.duration = duration2;
        this.nameHint = null;
        this.matchSideOfStreet = null;
        this.segmentHint = null;
        this.onRoadThresholdInMeters = null;
    }

    public Waypoint(@NonNull GeoCoordinates geoCoordinates, @NonNull WaypointType waypointType, int i, @Nullable Double d, @Nullable GeoCoordinates geoCoordinates2, @Nullable Integer num, @Nullable String str, @NonNull Duration duration2) {
        this.coordinates = geoCoordinates;
        this.type = waypointType;
        this.transitRadiusInMeters = i;
        this.headingInDegrees = d;
        this.sideOfStreetHint = geoCoordinates2;
        this.minCourseDistanceInMeters = num;
        this.nameHint = str;
        this.duration = duration2;
        this.matchSideOfStreet = null;
        this.segmentHint = null;
        this.onRoadThresholdInMeters = null;
    }
}
