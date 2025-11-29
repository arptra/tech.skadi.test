package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.GeoCoordinates;
import java.util.Objects;

public final class TransitWaypoint {
    @NonNull
    public GeoCoordinates coordinates;
    @Nullable
    public String placeName = null;

    public TransitWaypoint(@NonNull GeoCoordinates geoCoordinates) {
        this.coordinates = geoCoordinates;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransitWaypoint)) {
            return false;
        }
        TransitWaypoint transitWaypoint = (TransitWaypoint) obj;
        return Objects.equals(this.coordinates, transitWaypoint.coordinates) && Objects.equals(this.placeName, transitWaypoint.placeName);
    }

    public int hashCode() {
        GeoCoordinates geoCoordinates = this.coordinates;
        int i = 0;
        int hashCode = (217 + (geoCoordinates != null ? geoCoordinates.hashCode() : 0)) * 31;
        String str = this.placeName;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }
}
