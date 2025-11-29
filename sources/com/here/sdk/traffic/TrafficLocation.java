package com.here.sdk.traffic;

import androidx.annotation.NonNull;
import com.here.sdk.core.GeoPolyline;
import java.util.Objects;

public final class TrafficLocation {
    @NonNull
    public String description = "";
    public int lengthInMeters;
    @NonNull
    public GeoPolyline polyline;

    public TrafficLocation(@NonNull GeoPolyline geoPolyline, int i) {
        this.polyline = geoPolyline;
        this.lengthInMeters = i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrafficLocation)) {
            return false;
        }
        TrafficLocation trafficLocation = (TrafficLocation) obj;
        return Objects.equals(this.description, trafficLocation.description) && Objects.equals(this.polyline, trafficLocation.polyline) && this.lengthInMeters == trafficLocation.lengthInMeters;
    }

    public int hashCode() {
        String str = this.description;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        GeoPolyline geoPolyline = this.polyline;
        if (geoPolyline != null) {
            i = geoPolyline.hashCode();
        }
        return ((hashCode + i) * 31) + this.lengthInMeters;
    }
}
