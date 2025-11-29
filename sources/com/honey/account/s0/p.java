package com.honey.account.s0;

import com.airbnb.lottie.LottieCompositionFactory;
import java.io.InputStream;
import java.util.concurrent.Callable;

public final /* synthetic */ class p implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InputStream f3103a;
    public final /* synthetic */ String b;

    public /* synthetic */ p(InputStream inputStream, String str) {
        this.f3103a = inputStream;
        this.b = str;
    }

    public final Object call() {
        return LottieCompositionFactory.fromJsonInputStreamSync(this.f3103a, this.b);
    }
}
