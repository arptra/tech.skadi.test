package a.a.a.a.b;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Method f64a;
    public static Method b;
    public static Field c;
    public static int d;

    static {
        Class<Activity> cls = Activity.class;
        try {
            f64a = cls.getMethod("setStatusBarDarkIcon", new Class[]{Integer.TYPE});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            b = cls.getMethod("setStatusBarDarkIcon", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        }
        try {
            c = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
        try {
            d = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt((Object) null);
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Activity activity, boolean z) {
        b(activity, z, true);
    }

    public static void b(Activity activity, boolean z, boolean z2) {
        Method method = b;
        if (method != null) {
            try {
                method.invoke(activity, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        } else if (z2) {
            e(activity.getWindow(), z);
        }
    }

    public static void c(View view, boolean z) {
        int systemUiVisibility = view.getSystemUiVisibility();
        int i = z ? d | systemUiVisibility : (~d) & systemUiVisibility;
        if (i != systemUiVisibility) {
            view.setSystemUiVisibility(i);
        }
    }

    public static void d(Window window, int i) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = c;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i) {
                    c.set(attributes, Integer.valueOf(i));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void e(Window window, boolean z) {
        View decorView = window.getDecorView();
        if (decorView != null) {
            c(decorView, z);
            d(window, 0);
        }
    }
}
