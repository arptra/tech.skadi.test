package com.upuphone.xr.sapp.utils;

import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a#\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\"\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\n\u0010\b\"\u0015\u0010\r\u001a\u00020\u0004*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\f\u0010\b\"\u0015\u0010\u0011\u001a\u00020\u000e*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"", "", "num", "roundingMode", "", "e", "(Ljava/lang/Number;II)D", "c", "(Ljava/lang/Number;)D", "keepNoPoint", "a", "keep1Point", "b", "keep2Point", "", "d", "(D)Ljava/lang/String;", "removePointZero", "lib_common_release"}, k = 2, mv = {1, 9, 0})
public final class MathExtKt {
    public static final double a(Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return f(number, 1, 0, 2, (Object) null);
    }

    public static final double b(Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return f(number, 2, 0, 2, (Object) null);
    }

    public static final double c(Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return f(number, 0, 0, 2, (Object) null);
    }

    public static final String d(double d) {
        return d % ((double) 1) > 0.0d ? String.valueOf(d) : String.valueOf((int) d);
    }

    public static final double e(Number number, int i, int i2) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return new BigDecimal(number.toString()).setScale(i, i2).doubleValue();
    }

    public static /* synthetic */ double f(Number number, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 6;
        }
        return e(number, i, i2);
    }
}
