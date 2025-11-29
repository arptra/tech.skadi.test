package com.honey.account.l1;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import com.google.android.material.internal.ExpandCollapseAnimationHelper;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExpandCollapseAnimationHelper f9775a;
    public final /* synthetic */ Rect b;

    public /* synthetic */ a(ExpandCollapseAnimationHelper expandCollapseAnimationHelper, Rect rect) {
        this.f9775a = expandCollapseAnimationHelper;
        this.b = rect;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9775a.lambda$getExpandCollapseAnimator$0(this.b, valueAnimator);
    }
}
