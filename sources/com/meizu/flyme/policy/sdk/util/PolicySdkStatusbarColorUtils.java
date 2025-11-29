package com.meizu.flyme.policy.sdk.util;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PolicySdkStatusbarColorUtils {
    private static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = 0;
    private static final String TAG = "StatusbarColorUtils";
    private static Method mSetStatusBarColorIcon;
    private static Method mSetStatusBarDarkIcon;
    private static Field mStatusBarColorFiled;

    /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|7|8|9|11|12|14) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
    static {
        /*
            java.lang.String r0 = "setStatusBarDarkIcon"
            java.lang.Class<android.app.Activity> r1 = android.app.Activity.class
            java.lang.Class r2 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0010 }
            java.lang.Class[] r2 = new java.lang.Class[]{r2}     // Catch:{ NoSuchMethodException -> 0x0010 }
            java.lang.reflect.Method r2 = r1.getMethod(r0, r2)     // Catch:{ NoSuchMethodException -> 0x0010 }
            mSetStatusBarColorIcon = r2     // Catch:{ NoSuchMethodException -> 0x0010 }
        L_0x0010:
            java.lang.Class r2 = java.lang.Boolean.TYPE     // Catch:{ NoSuchMethodException -> 0x001c }
            java.lang.Class[] r2 = new java.lang.Class[]{r2}     // Catch:{ NoSuchMethodException -> 0x001c }
            java.lang.reflect.Method r0 = r1.getMethod(r0, r2)     // Catch:{ NoSuchMethodException -> 0x001c }
            mSetStatusBarDarkIcon = r0     // Catch:{ NoSuchMethodException -> 0x001c }
        L_0x001c:
            java.lang.Class<android.view.WindowManager$LayoutParams> r0 = android.view.WindowManager.LayoutParams.class
            java.lang.String r1 = "statusBarColor"
            java.lang.reflect.Field r0 = r0.getField(r1)     // Catch:{ NoSuchFieldException -> 0x0026 }
            mStatusBarColorFiled = r0     // Catch:{ NoSuchFieldException -> 0x0026 }
        L_0x0026:
            java.lang.Class<android.view.View> r0 = android.view.View.class
            java.lang.String r1 = "SYSTEM_UI_FLAG_LIGHT_STATUS_BAR"
            java.lang.reflect.Field r0 = r0.getField(r1)     // Catch:{ Exception -> 0x0035 }
            r1 = 0
            int r0 = r0.getInt(r1)     // Catch:{ Exception -> 0x0035 }
            SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = r0     // Catch:{ Exception -> 0x0035 }
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.flyme.policy.sdk.util.PolicySdkStatusbarColorUtils.<clinit>():void");
    }

    private static boolean changeMeizuFlag(WindowManager.LayoutParams layoutParams, String str, boolean z) {
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            int i = declaredField.getInt(layoutParams);
            Field declaredField2 = layoutParams.getClass().getDeclaredField("meizuFlags");
            declaredField2.setAccessible(true);
            int i2 = declaredField2.getInt(layoutParams);
            int i3 = z ? i | i2 : (~i) & i2;
            if (i2 == i3) {
                return false;
            }
            declaredField2.setInt(layoutParams, i3);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isBlackColor(int i, int i2) {
        return toGrey(i) < i2;
    }

    public static void setStatusBarColor(Window window, int i) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = mStatusBarColorFiled;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i) {
                    mStatusBarColorFiled.set(attributes, Integer.valueOf(i));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException unused) {
            }
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, int i) {
        Method method = mSetStatusBarColorIcon;
        if (method != null) {
            try {
                method.invoke(activity, new Object[]{Integer.valueOf(i)});
            } catch (Exception unused) {
            }
        } else {
            boolean isBlackColor = isBlackColor(i, 50);
            if (mStatusBarColorFiled != null) {
                setStatusBarDarkIcon(activity, isBlackColor, isBlackColor);
                setStatusBarDarkIcon(activity.getWindow(), i);
                return;
            }
            setStatusBarDarkIcon(activity, isBlackColor);
        }
    }

    public static int toGrey(int i) {
        return (((((i & 16711680) >> 16) * 38) + (((65280 & i) >> 8) * 75)) + ((i & 255) * 15)) >> 7;
    }

    public static void setStatusBarDarkIcon(Activity activity, boolean z) {
        setStatusBarDarkIcon(activity, z, true);
    }

    private static void setStatusBarDarkIcon(Activity activity, boolean z, boolean z2) {
        Method method = mSetStatusBarDarkIcon;
        if (method != null) {
            try {
                method.invoke(activity, new Object[]{Boolean.valueOf(z)});
            } catch (Exception unused) {
            }
        } else if (z2) {
            setStatusBarDarkIcon(activity.getWindow(), z);
        }
    }

    private static void setStatusBarDarkIcon(View view, boolean z) {
        int systemUiVisibility = view.getSystemUiVisibility();
        int i = z ? SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | systemUiVisibility : (~SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) & systemUiVisibility;
        if (i != systemUiVisibility) {
            view.setSystemUiVisibility(i);
        }
    }

    public static void setStatusBarDarkIcon(Window window, int i) {
        try {
            setStatusBarColor(window, i);
            setStatusBarDarkIcon(window.getDecorView(), true);
        } catch (Exception unused) {
        }
    }

    public static void setStatusBarDarkIcon(Window window, boolean z) {
        View decorView = window.getDecorView();
        if (decorView != null) {
            setStatusBarDarkIcon(decorView, z);
            setStatusBarColor(window, 0);
        }
    }
}
