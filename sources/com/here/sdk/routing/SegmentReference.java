package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

public final class SegmentReference {
    @Nullable
    public Long localId;
    public double offsetEnd;
    public double offsetStart;
    @NonNull
    public String segmentId;
    public long tilePartitionId;
    @NonNull
    public TravelDirection travelDirection;

    public SegmentReference() {
        this.segmentId = "";
        this.travelDirection = TravelDirection.BIDIRECTIONAL;
        this.offsetStart = 0.0d;
        this.offsetEnd = 1.0d;
        this.tilePartitionId = 0;
        this.localId = 0L;
    }

    @Nullable
    public static native SegmentReference fromString(@NonNull String str);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SegmentReference)) {
            return false;
        }
        SegmentReference segmentReference = (SegmentReference) obj;
        return Objects.equals(this.segmentId, segmentReference.segmentId) && Objects.equals(this.travelDirection, segmentReference.travelDirection) && Double.compare(this.offsetStart, segmentReference.offsetStart) == 0 && Double.compare(this.offsetEnd, segmentReference.offsetEnd) == 0 && this.tilePartitionId == segmentReference.tilePartitionId && Objects.equals(this.localId, segmentReference.localId);
    }

    public int hashCode() {
        String str = this.segmentId;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        TravelDirection travelDirection2 = this.travelDirection;
        int hashCode2 = travelDirection2 != null ? travelDirection2.hashCode() : 0;
        long j = this.tilePartitionId;
        int doubleToLongBits = (((((((hashCode + hashCode2) * 31) + ((int) (Double.doubleToLongBits(this.offsetStart) ^ (Double.doubleToLongBits(this.offsetStart) >>> 32)))) * 31) + ((int) (Double.doubleToLongBits(this.offsetEnd) ^ (Double.doubleToLongBits(this.offsetEnd) >>> 32)))) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        Long l = this.localId;
        if (l != null) {
            i = l.hashCode();
        }
        return doubleToLongBits + i;
    }

    public SegmentReference(@NonNull String str) {
        this.segmentId = str;
        this.travelDirection = TravelDirection.BIDIRECTIONAL;
        this.offsetStart = 0.0d;
        this.offsetEnd = 1.0d;
        this.tilePartitionId = 0;
        this.localId = 0L;
    }

    public SegmentReference(@NonNull String str, @NonNull TravelDirection travelDirection2) {
        this.segmentId = str;
        this.travelDirection = travelDirection2;
        this.offsetStart = 0.0d;
        this.offsetEnd = 1.0d;
        this.tilePartitionId = 0;
        this.localId = 0L;
    }

    public SegmentReference(@NonNull String str, @NonNull TravelDirection travelDirection2, double d) {
        this.segmentId = str;
        this.travelDirection = travelDirection2;
        this.offsetStart = d;
        this.offsetEnd = 1.0d;
        this.tilePartitionId = 0;
        this.localId = 0L;
    }

    public SegmentReference(@NonNull String str, @NonNull TravelDirection travelDirection2, double d, double d2) {
        this.segmentId = str;
        this.travelDirection = travelDirection2;
        this.offsetStart = d;
        this.offsetEnd = d2;
        this.tilePartitionId = 0;
        this.localId = 0L;
    }

    public SegmentReference(@NonNull String str, @NonNull TravelDirection travelDirection2, double d, double d2, long j) {
        this.segmentId = str;
        this.travelDirection = travelDirection2;
        this.offsetStart = d;
        this.offsetEnd = d2;
        this.tilePartitionId = j;
        this.localId = 0L;
    }

    public SegmentReference(@NonNull String str, @NonNull TravelDirection travelDirection2, double d, double d2, long j, @Nullable Long l) {
        this.segmentId = str;
        this.travelDirection = travelDirection2;
        this.offsetStart = d;
        this.offsetEnd = d2;
        this.tilePartitionId = j;
        this.localId = l;
    }
}
