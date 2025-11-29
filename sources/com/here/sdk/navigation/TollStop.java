package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.Objects;

public final class TollStop {
    public double distanceToTollStopInMeters;
    @NonNull
    public DistanceType distanceType;
    @NonNull
    public List<TollBoothLane> lanes;

    public TollStop(@NonNull DistanceType distanceType2, double d, @NonNull List<TollBoothLane> list) {
        this.distanceType = distanceType2;
        this.distanceToTollStopInMeters = d;
        this.lanes = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TollStop)) {
            return false;
        }
        TollStop tollStop = (TollStop) obj;
        return Objects.equals(this.distanceType, tollStop.distanceType) && Double.compare(this.distanceToTollStopInMeters, tollStop.distanceToTollStopInMeters) == 0 && Objects.equals(this.lanes, tollStop.lanes);
    }

    public int hashCode() {
        DistanceType distanceType2 = this.distanceType;
        int i = 0;
        int hashCode = (((217 + (distanceType2 != null ? distanceType2.hashCode() : 0)) * 31) + ((int) (Double.doubleToLongBits(this.distanceToTollStopInMeters) ^ (Double.doubleToLongBits(this.distanceToTollStopInMeters) >>> 32)))) * 31;
        List<TollBoothLane> list = this.lanes;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }
}
