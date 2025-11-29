package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.sdk.routing.PaymentMethod;
import java.util.List;
import java.util.Objects;

public final class TollBooth {
    @NonNull
    public List<PaymentMethod> paymentMethods;
    @NonNull
    public List<TollCollectionMethod> tollCollectionMethods;

    public TollBooth(@NonNull List<TollCollectionMethod> list, @NonNull List<PaymentMethod> list2) {
        this.tollCollectionMethods = list;
        this.paymentMethods = list2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TollBooth)) {
            return false;
        }
        TollBooth tollBooth = (TollBooth) obj;
        return Objects.equals(this.tollCollectionMethods, tollBooth.tollCollectionMethods) && Objects.equals(this.paymentMethods, tollBooth.paymentMethods);
    }

    public int hashCode() {
        List<TollCollectionMethod> list = this.tollCollectionMethods;
        int i = 0;
        int hashCode = (217 + (list != null ? list.hashCode() : 0)) * 31;
        List<PaymentMethod> list2 = this.paymentMethods;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }
}
