package com.xjsd.ai.assistant.core.util;

import android.text.TextUtils;

public class DeviceUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8459a = ("deviceId_" + System.currentTimeMillis());
    public static String b = "";
    public static String c = "";
    public static String d = "";

    public static String a() {
        return TextUtils.isEmpty(c) ? f8459a : c;
    }

    public static boolean b() {
        return TextUtils.equals("1003", b);
    }

    public static boolean c() {
        return TextUtils.equals("1004", b);
    }

    public static boolean d() {
        return b() || c() || h() || i();
    }

    public static boolean e() {
        return TextUtils.equals("1001", b);
    }

    public static boolean f() {
        return !TextUtils.isEmpty(d);
    }

    public static boolean g() {
        return !TextUtils.isEmpty(c);
    }

    public static boolean h() {
        return TextUtils.equals("5001", b);
    }

    public static boolean i() {
        return TextUtils.equals("5002", b);
    }

    public static boolean j() {
        return TextUtils.equals("1002", b);
    }

    public static void k(String str) {
        d = str;
    }

    public static void l(String str) {
        c = str;
    }

    public static void m(String str) {
        b = str;
    }
}
