package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class h implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f2343a;
    public final /* synthetic */ float b;

    public /* synthetic */ h(LottieDrawable lottieDrawable, float f) {
        this.f2343a = lottieDrawable;
        this.b = f;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f2343a.lambda$setMaxProgress$7(this.b, lottieComposition);
    }
}
