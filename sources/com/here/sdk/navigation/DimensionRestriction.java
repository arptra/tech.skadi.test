package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class DimensionRestriction {
    @NonNull
    public DimensionRestrictionType type;
    public int valueInCentimeters;

    public DimensionRestriction(int i, @NonNull DimensionRestrictionType dimensionRestrictionType) {
        this.valueInCentimeters = i;
        this.type = dimensionRestrictionType;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DimensionRestriction)) {
            return false;
        }
        DimensionRestriction dimensionRestriction = (DimensionRestriction) obj;
        return this.valueInCentimeters == dimensionRestriction.valueInCentimeters && Objects.equals(this.type, dimensionRestriction.type);
    }

    public int hashCode() {
        int i = (217 + this.valueInCentimeters) * 31;
        DimensionRestrictionType dimensionRestrictionType = this.type;
        return i + (dimensionRestrictionType != null ? dimensionRestrictionType.hashCode() : 0);
    }
}
