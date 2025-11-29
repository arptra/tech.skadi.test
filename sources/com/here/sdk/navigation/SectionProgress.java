package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.time.Duration;
import java.util.Objects;

public final class SectionProgress {
    public int remainingDistanceInMeters = 0;
    @NonNull
    public Duration remainingDuration = Duration.ofSeconds(0);
    @NonNull
    public Duration trafficDelay = Duration.ofSeconds(0);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SectionProgress)) {
            return false;
        }
        SectionProgress sectionProgress = (SectionProgress) obj;
        return this.remainingDistanceInMeters == sectionProgress.remainingDistanceInMeters && Objects.equals(this.remainingDuration, sectionProgress.remainingDuration) && Objects.equals(this.trafficDelay, sectionProgress.trafficDelay);
    }

    public int hashCode() {
        int i = (217 + this.remainingDistanceInMeters) * 31;
        Duration duration = this.remainingDuration;
        int i2 = 0;
        int hashCode = (i + (duration != null ? duration.hashCode() : 0)) * 31;
        Duration duration2 = this.trafficDelay;
        if (duration2 != null) {
            i2 = duration2.hashCode();
        }
        return hashCode + i2;
    }
}
