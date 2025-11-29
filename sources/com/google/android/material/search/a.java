package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f9672a;

    public /* synthetic */ a(View view) {
        this.f9672a = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9672a.setAlpha(0.0f);
    }
}
