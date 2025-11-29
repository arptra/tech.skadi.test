package com.upuphone.runasone.utils;

import com.upuphone.runasone.utils.log.LogManager;

public class BleLogger {
    private static final String DEFAULT_MESSAGE = "execute";
    private static final String DEFAULT_TAG = "[StarryBle]";

    private BleLogger() {
    }

    public static void d() {
        LogManager.d(getTag((String) null), (byte) 15, DEFAULT_MESSAGE);
    }

    public static void dPrimary(String str, String str2) {
        LogManager.d(getTag(str), (byte) 15, str2);
    }

    public static void e(Object obj) {
        LogManager.e(getTag((String) null), (byte) 15, getMsg(obj));
    }

    public static void ePrimary(String str, String str2) {
        LogManager.e(getTag(str), (byte) 1, str2);
    }

    private static String format(String str, Object... objArr) {
        if (str == null) {
            return null;
        }
        return objArr.length == 0 ? str : String.format(str, objArr);
    }

    private static String getMsg(Object obj) {
        return obj == null ? "Log with null Object" : obj.toString();
    }

    private static String getTag(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(DEFAULT_TAG);
        if (str == null) {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public static void i() {
        LogManager.i(getTag((String) null), (byte) 15, DEFAULT_MESSAGE);
    }

    public static void iPrimary(String str, String str2) {
        LogManager.i(getTag(str), (byte) 1, str2);
    }

    public static void v(Object obj) {
        LogManager.v(getTag((String) null), (byte) 15, getMsg(obj));
    }

    public static void vPrimary(String str, String str2) {
        LogManager.v(getTag(str), (byte) 15, str2);
    }

    public static void w(Object obj) {
        LogManager.w(getTag((String) null), (byte) 15, getMsg(obj));
    }

    public static void wPrimary(String str, String str2) {
        LogManager.w(getTag(str), (byte) 1, str2);
    }

    public static void d(Object obj) {
        LogManager.d(getTag((String) null), (byte) 15, getMsg(obj));
    }

    public static void e(String str, Object obj) {
        LogManager.e(getTag(str), (byte) 15, getMsg(obj));
    }

    public static void i(Object obj) {
        LogManager.i(getTag((String) null), (byte) 15, getMsg(obj));
    }

    public static void v(String str, String str2) {
        LogManager.v(getTag(str), (byte) 15, str2);
    }

    public static void w(String str, Object obj) {
        LogManager.w(getTag(str), (byte) 15, getMsg(obj));
    }

    public static void d(String str, Object obj) {
        LogManager.d(getTag(str), (byte) 15, getMsg(obj));
    }

    public static void e(String str, Object... objArr) {
        LogManager.e(getTag((String) null), (byte) 15, format(str, objArr));
    }

    public static void i(String str, Object obj) {
        LogManager.i(getTag(str), (byte) 15, getMsg(obj));
    }

    public static void v(String str, Object... objArr) {
        LogManager.v(getTag((String) null), (byte) 15, format(str, objArr));
    }

    public static void w(String str, Object... objArr) {
        LogManager.w(getTag((String) null), (byte) 15, format(str, objArr));
    }

    public static void d(String str, Object... objArr) {
        LogManager.d(getTag((String) null), (byte) 15, format(str, objArr));
    }

    public static void i(String str, Object... objArr) {
        LogManager.i(getTag((String) null), (byte) 15, format(str, objArr));
    }

    public static void e(String str, String str2, Object... objArr) {
        LogManager.e(getTag(str), (byte) 15, format(str2, objArr));
    }

    public static void v(String str, String str2, Object... objArr) {
        LogManager.v(getTag(str), (byte) 15, format(str2, objArr));
    }

    public static void w(String str, String str2, Object... objArr) {
        LogManager.w(getTag(str), (byte) 15, format(str2, objArr));
    }

    public static void d(String str, String str2, Object... objArr) {
        LogManager.d(getTag(str), (byte) 15, format(str2, objArr));
    }

    public static void i(String str, String str2, Object... objArr) {
        LogManager.i(getTag(str), (byte) 15, format(str2, objArr));
    }
}
