package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class RoadSignWarningOptions {
    @NonNull
    public List<RoadSignCategory> categoriesFilter = new ArrayList();
    @NonNull
    public List<GeneralWarningRoadSignType> generalWarningTypesFilter = new ArrayList();
    @NonNull
    public List<RoadSignType> typesFilter = new ArrayList();
    @NonNull
    public List<RoadSignVehicleType> vehicleTypesFilter = new ArrayList();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RoadSignWarningOptions)) {
            return false;
        }
        RoadSignWarningOptions roadSignWarningOptions = (RoadSignWarningOptions) obj;
        return Objects.equals(this.typesFilter, roadSignWarningOptions.typesFilter) && Objects.equals(this.categoriesFilter, roadSignWarningOptions.categoriesFilter) && Objects.equals(this.generalWarningTypesFilter, roadSignWarningOptions.generalWarningTypesFilter) && Objects.equals(this.vehicleTypesFilter, roadSignWarningOptions.vehicleTypesFilter);
    }

    public int hashCode() {
        List<RoadSignType> list = this.typesFilter;
        int i = 0;
        int hashCode = (217 + (list != null ? list.hashCode() : 0)) * 31;
        List<RoadSignCategory> list2 = this.categoriesFilter;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<GeneralWarningRoadSignType> list3 = this.generalWarningTypesFilter;
        int hashCode3 = (hashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<RoadSignVehicleType> list4 = this.vehicleTypesFilter;
        if (list4 != null) {
            i = list4.hashCode();
        }
        return hashCode3 + i;
    }
}
