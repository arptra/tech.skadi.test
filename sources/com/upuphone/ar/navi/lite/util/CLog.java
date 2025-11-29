package com.upuphone.ar.navi.lite.util;

import com.upuphone.star.core.log.ULog;

public final class CLog {
    public static void a(String str, String str2) {
        ULog.d(str, " " + str2);
    }

    public static void b(String str, String str2) {
        ULog.f(str, " " + str2);
    }

    public static void c(String str, String str2) {
        ULog.i(str, " " + str2);
    }

    public static void d(String str, String str2) {
        ULog.m(str, " " + str2);
    }
}
