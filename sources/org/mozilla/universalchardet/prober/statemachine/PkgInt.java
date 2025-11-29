package org.mozilla.universalchardet.prober.statemachine;

public class PkgInt {

    /* renamed from: a  reason: collision with root package name */
    public int f3441a;
    public int b;
    public int c;
    public int d;
    public int[] e;

    public PkgInt(int i, int i2, int i3, int i4, int[] iArr) {
        this.f3441a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = (int[]) iArr.clone();
    }

    public static int a(int i, int i2) {
        return i | (i2 << 16);
    }

    public static int b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return c(i | (i2 << 4), (i4 << 4) | i3, (i6 << 4) | i5, (i8 << 4) | i7);
    }

    public static int c(int i, int i2, int i3, int i4) {
        return a(i | (i2 << 8), (i4 << 8) | i3);
    }

    public int d(int i) {
        return this.d & (this.e[i >> this.f3441a] >> ((i & this.b) << this.c));
    }
}
