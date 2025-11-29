package com.honey.account.r2;

import android.animation.ValueAnimator;
import android.view.View;
import com.meizu.common.animator.ExpandAnimator;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExpandAnimator f9221a;
    public final /* synthetic */ View b;

    public /* synthetic */ b(ExpandAnimator expandAnimator, View view) {
        this.f9221a = expandAnimator;
        this.b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ExpandAnimator.fold$lambda$1(this.f9221a, this.b, valueAnimator);
    }
}
