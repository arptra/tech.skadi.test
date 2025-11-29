package com.honey.account.y4;

import android.animation.ValueAnimator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.upuphone.ar.transcribe.phone.view.TransLoadingView;

public final /* synthetic */ class g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConstraintLayout.LayoutParams f5316a;
    public final /* synthetic */ TransLoadingView b;

    public /* synthetic */ g(ConstraintLayout.LayoutParams layoutParams, TransLoadingView transLoadingView) {
        this.f5316a = layoutParams;
        this.b = transLoadingView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        TransLoadingView.j(this.f5316a, this.b, valueAnimator);
    }
}
