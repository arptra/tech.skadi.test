package com.meizu.common.scrollbarview;

import android.animation.ValueAnimator;
import com.meizu.common.scrollbarview.MzScrollBarView;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MzScrollBarView.ScaleAction f9494a;
    public final /* synthetic */ int b;

    public /* synthetic */ a(MzScrollBarView.ScaleAction scaleAction, int i) {
        this.f9494a = scaleAction;
        this.b = i;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9494a.lambda$run$0(this.b, valueAnimator);
    }
}
