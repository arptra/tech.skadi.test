package com.upuphone.runasone.channel.proxy.client.util;

import com.upuphone.runasone.utils.LogUtil;
import java.lang.reflect.Method;

public class Iptool {
    private static final String TAG = "Iptool";

    public static void save(String str, String str2) {
        Class<String> cls = String.class;
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("set", new Class[]{cls, cls});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke((Object) null, new Object[]{str, str2});
            LogUtil.d(TAG, (Object) "success key=" + str + " value=" + str2);
        } catch (Exception e) {
            LogUtil.e(TAG, (Object) "fail key=" + str + " value=" + str2);
            e.printStackTrace();
        }
    }
}
