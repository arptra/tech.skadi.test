package com.here.sdk.search;

import androidx.annotation.NonNull;
import com.here.sdk.transport.FuelType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class GenericFuel {
    @NonNull
    public List<FuelAdditive> additives = new ArrayList();
    @NonNull
    public FuelType type;

    public GenericFuel(@NonNull FuelType fuelType) {
        this.type = fuelType;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GenericFuel)) {
            return false;
        }
        GenericFuel genericFuel = (GenericFuel) obj;
        return Objects.equals(this.type, genericFuel.type) && Objects.equals(this.additives, genericFuel.additives);
    }

    public int hashCode() {
        FuelType fuelType = this.type;
        int i = 0;
        int hashCode = (217 + (fuelType != null ? fuelType.hashCode() : 0)) * 31;
        List<FuelAdditive> list = this.additives;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }
}
