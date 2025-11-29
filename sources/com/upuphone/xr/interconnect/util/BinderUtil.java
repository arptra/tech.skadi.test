package com.upuphone.xr.interconnect.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Binder;

public class BinderUtil {
    private BinderUtil() {
    }

    public static String getCallingPkgName(Context context) {
        if (context == null) {
            return null;
        }
        return context.getPackageManager().getNameForUid(Binder.getCallingUid());
    }

    public static String getCallingPkgName2(Context context) {
        if (context == null) {
            return null;
        }
        int callingPid = Binder.getCallingPid();
        for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (next.pid == callingPid) {
                return next.processName;
            }
        }
        return null;
    }
}
