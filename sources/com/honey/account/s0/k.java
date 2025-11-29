package com.honey.account.s0;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class k implements LottieListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3098a;
    public final /* synthetic */ AtomicBoolean b;

    public /* synthetic */ k(String str, AtomicBoolean atomicBoolean) {
        this.f3098a = str;
        this.b = atomicBoolean;
    }

    public final void onResult(Object obj) {
        LottieCompositionFactory.lambda$cache$16(this.f3098a, this.b, (LottieComposition) obj);
    }
}
