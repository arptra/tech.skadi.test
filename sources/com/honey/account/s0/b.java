package com.honey.account.s0;

import com.airbnb.lottie.LottieAnimationView;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f3090a;
    public final /* synthetic */ String b;

    public /* synthetic */ b(LottieAnimationView lottieAnimationView, String str) {
        this.f3090a = lottieAnimationView;
        this.b = str;
    }

    public final Object call() {
        return this.f3090a.lambda$fromAssets$2(this.b);
    }
}
