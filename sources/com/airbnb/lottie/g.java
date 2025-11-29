package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;

public final /* synthetic */ class g implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f2342a;
    public final /* synthetic */ KeyPath b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ LottieValueCallback d;

    public /* synthetic */ g(LottieDrawable lottieDrawable, KeyPath keyPath, Object obj, LottieValueCallback lottieValueCallback) {
        this.f2342a = lottieDrawable;
        this.b = keyPath;
        this.c = obj;
        this.d = lottieValueCallback;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f2342a.lambda$addValueCallback$16(this.b, this.c, this.d, lottieComposition);
    }
}
