package com.here.sdk.core;

import androidx.annotation.NonNull;
import com.here.sdk.core.errors.InstantiationErrorException;
import java.util.List;
import java.util.Objects;

public final class GeoPolyline {
    @NonNull
    public final List<GeoCoordinates> vertices;

    public GeoPolyline(@NonNull List<GeoCoordinates> list) throws InstantiationErrorException {
        this.vertices = make(list).vertices;
    }

    private static native GeoPolyline make(@NonNull List<GeoCoordinates> list) throws InstantiationErrorException;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GeoPolyline)) {
            return false;
        }
        return Objects.equals(this.vertices, ((GeoPolyline) obj).vertices);
    }

    public native long getNearestIndexTo(@NonNull GeoCoordinates geoCoordinates);

    @NonNull
    public native GeoCoordinates getNearestTo(@NonNull GeoCoordinates geoCoordinates);

    public int hashCode() {
        List<GeoCoordinates> list = this.vertices;
        return 217 + (list != null ? list.hashCode() : 0);
    }
}
