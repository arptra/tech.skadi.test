package com.honey.account.h5;

import android.animation.ValueAnimator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.upuphone.ar.translation.phone.view.TranslatorLoadingView;

public final /* synthetic */ class t implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConstraintLayout.LayoutParams f4527a;
    public final /* synthetic */ TranslatorLoadingView b;

    public /* synthetic */ t(ConstraintLayout.LayoutParams layoutParams, TranslatorLoadingView translatorLoadingView) {
        this.f4527a = layoutParams;
        this.b = translatorLoadingView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        TranslatorLoadingView.j(this.f4527a, this.b, valueAnimator);
    }
}
