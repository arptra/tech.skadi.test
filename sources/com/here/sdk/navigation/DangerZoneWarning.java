package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class DangerZoneWarning {
    public double distanceInMeters;
    @NonNull
    public DistanceType distanceType;
    public boolean isZoneStart;

    public DangerZoneWarning(boolean z, double d, @NonNull DistanceType distanceType2) {
        this.isZoneStart = z;
        this.distanceInMeters = d;
        this.distanceType = distanceType2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DangerZoneWarning)) {
            return false;
        }
        DangerZoneWarning dangerZoneWarning = (DangerZoneWarning) obj;
        return this.isZoneStart == dangerZoneWarning.isZoneStart && Double.compare(this.distanceInMeters, dangerZoneWarning.distanceInMeters) == 0 && Objects.equals(this.distanceType, dangerZoneWarning.distanceType);
    }

    public int hashCode() {
        int doubleToLongBits = (((217 + (this.isZoneStart ? 79 : 97)) * 31) + ((int) (Double.doubleToLongBits(this.distanceInMeters) ^ (Double.doubleToLongBits(this.distanceInMeters) >>> 32)))) * 31;
        DistanceType distanceType2 = this.distanceType;
        return doubleToLongBits + (distanceType2 != null ? distanceType2.hashCode() : 0);
    }
}
