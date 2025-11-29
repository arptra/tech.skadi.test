package com.xingin.xhssharesdk.b;

public final class m implements Cloneable {
    public static final m c = new m();

    /* renamed from: a  reason: collision with root package name */
    public String f8161a;
    public String b;

    public static m b() {
        try {
            m mVar = c;
            f.i.h.getClass();
            mVar.f8161a = "mobile";
            f.i.h.getClass();
            mVar.b = "";
            return (m) mVar.clone();
        } catch (CloneNotSupportedException unused) {
            return c;
        }
    }

    public final String toString() {
        return "TrackerEventNetwork{networkType='" + this.f8161a + "', ispName='" + this.b + "'}";
    }
}
