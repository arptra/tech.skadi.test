package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class d implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f2339a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public /* synthetic */ d(LottieDrawable lottieDrawable, int i, int i2) {
        this.f2339a = lottieDrawable;
        this.b = i;
        this.c = i2;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f2339a.lambda$setMinAndMaxFrame$12(this.b, this.c, lottieComposition);
    }
}
