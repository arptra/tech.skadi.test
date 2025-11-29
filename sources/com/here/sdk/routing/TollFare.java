package com.here.sdk.routing;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.Objects;

public final class TollFare {
    @NonNull
    public String currency;
    @NonNull
    public List<PaymentMethod> paymentMethods;
    public double price;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TollFare)) {
            return false;
        }
        TollFare tollFare = (TollFare) obj;
        return Objects.equals(this.currency, tollFare.currency) && Double.compare(this.price, tollFare.price) == 0 && Objects.equals(this.paymentMethods, tollFare.paymentMethods);
    }

    public int hashCode() {
        String str = this.currency;
        int i = 0;
        int hashCode = (((217 + (str != null ? str.hashCode() : 0)) * 31) + ((int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32)))) * 31;
        List<PaymentMethod> list = this.paymentMethods;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }
}
