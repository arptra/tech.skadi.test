package com.geetest.sdk.utils;

import android.content.Context;
import android.os.Debug;
import android.text.TextUtils;

public class e {
    public static boolean a() {
        try {
            return Debug.isDebuggerConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int c(Context context) {
        try {
            return (b(context) || a() || d()) ? 1 : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean d() {
        String c = c.a().c("getprop init.svc.adbd");
        return !TextUtils.isEmpty(c) && c.contains("running");
    }
}
