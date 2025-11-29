package com.here.sdk.navigation;

public final class SpeedLimitOffset {
    public double highSpeedBoundaryInMetersPerSecond = 0.0d;
    public double highSpeedOffsetInMetersPerSecond = 0.0d;
    public double lowSpeedOffsetInMetersPerSecond = 0.0d;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpeedLimitOffset)) {
            return false;
        }
        SpeedLimitOffset speedLimitOffset = (SpeedLimitOffset) obj;
        return Double.compare(this.lowSpeedOffsetInMetersPerSecond, speedLimitOffset.lowSpeedOffsetInMetersPerSecond) == 0 && Double.compare(this.highSpeedOffsetInMetersPerSecond, speedLimitOffset.highSpeedOffsetInMetersPerSecond) == 0 && Double.compare(this.highSpeedBoundaryInMetersPerSecond, speedLimitOffset.highSpeedBoundaryInMetersPerSecond) == 0;
    }

    public int hashCode() {
        return ((((217 + ((int) (Double.doubleToLongBits(this.lowSpeedOffsetInMetersPerSecond) ^ (Double.doubleToLongBits(this.lowSpeedOffsetInMetersPerSecond) >>> 32)))) * 31) + ((int) (Double.doubleToLongBits(this.highSpeedOffsetInMetersPerSecond) ^ (Double.doubleToLongBits(this.highSpeedOffsetInMetersPerSecond) >>> 32)))) * 31) + ((int) (Double.doubleToLongBits(this.highSpeedBoundaryInMetersPerSecond) ^ (Double.doubleToLongBits(this.highSpeedBoundaryInMetersPerSecond) >>> 32)));
    }
}
