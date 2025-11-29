package com.upuphone.starrynet.core.ble.utils;

import com.upuphone.runasone.utils.log.LogManager;
import java.io.PrintWriter;
import java.io.StringWriter;

public class BluetoothLog {
    public static final int MODE_CLOSED = 1;
    public static final int MODE_DETAIL = 2;
    public static final int MODE_NORMAL = 0;
    private static final String TAG = "CORE-BLE";
    public static boolean debug = true;
    private static int mCurrentMode;

    private BluetoothLog() {
    }

    public static void df(String str, String str2, Object... objArr) {
        if (debug) {
            if (objArr != null && objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            LogManager.d(TAG, (byte) 2, str + "=>" + str2);
        }
    }

    public static void e(Throwable th) {
        if (debug) {
            LogManager.e(TAG, (byte) 15, getThrowableString(th));
        }
    }

    public static void error(String str, String str2, Object... objArr) {
        if (debug) {
            if (objArr != null && objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            LogManager.e(TAG, (byte) 15, str + "=>" + str2);
        }
    }

    private static String getThrowableString(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        while (th != null) {
            th.printStackTrace(printWriter);
            th = th.getCause();
        }
        String obj = stringWriter.toString();
        printWriter.close();
        return obj == null ? "" : obj;
    }

    public static boolean isDetailMode() {
        return mCurrentMode == 2;
    }

    public static void log(String str, String str2, Object... objArr) {
        if (debug) {
            if (objArr != null && objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            LogManager.d(TAG, (byte) 15, str + "=>" + str2);
        }
    }

    public static void setLogMode(int i) {
        mCurrentMode = i;
        boolean z = true;
        if (i == 1) {
            z = false;
        }
        debug = z;
    }

    public static void v(String str, String str2, Object... objArr) {
        if (debug) {
            if (objArr != null && objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            LogManager.v(TAG, (byte) 15, str + "=>" + str2);
        }
    }
}
