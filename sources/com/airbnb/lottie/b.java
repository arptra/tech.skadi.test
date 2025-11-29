package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class b implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f2337a;
    public final /* synthetic */ int b;

    public /* synthetic */ b(LottieDrawable lottieDrawable, int i) {
        this.f2337a = lottieDrawable;
        this.b = i;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f2337a.lambda$setFrame$14(this.b, lottieComposition);
    }
}
