package com.honey.account.s0;

import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class l implements LottieListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3099a;
    public final /* synthetic */ AtomicBoolean b;

    public /* synthetic */ l(String str, AtomicBoolean atomicBoolean) {
        this.f3099a = str;
        this.b = atomicBoolean;
    }

    public final void onResult(Object obj) {
        LottieCompositionFactory.lambda$cache$17(this.f3099a, this.b, (Throwable) obj);
    }
}
