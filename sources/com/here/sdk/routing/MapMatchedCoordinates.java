package com.here.sdk.routing;

import androidx.annotation.NonNull;
import com.here.sdk.core.GeoCoordinates;
import java.util.Objects;

public final class MapMatchedCoordinates {
    @NonNull
    public GeoCoordinates matchedCoordinates;
    @NonNull
    public GeoCoordinates originalCoordinates;

    public MapMatchedCoordinates(@NonNull GeoCoordinates geoCoordinates, @NonNull GeoCoordinates geoCoordinates2) {
        this.originalCoordinates = geoCoordinates;
        this.matchedCoordinates = geoCoordinates2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapMatchedCoordinates)) {
            return false;
        }
        MapMatchedCoordinates mapMatchedCoordinates = (MapMatchedCoordinates) obj;
        return Objects.equals(this.originalCoordinates, mapMatchedCoordinates.originalCoordinates) && Objects.equals(this.matchedCoordinates, mapMatchedCoordinates.matchedCoordinates);
    }

    public int hashCode() {
        GeoCoordinates geoCoordinates = this.originalCoordinates;
        int i = 0;
        int hashCode = (217 + (geoCoordinates != null ? geoCoordinates.hashCode() : 0)) * 31;
        GeoCoordinates geoCoordinates2 = this.matchedCoordinates;
        if (geoCoordinates2 != null) {
            i = geoCoordinates2.hashCode();
        }
        return hashCode + i;
    }
}
