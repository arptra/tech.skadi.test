package com.sina.weibo.sdk;

import android.util.Log;
import com.upuphone.runasone.share.api.ApiConstant;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9990a = ("wbsdk_" + "sso");
    public static final String b = ("wbsdk_" + ApiConstant.COMPONENT);
    public static final String c = ("wbsdk_" + "oauth");
    public static boolean d = false;

    public static void a(String str, String str2) {
        if (d) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.d(str, (stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + ": " + str2);
        }
    }

    public static void b(String str, String str2) {
        if (d) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.i(str, (stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + ": " + str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (!d) {
            return;
        }
        if (th == null) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.e(str, (stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + ": " + str2);
            return;
        }
        Log.e(str, str2, th);
    }
}
