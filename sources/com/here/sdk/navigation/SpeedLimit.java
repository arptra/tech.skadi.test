package com.here.sdk.navigation;

import androidx.annotation.Nullable;
import java.util.Objects;

public final class SpeedLimit {
    @Nullable
    public Double advisorySpeedLimitInMetersPerSecond = null;
    @Nullable
    public Double fogSpeedLimitInMetersPerSecond = null;
    @Nullable
    public Double optimalWeatherSpeedLimitInMetersPerSecond = null;
    @Nullable
    public Double rainSpeedLimitInMetersPerSecond = null;
    @Nullable
    public Double schoolZoneSpeedLimitInMetersPerSecond = null;
    @Nullable
    public Double snowSpeedLimitInMetersPerSecond = null;
    @Nullable
    public Double speedLimitInMetersPerSecond = null;
    @Nullable
    public Double timeDependentSpeedLimitInMetersPerSecond = null;

    @Nullable
    public native Double effectiveSpeedLimitInMetersPerSecond();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpeedLimit)) {
            return false;
        }
        SpeedLimit speedLimit = (SpeedLimit) obj;
        return Objects.equals(this.speedLimitInMetersPerSecond, speedLimit.speedLimitInMetersPerSecond) && Objects.equals(this.advisorySpeedLimitInMetersPerSecond, speedLimit.advisorySpeedLimitInMetersPerSecond) && Objects.equals(this.snowSpeedLimitInMetersPerSecond, speedLimit.snowSpeedLimitInMetersPerSecond) && Objects.equals(this.rainSpeedLimitInMetersPerSecond, speedLimit.rainSpeedLimitInMetersPerSecond) && Objects.equals(this.fogSpeedLimitInMetersPerSecond, speedLimit.fogSpeedLimitInMetersPerSecond) && Objects.equals(this.optimalWeatherSpeedLimitInMetersPerSecond, speedLimit.optimalWeatherSpeedLimitInMetersPerSecond) && Objects.equals(this.schoolZoneSpeedLimitInMetersPerSecond, speedLimit.schoolZoneSpeedLimitInMetersPerSecond) && Objects.equals(this.timeDependentSpeedLimitInMetersPerSecond, speedLimit.timeDependentSpeedLimitInMetersPerSecond);
    }

    public int hashCode() {
        Double d = this.speedLimitInMetersPerSecond;
        int i = 0;
        int hashCode = (217 + (d != null ? d.hashCode() : 0)) * 31;
        Double d2 = this.advisorySpeedLimitInMetersPerSecond;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 31;
        Double d3 = this.snowSpeedLimitInMetersPerSecond;
        int hashCode3 = (hashCode2 + (d3 != null ? d3.hashCode() : 0)) * 31;
        Double d4 = this.rainSpeedLimitInMetersPerSecond;
        int hashCode4 = (hashCode3 + (d4 != null ? d4.hashCode() : 0)) * 31;
        Double d5 = this.fogSpeedLimitInMetersPerSecond;
        int hashCode5 = (hashCode4 + (d5 != null ? d5.hashCode() : 0)) * 31;
        Double d6 = this.optimalWeatherSpeedLimitInMetersPerSecond;
        int hashCode6 = (hashCode5 + (d6 != null ? d6.hashCode() : 0)) * 31;
        Double d7 = this.schoolZoneSpeedLimitInMetersPerSecond;
        int hashCode7 = (hashCode6 + (d7 != null ? d7.hashCode() : 0)) * 31;
        Double d8 = this.timeDependentSpeedLimitInMetersPerSecond;
        if (d8 != null) {
            i = d8.hashCode();
        }
        return hashCode7 + i;
    }
}
