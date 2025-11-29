package com.here.sdk.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public final class GeoCorridor {
    @Nullable
    public final Integer halfWidthInMeters;
    @NonNull
    public final List<GeoCoordinates> polyline;

    public GeoCorridor(@NonNull List<GeoCoordinates> list, int i) {
        GeoCorridor make = make(list, i);
        this.polyline = make.polyline;
        this.halfWidthInMeters = make.halfWidthInMeters;
    }

    private static native GeoCorridor make(@NonNull List<GeoCoordinates> list);

    private static native GeoCorridor make(@NonNull List<GeoCoordinates> list, int i);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GeoCorridor)) {
            return false;
        }
        GeoCorridor geoCorridor = (GeoCorridor) obj;
        return Objects.equals(this.polyline, geoCorridor.polyline) && Objects.equals(this.halfWidthInMeters, geoCorridor.halfWidthInMeters);
    }

    public int hashCode() {
        List<GeoCoordinates> list = this.polyline;
        int i = 0;
        int hashCode = (217 + (list != null ? list.hashCode() : 0)) * 31;
        Integer num = this.halfWidthInMeters;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }

    public GeoCorridor(@NonNull List<GeoCoordinates> list) {
        GeoCorridor make = make(list);
        this.polyline = make.polyline;
        this.halfWidthInMeters = make.halfWidthInMeters;
    }
}
