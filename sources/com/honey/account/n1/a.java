package com.honey.account.n1;

import android.animation.ValueAnimator;
import androidx.core.graphics.ColorUtils;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.navigation.DrawerLayoutUtils;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DrawerLayout f9779a;

    public /* synthetic */ a(DrawerLayout drawerLayout) {
        this.f9779a = drawerLayout;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9779a.setScrimColor(ColorUtils.k(DrawerLayoutUtils.DEFAULT_SCRIM_COLOR, AnimationUtils.lerp(DrawerLayoutUtils.DEFAULT_SCRIM_ALPHA, 0, valueAnimator.getAnimatedFraction())));
    }
}
