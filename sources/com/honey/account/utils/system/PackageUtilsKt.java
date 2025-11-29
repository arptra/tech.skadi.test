package com.honey.account.utils.system;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0006"}, d2 = {"getAppVersionCode", "", "context", "Landroid/content/Context;", "getAppVersionName", "", "CoreLibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class PackageUtilsKt {
    public static final long getAppVersionCode(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).getLongVersionCode();
        } catch (Exception unused) {
            return 0;
        }
    }

    @NotNull
    public static final String getAppVersionName(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            Intrinsics.checkNotNull(str);
            return str;
        } catch (Exception unused) {
            return "";
        }
    }
}
