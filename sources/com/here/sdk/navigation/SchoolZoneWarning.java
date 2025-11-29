package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.TimeRule;
import java.util.Objects;

public final class SchoolZoneWarning {
    public double distanceToSchoolZoneInMeters;
    @NonNull
    public DistanceType distanceType;
    public double speedLimitInMetersPerSecond;
    @Nullable
    public TimeRule timeRule = null;

    public SchoolZoneWarning(double d, double d2, @NonNull DistanceType distanceType2) {
        this.distanceToSchoolZoneInMeters = d;
        this.speedLimitInMetersPerSecond = d2;
        this.distanceType = distanceType2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchoolZoneWarning)) {
            return false;
        }
        SchoolZoneWarning schoolZoneWarning = (SchoolZoneWarning) obj;
        return Double.compare(this.distanceToSchoolZoneInMeters, schoolZoneWarning.distanceToSchoolZoneInMeters) == 0 && Double.compare(this.speedLimitInMetersPerSecond, schoolZoneWarning.speedLimitInMetersPerSecond) == 0 && Objects.equals(this.distanceType, schoolZoneWarning.distanceType) && Objects.equals(this.timeRule, schoolZoneWarning.timeRule);
    }

    public int hashCode() {
        int doubleToLongBits = (((217 + ((int) (Double.doubleToLongBits(this.distanceToSchoolZoneInMeters) ^ (Double.doubleToLongBits(this.distanceToSchoolZoneInMeters) >>> 32)))) * 31) + ((int) (Double.doubleToLongBits(this.speedLimitInMetersPerSecond) ^ (Double.doubleToLongBits(this.speedLimitInMetersPerSecond) >>> 32)))) * 31;
        DistanceType distanceType2 = this.distanceType;
        int i = 0;
        int hashCode = (doubleToLongBits + (distanceType2 != null ? distanceType2.hashCode() : 0)) * 31;
        TimeRule timeRule2 = this.timeRule;
        if (timeRule2 != null) {
            i = timeRule2.hashCode();
        }
        return hashCode + i;
    }
}
