package com.honey.account.b9;

import android.animation.ValueAnimator;
import com.upuphone.xr.sapp.vu.VuTouchpadActivity;

public final /* synthetic */ class f0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuTouchpadActivity f7129a;

    public /* synthetic */ f0(VuTouchpadActivity vuTouchpadActivity) {
        this.f7129a = vuTouchpadActivity;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        VuTouchpadActivity.J1(this.f7129a, valueAnimator);
    }
}
