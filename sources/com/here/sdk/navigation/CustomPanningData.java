package com.here.sdk.navigation;

import androidx.annotation.Nullable;
import com.here.time.Duration;
import java.util.Objects;

public final class CustomPanningData {
    @Nullable
    public Duration estimatedAudioCueDuration;
    @Nullable
    public Double initialAzimuthInDegrees;
    @Nullable
    public Double sweepAzimuthInDegrees;

    public CustomPanningData(@Nullable Duration duration, @Nullable Double d, @Nullable Double d2) {
        this.estimatedAudioCueDuration = duration;
        this.initialAzimuthInDegrees = d;
        this.sweepAzimuthInDegrees = d2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomPanningData)) {
            return false;
        }
        CustomPanningData customPanningData = (CustomPanningData) obj;
        return Objects.equals(this.estimatedAudioCueDuration, customPanningData.estimatedAudioCueDuration) && Objects.equals(this.initialAzimuthInDegrees, customPanningData.initialAzimuthInDegrees) && Objects.equals(this.sweepAzimuthInDegrees, customPanningData.sweepAzimuthInDegrees);
    }

    public int hashCode() {
        Duration duration = this.estimatedAudioCueDuration;
        int i = 0;
        int hashCode = (217 + (duration != null ? duration.hashCode() : 0)) * 31;
        Double d = this.initialAzimuthInDegrees;
        int hashCode2 = (hashCode + (d != null ? d.hashCode() : 0)) * 31;
        Double d2 = this.sweepAzimuthInDegrees;
        if (d2 != null) {
            i = d2.hashCode();
        }
        return hashCode2 + i;
    }
}
