package com.geetest.sdk.utils;

import com.upuphone.starrynet.common.StarryNetConstant;
import java.lang.reflect.Method;

public class s {
    public static String a(String str) {
        try {
            Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass("android.os.SystemProperties");
            Method method = loadClass.getMethod("get", new Class[]{String.class});
            method.setAccessible(true);
            return (String) method.invoke(loadClass, new Object[]{str});
        } catch (Exception unused) {
            return StarryNetConstant.DEVICE_NAME_UNKNOWN;
        }
    }
}
