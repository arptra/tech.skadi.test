package com.google.android.material.search;

import android.animation.ValueAnimator;
import com.google.android.material.internal.FadeThroughDrawable;

public final /* synthetic */ class i implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FadeThroughDrawable f9678a;

    public /* synthetic */ i(FadeThroughDrawable fadeThroughDrawable) {
        this.f9678a = fadeThroughDrawable;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9678a.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
