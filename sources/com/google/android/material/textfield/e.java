package com.google.android.material.textfield;

import android.animation.ValueAnimator;

public final /* synthetic */ class e implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClearTextEndIconDelegate f9687a;

    public /* synthetic */ e(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        this.f9687a = clearTextEndIconDelegate;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9687a.lambda$getScaleAnimator$4(valueAnimator);
    }
}
