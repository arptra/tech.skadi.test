package com.upuphone.datatrack.base.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;

public class XJPackageUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6403a = "XJPackageUtil";
    public static String b;
    public static String c;
    public static boolean d;

    public static String a() {
        return "67956346876553894800";
    }

    public static String b() {
        return c;
    }

    public static String c(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getApplicationInfo().packageName, 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String d(Context context) {
        try {
            return context.getPackageName();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String f(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String g() {
        return "Android";
    }

    public static String h() {
        String str = f6403a;
        Log.d(str, "getSdkVersion: " + "0.4.14-SNAPSHOT");
        return "0.4.14";
    }

    public static String i() {
        return b;
    }

    public static boolean j() {
        return d;
    }

    public static Boolean k(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("data_track", 0);
        boolean z = sharedPreferences.getBoolean("IS_FIRST_RUN", true);
        Boolean valueOf = Boolean.valueOf(z);
        if (z) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("IS_FIRST_RUN", false);
            edit.commit();
        }
        return valueOf;
    }

    public static void l(String str) {
        c = str;
    }

    public static void m(boolean z) {
        d = z;
    }

    public static void n(String str) {
        b = str;
    }
}
