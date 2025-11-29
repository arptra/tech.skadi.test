package com.honey.account.s0;

import com.airbnb.lottie.LottieCompositionFactory;
import java.io.InputStream;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f3107a;
    public final /* synthetic */ InputStream b;

    public /* synthetic */ t(boolean z, InputStream inputStream) {
        this.f3107a = z;
        this.b = inputStream;
    }

    public final void run() {
        LottieCompositionFactory.lambda$fromJsonInputStream$6(this.f3107a, this.b);
    }
}
