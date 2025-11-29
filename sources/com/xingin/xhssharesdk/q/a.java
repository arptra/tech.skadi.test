package com.xingin.xhssharesdk.q;

import android.content.Context;
import android.content.pm.PackageManager;
import com.android.dingtalk.openauth.web.AuthWebviewActivity;
import com.xingin.xhssharesdk.XhsShareSdkTools;
import com.xingin.xhssharesdk.b.e;
import com.xingin.xhssharesdk.b.i;
import com.xingin.xhssharesdk.core.XhsShareSdk;

public final class a {
    public static i.a a(Context context) {
        String str;
        String sdkVersion = XhsShareSdkTools.getSdkVersion();
        String currentAppPackageName = XhsShareSdkTools.getCurrentAppPackageName(context);
        try {
            str = XhsShareSdkTools.getAppVersionName(context, XhsShareSdkTools.getXhsPackageName());
        } catch (PackageManager.NameNotFoundException e) {
            XhsShareSdk.d("SDKTracker", "Get package & Get version", e);
            str = "";
        }
        return new i.a().a(AuthWebviewActivity.m, sdkVersion).a("xhs_version", str).a("app_package", currentAppPackageName);
    }

    public static void b(Context context, String str, boolean z, int i, String str2, long j) {
        e h = e.h();
        i.a a2 = a(context);
        a2.b = 30758;
        a2.c = 3;
        a2.d.put("session_id", str);
        a2.d.put("share_result", z ? "SUCCESS" : "FAIL");
        a2.d.put("share_error_code", String.valueOf(i));
        a2.d.put("share_error_message", str2);
        a2.d.put("time_consume", String.valueOf(j));
        h.d(a2);
    }
}
