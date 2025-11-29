package com.meizu.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;

public class ScreenUtil {
    public static final String FLYME_HIGH_CONTRAST_MODE = "flyme_high_contrast_mode";
    private static final float FLYME_SYSTEM_CONTRACT_THRESHOLD = 0.2f;
    private static Method actualScreenHeightMethod;

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0019  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void applyF11NavigationColor(android.app.Activity r4) {
        /*
            r0 = 1
            android.content.ContentResolver r1 = r4.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x0010 }
            java.lang.String r2 = "navigation_mode"
            int r1 = android.provider.Settings.Secure.getInt(r1, r2)     // Catch:{ SettingNotFoundException -> 0x0010 }
            if (r1 != 0) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r1 = 0
            goto L_0x0011
        L_0x0010:
            r1 = r0
        L_0x0011:
            int r2 = com.meizu.common.R.color.fd_sys_color_surface_default
            int r2 = androidx.core.content.ContextCompat.getColor(r4, r2)
            if (r1 == 0) goto L_0x001b
            r0 = 230(0xe6, float:3.22E-43)
        L_0x001b:
            int r1 = android.graphics.Color.red(r2)
            int r3 = android.graphics.Color.green(r2)
            int r2 = android.graphics.Color.blue(r2)
            int r0 = android.graphics.Color.argb(r0, r1, r3, r2)
            android.view.Window r4 = r4.getWindow()
            r4.setNavigationBarColor(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.util.ScreenUtil.applyF11NavigationColor(android.app.Activity):void");
    }

    public static int dip2px(Context context, double d) {
        return (int) TypedValue.applyDimension(1, (float) d, context.getResources().getDisplayMetrics());
    }

    public static int getActualScreenHeight(Activity activity) {
        return getActualScreenHeight(activity.getWindowManager());
    }

    public static int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(ResourceUtils.getIdentifier(resources, "navigation_bar_height", "dimen", "android"));
    }

    public static boolean haveSaturation(int i) {
        float[] fArr = new float[3];
        if (Color.alpha(i) == 0) {
            return false;
        }
        Color.colorToHSV(i, fArr);
        return fArr[1] > 0.2f && fArr[2] > 0.2f;
    }

    public static boolean isFlymeHighContrastOn(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), FLYME_HIGH_CONTRAST_MODE, 0) != 0;
    }

    public static int sp2PxBesidesDeviceDPI(Context context, int i) {
        return i * (DisplayMetrics.DENSITY_DEVICE_STABLE / 160);
    }

    public static int sp2px(Context context, int i) {
        return (int) TypedValue.applyDimension(2, (float) i, context.getResources().getDisplayMetrics());
    }

    public static int getActualScreenHeight(WindowManager windowManager) {
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            if (actualScreenHeightMethod == null) {
                Method method = Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class});
                actualScreenHeightMethod = method;
                method.invoke(defaultDisplay, new Object[]{displayMetrics});
            }
            actualScreenHeightMethod.invoke(defaultDisplay, new Object[]{displayMetrics});
            return displayMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
