package com.upuphone.ar.translation.ext;

import android.app.Activity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/app/Activity;", "", "b", "(Landroid/app/Activity;)Z", "", "a", "(Landroid/app/Activity;)I", "ar-translator_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class ActivityExtKt {
    public static final int a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        WindowInsetsCompat H = ViewCompat.H(activity.getWindow().getDecorView());
        if (H == null) {
            LogExt.j("getNavigationBarHeight windowInsets is null", "ActivityExt");
            return 0;
        }
        Insets f = H.f(WindowInsetsCompat.Type.d());
        Intrinsics.checkNotNullExpressionValue(f, "getInsets(...)");
        int abs = Math.abs(f.d - f.b);
        LogExt.j("getNavigationBarHeight naviHeight=" + abs, "ActivityExt");
        return abs;
    }

    public static final boolean b(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        WindowInsetsCompat H = ViewCompat.H(activity.getWindow().getDecorView());
        if (H == null) {
            LogExt.j("hasNavigationBars windowInsets is null", "ActivityExt");
            return false;
        }
        boolean q = H.q(WindowInsetsCompat.Type.d());
        int a2 = a(activity);
        LogExt.j("hasNavigationBars naviVisible=" + q + ", naviHeight=" + a2, "ActivityExt");
        return q && a2 > 0;
    }
}
