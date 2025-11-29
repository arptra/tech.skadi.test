package com.here.sdk.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

public final class GeoOrientationUpdate {
    @Nullable
    public final Double bearing;
    @Nullable
    public final Double tilt;

    public GeoOrientationUpdate(@Nullable Double d, @Nullable Double d2) {
        GeoOrientationUpdate make = make(d, d2);
        this.bearing = make.bearing;
        this.tilt = make.tilt;
    }

    private static native GeoOrientationUpdate make(@NonNull GeoOrientation geoOrientation);

    private static native GeoOrientationUpdate make(@Nullable Double d, @Nullable Double d2);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GeoOrientationUpdate)) {
            return false;
        }
        GeoOrientationUpdate geoOrientationUpdate = (GeoOrientationUpdate) obj;
        return Objects.equals(this.bearing, geoOrientationUpdate.bearing) && Objects.equals(this.tilt, geoOrientationUpdate.tilt);
    }

    public int hashCode() {
        Double d = this.bearing;
        int i = 0;
        int hashCode = (217 + (d != null ? d.hashCode() : 0)) * 31;
        Double d2 = this.tilt;
        if (d2 != null) {
            i = d2.hashCode();
        }
        return hashCode + i;
    }

    public GeoOrientationUpdate(@NonNull GeoOrientation geoOrientation) {
        GeoOrientationUpdate make = make(geoOrientation);
        this.bearing = make.bearing;
        this.tilt = make.tilt;
    }
}
