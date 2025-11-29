package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class a implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f2336a;
    public final /* synthetic */ String b;

    public /* synthetic */ a(LottieDrawable lottieDrawable, String str) {
        this.f2336a = lottieDrawable;
        this.b = str;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f2336a.lambda$setMinAndMaxFrame$10(this.b, lottieComposition);
    }
}
