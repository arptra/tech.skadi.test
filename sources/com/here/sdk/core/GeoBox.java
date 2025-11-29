package com.here.sdk.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.errors.InstantiationErrorException;
import java.util.List;
import java.util.Objects;

public final class GeoBox {
    @NonNull
    public final GeoCoordinates northEastCorner;
    @NonNull
    public final GeoCoordinates southWestCorner;

    public GeoBox(@NonNull GeoCoordinates geoCoordinates, @NonNull GeoCoordinates geoCoordinates2) {
        this.southWestCorner = geoCoordinates;
        this.northEastCorner = geoCoordinates2;
    }

    @Nullable
    public static native GeoBox containing(@NonNull List<GeoCoordinates> list);

    @Nullable
    public static native GeoBox envelopeGeoBoxes(@NonNull List<GeoBox> list);

    @NonNull
    public static native List<GeoBox> intersection(@NonNull List<GeoBox> list);

    public native boolean contains(@NonNull GeoBox geoBox);

    public native boolean contains(@NonNull GeoCoordinates geoCoordinates);

    @NonNull
    public native GeoBox envelope(@NonNull GeoBox geoBox);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GeoBox)) {
            return false;
        }
        GeoBox geoBox = (GeoBox) obj;
        return Objects.equals(this.southWestCorner, geoBox.southWestCorner) && Objects.equals(this.northEastCorner, geoBox.northEastCorner);
    }

    @NonNull
    public native GeoBox expandedBy(double d, double d2, double d3, double d4) throws InstantiationErrorException;

    public int hashCode() {
        GeoCoordinates geoCoordinates = this.southWestCorner;
        int i = 0;
        int hashCode = (217 + (geoCoordinates != null ? geoCoordinates.hashCode() : 0)) * 31;
        GeoCoordinates geoCoordinates2 = this.northEastCorner;
        if (geoCoordinates2 != null) {
            i = geoCoordinates2.hashCode();
        }
        return hashCode + i;
    }

    @NonNull
    public native List<GeoBox> intersection(@NonNull GeoBox geoBox);

    public native boolean intersects(@NonNull GeoBox geoBox);
}
