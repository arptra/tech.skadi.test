package com.google.android.material.timepicker;

import android.animation.ValueAnimator;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClockHandView f9696a;

    public /* synthetic */ a(ClockHandView clockHandView) {
        this.f9696a = clockHandView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9696a.lambda$setHandRotation$0(valueAnimator);
    }
}
