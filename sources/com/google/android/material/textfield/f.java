package com.google.android.material.textfield;

import android.animation.ValueAnimator;

public final /* synthetic */ class f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DropdownMenuEndIconDelegate f9688a;

    public /* synthetic */ f(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.f9688a = dropdownMenuEndIconDelegate;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9688a.lambda$getAlphaAnimator$6(valueAnimator);
    }
}
