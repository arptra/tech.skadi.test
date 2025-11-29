package com.here.sdk.core;

public final class PedestrianProfile {
    public double walkingSpeedInMetersPerSecond = 1.0d;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PedestrianProfile)) {
            return false;
        }
        return Double.compare(this.walkingSpeedInMetersPerSecond, ((PedestrianProfile) obj).walkingSpeedInMetersPerSecond) == 0;
    }

    public int hashCode() {
        return 217 + ((int) (Double.doubleToLongBits(this.walkingSpeedInMetersPerSecond) ^ (Double.doubleToLongBits(this.walkingSpeedInMetersPerSecond) >>> 32)));
    }
}
