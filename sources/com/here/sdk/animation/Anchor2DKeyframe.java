package com.here.sdk.animation;

import androidx.annotation.NonNull;
import com.here.sdk.core.Anchor2D;
import com.here.time.Duration;
import java.util.Objects;

public final class Anchor2DKeyframe {
    @NonNull
    public final Duration duration;
    @NonNull
    public final Anchor2D value;

    public Anchor2DKeyframe(@NonNull Anchor2D anchor2D, @NonNull Duration duration2) {
        Anchor2DKeyframe create = create(anchor2D, duration2);
        this.value = create.value;
        this.duration = create.duration;
    }

    private static native Anchor2DKeyframe create(@NonNull Anchor2D anchor2D, @NonNull Duration duration2);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Anchor2DKeyframe)) {
            return false;
        }
        Anchor2DKeyframe anchor2DKeyframe = (Anchor2DKeyframe) obj;
        return Objects.equals(this.value, anchor2DKeyframe.value) && Objects.equals(this.duration, anchor2DKeyframe.duration);
    }

    public int hashCode() {
        Anchor2D anchor2D = this.value;
        int i = 0;
        int hashCode = (217 + (anchor2D != null ? anchor2D.hashCode() : 0)) * 31;
        Duration duration2 = this.duration;
        if (duration2 != null) {
            i = duration2.hashCode();
        }
        return hashCode + i;
    }
}
