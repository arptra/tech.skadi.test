package com.honey.account.b9;

import android.animation.ValueAnimator;
import com.upuphone.xr.sapp.vu.VuTouchpadActivity;

public final /* synthetic */ class g0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuTouchpadActivity f7130a;

    public /* synthetic */ g0(VuTouchpadActivity vuTouchpadActivity) {
        this.f7130a = vuTouchpadActivity;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        VuTouchpadActivity.I1(this.f7130a, valueAnimator);
    }
}
