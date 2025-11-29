package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class e implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f2340a;
    public final /* synthetic */ int b;

    public /* synthetic */ e(LottieDrawable lottieDrawable, int i) {
        this.f2340a = lottieDrawable;
        this.b = i;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f2340a.lambda$setMaxFrame$6(this.b, lottieComposition);
    }
}
