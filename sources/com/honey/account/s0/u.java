package com.honey.account.s0;

import com.airbnb.lottie.LottieCompositionFactory;
import java.util.concurrent.Callable;

public final /* synthetic */ class u implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3108a;
    public final /* synthetic */ String b;

    public /* synthetic */ u(String str, String str2) {
        this.f3108a = str;
        this.b = str2;
    }

    public final Object call() {
        return LottieCompositionFactory.fromJsonStringSync(this.f3108a, this.b);
    }
}
