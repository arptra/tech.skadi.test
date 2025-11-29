package com.upuphone.xr.sapp.utils;

import android.app.Activity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0007\u001a\u00020\u0004*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Landroid/app/Activity;", "", "a", "(Landroid/app/Activity;)V", "", "b", "(Landroid/app/Activity;)Z", "isImeVisible", "lib_common_release"}, k = 2, mv = {1, 9, 0})
public final class ActivityExtKt {
    public static final void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        WindowCompat.a(activity.getWindow(), activity.getWindow().getDecorView()).a(WindowInsetsCompat.Type.a());
    }

    public static final boolean b(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        WindowInsetsCompat H = ViewCompat.H(activity.getWindow().getDecorView());
        if (H != null) {
            return H.q(WindowInsetsCompat.Type.a());
        }
        return false;
    }
}
