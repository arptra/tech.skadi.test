package com.here.sdk.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class BusinessDetails {
    @NonNull
    public List<Contact> contacts = new ArrayList();
    @Nullable
    public EVChargingPool evChargingPool = null;
    @NonNull
    public List<OpeningHours> openingHours = new ArrayList();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BusinessDetails)) {
            return false;
        }
        BusinessDetails businessDetails = (BusinessDetails) obj;
        return Objects.equals(this.contacts, businessDetails.contacts) && Objects.equals(this.openingHours, businessDetails.openingHours) && Objects.equals(this.evChargingPool, businessDetails.evChargingPool);
    }

    public int hashCode() {
        List<Contact> list = this.contacts;
        int i = 0;
        int hashCode = (217 + (list != null ? list.hashCode() : 0)) * 31;
        List<OpeningHours> list2 = this.openingHours;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        EVChargingPool eVChargingPool = this.evChargingPool;
        if (eVChargingPool != null) {
            i = eVChargingPool.hashCode();
        }
        return hashCode2 + i;
    }
}
