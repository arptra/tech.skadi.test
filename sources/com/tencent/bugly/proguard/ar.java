package com.tencent.bugly.proguard;

public final class ar implements Comparable<ar> {

    /* renamed from: a  reason: collision with root package name */
    public long f9539a = -1;
    public long b = -1;
    public String c = null;
    public boolean d = false;
    public boolean e = false;
    public int f = 0;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        int i;
        ar arVar = (ar) obj;
        if (arVar == null || this.b - arVar.b > 0) {
            return 1;
        }
        return i < 0 ? -1 : 0;
    }
}
