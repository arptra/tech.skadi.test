package com.here.sdk.trafficawarenavigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.time.Duration;
import java.util.Objects;

public final class DynamicRoutingEngineOptions {
    @Nullable
    public Duration minTimeDifference = null;
    @Nullable
    public Double minTimeDifferencePercentage = null;
    @NonNull
    public Duration pollInterval = Duration.ofMinutes(15);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DynamicRoutingEngineOptions)) {
            return false;
        }
        DynamicRoutingEngineOptions dynamicRoutingEngineOptions = (DynamicRoutingEngineOptions) obj;
        return Objects.equals(this.minTimeDifferencePercentage, dynamicRoutingEngineOptions.minTimeDifferencePercentage) && Objects.equals(this.minTimeDifference, dynamicRoutingEngineOptions.minTimeDifference) && Objects.equals(this.pollInterval, dynamicRoutingEngineOptions.pollInterval);
    }

    public int hashCode() {
        Double d = this.minTimeDifferencePercentage;
        int i = 0;
        int hashCode = (217 + (d != null ? d.hashCode() : 0)) * 31;
        Duration duration = this.minTimeDifference;
        int hashCode2 = (hashCode + (duration != null ? duration.hashCode() : 0)) * 31;
        Duration duration2 = this.pollInterval;
        if (duration2 != null) {
            i = duration2.hashCode();
        }
        return hashCode2 + i;
    }
}
