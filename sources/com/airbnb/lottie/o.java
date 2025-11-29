package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class o implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f2349a;
    public final /* synthetic */ float b;

    public /* synthetic */ o(LottieDrawable lottieDrawable, float f) {
        this.f2349a = lottieDrawable;
        this.b = f;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f2349a.lambda$setMinProgress$5(this.b, lottieComposition);
    }
}
