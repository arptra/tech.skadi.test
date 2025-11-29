package com.here.sdk.routing;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class MaxSpeedOnSegment {
    public double baseSpeedInMetersPerSecond;
    @NonNull
    public SegmentReference segment;

    public MaxSpeedOnSegment(@NonNull SegmentReference segmentReference, double d) {
        this.segment = segmentReference;
        this.baseSpeedInMetersPerSecond = d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MaxSpeedOnSegment)) {
            return false;
        }
        MaxSpeedOnSegment maxSpeedOnSegment = (MaxSpeedOnSegment) obj;
        return Objects.equals(this.segment, maxSpeedOnSegment.segment) && Double.compare(this.baseSpeedInMetersPerSecond, maxSpeedOnSegment.baseSpeedInMetersPerSecond) == 0;
    }

    public int hashCode() {
        SegmentReference segmentReference = this.segment;
        return ((217 + (segmentReference != null ? segmentReference.hashCode() : 0)) * 31) + ((int) (Double.doubleToLongBits(this.baseSpeedInMetersPerSecond) ^ (Double.doubleToLongBits(this.baseSpeedInMetersPerSecond) >>> 32)));
    }
}
