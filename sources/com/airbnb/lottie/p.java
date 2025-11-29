package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class p implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f2350a;
    public final /* synthetic */ float b;

    public /* synthetic */ p(LottieDrawable lottieDrawable, float f) {
        this.f2350a = lottieDrawable;
        this.b = f;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f2350a.lambda$setProgress$15(this.b, lottieComposition);
    }
}
