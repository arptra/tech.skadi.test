package com.upuphone.ar.transcribe.ext;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.upuphone.xr.sapp.utils.FlymeUtils;
import flyme.support.v7.app.AlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\t\u001a\u00020\b*\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/app/Activity;", "", "c", "(Landroid/app/Activity;)Z", "", "b", "(Landroid/app/Activity;)I", "Lflyme/support/v7/app/AlertDialog;", "", "a", "(Lflyme/support/v7/app/AlertDialog;)V", "ar-transcribe_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class ActivityExtKt {
    public static final void a(AlertDialog alertDialog) {
        View decorView;
        Intrinsics.checkNotNullParameter(alertDialog, "<this>");
        Window window = alertDialog.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            FlymeUtils.a(decorView, alertDialog.getContext());
        }
    }

    public static final int b(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        WindowInsetsCompat H = ViewCompat.H(activity.getWindow().getDecorView());
        if (H == null) {
            LogExt.g("getNavigationBarHeight windowInsets is null", "ActivityExt");
            return 0;
        }
        Insets f = H.f(WindowInsetsCompat.Type.d());
        Intrinsics.checkNotNullExpressionValue(f, "getInsets(...)");
        int abs = Math.abs(f.d - f.b);
        LogExt.g("getNavigationBarHeight naviHeight=" + abs, "ActivityExt");
        return abs;
    }

    public static final boolean c(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        WindowInsetsCompat H = ViewCompat.H(activity.getWindow().getDecorView());
        if (H == null) {
            LogExt.g("hasNavigationBars windowInsets is null", "ActivityExt");
            return false;
        }
        boolean q = H.q(WindowInsetsCompat.Type.d());
        int b = b(activity);
        LogExt.g("hasNavigationBars naviVisible=" + q + ", naviHeight=" + b, "ActivityExt");
        return q && b > 0;
    }
}
