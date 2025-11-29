package com.here.sdk.core;

import androidx.annotation.NonNull;
import com.here.sdk.core.errors.InstantiationErrorException;
import java.util.List;
import java.util.Objects;

public final class GeoPolygon {
    @NonNull
    public final List<GeoCoordinates> vertices;

    public GeoPolygon(@NonNull List<GeoCoordinates> list) throws InstantiationErrorException {
        this.vertices = make(list).vertices;
    }

    private static native GeoPolygon make(@NonNull GeoCircle geoCircle);

    private static native GeoPolygon make(@NonNull List<GeoCoordinates> list) throws InstantiationErrorException;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GeoPolygon)) {
            return false;
        }
        return Objects.equals(this.vertices, ((GeoPolygon) obj).vertices);
    }

    public int hashCode() {
        List<GeoCoordinates> list = this.vertices;
        return 217 + (list != null ? list.hashCode() : 0);
    }

    public GeoPolygon(@NonNull GeoCircle geoCircle) {
        this.vertices = make(geoCircle).vertices;
    }
}
