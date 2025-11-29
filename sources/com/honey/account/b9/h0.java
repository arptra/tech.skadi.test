package com.honey.account.b9;

import android.animation.ValueAnimator;
import com.upuphone.xr.sapp.vu.VuTouchpadActivity;

public final /* synthetic */ class h0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuTouchpadActivity f7132a;

    public /* synthetic */ h0(VuTouchpadActivity vuTouchpadActivity) {
        this.f7132a = vuTouchpadActivity;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        VuTouchpadActivity.h1(this.f7132a, valueAnimator);
    }
}
