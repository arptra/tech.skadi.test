package com.meizu.common.util;

import android.util.Log;
import android.view.View;
import com.android.internal.graphics.drawable.BackgroundBlurDrawable;

public class BlurDrawableUtil {
    public static BackgroundBlurDrawable createDrawable(View view, float f, int i, int i2, int i3) {
        try {
            Object invoke = ReflectUtils.from((Class<?>) View.class).method("getViewRootImpl", new Class[0]).invoke(view, new Object[0]);
            BackgroundBlurDrawable backgroundBlurDrawable = (BackgroundBlurDrawable) ReflectUtils.from(invoke).method("createBackgroundBlurDrawable", new Class[0]).invoke(invoke, new Object[0]);
            backgroundBlurDrawable.setCornerRadius(f);
            backgroundBlurDrawable.setBlurRadius(i);
            backgroundBlurDrawable.setColor(i2);
            backgroundBlurDrawable.setAlpha(i3);
            return backgroundBlurDrawable;
        } catch (Exception e) {
            Log.e("BlurDrawableUtil", "createDrawable has an error:" + e);
            e.printStackTrace();
            return null;
        }
    }
}
