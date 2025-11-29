package com.here.sdk.transport;

import androidx.annotation.Nullable;
import java.util.Objects;

public final class GeneralVehicleSpeedLimits {
    @Nullable
    public Double maxSpeedHighwaysInMetersPerSecond = null;
    @Nullable
    public Double maxSpeedRuralInMetersPerSecond = null;
    @Nullable
    public Double maxSpeedUrbanInMetersPerSecond = null;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GeneralVehicleSpeedLimits)) {
            return false;
        }
        GeneralVehicleSpeedLimits generalVehicleSpeedLimits = (GeneralVehicleSpeedLimits) obj;
        return Objects.equals(this.maxSpeedHighwaysInMetersPerSecond, generalVehicleSpeedLimits.maxSpeedHighwaysInMetersPerSecond) && Objects.equals(this.maxSpeedRuralInMetersPerSecond, generalVehicleSpeedLimits.maxSpeedRuralInMetersPerSecond) && Objects.equals(this.maxSpeedUrbanInMetersPerSecond, generalVehicleSpeedLimits.maxSpeedUrbanInMetersPerSecond);
    }

    public int hashCode() {
        Double d = this.maxSpeedHighwaysInMetersPerSecond;
        int i = 0;
        int hashCode = (217 + (d != null ? d.hashCode() : 0)) * 31;
        Double d2 = this.maxSpeedRuralInMetersPerSecond;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 31;
        Double d3 = this.maxSpeedUrbanInMetersPerSecond;
        if (d3 != null) {
            i = d3.hashCode();
        }
        return hashCode2 + i;
    }
}
