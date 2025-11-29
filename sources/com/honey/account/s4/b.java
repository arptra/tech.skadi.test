package com.honey.account.s4;

import com.airbnb.lottie.LottieAnimationView;
import com.upuphone.ar.tici.phone.utils.LottieExtKt;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f5121a;
    public final /* synthetic */ long b;

    public /* synthetic */ b(LottieAnimationView lottieAnimationView, long j) {
        this.f5121a = lottieAnimationView;
        this.b = j;
    }

    public final void run() {
        LottieExtKt.f(this.f5121a, this.b);
    }
}
