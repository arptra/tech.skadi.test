package com.upuphone.xr.interconnect.util;

import com.upuphone.xr.interconnect.util.log.ILog;

public final class ExceptionLogUtil {
    private ExceptionLogUtil() {
    }

    public static void print(String str, Exception exc, String str2, String str3) {
        ILog.e(str, String.format("Exception occurred when calling %s#%s", new Object[]{str2, str3}), exc);
    }
}
