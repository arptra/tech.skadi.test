package com.scwang.smart.refresh.layout.constant;

public class DimensionStatus {
    public static final DimensionStatus c;
    public static final DimensionStatus d;
    public static final DimensionStatus e;
    public static final DimensionStatus f;
    public static final DimensionStatus g;
    public static final DimensionStatus h;
    public static final DimensionStatus i;
    public static final DimensionStatus j;
    public static final DimensionStatus k;
    public static final DimensionStatus l;
    public static final DimensionStatus m;
    public static final DimensionStatus n;
    public static final DimensionStatus[] o;

    /* renamed from: a  reason: collision with root package name */
    public final int f9863a;
    public final boolean b;

    static {
        DimensionStatus dimensionStatus = new DimensionStatus(0, false);
        c = dimensionStatus;
        DimensionStatus dimensionStatus2 = new DimensionStatus(1, true);
        d = dimensionStatus2;
        DimensionStatus dimensionStatus3 = new DimensionStatus(2, false);
        e = dimensionStatus3;
        DimensionStatus dimensionStatus4 = new DimensionStatus(3, true);
        f = dimensionStatus4;
        DimensionStatus dimensionStatus5 = new DimensionStatus(4, false);
        g = dimensionStatus5;
        DimensionStatus dimensionStatus6 = new DimensionStatus(5, true);
        h = dimensionStatus6;
        DimensionStatus dimensionStatus7 = new DimensionStatus(6, false);
        i = dimensionStatus7;
        DimensionStatus dimensionStatus8 = new DimensionStatus(7, true);
        j = dimensionStatus8;
        DimensionStatus dimensionStatus9 = new DimensionStatus(8, false);
        k = dimensionStatus9;
        DimensionStatus dimensionStatus10 = new DimensionStatus(9, true);
        l = dimensionStatus10;
        DimensionStatus dimensionStatus11 = new DimensionStatus(10, false);
        m = dimensionStatus11;
        DimensionStatus dimensionStatus12 = new DimensionStatus(10, true);
        n = dimensionStatus12;
        o = new DimensionStatus[]{dimensionStatus, dimensionStatus2, dimensionStatus3, dimensionStatus4, dimensionStatus5, dimensionStatus6, dimensionStatus7, dimensionStatus8, dimensionStatus9, dimensionStatus10, dimensionStatus11, dimensionStatus12};
    }

    public DimensionStatus(int i2, boolean z) {
        this.f9863a = i2;
        this.b = z;
    }

    public boolean a(DimensionStatus dimensionStatus) {
        int i2 = this.f9863a;
        int i3 = dimensionStatus.f9863a;
        return i2 < i3 || ((!this.b || l == this) && i2 == i3);
    }

    public DimensionStatus b() {
        return !this.b ? o[this.f9863a + 1] : this;
    }
}
