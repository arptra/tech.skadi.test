package com.here.sdk.core;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class ParameterConfiguration {
    @NonNull
    public Pedestrian pedestrian = new Pedestrian();

    public static final class Pedestrian {
        public double walkingSpeedInMetersPerSecond = 1.0d;

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Pedestrian)) {
                return false;
            }
            return Double.compare(this.walkingSpeedInMetersPerSecond, ((Pedestrian) obj).walkingSpeedInMetersPerSecond) == 0;
        }

        public int hashCode() {
            return 217 + ((int) (Double.doubleToLongBits(this.walkingSpeedInMetersPerSecond) ^ (Double.doubleToLongBits(this.walkingSpeedInMetersPerSecond) >>> 32)));
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ParameterConfiguration)) {
            return false;
        }
        return Objects.equals(this.pedestrian, ((ParameterConfiguration) obj).pedestrian);
    }

    public int hashCode() {
        Pedestrian pedestrian2 = this.pedestrian;
        return 217 + (pedestrian2 != null ? pedestrian2.hashCode() : 0);
    }
}
