package com.here.sdk.traffic;

import androidx.annotation.Nullable;
import java.util.Objects;

public final class TrafficFlowQueryOptions {
    @Nullable
    public Double maxJamFactor = null;
    @Nullable
    public Double minJamFactor = null;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrafficFlowQueryOptions)) {
            return false;
        }
        TrafficFlowQueryOptions trafficFlowQueryOptions = (TrafficFlowQueryOptions) obj;
        return Objects.equals(this.minJamFactor, trafficFlowQueryOptions.minJamFactor) && Objects.equals(this.maxJamFactor, trafficFlowQueryOptions.maxJamFactor);
    }

    public int hashCode() {
        Double d = this.minJamFactor;
        int i = 0;
        int hashCode = (217 + (d != null ? d.hashCode() : 0)) * 31;
        Double d2 = this.maxJamFactor;
        if (d2 != null) {
            i = d2.hashCode();
        }
        return hashCode + i;
    }
}
