package com.xjmz.myvu.flutter;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/fragment/app/Fragment;", "", "initialRoute", "", "a", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "app_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class FlutterExtKt {
    public static final void a(Fragment fragment, String str) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(str, "initialRoute");
        try {
            if (!fragment.isDetached() && !fragment.isRemoving()) {
                NavHostFragment.f.c(fragment).P(R.id.flutterRouteFragment, FlutterRouteFragment.f.a(str), StaticMethodUtilsKt.j());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
