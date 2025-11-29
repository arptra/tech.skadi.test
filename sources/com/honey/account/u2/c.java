package com.honey.account.u2;

import android.animation.ValueAnimator;
import android.view.View;
import com.meizu.common.widget.PageIndicator;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f9228a;

    public /* synthetic */ c(View view) {
        this.f9228a = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        PageIndicator.lambda$createColorTransitionAnimation$0(this.f9228a, valueAnimator);
    }
}
