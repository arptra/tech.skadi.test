package com.upuphone.ai.ttsengine.base.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

public class PackageUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final AILOG f5528a = AILOG.a("PackageUtils");

    public static String a(Context context, String str) {
        try {
            return (Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.ApplicationInfoFlags.of(128)) : context.getPackageManager().getApplicationInfo(context.getPackageName(), 128)).metaData.getString(str, (String) null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean b(Context context) {
        return "com.upuphone.ai.ttsengine".equals(context.getPackageName());
    }
}
