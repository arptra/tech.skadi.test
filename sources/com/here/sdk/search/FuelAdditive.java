package com.here.sdk.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.transport.FuelAdditiveType;
import java.util.Objects;

public final class FuelAdditive {
    @Nullable
    public Boolean availableAtPump = null;
    @Nullable
    public Boolean availableInCans = null;
    @NonNull
    public FuelAdditiveType type = FuelAdditiveType.AUS32;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FuelAdditive)) {
            return false;
        }
        FuelAdditive fuelAdditive = (FuelAdditive) obj;
        return Objects.equals(this.type, fuelAdditive.type) && Objects.equals(this.availableInCans, fuelAdditive.availableInCans) && Objects.equals(this.availableAtPump, fuelAdditive.availableAtPump);
    }

    public int hashCode() {
        FuelAdditiveType fuelAdditiveType = this.type;
        int i = 0;
        int hashCode = (217 + (fuelAdditiveType != null ? fuelAdditiveType.hashCode() : 0)) * 31;
        Boolean bool = this.availableInCans;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.availableAtPump;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        return hashCode2 + i;
    }
}
