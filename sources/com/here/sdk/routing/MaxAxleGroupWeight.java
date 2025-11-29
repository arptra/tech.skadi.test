package com.here.sdk.routing;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class MaxAxleGroupWeight {
    @NonNull
    public String axleGroupType;
    public int maxWeightInKilograms;

    public MaxAxleGroupWeight(int i, @NonNull String str) {
        this.maxWeightInKilograms = i;
        this.axleGroupType = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MaxAxleGroupWeight)) {
            return false;
        }
        MaxAxleGroupWeight maxAxleGroupWeight = (MaxAxleGroupWeight) obj;
        return this.maxWeightInKilograms == maxAxleGroupWeight.maxWeightInKilograms && Objects.equals(this.axleGroupType, maxAxleGroupWeight.axleGroupType);
    }

    public int hashCode() {
        int i = (217 + this.maxWeightInKilograms) * 31;
        String str = this.axleGroupType;
        return i + (str != null ? str.hashCode() : 0);
    }
}
