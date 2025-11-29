package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.graphics.Rect;

public final /* synthetic */ class f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchViewAnimationHelper f9675a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;
    public final /* synthetic */ Rect d;

    public /* synthetic */ f(SearchViewAnimationHelper searchViewAnimationHelper, float f, float f2, Rect rect) {
        this.f9675a = searchViewAnimationHelper;
        this.b = f;
        this.c = f2;
        this.d = rect;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9675a.lambda$getRootViewAnimator$2(this.b, this.c, this.d, valueAnimator);
    }
}
