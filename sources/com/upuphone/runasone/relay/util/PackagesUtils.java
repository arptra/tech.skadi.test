package com.upuphone.runasone.relay.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/upuphone/runasone/relay/util/PackagesUtils;", "", "()V", "PACKAGE_CURRENT_CODE", "", "PACKAGE_STARRYNET", "", "getVersionCode", "", "context", "Landroid/content/Context;", "getVersionName", "isAppInstalled", "", "packageName", "isSupportMulSendMsg", "relay-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PackagesUtils {
    @NotNull
    public static final PackagesUtils INSTANCE = new PackagesUtils();
    public static final int PACKAGE_CURRENT_CODE = 20780;
    @NotNull
    public static final String PACKAGE_STARRYNET = "com.upuphone.starrynet";

    private PackagesUtils() {
    }

    public final long getVersionCode(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.upuphone.starrynet", 0);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "context.packageManager.g…    PACKAGE_STARRYNET, 0)");
            return packageInfo.getLongVersionCode();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @NotNull
    public final String getVersionName(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.upuphone.starrynet", 0);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "context.packageManager.g…    PACKAGE_STARRYNET, 0)");
            String str = packageInfo.versionName;
            Intrinsics.checkNotNullExpressionValue(str, "packageInfo.versionName");
            return str;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public final boolean isAppInstalled(@NotNull Context context, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        PackageManager packageManager = context.getPackageManager();
        try {
            Intrinsics.checkNotNull(str);
            packageManager.getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final boolean isSupportMulSendMsg(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return isAppInstalled(context, "com.upuphone.starrynet") && getVersionCode(context) > 20780;
    }
}
