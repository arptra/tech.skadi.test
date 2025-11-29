package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class TollBoothLane {
    @NonNull
    public LaneAccess access;
    @NonNull
    public TollBooth booth;

    public TollBoothLane(@NonNull TollBooth tollBooth, @NonNull LaneAccess laneAccess) {
        this.booth = tollBooth;
        this.access = laneAccess;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TollBoothLane)) {
            return false;
        }
        TollBoothLane tollBoothLane = (TollBoothLane) obj;
        return Objects.equals(this.booth, tollBoothLane.booth) && Objects.equals(this.access, tollBoothLane.access);
    }

    public int hashCode() {
        TollBooth tollBooth = this.booth;
        int i = 0;
        int hashCode = (217 + (tollBooth != null ? tollBooth.hashCode() : 0)) * 31;
        LaneAccess laneAccess = this.access;
        if (laneAccess != null) {
            i = laneAccess.hashCode();
        }
        return hashCode + i;
    }
}
