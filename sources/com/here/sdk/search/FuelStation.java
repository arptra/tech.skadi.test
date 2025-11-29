package com.here.sdk.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class FuelStation {
    @NonNull
    public List<GenericFuel> fuels = new ArrayList();
    @Nullable
    public Boolean highVolumePumps = null;
    @Nullable
    public Boolean payAtThePump = null;
    @NonNull
    public List<TruckFuel> truckFuels = new ArrayList();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FuelStation)) {
            return false;
        }
        FuelStation fuelStation = (FuelStation) obj;
        return Objects.equals(this.fuels, fuelStation.fuels) && Objects.equals(this.truckFuels, fuelStation.truckFuels) && Objects.equals(this.payAtThePump, fuelStation.payAtThePump) && Objects.equals(this.highVolumePumps, fuelStation.highVolumePumps);
    }

    public int hashCode() {
        List<GenericFuel> list = this.fuels;
        int i = 0;
        int hashCode = (217 + (list != null ? list.hashCode() : 0)) * 31;
        List<TruckFuel> list2 = this.truckFuels;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        Boolean bool = this.payAtThePump;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.highVolumePumps;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        return hashCode3 + i;
    }
}
