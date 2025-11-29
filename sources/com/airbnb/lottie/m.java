package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class m implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f2347a;
    public final /* synthetic */ String b;

    public /* synthetic */ m(LottieDrawable lottieDrawable, String str) {
        this.f2347a = lottieDrawable;
        this.b = str;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f2347a.lambda$setMinFrame$8(this.b, lottieComposition);
    }
}
