package com.here.sdk.mapdata;

import androidx.annotation.Nullable;
import java.util.Objects;

public final class SegmentSpeedLimit {
    @Nullable
    public Double speedLimitInMeterPerSeconds = null;
    public boolean speedLimitIsUnlimited;

    public SegmentSpeedLimit(boolean z) {
        this.speedLimitIsUnlimited = z;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SegmentSpeedLimit)) {
            return false;
        }
        SegmentSpeedLimit segmentSpeedLimit = (SegmentSpeedLimit) obj;
        return Objects.equals(this.speedLimitInMeterPerSeconds, segmentSpeedLimit.speedLimitInMeterPerSeconds) && this.speedLimitIsUnlimited == segmentSpeedLimit.speedLimitIsUnlimited;
    }

    public int hashCode() {
        Double d = this.speedLimitInMeterPerSeconds;
        return ((217 + (d != null ? d.hashCode() : 0)) * 31) + (this.speedLimitIsUnlimited ? 79 : 97);
    }
}
