package com.scwang.smart.refresh.layout.constant;

public class SpinnerStyle {
    public static final SpinnerStyle d;
    public static final SpinnerStyle e;
    public static final SpinnerStyle f;
    public static final SpinnerStyle g;
    public static final SpinnerStyle h;
    public static final SpinnerStyle[] i;

    /* renamed from: a  reason: collision with root package name */
    public final int f9864a;
    public final boolean b;
    public final boolean c;

    static {
        SpinnerStyle spinnerStyle = new SpinnerStyle(0, true, false);
        d = spinnerStyle;
        SpinnerStyle spinnerStyle2 = new SpinnerStyle(1, true, true);
        e = spinnerStyle2;
        SpinnerStyle spinnerStyle3 = new SpinnerStyle(2, false, false);
        f = spinnerStyle3;
        SpinnerStyle spinnerStyle4 = new SpinnerStyle(3, true, false);
        g = spinnerStyle4;
        SpinnerStyle spinnerStyle5 = new SpinnerStyle(4, true, false);
        h = spinnerStyle5;
        i = new SpinnerStyle[]{spinnerStyle, spinnerStyle2, spinnerStyle3, spinnerStyle4, spinnerStyle5};
    }

    public SpinnerStyle(int i2, boolean z, boolean z2) {
        this.f9864a = i2;
        this.b = z;
        this.c = z2;
    }
}
