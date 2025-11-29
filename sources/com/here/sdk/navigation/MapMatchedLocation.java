package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.routing.SegmentReference;
import java.util.Objects;

public final class MapMatchedLocation {
    @Nullable
    public Double bearingInDegrees;
    public double confidence = 0.0d;
    @NonNull
    public GeoCoordinates coordinates;
    public long segmentOffsetInCentimeters = 0;
    @NonNull
    public SegmentReference segmentReference = new SegmentReference();

    public MapMatchedLocation(@NonNull GeoCoordinates geoCoordinates, @Nullable Double d) {
        this.coordinates = geoCoordinates;
        this.bearingInDegrees = d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapMatchedLocation)) {
            return false;
        }
        MapMatchedLocation mapMatchedLocation = (MapMatchedLocation) obj;
        return Objects.equals(this.coordinates, mapMatchedLocation.coordinates) && Objects.equals(this.bearingInDegrees, mapMatchedLocation.bearingInDegrees) && Objects.equals(this.segmentReference, mapMatchedLocation.segmentReference) && this.segmentOffsetInCentimeters == mapMatchedLocation.segmentOffsetInCentimeters && Double.compare(this.confidence, mapMatchedLocation.confidence) == 0;
    }

    public int hashCode() {
        GeoCoordinates geoCoordinates = this.coordinates;
        int i = 0;
        int hashCode = (217 + (geoCoordinates != null ? geoCoordinates.hashCode() : 0)) * 31;
        Double d = this.bearingInDegrees;
        int hashCode2 = (hashCode + (d != null ? d.hashCode() : 0)) * 31;
        SegmentReference segmentReference2 = this.segmentReference;
        if (segmentReference2 != null) {
            i = segmentReference2.hashCode();
        }
        long j = this.segmentOffsetInCentimeters;
        return ((((hashCode2 + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (Double.doubleToLongBits(this.confidence) ^ (Double.doubleToLongBits(this.confidence) >>> 32)));
    }
}
