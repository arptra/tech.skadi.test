package com.honey.account.u2;

import android.animation.ValueAnimator;
import com.meizu.common.widget.MzPAGEmptyLayout;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MzPAGEmptyLayout f9227a;

    public /* synthetic */ b(MzPAGEmptyLayout mzPAGEmptyLayout) {
        this.f9227a = mzPAGEmptyLayout;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9227a.lambda$initAlphaAnimator$1(valueAnimator);
    }
}
