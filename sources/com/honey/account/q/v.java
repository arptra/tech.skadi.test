package com.honey.account.q;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;

public final /* synthetic */ class v implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimatorUpdateListener f3082a;
    public final /* synthetic */ View b;

    public /* synthetic */ v(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
        this.f3082a = viewPropertyAnimatorUpdateListener;
        this.b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3082a.onAnimationUpdate(this.b);
    }
}
