package com.honey.account.s0;

import com.airbnb.lottie.LottieAnimationView;
import java.util.concurrent.Callable;

public final /* synthetic */ class d implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f3091a;
    public final /* synthetic */ int b;

    public /* synthetic */ d(LottieAnimationView lottieAnimationView, int i) {
        this.f3091a = lottieAnimationView;
        this.b = i;
    }

    public final Object call() {
        return this.f3091a.lambda$fromRawRes$1(this.b);
    }
}
