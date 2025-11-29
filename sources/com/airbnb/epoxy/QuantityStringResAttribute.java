package com.airbnb.epoxy;

import java.util.Arrays;

public class QuantityStringResAttribute {

    /* renamed from: a  reason: collision with root package name */
    public final int f2314a;
    public final int b;
    public final Object[] c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuantityStringResAttribute)) {
            return false;
        }
        QuantityStringResAttribute quantityStringResAttribute = (QuantityStringResAttribute) obj;
        if (this.f2314a == quantityStringResAttribute.f2314a && this.b == quantityStringResAttribute.b) {
            return Arrays.equals(this.c, quantityStringResAttribute.c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f2314a * 31) + this.b) * 31) + Arrays.hashCode(this.c);
    }
}
