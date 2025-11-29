package com.easy.logger;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class EasyLog {

    /* renamed from: a  reason: collision with root package name */
    public static String f2816a = "easylog_";
    public static int b = 0;
    public static boolean c = true;

    public interface LazyPrintFunction {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    public static void a(String str, String str2) {
        if (!(c ? b <= 3 : Log.isLoggable("UCarLog", 3))) {
            return;
        }
        if ("yftech".equals(Build.MANUFACTURER)) {
            Log.i(f2816a + str, str2);
            return;
        }
        Log.d(f2816a + str, str2);
    }

    public static void b(String str, String str2, Throwable th) {
        if (!(c ? b <= 3 : Log.isLoggable("UCarLog", 3))) {
            return;
        }
        if ("yftech".equals(Build.MANUFACTURER)) {
            Log.i(f2816a + str, str2, th);
            return;
        }
        Log.d(f2816a + str, str2, th);
    }

    public static void c(String str, String str2) {
        if (c ? b <= 6 : Log.isLoggable("UCarLog", 6)) {
            Log.e(f2816a + str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (c ? b <= 6 : Log.isLoggable("UCarLog", 6)) {
            Log.e(f2816a + str, str2, th);
        }
    }

    public static void e(String str, String str2) {
        if (c ? b <= 4 : Log.isLoggable("UCarLog", 4)) {
            Log.i(f2816a + str, str2);
        }
    }

    public static void f(String str, String str2, Throwable th) {
        if (c ? b <= 4 : Log.isLoggable("UCarLog", 4)) {
            Log.i(f2816a + str, str2, th);
        }
    }

    public static void g(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        f2816a = str;
    }

    public static void h(String str, String str2) {
        if (c ? b <= 2 : Log.isLoggable("UCarLog", 2)) {
            Log.v(f2816a + str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (c ? b <= 5 : Log.isLoggable("UCarLog", 5)) {
            Log.w(f2816a + str, str2);
        }
    }

    public static void j(String str, String str2, Throwable th) {
        if (c ? b <= 5 : Log.isLoggable("UCarLog", 5)) {
            Log.w(f2816a + str, str2, th);
        }
    }
}
