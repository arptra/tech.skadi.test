package com.here.sdk.navigation;

public final class GPXOptions {
    public double speedInMetersPerSecond = 10.0d;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GPXOptions)) {
            return false;
        }
        return Double.compare(this.speedInMetersPerSecond, ((GPXOptions) obj).speedInMetersPerSecond) == 0;
    }

    public int hashCode() {
        return 217 + ((int) (Double.doubleToLongBits(this.speedInMetersPerSecond) ^ (Double.doubleToLongBits(this.speedInMetersPerSecond) >>> 32)));
    }
}
