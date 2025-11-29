package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.time.Duration;
import java.util.Objects;

public final class ManeuverProgress {
    public int maneuverIndex = 0;
    public int remainingDistanceInMeters = 0;
    @NonNull
    public Duration remainingDuration = Duration.ofSeconds(0);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ManeuverProgress)) {
            return false;
        }
        ManeuverProgress maneuverProgress = (ManeuverProgress) obj;
        return this.maneuverIndex == maneuverProgress.maneuverIndex && this.remainingDistanceInMeters == maneuverProgress.remainingDistanceInMeters && Objects.equals(this.remainingDuration, maneuverProgress.remainingDuration);
    }

    public int hashCode() {
        int i = (((217 + this.maneuverIndex) * 31) + this.remainingDistanceInMeters) * 31;
        Duration duration = this.remainingDuration;
        return i + (duration != null ? duration.hashCode() : 0);
    }
}
