package com.honey.account.b9;

import android.animation.ValueAnimator;
import com.upuphone.xr.sapp.vu.VuTouchpadActivity;

public final /* synthetic */ class w implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuTouchpadActivity f7146a;

    public /* synthetic */ w(VuTouchpadActivity vuTouchpadActivity) {
        this.f7146a = vuTouchpadActivity;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        VuTouchpadActivity.i1(this.f7146a, valueAnimator);
    }
}
