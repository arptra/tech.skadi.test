package com.honey.account.s0;

import com.airbnb.lottie.LottieCompositionFactory;
import java.io.InputStream;
import java.util.concurrent.Callable;

public final /* synthetic */ class s implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InputStream f3106a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ s(InputStream inputStream, String str, boolean z) {
        this.f3106a = inputStream;
        this.b = str;
        this.c = z;
    }

    public final Object call() {
        return LottieCompositionFactory.fromJsonInputStreamSync(this.f3106a, this.b, this.c);
    }
}
