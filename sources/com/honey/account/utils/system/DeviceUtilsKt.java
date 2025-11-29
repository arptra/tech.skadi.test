package com.honey.account.utils.system;

import android.content.Context;
import android.os.Build;
import com.fm.sdk.deviceid.DeviceId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u000e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\t\u001a\u00020\u0001\u001a\u000e\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\f\u001a\u00020\u0001\u001a\u0006\u0010\r\u001a\u00020\u0001\u001a\u0006\u0010\u000e\u001a\u00020\u0001¨\u0006\u000f"}, d2 = {"getAndroidId", "", "context", "Landroid/content/Context;", "getBrand", "getImei", "getImeiOr0", "getImeiOrOtherId", "getMaid", "getModel", "getOaid", "getOaidOrOtherId", "getOsVersion", "getSn", "getSystemVersion", "CoreLibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DeviceUtilsKt {
    @NotNull
    public static final String getAndroidId(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String androidId = DeviceId.getAndroidId(context);
        return androidId == null ? "" : androidId;
    }

    @NotNull
    public static final String getBrand() {
        String str = Build.BRAND;
        return str == null ? "" : str;
    }

    @NotNull
    public static final String getImei(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String imei = DeviceId.getImei(context);
        return imei == null ? "" : imei;
    }

    @NotNull
    public static final String getImeiOr0(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String imei = getImei(context);
        if (imei.length() == 0) {
            imei = "0";
        }
        Intrinsics.checkNotNull(imei);
        return imei;
    }

    @NotNull
    public static final String getImeiOrOtherId(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        String imei = getImei(applicationContext);
        return imei.length() > 0 ? imei : getOaidOrOtherId(context);
    }

    @NotNull
    public static final String getMaid(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String maid = DeviceId.getMaid(context);
        return maid == null ? "" : maid;
    }

    @NotNull
    public static final String getModel() {
        String str = Build.MODEL;
        return str == null ? "" : str;
    }

    @NotNull
    public static final String getOaid(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String oaid = DeviceId.getOaid(context);
        return oaid == null ? "" : oaid;
    }

    @NotNull
    public static final String getOaidOrOtherId(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        String oaid = getOaid(applicationContext);
        if (oaid.length() > 0) {
            return oaid;
        }
        Context applicationContext2 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        String androidId = getAndroidId(applicationContext2);
        if (androidId.length() > 0) {
            return androidId;
        }
        Context applicationContext3 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
        String maid = getMaid(applicationContext3);
        return maid.length() > 0 ? maid : "";
    }

    @NotNull
    public static final String getOsVersion() {
        String str = Build.DISPLAY;
        return str == null ? "" : str;
    }

    @NotNull
    public static final String getSn() {
        String sn = DeviceId.getSn();
        return sn == null ? "" : sn;
    }

    @NotNull
    public static final String getSystemVersion() {
        String systemProperties = SystemUtilsKt.getSystemProperties("ro.build.mask.id");
        return (systemProperties == null || systemProperties.length() == 0) ? getOsVersion() : systemProperties;
    }
}
