package com.upuphone.datatrack.base.utils;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.ucar.vehiclesdk.MDevice;
import com.upuphone.runasone.channel.linker.starrystack.NetworkUtils;

public class XJDeviceUtil {

    /* renamed from: a  reason: collision with root package name */
    public static String f6402a = "";
    public static String b;
    public static String c;
    public static String d;
    public static int e;
    public static int f;

    public static void A(String str) {
        c = str;
    }

    public static void B(int i) {
        e = i;
    }

    public static String a(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String b() {
        return Build.BRAND;
    }

    public static String c() {
        return Build.DISPLAY;
    }

    public static String d(Context context) {
        return a(context);
    }

    public static String e() {
        return Build.MODEL;
    }

    public static String f() {
        return b;
    }

    public static String g() {
        return d;
    }

    public static String h() {
        return c;
    }

    public static int i() {
        return e;
    }

    public static String j(Context context) {
        return context.getResources().getConfiguration().getLocales().get(0).getLanguage();
    }

    public static String k() {
        return Build.MANUFACTURER;
    }

    public static String l(Context context) {
        return a(context);
    }

    public static String m() {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        return TextUtils.equals(lowerCase, MDevice.MANUFACTURERS_MEIZU) ? "Flyme" : TextUtils.equals(lowerCase, MDevice.MANUFACTURERS_XIAOMI) ? "MIUI" : TextUtils.equals(lowerCase, "huawei") ? "HarmonyOS" : TextUtils.equals(lowerCase, "oneplus") ? "ColorOS" : TextUtils.equals(lowerCase, MDevice.MANUFACTURERS_VIVO) ? "OriginOS" : TextUtils.equals(lowerCase, "honor") ? "MagicOS" : NetworkUtils.UNKNOWN;
    }

    public static String n() {
        return Build.VERSION.RELEASE;
    }

    public static String o(Context context) {
        return a(context);
    }

    public static String p(Context context) {
        return a(context);
    }

    public static String q(Context context) {
        return "";
    }

    public static String r() {
        return Build.PRODUCT;
    }

    public static String s() {
        return f6402a;
    }

    public static int t(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int u(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int v() {
        return f;
    }

    public static String w() {
        return "";
    }

    public static void x(Application application, int i) {
        f = i;
    }

    public static void y(String str) {
        b = str;
    }

    public static void z(String str) {
        d = str;
    }
}
