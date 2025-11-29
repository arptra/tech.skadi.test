package com.here.sdk.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.transport.TruckClass;
import com.here.sdk.transport.TruckFuelType;
import java.util.Objects;

public final class TruckFuel {
    @Nullable
    public TruckClass maximumTruckClass = null;
    @NonNull
    public TruckFuelType type;

    public TruckFuel(@NonNull TruckFuelType truckFuelType) {
        this.type = truckFuelType;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TruckFuel)) {
            return false;
        }
        TruckFuel truckFuel = (TruckFuel) obj;
        return Objects.equals(this.type, truckFuel.type) && Objects.equals(this.maximumTruckClass, truckFuel.maximumTruckClass);
    }

    public int hashCode() {
        TruckFuelType truckFuelType = this.type;
        int i = 0;
        int hashCode = (217 + (truckFuelType != null ? truckFuelType.hashCode() : 0)) * 31;
        TruckClass truckClass = this.maximumTruckClass;
        if (truckClass != null) {
            i = truckClass.hashCode();
        }
        return hashCode + i;
    }
}
