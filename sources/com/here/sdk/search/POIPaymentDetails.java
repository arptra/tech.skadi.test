package com.here.sdk.search;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class POIPaymentDetails {
    @NonNull
    public List<String> acceptedCashCurrencies = new ArrayList();
    @NonNull
    public List<String> acceptedMethods = new ArrayList();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof POIPaymentDetails)) {
            return false;
        }
        POIPaymentDetails pOIPaymentDetails = (POIPaymentDetails) obj;
        return Objects.equals(this.acceptedMethods, pOIPaymentDetails.acceptedMethods) && Objects.equals(this.acceptedCashCurrencies, pOIPaymentDetails.acceptedCashCurrencies);
    }

    public int hashCode() {
        List<String> list = this.acceptedMethods;
        int i = 0;
        int hashCode = (217 + (list != null ? list.hashCode() : 0)) * 31;
        List<String> list2 = this.acceptedCashCurrencies;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }
}
