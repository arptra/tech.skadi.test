package com.upuphone.runasone.relay.lib.utils;

import android.content.Context;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.relay.lib.utils.log.FilePrint;
import com.upuphone.runasone.relay.lib.utils.log.ILogPrinter;
import com.upuphone.runasone.relay.lib.utils.log.LogConfig;
import com.upuphone.runasone.relay.lib.utils.log.LogcatPrint;

public final class LogUtil {
    private static final String DEFAULT_MESSAGE = "execute";
    private static final String DEFAULT_TAG = "[RunAsOneLog]";
    private static LogConfig logConfig;
    private static ILogPrinter logcatPrinter;
    private static ILogPrinter[] printer;

    private LogUtil() {
    }

    public static void d() {
        printLog(3, (String) null, DEFAULT_MESSAGE);
    }

    public static void dPrimary(String str, String str2) {
        printLogPrimary(3, str, str2);
    }

    public static void e(Object obj) {
        printLog(6, (String) null, obj);
    }

    public static void ePrimary(String str, String str2) {
        printLogPrimary(6, str, str2);
    }

    private static String format(String str, Object... objArr) {
        if (str == null) {
            return null;
        }
        return objArr.length == 0 ? str : String.format(str, objArr);
    }

    public static void i() {
        printLog(4, (String) null, DEFAULT_MESSAGE);
    }

    public static void iPrimary(String str, String str2) {
        printLogPrimary(4, str, str2);
    }

    public static void init(Context context) {
        LogConfig tag = new LogConfig().setLogLevel(Integer.MIN_VALUE).setTag("[RunAsOneLog]");
        LogcatPrint logcatPrint = new LogcatPrint();
        logcatPrinter = logcatPrint;
        init(tag, logcatPrint, new FilePrint(context));
    }

    private static void printLog(int i, String str, Object obj) {
        LogConfig logConfig2 = logConfig;
        if (logConfig2 != null && i >= logConfig2.getLogLevel()) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String fileName = stackTrace[4].getFileName();
            String methodName = stackTrace[4].getMethodName();
            int lineNumber = stackTrace[4].getLineNumber();
            StringBuilder sb = new StringBuilder();
            sb.append(logConfig.getTag());
            if (str == null) {
                str = "";
            }
            sb.append(str);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(methodName.substring(0, 1).toUpperCase());
            sb3.append(methodName.substring(1));
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[(");
            sb5.append(fileName);
            sb5.append(AccountConstantKt.CODE_SEPARTOR);
            sb5.append(lineNumber);
            sb5.append(")#");
            sb5.append(sb4);
            sb5.append("] ");
            sb5.append(obj == null ? "Log with null Object" : obj.toString());
            String sb6 = sb5.toString();
            for (ILogPrinter println : printer) {
                println.println(i, sb2, sb6);
            }
        }
    }

    private static void printLogPrimary(int i, String str, Object obj) {
        ILogPrinter iLogPrinter;
        LogConfig logConfig2 = logConfig;
        if (logConfig2 != null && i >= logConfig2.getLogLevel() && (iLogPrinter = logcatPrinter) != null) {
            iLogPrinter.println(i, "[RunAsOneLog] " + str, (String) obj);
        }
    }

    public static void v(Object obj) {
        printLog(2, (String) null, obj);
    }

    public static void vPrimary(String str, String str2) {
        printLogPrimary(2, str, str2);
    }

    public static void w(Object obj) {
        printLog(5, (String) null, obj);
    }

    public static void wPrimary(String str, String str2) {
        printLogPrimary(5, str, str2);
    }

    public static void d(Object obj) {
        printLog(3, (String) null, obj);
    }

    public static void e(String str, Object obj) {
        printLog(6, str, obj);
    }

    public static void i(Object obj) {
        printLog(4, (String) null, obj);
    }

    public static void v(String str, String str2) {
        printLog(2, str, str2);
    }

    public static void w(String str, Object obj) {
        printLog(5, str, obj);
    }

    public static void d(String str, Object obj) {
        printLog(3, str, obj);
    }

    public static void e(String str, Object... objArr) {
        printLog(6, (String) null, format(str, objArr));
    }

    public static void i(String str, Object obj) {
        printLog(4, str, obj);
    }

    public static void v(String str, Object... objArr) {
        printLog(2, (String) null, format(str, objArr));
    }

    public static void w(String str, Object... objArr) {
        printLog(5, (String) null, format(str, objArr));
    }

    public static void d(String str, Object... objArr) {
        printLog(3, (String) null, format(str, objArr));
    }

    public static void i(String str, Object... objArr) {
        printLog(4, (String) null, format(str, objArr));
    }

    public static void e(String str, String str2, Object... objArr) {
        printLog(6, str, format(str2, objArr));
    }

    public static void v(String str, String str2, Object... objArr) {
        printLog(2, str, format(str2, objArr));
    }

    public static void w(String str, String str2, Object... objArr) {
        printLog(5, str, format(str2, objArr));
    }

    public static void d(String str, String str2, Object... objArr) {
        printLog(3, str, format(str2, objArr));
    }

    public static void i(String str, String str2, Object... objArr) {
        printLog(4, str, format(str2, objArr));
    }

    public static void init(LogConfig logConfig2, ILogPrinter... iLogPrinterArr) {
        printer = iLogPrinterArr;
        logConfig = logConfig2;
    }
}
