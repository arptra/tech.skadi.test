package com.google.android.material.textfield;

import android.animation.ValueAnimator;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClearTextEndIconDelegate f9685a;

    public /* synthetic */ c(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        this.f9685a = clearTextEndIconDelegate;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9685a.lambda$getAlphaAnimator$3(valueAnimator);
    }
}
