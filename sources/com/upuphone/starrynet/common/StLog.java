package com.upuphone.starrynet.common;

import com.upuphone.runasone.utils.log.LogManager;

public class StLog {
    public static StLog DEFAULT = new StLog("[StLog]");
    private final String SEPARATOR_FLAG = ": ";
    private String TAG;

    public StLog(String str) {
        this.TAG = str;
    }

    public static void d(String str, String str2) {
        DEFAULT.debug(str, str2);
    }

    public static void df(String str, String str2) {
        DEFAULT.debugFile(str, str2);
    }

    public static void e(String str, String str2) {
        DEFAULT.error(str, str2);
    }

    public static void i(String str, String str2) {
        DEFAULT.info(str, str2);
    }

    public static void v(String str, String str2) {
        DEFAULT.verbose(str, str2);
    }

    public static void w(String str, String str2) {
        DEFAULT.warn(str, str2);
    }

    public void debug(String str, String str2) {
        String str3 = this.TAG;
        LogManager.d(str3, (byte) 15, str + ": " + str2);
    }

    public void debugFile(String str, String str2) {
        String str3 = this.TAG;
        LogManager.d(str3, (byte) 2, str + ": " + str2);
    }

    public void error(String str, String str2) {
        String str3 = this.TAG;
        LogManager.e(str3, (byte) 15, str + ": " + str2);
    }

    public void info(String str, String str2) {
        String str3 = this.TAG;
        LogManager.i(str3, (byte) 15, str + ": " + str2);
    }

    public void verbose(String str, String str2) {
        String str3 = this.TAG;
        LogManager.v(str3, (byte) 15, str + ": " + str2);
    }

    public void warn(String str, String str2) {
        String str3 = this.TAG;
        LogManager.w(str3, (byte) 15, str + ": " + str2);
    }

    public static void d(String str, String str2, Object... objArr) {
        DEFAULT.debug(str, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        DEFAULT.error(str, str2, objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        DEFAULT.info(str, str2, objArr);
    }

    public static void v(String str, String str2, Object... objArr) {
        DEFAULT.verbose(str, str2, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        DEFAULT.warn(str, str2, objArr);
    }

    public void debug(String str, String str2, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str2 = String.format(str2, objArr);
        }
        String str3 = this.TAG;
        LogManager.d(str3, (byte) 15, str + ": " + str2);
    }

    public void error(String str, String str2, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str2 = String.format(str2, objArr);
        }
        String str3 = this.TAG;
        LogManager.e(str3, (byte) 15, str + ": " + str2);
    }

    public void info(String str, String str2, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str2 = String.format(str2, objArr);
        }
        String str3 = this.TAG;
        LogManager.i(str3, (byte) 15, str + ": " + str2);
    }

    public void verbose(String str, String str2, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str2 = String.format(str2, objArr);
        }
        String str3 = this.TAG;
        LogManager.v(str3, (byte) 15, str + ": " + str2);
    }

    public void warn(String str, String str2, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str2 = String.format(str2, objArr);
        }
        String str3 = this.TAG;
        LogManager.w(str3, (byte) 15, str + ": " + str2);
    }

    public static void d(String str, String str2, Throwable th) {
        DEFAULT.debug(str, str2, th);
    }

    public static void e(String str, String str2, Throwable th) {
        DEFAULT.error(str, str2, th);
    }

    public static void i(String str, String str2, Throwable th) {
        DEFAULT.info(str, str2, th);
    }

    public static void w(String str, String str2, Throwable th) {
        DEFAULT.warn(str, str2, th);
    }

    public void debug(String str, String str2, Throwable th) {
        String str3 = this.TAG;
        LogManager.d(str3, (byte) 15, str + ": " + str2, th);
    }

    public void error(String str, String str2, Throwable th) {
        String str3 = this.TAG;
        LogManager.e(str3, (byte) 15, str + ": " + str2, th);
    }

    public void info(String str, String str2, Throwable th) {
        String str3 = this.TAG;
        LogManager.i(str3, (byte) 15, str + ": " + str2, th);
    }

    public void warn(String str, String str2, Throwable th) {
        String str3 = this.TAG;
        LogManager.w(str3, (byte) 15, str + ": " + str2, th);
    }
}
