package com.honey.account.j8;

import android.animation.ValueAnimator;
import android.view.View;
import com.upuphone.xr.sapp.guide.adapter.WifiListAdapter;

public final /* synthetic */ class g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f4895a;

    public /* synthetic */ g(View view) {
        this.f4895a = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        WifiListAdapter.r(this.f4895a, valueAnimator);
    }
}
