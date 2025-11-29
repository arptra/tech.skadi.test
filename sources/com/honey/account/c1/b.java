package com.honey.account.c1;

import android.animation.ValueAnimator;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.shape.MaterialShapeDrawable;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f9708a;
    public final /* synthetic */ MaterialShapeDrawable b;

    public /* synthetic */ b(AppBarLayout appBarLayout, MaterialShapeDrawable materialShapeDrawable) {
        this.f9708a = appBarLayout;
        this.b = materialShapeDrawable;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9708a.lambda$initializeLiftOnScrollWithElevation$1(this.b, valueAnimator);
    }
}
