package com.android.dingtalk.openauth.utils;

import a.a.a.a.a.c;
import a.a.a.a.a.e;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;

public class DDAuthUtil {
    public static final int ENV_DAILY = 2;
    public static final int ENV_ONLINE = 0;
    public static final int ENV_PRE = 1;
    public static Boolean sDebug = null;
    public static int sEnv = 0;
    public static volatile int sTargetSdkVersion = -1;

    public static boolean checkSumConsistent(Context context, String str) {
        if (isDebug(context)) {
            c.a("checkSumConsistent ignore");
            return true;
        }
        String a2 = e.a(context, str);
        boolean equals = TextUtils.equals(a2, DDAuthConstant.DD_APP_SIGNATURE);
        if (!equals) {
            c.a("checkSumConsistent fail, md5Signature : " + a2 + ", ddAppSignature : " + DDAuthConstant.DD_APP_SIGNATURE);
        }
        return equals;
    }

    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String getAuthLoginUrl(Context context) {
        if (!isDebug(context)) {
            return DDAuthConstant.DD_AUTH_LOGIN_URL;
        }
        int i = sEnv;
        return i != 1 ? i != 2 ? DDAuthConstant.DD_AUTH_LOGIN_URL : DDAuthConstant.DD_AUTH_LOGIN_URL_DAILY : DDAuthConstant.DD_AUTH_LOGIN_URL_PRE;
    }

    public static int getDDSupportAPI(Context context) {
        if (!isDDAppInstalled(context)) {
            return 0;
        }
        return getSdkVersionFromMetaData(context);
    }

    public static int getSdkVersionFromMetaData(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(DDAuthConstant.DD_APP_PACKAGE, 128).metaData;
            if (bundle != null) {
                return bundle.getInt(DDAuthConstant.DD_SDK_VERSION_META_KEY);
            }
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            c.a("getSdkVersionFromMetaData exception : " + e.getLocalizedMessage());
        }
        return 0;
    }

    public static int getTargetSdkVersion(Context context) {
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo2;
        if (sTargetSdkVersion != -1) {
            return sTargetSdkVersion;
        }
        if (context == null) {
            return -1;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (!(packageManager == null || (packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0)) == null || (applicationInfo2 = packageInfo.applicationInfo) == null)) {
                sTargetSdkVersion = applicationInfo2.targetSdkVersion;
            }
            if (sTargetSdkVersion == -1 && (applicationInfo = context.getApplicationInfo()) != null) {
                sTargetSdkVersion = applicationInfo.targetSdkVersion;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sTargetSdkVersion;
    }

    public static boolean isDDAppInstalled(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(DDAuthConstant.DD_APP_PACKAGE, 64) != null && checkSumConsistent(context, DDAuthConstant.DD_APP_PACKAGE);
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            c.a("isDDAppInstalled exception : " + e.getLocalizedMessage());
            return false;
        }
    }

    public static boolean isDDSupportAPI(Context context) {
        int dDSupportAPI = getDDSupportAPI(context);
        boolean z = dDSupportAPI >= 20210101;
        if (!z) {
            c.a("isDDSupportAPI fail, ddSupportAPI : " + dDSupportAPI + ", authSdkVersion : " + 20210101);
        }
        return z;
    }

    public static boolean isDebug(Context context) {
        if (sDebug == null) {
            sDebug = isDebugApp(context);
        }
        Boolean bool = sDebug;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static Boolean isDebugApp(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return Boolean.valueOf((context.getApplicationInfo().flags & 2) != 0);
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    public static boolean isTarget30FeatureEnable(Context context) {
        return getTargetSdkVersion(context) >= 30;
    }

    public static void setEnv(int i) {
        sEnv = i;
    }
}
