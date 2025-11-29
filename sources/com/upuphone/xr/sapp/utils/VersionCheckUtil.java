package com.upuphone.xr.sapp.utils;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.common.StarryNetConstant;
import com.upuphone.xr.sapp.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/utils/VersionCheckUtil;", "", "<init>", "()V", "", "pkgName", "", "d", "(Ljava/lang/String;)Z", "packageName", "c", "marketPackageName", "e", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "a", "brand", "b", "(Ljava/lang/String;)Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVersionCheckUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VersionCheckUtil.kt\ncom/upuphone/xr/sapp/utils/VersionCheckUtil\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,200:1\n1855#2,2:201\n*S KotlinDebug\n*F\n+ 1 VersionCheckUtil.kt\ncom/upuphone/xr/sapp/utils/VersionCheckUtil\n*L\n178#1:201,2\n*E\n"})
public final class VersionCheckUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final VersionCheckUtil f7929a = new VersionCheckUtil();

    public final void a() {
        try {
            Intent intent = new Intent();
            intent.setData(Uri.parse("https://www.myvu.cn/app-get/download.html"));
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            GlobalExtKt.f().startActivity(intent);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("VersionCheckUtil", "defaultUpdateApp error: " + message);
        }
    }

    public final String b(String str) {
        String upperCase = str.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        switch (upperCase.hashCode()) {
            case -1706170181:
                if (upperCase.equals("XIAOMI")) {
                    return "com.xiaomi.market";
                }
                break;
            case -602397472:
                if (upperCase.equals("ONEPLUS")) {
                    return "com.heytap.market";
                }
                break;
            case 2432928:
                if (upperCase.equals(StarryNetConstant.DEVICE_NAME_OPPO)) {
                    return "com.heytap.market";
                }
                break;
            case 2634924:
                if (upperCase.equals("VIVO")) {
                    return "com.bbk.appstore";
                }
                break;
            case 68924490:
                if (upperCase.equals("HONOR")) {
                    return "com.hihonor.appmarket";
                }
                break;
            case 73239724:
                if (upperCase.equals("MEIZU")) {
                    return "com.meizu.mstore";
                }
                break;
            case 77852109:
                if (upperCase.equals("REDMI")) {
                    return "com.xiaomi.market";
                }
                break;
            case 2141820391:
                if (upperCase.equals("HUAWEI")) {
                    return "com.huawei.appmarket";
                }
                break;
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("VersionCheckUtil", "no match brand, brand: " + str);
        return "";
    }

    public final boolean c(String str) {
        Intrinsics.checkNotNullParameter(str, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        try {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("VersionCheckUtil", "openGooglePlayMarket, packageName: " + str);
            Uri parse = Uri.parse("market://details?id=" + str);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            Intent intent = new Intent("android.intent.action.VIEW", parse);
            intent.setPackage("com.android.vending");
            intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            GlobalExtKt.f().startActivity(intent);
            delegate.g("VersionCheckUtil", "openGooglePlayMarket, success");
            return true;
        } catch (Throwable th) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("VersionCheckUtil", "openGooglePlayMarket, error: " + th);
            ContextExtKt.e(R.string.fail_to_open_google_play, 0, 2, (Object) null);
            return false;
        }
    }

    public final boolean d(String str) {
        Intrinsics.checkNotNullParameter(str, "pkgName");
        String str2 = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(str2, "BRAND");
        if (StringsKt.isBlank(str2)) {
            ULog.f6446a.g("VersionCheckUtil", "brand is null");
            return false;
        }
        String b = b(str2);
        if (b != null && !StringsKt.isBlank(b)) {
            return e(b, str);
        }
        a();
        return true;
    }

    public final boolean e(String str, String str2) {
        try {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("VersionCheckUtil", "startMarket, marketPackageName: " + str + ", packageName: " + str2);
            StringBuilder sb = new StringBuilder();
            sb.append("market://details?id=");
            sb.append(str2);
            Uri parse = Uri.parse(sb.toString());
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            Intent intent = new Intent("android.intent.action.VIEW", parse);
            intent.setPackage(str);
            intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            GlobalExtKt.f().startActivity(intent);
            delegate.g("VersionCheckUtil", "startMarket, success");
            return true;
        } catch (Throwable th) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("VersionCheckUtil", "startMarket, error: " + th);
            a();
            return false;
        }
    }
}
