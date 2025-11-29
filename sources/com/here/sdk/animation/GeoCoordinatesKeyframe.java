package com.here.sdk.animation;

import androidx.annotation.NonNull;
import com.here.sdk.core.GeoCoordinates;
import com.here.time.Duration;
import java.util.Objects;

public final class GeoCoordinatesKeyframe {
    @NonNull
    public final Duration duration;
    @NonNull
    public final GeoCoordinates value;

    public GeoCoordinatesKeyframe(@NonNull GeoCoordinates geoCoordinates, @NonNull Duration duration2) {
        GeoCoordinatesKeyframe create = create(geoCoordinates, duration2);
        this.value = create.value;
        this.duration = create.duration;
    }

    private static native GeoCoordinatesKeyframe create(@NonNull GeoCoordinates geoCoordinates, @NonNull Duration duration2);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GeoCoordinatesKeyframe)) {
            return false;
        }
        GeoCoordinatesKeyframe geoCoordinatesKeyframe = (GeoCoordinatesKeyframe) obj;
        return Objects.equals(this.value, geoCoordinatesKeyframe.value) && Objects.equals(this.duration, geoCoordinatesKeyframe.duration);
    }

    public int hashCode() {
        GeoCoordinates geoCoordinates = this.value;
        int i = 0;
        int hashCode = (217 + (geoCoordinates != null ? geoCoordinates.hashCode() : 0)) * 31;
        Duration duration2 = this.duration;
        if (duration2 != null) {
            i = duration2.hashCode();
        }
        return hashCode + i;
    }
}
