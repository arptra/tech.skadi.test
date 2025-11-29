package org.mozilla.universalchardet.prober.statemachine;

public abstract class SMModel {

    /* renamed from: a  reason: collision with root package name */
    public PkgInt f3442a;
    public int b;
    public PkgInt c;
    public int[] d;
    public String e;

    public SMModel(PkgInt pkgInt, int i, PkgInt pkgInt2, int[] iArr, String str) {
        this.f3442a = pkgInt;
        this.b = i;
        this.c = pkgInt2;
        this.d = (int[]) iArr.clone();
        this.e = str;
    }

    public int a(int i) {
        return this.d[i];
    }

    public int b(byte b2) {
        return this.f3442a.d(b2 & 255);
    }

    public String c() {
        return this.e;
    }

    public int d(int i, int i2) {
        return this.c.d((i2 * this.b) + i);
    }
}
