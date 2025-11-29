package com.honey.account.r2;

import androidx.dynamicanimation.animation.SpringAnimation;
import com.meizu.common.animator.MzPressAnimationDrawable;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SpringAnimation f9222a;

    public /* synthetic */ c(SpringAnimation springAnimation) {
        this.f9222a = springAnimation;
    }

    public final void run() {
        MzPressAnimationDrawable.lambda$startAnimationOnMainThread$0(this.f9222a);
    }
}
