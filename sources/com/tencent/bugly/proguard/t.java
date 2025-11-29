package com.tencent.bugly.proguard;

import java.io.Serializable;

public final class t implements Serializable, Comparable<t> {

    /* renamed from: a  reason: collision with root package name */
    public long f9595a;
    public String b;
    public long c;
    public int d;
    public String e;
    public String f;
    public long g;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return (int) (this.c - ((t) obj).c);
    }
}
