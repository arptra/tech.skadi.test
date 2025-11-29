package com.here.sdk.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.GeoBox;
import com.here.sdk.core.GeoCoordinates;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class LocationDetails {
    @NonNull
    public List<GeoCoordinates> accessPoints = new ArrayList();
    @Nullable
    public GeoBox boundingBox = null;
    @NonNull
    public GeoCoordinates coordinates;
    public boolean coordinatesInterpolated = false;

    public LocationDetails(@NonNull GeoCoordinates geoCoordinates) {
        this.coordinates = geoCoordinates;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocationDetails)) {
            return false;
        }
        LocationDetails locationDetails = (LocationDetails) obj;
        return Objects.equals(this.coordinates, locationDetails.coordinates) && this.coordinatesInterpolated == locationDetails.coordinatesInterpolated && Objects.equals(this.accessPoints, locationDetails.accessPoints) && Objects.equals(this.boundingBox, locationDetails.boundingBox);
    }

    public int hashCode() {
        GeoCoordinates geoCoordinates = this.coordinates;
        int i = 0;
        int hashCode = (((217 + (geoCoordinates != null ? geoCoordinates.hashCode() : 0)) * 31) + (this.coordinatesInterpolated ? 79 : 97)) * 31;
        List<GeoCoordinates> list = this.accessPoints;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        GeoBox geoBox = this.boundingBox;
        if (geoBox != null) {
            i = geoBox.hashCode();
        }
        return hashCode2 + i;
    }
}
