package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class k implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f2346a;
    public final /* synthetic */ String b;

    public /* synthetic */ k(LottieDrawable lottieDrawable, String str) {
        this.f2346a = lottieDrawable;
        this.b = str;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f2346a.lambda$setMaxFrame$9(this.b, lottieComposition);
    }
}
