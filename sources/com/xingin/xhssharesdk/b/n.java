package com.xingin.xhssharesdk.b;

import com.xingin.xhssharesdk.i.i;

public final class n implements Cloneable {
    public static final n c = new n();

    /* renamed from: a  reason: collision with root package name */
    public String f8162a;
    public String b;

    public static n b() {
        try {
            n nVar = c;
            nVar.f8162a = ((i) f.i.h).a();
            f.i.h.getClass();
            nVar.b = "";
            return (n) nVar.clone();
        } catch (CloneNotSupportedException unused) {
            return c;
        }
    }

    public final String toString() {
        return "TrackerEventUser{userId='" + this.f8162a + "', userGroupId='" + this.b + "'}";
    }
}
