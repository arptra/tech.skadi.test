package com.upuphone.starrycommon.threads;

public class UupMsg {
    public static final Object g = new Object();
    public static UupMsg h;
    public static int i;

    /* renamed from: a  reason: collision with root package name */
    public int f6494a;
    public int b;
    public int c;
    public Object d;
    public UupMsg e;
    public Runnable f;

    public void a() {
        b();
    }

    public void b() {
        this.f6494a = 0;
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.f = null;
        synchronized (g) {
            try {
                int i2 = i;
                if (i2 < 50) {
                    this.e = h;
                    h = this;
                    i = i2 + 1;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
