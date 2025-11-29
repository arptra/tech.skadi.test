package com.meizu.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
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
    private static Method setNavigationBarIconColor;
    private static Method setNavigationBarIconColorExt;

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x003d */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0068 A[Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x004e A[Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x005b A[Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x006b }] */
    static {
        /*
            java.lang.Class<android.view.WindowManager$LayoutParams> r0 = android.view.WindowManager.LayoutParams.class
            java.lang.String r1 = "setNavigationBarIconColor"
            java.lang.Class<android.view.Window> r2 = android.view.Window.class
            java.lang.Class r3 = java.lang.Boolean.TYPE     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x003d }
            java.lang.Class[] r4 = new java.lang.Class[]{r3}     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x003d }
            java.lang.reflect.Method r4 = r2.getDeclaredMethod(r1, r4)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x003d }
            setNavigationBarIconColor = r4     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x003d }
            java.lang.String r4 = "meizuFlags"
            java.lang.reflect.Field r4 = r0.getDeclaredField(r4)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x003d }
            mFiledMeizuFlags = r4     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x003d }
            java.lang.String r4 = "setForcedNavigationBarColor"
            java.lang.Class[] r5 = new java.lang.Class[]{r3}     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x003d }
            java.lang.reflect.Method r4 = r2.getDeclaredMethod(r4, r5)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x003d }
            setForcedNavigationBarColor = r4     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x003d }
            java.lang.String r4 = "MEIZU_FLAG_DARK_NAVIGATION_BAR_ICON"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r4)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x003d }
            r4 = 0
            int r0 = r0.getInt(r4)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x003d }
            MEIZU_FLAG_DARK_NAVIGATION_BAR_ICON = r0     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x003d }
            java.lang.Class[] r0 = new java.lang.Class[]{r3, r3}     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x003d }
            java.lang.reflect.Method r0 = r2.getDeclaredMethod(r1, r0)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x003d }
            setNavigationBarIconColorExt = r0     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException -> 0x003d }
        L_0x003d:
            java.lang.String r0 = DecorViewClsName     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x006b }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x006b }
            java.lang.String r1 = "mLastBottomInset"
            java.lang.reflect.Field r1 = r0.getDeclaredField(r1)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x006b }
            mLastBottomInset = r1     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x006b }
            r2 = 1
            if (r1 == 0) goto L_0x0051
            r1.setAccessible(r2)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x006b }
        L_0x0051:
            java.lang.String r1 = "mLastRightInset"
            java.lang.reflect.Field r1 = r0.getDeclaredField(r1)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x006b }
            mLastRightInset = r1     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x006b }
            if (r1 == 0) goto L_0x005e
            r1.setAccessible(r2)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x006b }
        L_0x005e:
            java.lang.String r1 = "mLastLeftInset"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r1)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x006b }
            mLastLeftInset = r0     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x006b }
            if (r0 == 0) goto L_0x006b
            r0.setAccessible(r2)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x006b }
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.util.NavigationBarUtils.<clinit>():void");
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
        return resources.getDimensionPixelSize(ResourceUtils.getIdentifier(resources, "status_bar_height", "dimen", "android"));
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
