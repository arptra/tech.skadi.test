package com.xingin.xhssharesdk.b;

public final class l implements Cloneable {
    public static final l d = new l();

    /* renamed from: a  reason: collision with root package name */
    public String f8160a;
    public String b;
    public int c;

    public static l b() {
        try {
            l lVar = d;
            f.i.h.getClass();
            lVar.f8160a = "";
            f.i.h.getClass();
            lVar.b = "";
            f.i.h.getClass();
            lVar.c = 1;
            return (l) lVar.clone();
        } catch (CloneNotSupportedException unused) {
            return d;
        }
    }

    public final String toString() {
        return "TrackerEventEnv{sessionId='" + this.f8160a + "', launchId='" + this.b + "', appMode=" + b.b(this.c) + '}';
    }
}
