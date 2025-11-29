package org.greenrobot.eventbus.android;

import java.lang.reflect.InvocationTargetException;

public class AndroidDependenciesDetector {
    public static boolean a() {
        try {
            int i = AndroidComponentsImpl.d;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static AndroidComponents b() {
        Class<AndroidComponentsImpl> cls = AndroidComponentsImpl.class;
        try {
            int i = AndroidComponentsImpl.d;
            return cls.getConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean c() {
        try {
            return Class.forName("android.os.Looper").getDeclaredMethod("getMainLooper", (Class[]) null).invoke((Object) null, (Object[]) null) != null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }
}
