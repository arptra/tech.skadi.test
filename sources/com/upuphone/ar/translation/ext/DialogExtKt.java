package com.upuphone.ar.translation.ext;

import android.view.View;
import android.view.Window;
import com.upuphone.xr.sapp.utils.FlymeUtils;
import flyme.support.v7.app.AlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lflyme/support/v7/app/AlertDialog;", "", "a", "(Lflyme/support/v7/app/AlertDialog;)V", "ar-translator_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class DialogExtKt {
    public static final void a(AlertDialog alertDialog) {
        View decorView;
        Intrinsics.checkNotNullParameter(alertDialog, "<this>");
        Window window = alertDialog.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            FlymeUtils.a(decorView, alertDialog.getContext());
        }
    }
}
