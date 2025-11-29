package me.weishu.reflection;

import android.util.Log;
import java.lang.reflect.Method;

public final class BootstrapClass {
    private static final String TAG = "BootstrapClass";
    private static Object sVmRuntime;
    private static Method setHiddenApiExemptions;

    static {
        Class<String> cls = String.class;
        Class<Class> cls2 = Class.class;
        try {
            Method declaredMethod = cls2.getDeclaredMethod("forName", new Class[]{cls});
            Method declaredMethod2 = cls2.getDeclaredMethod("getDeclaredMethod", new Class[]{cls, Class[].class});
            Class cls3 = (Class) declaredMethod.invoke((Object) null, new Object[]{"dalvik.system.VMRuntime"});
            setHiddenApiExemptions = (Method) declaredMethod2.invoke(cls3, new Object[]{"setHiddenApiExemptions", new Class[]{String[].class}});
            sVmRuntime = ((Method) declaredMethod2.invoke(cls3, new Object[]{"getRuntime", null})).invoke((Object) null, (Object[]) null);
        } catch (Throwable th) {
            Log.w(TAG, "reflect bootstrap failed:", th);
        }
    }

    public static boolean exempt(String str) {
        return exempt(str);
    }

    public static boolean exemptAll() {
        return exempt("L");
    }

    public static boolean exempt(String... strArr) {
        Method method;
        Object obj = sVmRuntime;
        if (!(obj == null || (method = setHiddenApiExemptions) == null)) {
            try {
                method.invoke(obj, new Object[]{strArr});
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
