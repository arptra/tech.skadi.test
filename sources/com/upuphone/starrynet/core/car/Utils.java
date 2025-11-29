package com.upuphone.starrynet.core.car;

import com.upuphone.starrynet.common.StLog;

public class Utils {
    public static final String TAG = "Utils_car";

    public static String getProperty(String str, String str2) {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            str2 = (String) cls2.getMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{str, str2});
        } catch (Exception e) {
            StLog.e(TAG, "reflect error", (Throwable) e);
        }
        StLog.d(TAG, "getProperty " + str + " : " + str2);
        return str2;
    }
}
