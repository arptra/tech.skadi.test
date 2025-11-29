package com.meizu.net.pedometerprovider.util;

import android.text.TextUtils;
import android.util.Log;
import com.honey.account.constant.AccountConstantKt;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class KLog {
    private static final int A = 6;
    private static final int D = 2;
    private static final String DEFAULT_MESSAGE = "execute";
    private static final int E = 5;
    private static final int I = 3;
    private static boolean IS_SHOW_LOG = true;
    private static final int JSON = 7;
    private static final int JSON_INDENT = 4;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final int V = 1;
    private static final int W = 4;

    public static void a() {
        printLog(6, (String) null, DEFAULT_MESSAGE);
    }

    public static void d() {
        printLog(2, (String) null, DEFAULT_MESSAGE);
    }

    public static void e() {
        printLog(5, (String) null, DEFAULT_MESSAGE);
    }

    public static void i() {
        printLog(3, (String) null, DEFAULT_MESSAGE);
    }

    public static void init(boolean z) {
        IS_SHOW_LOG = z;
    }

    public static void json(String str) {
        printLog(7, (String) null, str);
    }

    private static void printLine(String str, boolean z) {
        if (z) {
            Log.d(str, "╔═══════════════════════════════════════════════════════════════════════════════════════");
        } else {
            Log.d(str, "╚═══════════════════════════════════════════════════════════════════════════════════════");
        }
    }

    private static void printLog(int i, String str, Object obj) {
        if (IS_SHOW_LOG) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String fileName = stackTrace[5].getFileName();
            String methodName = stackTrace[5].getMethodName();
            int lineNumber = stackTrace[5].getLineNumber();
            if (str == null) {
                str = fileName;
            }
            String str2 = methodName.substring(0, 1) + methodName.substring(1);
            StringBuilder sb = new StringBuilder();
            sb.append("[ (");
            sb.append(fileName);
            sb.append(AccountConstantKt.CODE_SEPARTOR);
            sb.append(lineNumber);
            sb.append(")#");
            sb.append(str2);
            sb.append(" ] ");
            String obj2 = obj == null ? "Log with null Object" : obj.toString();
            if (!(obj2 == null || i == 7)) {
                sb.append(obj2);
            }
            String sb2 = sb.toString();
            switch (i) {
                case 1:
                    Log.v(str, sb2);
                    return;
                case 2:
                    Log.d(str, sb2);
                    return;
                case 3:
                    Log.i(str, sb2);
                    return;
                case 4:
                    Log.w(str, sb2);
                    return;
                case 5:
                    Log.e(str, sb2);
                    return;
                case 6:
                    Log.wtf(str, sb2);
                    return;
                case 7:
                    if (TextUtils.isEmpty(obj2)) {
                        Log.d(str, "Empty or Null json content");
                        return;
                    }
                    try {
                        String jSONObject = obj2.startsWith("{") ? new JSONObject(obj2).toString(4) : obj2.startsWith("[") ? new JSONArray(obj2).toString(4) : null;
                        printLine(str, true);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(sb2);
                        String str3 = LINE_SEPARATOR;
                        sb3.append(str3);
                        sb3.append(jSONObject);
                        String[] split = sb3.toString().split(str3);
                        StringBuilder sb4 = new StringBuilder();
                        for (String append : split) {
                            sb4.append("║ ");
                            sb4.append(append);
                            sb4.append(LINE_SEPARATOR);
                        }
                        Log.d(str, sb4.toString());
                        printLine(str, false);
                        return;
                    } catch (JSONException e) {
                        e(str, e.getCause().getMessage() + StringUtils.LF + obj2);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public static void v() {
        printLog(1, (String) null, DEFAULT_MESSAGE);
    }

    public static void w() {
        printLog(4, (String) null, DEFAULT_MESSAGE);
    }

    public static void a(Object obj) {
        printLog(6, (String) null, obj);
    }

    public static void d(Object obj) {
        printLog(2, (String) null, obj);
    }

    public static void e(Object obj) {
        printLog(5, (String) null, obj);
    }

    public static void i(Object obj) {
        printLog(3, (String) null, obj);
    }

    public static void json(String str, String str2) {
        printLog(7, str, str2);
    }

    public static void v(Object obj) {
        printLog(1, (String) null, obj);
    }

    public static void w(Object obj) {
        printLog(4, (String) null, obj);
    }

    public static void a(String str, Object obj) {
        printLog(6, str, obj);
    }

    public static void d(String str, Object obj) {
        printLog(2, str, obj);
    }

    public static void e(String str, Object obj) {
        printLog(5, str, obj);
    }

    public static void i(String str, Object obj) {
        printLog(3, str, obj);
    }

    public static void v(String str, String str2) {
        printLog(1, str, str2);
    }

    public static void w(String str, Object obj) {
        printLog(4, str, obj);
    }
}
