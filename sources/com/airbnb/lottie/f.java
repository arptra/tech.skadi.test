package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class f implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f2341a;
    public final /* synthetic */ int b;

    public /* synthetic */ f(LottieDrawable lottieDrawable, int i) {
        this.f2341a = lottieDrawable;
        this.b = i;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f2341a.lambda$setMinFrame$4(this.b, lottieComposition);
    }
}
