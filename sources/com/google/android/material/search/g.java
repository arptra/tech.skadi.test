package com.google.android.material.search;

import android.animation.ValueAnimator;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;

public final /* synthetic */ class g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DrawerArrowDrawable f9676a;

    public /* synthetic */ g(DrawerArrowDrawable drawerArrowDrawable) {
        this.f9676a = drawerArrowDrawable;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9676a.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
