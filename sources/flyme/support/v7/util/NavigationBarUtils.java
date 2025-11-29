package flyme.support.v7.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NavigationBarUtils {
    private static String DecorViewClsName = "com.android.internal.policy.DecorView";
    public static int MEIZU_FLAG_DARK_NAVIGATION_BAR_ICON = 256;
    private static Field mFiledMeizuFlags;
    private static Field mLastBottomInset;
    private static Field mLastLeftInset;
    private static Field mLastRightInset;
    private static Method setForcedNavigationBarColor;
    private static Method setNavigationBarColorExt;
    private static Method setNavigationBarIconColor;
    private static Method setNavigationBarIconColorExt;

    static {
        Class<WindowManager.LayoutParams> cls = WindowManager.LayoutParams.class;
        Class<Window> cls2 = Window.class;
        try {
            Class cls3 = Boolean.TYPE;
            setNavigationBarIconColor = cls2.getDeclaredMethod("setNavigationBarIconColor", new Class[]{cls3});
            mFiledMeizuFlags = cls.getDeclaredField("meizuFlags");
            setForcedNavigationBarColor = cls2.getDeclaredMethod("setForcedNavigationBarColor", new Class[]{cls3});
            MEIZU_FLAG_DARK_NAVIGATION_BAR_ICON = cls.getDeclaredField("MEIZU_FLAG_DARK_NAVIGATION_BAR_ICON").getInt((Object) null);
            setNavigationBarIconColorExt = cls2.getDeclaredMethod("setNavigationBarIconColor", new Class[]{cls3, cls3});
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException unused) {
        }
        try {
            Class<?> cls4 = Class.forName(DecorViewClsName);
            Field declaredField = cls4.getDeclaredField("mLastBottomInset");
            mLastBottomInset = declaredField;
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Field declaredField2 = cls4.getDeclaredField("mLastRightInset");
            mLastRightInset = declaredField2;
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Field declaredField3 = cls4.getDeclaredField("mLastLeftInset");
            mLastLeftInset = declaredField3;
            if (declaredField3 != null) {
                declaredField3.setAccessible(true);
            }
        } catch (ClassNotFoundException | NoSuchFieldException unused2) {
        }
        try {
            Method declaredMethod = cls2.getDeclaredMethod("setNavigationBarColorExt", new Class[]{Integer.TYPE});
            setNavigationBarColorExt = declaredMethod;
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
            }
        } catch (NoSuchMethodException unused3) {
        }
    }

    public static int getBottomNavigationBarWidth(Activity activity) {
        View decorView;
        if (!(activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null)) {
            try {
                Field field = mLastBottomInset;
                if (field != null) {
                    return field.getInt(decorView);
                }
                return 0;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static int getLeftNavigationBarWidth(Activity activity) {
        if (!(activity == null || activity.getWindow() == null)) {
            View decorView = activity.getWindow().getDecorView();
            try {
                Field field = mLastLeftInset;
                if (field != null) {
                    return field.getInt(decorView);
                }
                return 0;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static int getNavigationBarColor(Window window) {
        return window.getNavigationBarColor();
    }

    public static int getNavigationBarHeight(Activity activity) {
        View decorView;
        Field field;
        Field field2;
        if (!(activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null)) {
            try {
                Field field3 = mLastBottomInset;
                int i = field3 != null ? field3.getInt(decorView) : 0;
                if (i == 0 && (field2 = mLastRightInset) != null) {
                    i = field2.getInt(decorView);
                }
                return (i != 0 || (field = mLastLeftInset) == null) ? i : field.getInt(decorView);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static int getRightNavigationBarHeight(Activity activity) {
        View decorView;
        if (!(activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null)) {
            try {
                Field field = mLastRightInset;
                if (field != null) {
                    return field.getInt(decorView);
                }
                return 0;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static boolean isDarkIconColor(Window window) {
        Field field = mFiledMeizuFlags;
        if (!(field == null || window == null)) {
            try {
                return (field.getInt(window.getAttributes()) & MEIZU_FLAG_DARK_NAVIGATION_BAR_ICON) != 0;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isHaveNavigationBar(Activity activity) {
        return getNavigationBarHeight(activity) > 0;
    }

    public static void setDarkIconColor(Window window, boolean z) {
        Method method = setNavigationBarIconColor;
        if (method != null) {
            try {
                method.invoke(window, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void setForcedNavigationBarColor(Window window, boolean z) {
        Method method = setForcedNavigationBarColor;
        if (method != null) {
            try {
                method.invoke(window, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void setNavigationBarColor(Window window, int i, boolean z) {
        setForcedNavigationBarColor(window, z);
        window.setNavigationBarColor(i);
    }

    public static void setNavigationBarColorExt(Window window, int i) {
        Method method = setNavigationBarColorExt;
        if (method != null) {
            try {
                method.invoke(window, new Object[]{Integer.valueOf(i)});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean isHaveNavigationBar(Context context) {
        if (context instanceof Activity) {
            return isHaveNavigationBar((Activity) context);
        }
        return false;
    }

    public static void setNavigationBarColor(Window window, int i) {
        setNavigationBarColor(window, i, true);
    }

    public static void setDarkIconColor(Window window, boolean z, boolean z2) {
        Method method = setNavigationBarIconColorExt;
        if (method != null) {
            try {
                method.invoke(window, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        } else {
            setDarkIconColor(window, z);
        }
    }

    public static int getBottomNavigationBarWidth(Context context) {
        if (context instanceof Activity) {
            return getBottomNavigationBarWidth((Activity) context);
        }
        return 0;
    }

    public static int getLeftNavigationBarWidth(Context context) {
        if (context instanceof Activity) {
            return getLeftNavigationBarWidth((Activity) context);
        }
        return 0;
    }

    public static int getRightNavigationBarHeight(Context context) {
        if (context instanceof Activity) {
            return getRightNavigationBarHeight((Activity) context);
        }
        return 0;
    }

    public static int getNavigationBarHeight(Context context) {
        if (context instanceof Activity) {
            return getNavigationBarHeight((Activity) context);
        }
        return 0;
    }
}
