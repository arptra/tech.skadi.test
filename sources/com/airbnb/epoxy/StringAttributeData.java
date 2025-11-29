package com.airbnb.epoxy;

import java.util.Arrays;

public class StringAttributeData {

    /* renamed from: a  reason: collision with root package name */
    public CharSequence f2315a;
    public int b;
    public int c;
    public int d;
    public Object[] e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StringAttributeData)) {
            return false;
        }
        StringAttributeData stringAttributeData = (StringAttributeData) obj;
        if (this.b != stringAttributeData.b || this.c != stringAttributeData.c || this.d != stringAttributeData.d) {
            return false;
        }
        CharSequence charSequence = this.f2315a;
        if (charSequence == null ? stringAttributeData.f2315a == null : charSequence.equals(stringAttributeData.f2315a)) {
            return Arrays.equals(this.e, stringAttributeData.e);
        }
        return false;
    }

    public int hashCode() {
        CharSequence charSequence = this.f2315a;
        return ((((((((charSequence != null ? charSequence.hashCode() : 0) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + Arrays.hashCode(this.e);
    }
}
