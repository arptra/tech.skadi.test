package com.here.sdk.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class EVChargingPool {
    @NonNull
    public List<EVChargingStation> chargingStations;
    @Nullable
    public String cpoId = null;
    @Nullable
    public EVChargingPoolDetails details = null;
    @NonNull
    public List<Evse> evseInfo = new ArrayList();

    public EVChargingPool(@NonNull List<EVChargingStation> list) {
        this.chargingStations = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EVChargingPool)) {
            return false;
        }
        EVChargingPool eVChargingPool = (EVChargingPool) obj;
        return Objects.equals(this.chargingStations, eVChargingPool.chargingStations) && Objects.equals(this.details, eVChargingPool.details) && Objects.equals(this.cpoId, eVChargingPool.cpoId) && Objects.equals(this.evseInfo, eVChargingPool.evseInfo);
    }

    public int hashCode() {
        List<EVChargingStation> list = this.chargingStations;
        int i = 0;
        int hashCode = (217 + (list != null ? list.hashCode() : 0)) * 31;
        EVChargingPoolDetails eVChargingPoolDetails = this.details;
        int hashCode2 = (hashCode + (eVChargingPoolDetails != null ? eVChargingPoolDetails.hashCode() : 0)) * 31;
        String str = this.cpoId;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        List<Evse> list2 = this.evseInfo;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode3 + i;
    }
}
