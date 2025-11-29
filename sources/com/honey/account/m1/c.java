package com.honey.account.m1;

import android.animation.ValueAnimator;
import com.google.android.material.internal.ClippableRoundedCornerLayout;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClippableRoundedCornerLayout f9778a;

    public /* synthetic */ c(ClippableRoundedCornerLayout clippableRoundedCornerLayout) {
        this.f9778a = clippableRoundedCornerLayout;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9778a.updateCornerRadius(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
