package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class j implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f2345a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ j(LottieDrawable lottieDrawable, String str, String str2, boolean z) {
        this.f2345a = lottieDrawable;
        this.b = str;
        this.c = str2;
        this.d = z;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f2345a.lambda$setMinAndMaxFrame$11(this.b, this.c, this.d, lottieComposition);
    }
}
