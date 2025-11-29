package com.upuphone.ar.navi.lite.util;

import android.view.View;
import android.view.animation.TranslateAnimation;

public final class AnimationUtils {
    public static void a(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, ((float) view.getHeight()) / 2.0f, 0.0f);
        translateAnimation.setDuration(150);
        view.startAnimation(translateAnimation);
    }

    public static void b(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, ((float) view.getHeight()) / 2.0f);
        translateAnimation.setDuration(150);
        view.startAnimation(translateAnimation);
    }

    public static void c(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, ((float) (-view.getHeight())) / 2.0f);
        translateAnimation.setDuration(150);
        view.startAnimation(translateAnimation);
    }

    public static void d(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, ((float) (-view.getHeight())) / 2.0f, 0.0f);
        translateAnimation.setDuration(150);
        view.startAnimation(translateAnimation);
    }
}
