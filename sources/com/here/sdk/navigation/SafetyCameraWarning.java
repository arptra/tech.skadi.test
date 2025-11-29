package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class SafetyCameraWarning {
    public double distanceToCameraInMeters;
    @NonNull
    public DistanceType distanceType;
    public double speedLimitInMetersPerSecond;
    @NonNull
    public SafetyCameraType type;

    public SafetyCameraWarning(double d, double d2, @NonNull SafetyCameraType safetyCameraType, @NonNull DistanceType distanceType2) {
        this.distanceToCameraInMeters = d;
        this.speedLimitInMetersPerSecond = d2;
        this.type = safetyCameraType;
        this.distanceType = distanceType2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafetyCameraWarning)) {
            return false;
        }
        SafetyCameraWarning safetyCameraWarning = (SafetyCameraWarning) obj;
        return Double.compare(this.distanceToCameraInMeters, safetyCameraWarning.distanceToCameraInMeters) == 0 && Double.compare(this.speedLimitInMetersPerSecond, safetyCameraWarning.speedLimitInMetersPerSecond) == 0 && Objects.equals(this.type, safetyCameraWarning.type) && Objects.equals(this.distanceType, safetyCameraWarning.distanceType);
    }

    public int hashCode() {
        int doubleToLongBits = (((217 + ((int) (Double.doubleToLongBits(this.distanceToCameraInMeters) ^ (Double.doubleToLongBits(this.distanceToCameraInMeters) >>> 32)))) * 31) + ((int) (Double.doubleToLongBits(this.speedLimitInMetersPerSecond) ^ (Double.doubleToLongBits(this.speedLimitInMetersPerSecond) >>> 32)))) * 31;
        SafetyCameraType safetyCameraType = this.type;
        int i = 0;
        int hashCode = (doubleToLongBits + (safetyCameraType != null ? safetyCameraType.hashCode() : 0)) * 31;
        DistanceType distanceType2 = this.distanceType;
        if (distanceType2 != null) {
            i = distanceType2.hashCode();
        }
        return hashCode + i;
    }
}
