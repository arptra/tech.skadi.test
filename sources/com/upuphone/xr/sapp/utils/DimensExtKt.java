package com.upuphone.xr.sapp.utils;

import android.util.TypedValue;
import com.upuphone.xr.sapp.context.SdkContext;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\"\u0015\u0010\u0003\u001a\u00020\u0000*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0001\u0010\u0002\"\u0015\u0010\u0003\u001a\u00020\u0000*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "b", "(I)I", "dp", "", "a", "(F)I", "lib_common_release"}, k = 2, mv = {1, 9, 0})
public final class DimensExtKt {
    public static final int a(float f) {
        return (int) TypedValue.applyDimension(1, f, SdkContext.f6675a.c().getContext().getResources().getDisplayMetrics());
    }

    public static final int b(int i) {
        return a((float) i);
    }
}
