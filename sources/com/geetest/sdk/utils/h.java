package com.geetest.sdk.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import java.math.BigDecimal;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static double f2961a;

    public static double a(double d, int i) {
        return new BigDecimal(d).setScale(i, 4).doubleValue();
    }

    public static double b(Context context) {
        Class<h> cls = h.class;
        double d = f2961a;
        if (d != 0.0d) {
            return d;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            String simpleName = cls.getSimpleName();
            l.c(simpleName, "realWidth: " + i + " realHeight：" + i2);
            String simpleName2 = cls.getSimpleName();
            l.c(simpleName2, "density: " + displayMetrics.density + " densityDpi：" + displayMetrics.densityDpi);
            float f = (float) i;
            float f2 = displayMetrics.xdpi;
            float f3 = (f / f2) * (f / f2);
            float f4 = (float) i2;
            float f5 = displayMetrics.ydpi;
            f2961a = a(Math.sqrt((double) (f3 + ((f4 / f5) * (f4 / f5)))), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f2961a;
    }

    public static boolean c(Context context) {
        double b = b(context);
        String simpleName = h.class.getSimpleName();
        l.c(simpleName, "screenInch: " + b);
        return b > 7.0d;
    }
}
