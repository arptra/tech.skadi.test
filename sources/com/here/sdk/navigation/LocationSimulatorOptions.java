package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.time.Duration;
import java.util.Objects;

public final class LocationSimulatorOptions {
    @NonNull
    public Duration notificationInterval = Duration.ofMillis(1000);
    public double speedFactor = 1.0d;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocationSimulatorOptions)) {
            return false;
        }
        LocationSimulatorOptions locationSimulatorOptions = (LocationSimulatorOptions) obj;
        return Double.compare(this.speedFactor, locationSimulatorOptions.speedFactor) == 0 && Objects.equals(this.notificationInterval, locationSimulatorOptions.notificationInterval);
    }

    public int hashCode() {
        int doubleToLongBits = (217 + ((int) (Double.doubleToLongBits(this.speedFactor) ^ (Double.doubleToLongBits(this.speedFactor) >>> 32)))) * 31;
        Duration duration = this.notificationInterval;
        return doubleToLongBits + (duration != null ? duration.hashCode() : 0);
    }
}
