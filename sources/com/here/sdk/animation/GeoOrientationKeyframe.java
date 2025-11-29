package com.here.sdk.animation;

import androidx.annotation.NonNull;
import com.here.sdk.core.GeoOrientation;
import com.here.time.Duration;
import java.util.Objects;

public final class GeoOrientationKeyframe {
    @NonNull
    public final Duration duration;
    @NonNull
    public final GeoOrientation value;

    public GeoOrientationKeyframe(@NonNull GeoOrientation geoOrientation, @NonNull Duration duration2) {
        GeoOrientationKeyframe create = create(geoOrientation, duration2);
        this.value = create.value;
        this.duration = create.duration;
    }

    private static native GeoOrientationKeyframe create(@NonNull GeoOrientation geoOrientation, @NonNull Duration duration2);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GeoOrientationKeyframe)) {
            return false;
        }
        GeoOrientationKeyframe geoOrientationKeyframe = (GeoOrientationKeyframe) obj;
        return Objects.equals(this.value, geoOrientationKeyframe.value) && Objects.equals(this.duration, geoOrientationKeyframe.duration);
    }

    public int hashCode() {
        GeoOrientation geoOrientation = this.value;
        int i = 0;
        int hashCode = (217 + (geoOrientation != null ? geoOrientation.hashCode() : 0)) * 31;
        Duration duration2 = this.duration;
        if (duration2 != null) {
            i = duration2.hashCode();
        }
        return hashCode + i;
    }
}
