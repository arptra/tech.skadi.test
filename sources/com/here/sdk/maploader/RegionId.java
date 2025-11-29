package com.here.sdk.maploader;

public final class RegionId {
    public final long id;

    public RegionId(long j) {
        this.id = j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RegionId)) {
            return false;
        }
        return this.id == ((RegionId) obj).id;
    }

    public int hashCode() {
        long j = this.id;
        return 217 + ((int) (j ^ (j >>> 32)));
    }
}
