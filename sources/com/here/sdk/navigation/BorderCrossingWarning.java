package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.CountryCode;
import com.here.sdk.transport.GeneralVehicleSpeedLimits;
import java.util.Objects;

public final class BorderCrossingWarning {
    @NonNull
    public CountryCode countryCode;
    public double distanceToBorderCrossingInMeters;
    @NonNull
    public DistanceType distanceType;
    @NonNull
    public GeneralVehicleSpeedLimits speedLimits;
    @Nullable
    public String stateCode = null;
    @NonNull
    public BorderCrossingType type;

    public BorderCrossingWarning(double d, @NonNull BorderCrossingType borderCrossingType, @NonNull CountryCode countryCode2, @NonNull GeneralVehicleSpeedLimits generalVehicleSpeedLimits, @NonNull DistanceType distanceType2) {
        this.distanceToBorderCrossingInMeters = d;
        this.type = borderCrossingType;
        this.countryCode = countryCode2;
        this.speedLimits = generalVehicleSpeedLimits;
        this.distanceType = distanceType2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BorderCrossingWarning)) {
            return false;
        }
        BorderCrossingWarning borderCrossingWarning = (BorderCrossingWarning) obj;
        return Double.compare(this.distanceToBorderCrossingInMeters, borderCrossingWarning.distanceToBorderCrossingInMeters) == 0 && Objects.equals(this.type, borderCrossingWarning.type) && Objects.equals(this.countryCode, borderCrossingWarning.countryCode) && Objects.equals(this.stateCode, borderCrossingWarning.stateCode) && Objects.equals(this.speedLimits, borderCrossingWarning.speedLimits) && Objects.equals(this.distanceType, borderCrossingWarning.distanceType);
    }

    public int hashCode() {
        int doubleToLongBits = (217 + ((int) (Double.doubleToLongBits(this.distanceToBorderCrossingInMeters) ^ (Double.doubleToLongBits(this.distanceToBorderCrossingInMeters) >>> 32)))) * 31;
        BorderCrossingType borderCrossingType = this.type;
        int i = 0;
        int hashCode = (doubleToLongBits + (borderCrossingType != null ? borderCrossingType.hashCode() : 0)) * 31;
        CountryCode countryCode2 = this.countryCode;
        int hashCode2 = (hashCode + (countryCode2 != null ? countryCode2.hashCode() : 0)) * 31;
        String str = this.stateCode;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        GeneralVehicleSpeedLimits generalVehicleSpeedLimits = this.speedLimits;
        int hashCode4 = (hashCode3 + (generalVehicleSpeedLimits != null ? generalVehicleSpeedLimits.hashCode() : 0)) * 31;
        DistanceType distanceType2 = this.distanceType;
        if (distanceType2 != null) {
            i = distanceType2.hashCode();
        }
        return hashCode4 + i;
    }
}
