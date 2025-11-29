package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.sdk.routing.Maneuver;
import com.here.time.Duration;
import java.util.Objects;

public final class SpatialManeuver {
    @NonNull
    public Duration estimatedAudioCueDuration;
    public double initialAzimuthInDegrees;
    @NonNull
    public Maneuver maneuver;
    @NonNull
    public String voiceText;

    public SpatialManeuver(@NonNull String str, @NonNull Maneuver maneuver2, double d, @NonNull Duration duration) {
        this.voiceText = str;
        this.maneuver = maneuver2;
        this.initialAzimuthInDegrees = d;
        this.estimatedAudioCueDuration = duration;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpatialManeuver)) {
            return false;
        }
        SpatialManeuver spatialManeuver = (SpatialManeuver) obj;
        return Objects.equals(this.voiceText, spatialManeuver.voiceText) && Objects.equals(this.maneuver, spatialManeuver.maneuver) && Double.compare(this.initialAzimuthInDegrees, spatialManeuver.initialAzimuthInDegrees) == 0 && Objects.equals(this.estimatedAudioCueDuration, spatialManeuver.estimatedAudioCueDuration);
    }

    public int hashCode() {
        String str = this.voiceText;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        Maneuver maneuver2 = this.maneuver;
        int hashCode2 = (((hashCode + (maneuver2 != null ? maneuver2.hashCode() : 0)) * 31) + ((int) (Double.doubleToLongBits(this.initialAzimuthInDegrees) ^ (Double.doubleToLongBits(this.initialAzimuthInDegrees) >>> 32)))) * 31;
        Duration duration = this.estimatedAudioCueDuration;
        if (duration != null) {
            i = duration.hashCode();
        }
        return hashCode2 + i;
    }
}
