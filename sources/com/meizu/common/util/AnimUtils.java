package com.meizu.common.util;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.annotation.Nullable;

public class AnimUtils {
    public static void colorTransform(int i, int i2, long j, @Nullable Interpolator interpolator, ImageView imageView) {
        Interpolator interpolator2;
        final float alpha = (float) Color.alpha(i);
        final float alpha2 = (float) Color.alpha(i2);
        final float red = (float) Color.red(i);
        final float red2 = (float) Color.red(i2);
        final float green = (float) Color.green(i);
        final float green2 = (float) Color.green(i2);
        final float blue = (float) Color.blue(i);
        final float blue2 = (float) Color.blue(i2);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        long j2 = j;
        ofFloat.setDuration(j);
        if (interpolator != null) {
            interpolator2 = interpolator;
        } else {
            interpolator2 = new LinearInterpolator();
        }
        ofFloat.setInterpolator(interpolator2);
        final ImageView imageView2 = imageView;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimUtils.setTint(imageView2, AnimUtils.computeFractionColor(alpha, alpha2, red, red2, green, green2, blue, blue2, valueAnimator.getAnimatedFraction()));
            }
        });
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    public static int computeFractionColor(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return Color.argb((int) (f + ((f2 - f) * f9)), (int) (f3 + ((f4 - f3) * f9)), (int) (f5 + ((f6 - f5) * f9)), (int) (f7 + ((f8 - f7) * f9)));
    }

    public static boolean isViewHaveTransitionName(View view) {
        if (view == null) {
            return false;
        }
        return !TextUtils.isEmpty(view.getTransitionName());
    }

    public static final void setTint(ImageView imageView, int i) {
        imageView.setImageTintList(ColorStateList.valueOf(i));
    }

    public static int colorTransform(int i, int i2, float f) {
        return computeFractionColor((float) Color.alpha(i), (float) Color.alpha(i2), (float) Color.red(i), (float) Color.red(i2), (float) Color.green(i), (float) Color.green(i2), (float) Color.blue(i), (float) Color.blue(i2), f);
    }
}
