package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class c implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f2338a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;

    public /* synthetic */ c(LottieDrawable lottieDrawable, float f, float f2) {
        this.f2338a = lottieDrawable;
        this.b = f;
        this.c = f2;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f2338a.lambda$setMinAndMaxProgress$13(this.b, this.c, lottieComposition);
    }
}
