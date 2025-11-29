package com.google.android.material.card;

import android.animation.ValueAnimator;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialCardViewHelper f9668a;

    public /* synthetic */ a(MaterialCardViewHelper materialCardViewHelper) {
        this.f9668a = materialCardViewHelper;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9668a.lambda$animateCheckedIcon$0(valueAnimator);
    }
}
