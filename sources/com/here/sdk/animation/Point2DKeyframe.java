package com.here.sdk.animation;

import androidx.annotation.NonNull;
import com.here.sdk.core.Point2D;
import com.here.time.Duration;
import java.util.Objects;

public final class Point2DKeyframe {
    @NonNull
    public final Duration duration;
    @NonNull
    public final Point2D value;

    public Point2DKeyframe(@NonNull Point2D point2D, @NonNull Duration duration2) {
        Point2DKeyframe create = create(point2D, duration2);
        this.value = create.value;
        this.duration = create.duration;
    }

    private static native Point2DKeyframe create(@NonNull Point2D point2D, @NonNull Duration duration2);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Point2DKeyframe)) {
            return false;
        }
        Point2DKeyframe point2DKeyframe = (Point2DKeyframe) obj;
        return Objects.equals(this.value, point2DKeyframe.value) && Objects.equals(this.duration, point2DKeyframe.duration);
    }

    public int hashCode() {
        Point2D point2D = this.value;
        int i = 0;
        int hashCode = (217 + (point2D != null ? point2D.hashCode() : 0)) * 31;
        Duration duration2 = this.duration;
        if (duration2 != null) {
            i = duration2.hashCode();
        }
        return hashCode + i;
    }
}
