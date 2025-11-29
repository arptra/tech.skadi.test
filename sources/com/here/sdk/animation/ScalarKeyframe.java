package com.here.sdk.animation;

import androidx.annotation.NonNull;
import com.here.time.Duration;
import java.util.Objects;

public final class ScalarKeyframe {
    @NonNull
    public final Duration duration;
    public final double value;

    public ScalarKeyframe(double d, @NonNull Duration duration2) {
        ScalarKeyframe create = create(d, duration2);
        this.value = create.value;
        this.duration = create.duration;
    }

    private static native ScalarKeyframe create(double d, @NonNull Duration duration2);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ScalarKeyframe)) {
            return false;
        }
        ScalarKeyframe scalarKeyframe = (ScalarKeyframe) obj;
        return Double.compare(this.value, scalarKeyframe.value) == 0 && Objects.equals(this.duration, scalarKeyframe.duration);
    }

    public int hashCode() {
        int doubleToLongBits = (217 + ((int) (Double.doubleToLongBits(this.value) ^ (Double.doubleToLongBits(this.value) >>> 32)))) * 31;
        Duration duration2 = this.duration;
        return doubleToLongBits + (duration2 != null ? duration2.hashCode() : 0);
    }
}
