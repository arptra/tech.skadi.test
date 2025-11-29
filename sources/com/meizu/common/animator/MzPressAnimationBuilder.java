package com.meizu.common.animator;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

public class MzPressAnimationBuilder {
    private static final int ANIMATION_DURATION = 200;
    private static final float DAMPING = 0.9f;
    private static final float FROM_ALPHA = 1.0f;
    private static final float FROM_X_SCALE = 1.0f;
    private static final float FROM_Y_SCALE = 1.0f;
    private static final float STIFFNESS = 250.0f;
    private static final float TO_ALPHA = 0.8f;
    private static final float TO_X_SCALE = 0.9f;
    private static final float TO_Y_SCALE = 0.9f;
    private static final Interpolator sInterpolator = PathInterpolatorCompat.a(0.4f, 0.0f, 0.58f, 1.0f);
    private ObjectAnimator alphaAnimation;
    private PropertyValuesHolder alphaHolder;
    private int mDuration;
    private float mToAlpha;
    private float mToXScale;
    private float mToYScale;
    private View mView;
    private SpringAnimation springAnimationX;
    private SpringAnimation springAnimationY;

    public MzPressAnimationBuilder(View view) {
        this.mView = view;
    }

    public void pressAnimationInit() {
        pressAnimationInit(TO_ALPHA, 0.9f, 0.9f, 200);
    }

    public void pressAnimationReverse() {
        this.springAnimationX.v().e(1.0f);
        this.springAnimationY.v().e(1.0f);
        this.springAnimationX.q();
        this.springAnimationY.q();
        this.alphaAnimation.reverse();
    }

    public void pressAnimationStart() {
        this.springAnimationX.d();
        this.springAnimationY.d();
        this.springAnimationX.v().e(this.mToXScale);
        this.springAnimationY.v().e(this.mToYScale);
        this.springAnimationX.q();
        this.springAnimationY.q();
        this.alphaAnimation.start();
    }

    public void setDuration(int i) {
        if (this.mDuration != i) {
            this.mDuration = i;
            this.alphaAnimation.setDuration((long) i);
        }
    }

    public void setToAlpha(float f) {
        this.mToAlpha = f;
        this.alphaHolder.setFloatValues(new float[]{1.0f, f});
        this.alphaAnimation.setValues(new PropertyValuesHolder[]{this.alphaHolder});
    }

    public void setToXScale(float f) {
        this.mToXScale = f;
    }

    public void setToYScale(float f) {
        this.mToYScale = f;
    }

    public void pressAnimationInit(float f, float f2, float f3, int i) {
        this.mDuration = i;
        this.mToAlpha = f;
        this.mToXScale = f2;
        this.mToYScale = f3;
        SpringForce f4 = new SpringForce().d(0.9f).f(STIFFNESS);
        this.springAnimationX = new SpringAnimation(this.mView, DynamicAnimation.p).y(f4);
        this.springAnimationY = new SpringAnimation(this.mView, DynamicAnimation.q).y(f4);
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f, this.mToAlpha});
        this.alphaHolder = ofFloat;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mView, new PropertyValuesHolder[]{ofFloat});
        this.alphaAnimation = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setInterpolator(sInterpolator);
        this.alphaAnimation.setDuration((long) this.mDuration);
    }
}
