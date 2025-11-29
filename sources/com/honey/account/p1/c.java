package com.honey.account.p1;

import android.animation.Animator;
import com.google.android.material.animation.AnimatableView;

public final /* synthetic */ class c implements AnimatableView.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Animator f9784a;

    public /* synthetic */ c(Animator animator) {
        this.f9784a = animator;
    }

    public final void onAnimationEnd() {
        this.f9784a.start();
    }
}
