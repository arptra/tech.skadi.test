package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

public final class RealisticViewWarning {
    public double distanceToRealisticViewInMeters;
    @NonNull
    public DistanceType distanceType;
    @Nullable
    public RealisticView realisticView = null;

    public RealisticViewWarning(double d, @NonNull DistanceType distanceType2) {
        this.distanceToRealisticViewInMeters = d;
        this.distanceType = distanceType2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RealisticViewWarning)) {
            return false;
        }
        RealisticViewWarning realisticViewWarning = (RealisticViewWarning) obj;
        return Double.compare(this.distanceToRealisticViewInMeters, realisticViewWarning.distanceToRealisticViewInMeters) == 0 && Objects.equals(this.realisticView, realisticViewWarning.realisticView) && Objects.equals(this.distanceType, realisticViewWarning.distanceType);
    }

    public int hashCode() {
        int doubleToLongBits = (217 + ((int) (Double.doubleToLongBits(this.distanceToRealisticViewInMeters) ^ (Double.doubleToLongBits(this.distanceToRealisticViewInMeters) >>> 32)))) * 31;
        RealisticView realisticView2 = this.realisticView;
        int i = 0;
        int hashCode = (doubleToLongBits + (realisticView2 != null ? realisticView2.hashCode() : 0)) * 31;
        DistanceType distanceType2 = this.distanceType;
        if (distanceType2 != null) {
            i = distanceType2.hashCode();
        }
        return hashCode + i;
    }
}
