package com.here.sdk.mapdata;

public final class OCMSegmentId {
    public int localId = 0;
    public int tilePartitionId = 0;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OCMSegmentId)) {
            return false;
        }
        OCMSegmentId oCMSegmentId = (OCMSegmentId) obj;
        return this.tilePartitionId == oCMSegmentId.tilePartitionId && this.localId == oCMSegmentId.localId;
    }

    public int hashCode() {
        return ((217 + this.tilePartitionId) * 31) + this.localId;
    }
}
