package com.here.sdk.routing;

import androidx.annotation.Nullable;
import java.util.Objects;

public final class TrafficSpeed {
    @Nullable
    public Double baseSpeedInMetersPerSecond;
    @Nullable
    public Double jamFactor;
    @Nullable
    public Double trafficSpeedInMetersPerSecond;

    public TrafficSpeed(@Nullable Double d, @Nullable Double d2, @Nullable Double d3) {
        this.baseSpeedInMetersPerSecond = d;
        this.trafficSpeedInMetersPerSecond = d2;
        this.jamFactor = d3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrafficSpeed)) {
            return false;
        }
        TrafficSpeed trafficSpeed = (TrafficSpeed) obj;
        return Objects.equals(this.baseSpeedInMetersPerSecond, trafficSpeed.baseSpeedInMetersPerSecond) && Objects.equals(this.trafficSpeedInMetersPerSecond, trafficSpeed.trafficSpeedInMetersPerSecond) && Objects.equals(this.jamFactor, trafficSpeed.jamFactor);
    }

    public int hashCode() {
        Double d = this.baseSpeedInMetersPerSecond;
        int i = 0;
        int hashCode = (217 + (d != null ? d.hashCode() : 0)) * 31;
        Double d2 = this.trafficSpeedInMetersPerSecond;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 31;
        Double d3 = this.jamFactor;
        if (d3 != null) {
            i = d3.hashCode();
        }
        return hashCode2 + i;
    }
}
