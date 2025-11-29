package com.luck.picture.lib.animators;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;

public final class ViewHelper {
    public static void a(View view) {
        view.setAlpha(1.0f);
        view.setScaleY(1.0f);
        view.setScaleX(1.0f);
        view.setTranslationY(0.0f);
        view.setTranslationX(0.0f);
        view.setRotation(0.0f);
        view.setRotationY(0.0f);
        view.setRotationX(0.0f);
        view.setPivotY((float) (view.getMeasuredHeight() / 2));
        view.setPivotX((float) (view.getMeasuredWidth() / 2));
        ViewCompat.e(view).j((Interpolator) null).m(0);
    }
}
