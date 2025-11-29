package flyme.support.v7.util;

import android.content.Context;
import java.lang.reflect.Method;

public class ImportanceUXHintHelper {
    public static final int UX_TYPE_ANIMATION = 2;
    public static final int UX_TYPE_BRIGHTNESS_CHANGE = 1;
    public static final int UX_TYPE_KEYGUARD = 5;
    public static final int UX_TYPE_POWER = 4;
    public static final int UX_TYPE_SCROLL = 0;
    public static final int UX_TYPE_TOUCH = 3;
    private static Class<?> sFlymeInject;
    private static Class<?> sFrameworkInject;
    private static Method sMethodGet;
    private static Method sMethodImportanceUXHint;

    public static void importanceUXHint(Context context, int i, int i2, boolean z) {
        try {
            if (sFlymeInject == null) {
                sFlymeInject = Class.forName("flyme.hook.FlymeInject");
            }
            if (sFrameworkInject == null) {
                sFrameworkInject = Class.forName("flyme.hook.FrameworkInject");
            }
            if (sMethodGet == null) {
                sMethodGet = sFlymeInject.getDeclaredMethod("get", new Class[]{Class.class});
            }
            if (sMethodImportanceUXHint == null) {
                Class<?> cls = sFrameworkInject;
                Class cls2 = Integer.TYPE;
                sMethodImportanceUXHint = cls.getDeclaredMethod("importanceUXHint", new Class[]{Context.class, cls2, cls2, Boolean.TYPE});
            }
            sMethodImportanceUXHint.invoke(sMethodGet.invoke((Object) null, new Object[]{sFrameworkInject}), new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)});
        } catch (Exception unused) {
        }
    }
}
