package com.here.sdk.search;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class SupplierReference {
    @NonNull
    public String id;
    @NonNull
    public String supplier;

    public SupplierReference(@NonNull String str, @NonNull String str2) {
        this.supplier = str;
        this.id = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SupplierReference)) {
            return false;
        }
        SupplierReference supplierReference = (SupplierReference) obj;
        return Objects.equals(this.supplier, supplierReference.supplier) && Objects.equals(this.id, supplierReference.id);
    }

    public int hashCode() {
        String str = this.supplier;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.id;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public SupplierReference() {
        this.supplier = "";
        this.id = "";
    }
}
