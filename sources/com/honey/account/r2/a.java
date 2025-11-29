package com.honey.account.r2;

import android.animation.ValueAnimator;
import android.view.View;
import com.meizu.common.animator.ExpandAnimator;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExpandAnimator f9220a;
    public final /* synthetic */ View b;
    public final /* synthetic */ int c;

    public /* synthetic */ a(ExpandAnimator expandAnimator, View view, int i) {
        this.f9220a = expandAnimator;
        this.b = view;
        this.c = i;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ExpandAnimator.expand$lambda$0(this.f9220a, this.b, this.c, valueAnimator);
    }
}
