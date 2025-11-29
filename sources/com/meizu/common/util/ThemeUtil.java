package com.meizu.common.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

public class ThemeUtil {
    private static final String TAG = "ThemeUtil";

    public static Drawable getCustomRes(Context context, String str) {
        try {
            Object invoke = ReflectUtils.from("android.content.res.flymetheme.FlymeThemeUtils").method("getCustomRes", Context.class, String.class).invoke((Object) null, context, str);
            if (invoke instanceof Drawable) {
                return (Drawable) invoke;
            }
            return null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.w(TAG, "reflect method#getCustomRes has an error:" + e);
            return null;
        }
    }

    public static boolean isSystemTheme(Context context) {
        boolean z = true;
        try {
            if (Settings.System.getInt(context.getContentResolver(), "whether_using_flyme_theme") <= 0) {
                z = false;
            }
            Log.i(TAG, "systemTheme:" + z);
        } catch (Settings.SettingNotFoundException unused) {
            Log.w(TAG, "getSystemTheme, whether_using_flyme_theme not found.");
        }
        return z;
    }
}
