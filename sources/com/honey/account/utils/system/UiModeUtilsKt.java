package com.honey.account.utils.system;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import androidx.appcompat.app.AppCompatDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, d2 = {"getColorByAttr", "", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "attrRes", "getUiMode", "context", "Landroid/content/Context;", "isNightMode", "", "CoreLibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UiModeUtilsKt {
    public static final int getColorByAttr(@NotNull Resources.Theme theme, int i) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        TypedValue typedValue = new TypedValue();
        theme.resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    private static final int getUiMode(Context context) {
        Object systemService = context.getSystemService("uimode");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.UiModeManager");
        return ((UiModeManager) systemService).getNightMode();
    }

    public static final boolean isNightMode(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getUiMode(context) == 2 || AppCompatDelegate.k() == 2;
    }
}
