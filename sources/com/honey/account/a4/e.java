package com.honey.account.a4;

import android.animation.ValueAnimator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordLoadingView;

public final /* synthetic */ class e implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConstraintLayout.LayoutParams f4147a;
    public final /* synthetic */ FastRecordLoadingView b;

    public /* synthetic */ e(ConstraintLayout.LayoutParams layoutParams, FastRecordLoadingView fastRecordLoadingView) {
        this.f4147a = layoutParams;
        this.b = fastRecordLoadingView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        FastRecordLoadingView.createAiTextAnimator$lambda$12$lambda$11(this.f4147a, this.b, valueAnimator);
    }
}
