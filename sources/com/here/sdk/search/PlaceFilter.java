package com.here.sdk.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.transport.FuelType;
import com.here.sdk.transport.TruckClass;
import com.here.sdk.transport.TruckFuelType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class PlaceFilter {
    @NonNull
    public Ev ev = new Ev();
    @NonNull
    public List<FuelType> fuelTypes = new ArrayList();
    @Nullable
    public TruckClass truckClass = null;
    @NonNull
    public List<TruckFuelType> truckFuelTypes = new ArrayList();

    public static final class Ev {
        @NonNull
        public List<String> connectorTypeIDs = new ArrayList();
        @Nullable
        Double powerInKilowatts = null;
        @NonNull
        public List<String> supplierNames = new ArrayList();

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Ev)) {
                return false;
            }
            Ev ev = (Ev) obj;
            return Objects.equals(this.supplierNames, ev.supplierNames) && Objects.equals(this.connectorTypeIDs, ev.connectorTypeIDs) && Objects.equals(this.powerInKilowatts, ev.powerInKilowatts);
        }

        public int hashCode() {
            List<String> list = this.supplierNames;
            int i = 0;
            int hashCode = (217 + (list != null ? list.hashCode() : 0)) * 31;
            List<String> list2 = this.connectorTypeIDs;
            int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            Double d = this.powerInKilowatts;
            if (d != null) {
                i = d.hashCode();
            }
            return hashCode2 + i;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PlaceFilter)) {
            return false;
        }
        PlaceFilter placeFilter = (PlaceFilter) obj;
        return Objects.equals(this.fuelTypes, placeFilter.fuelTypes) && Objects.equals(this.truckFuelTypes, placeFilter.truckFuelTypes) && Objects.equals(this.truckClass, placeFilter.truckClass) && Objects.equals(this.ev, placeFilter.ev);
    }

    public int hashCode() {
        List<FuelType> list = this.fuelTypes;
        int i = 0;
        int hashCode = (217 + (list != null ? list.hashCode() : 0)) * 31;
        List<TruckFuelType> list2 = this.truckFuelTypes;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        TruckClass truckClass2 = this.truckClass;
        int hashCode3 = (hashCode2 + (truckClass2 != null ? truckClass2.hashCode() : 0)) * 31;
        Ev ev2 = this.ev;
        if (ev2 != null) {
            i = ev2.hashCode();
        }
        return hashCode3 + i;
    }
}
