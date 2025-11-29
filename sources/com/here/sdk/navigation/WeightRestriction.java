package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class WeightRestriction {
    @NonNull
    public WeightRestrictionType type;
    public int valueInKilograms;

    public WeightRestriction(int i, @NonNull WeightRestrictionType weightRestrictionType) {
        this.valueInKilograms = i;
        this.type = weightRestrictionType;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WeightRestriction)) {
            return false;
        }
        WeightRestriction weightRestriction = (WeightRestriction) obj;
        return this.valueInKilograms == weightRestriction.valueInKilograms && Objects.equals(this.type, weightRestriction.type);
    }

    public int hashCode() {
        int i = (217 + this.valueInKilograms) * 31;
        WeightRestrictionType weightRestrictionType = this.type;
        return i + (weightRestrictionType != null ? weightRestrictionType.hashCode() : 0);
    }
}
