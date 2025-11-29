package com.upuphone.xr.sapp.utils;

import android.content.Context;
import android.view.View;
import com.upuphone.star.core.log.ULog;

public class FlymeUtils {
    public static void a(View view, Context context) {
        try {
            int i = context.getResources().getConfiguration().uiMode & 48;
            ULog.i("FlymeUtils", "actInMzNightMode, night mode = " + i);
            if (i == 32) {
                View.class.getDeclaredMethod("actInMzNightMode", new Class[]{Integer.TYPE}).invoke(view, new Object[]{2});
                ULog.i("FlymeUtils", "actInMzNightMode to 2");
            }
        } catch (Throwable th) {
            ULog.f("FlymeUtils", "actInMzNightMode, error: " + th);
        }
    }
}
