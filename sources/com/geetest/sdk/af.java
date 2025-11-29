package com.geetest.sdk;

public class af<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public Object f2905a;
    public Object b;

    public af(Object obj, Object obj2) {
        this.f2905a = obj;
        this.b = obj2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof af)) {
            return false;
        }
        try {
            af afVar = (af) obj;
            return this.f2905a.equals(afVar.f2905a) && this.b.equals(afVar.b);
        } catch (Exception unused) {
            return false;
        }
    }

    public int hashCode() {
        return ((this.f2905a.hashCode() + 527) * 31) + this.b.hashCode();
    }
}
