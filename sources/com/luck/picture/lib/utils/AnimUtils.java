package com.luck.picture.lib.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class AnimUtils {
    public static void a(ImageView imageView, boolean z) {
        float f = 180.0f;
        float f2 = 0.0f;
        if (z) {
            f2 = 180.0f;
            f = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", new float[]{f, f2});
        ofFloat.setDuration(250);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.start();
    }

    public static void b(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, "scaleX", new float[]{1.0f, 1.05f, 1.0f}), ObjectAnimator.ofFloat(view, "scaleY", new float[]{1.0f, 1.05f, 1.0f})});
        animatorSet.setDuration(250);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.start();
    }
}
