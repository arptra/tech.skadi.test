package com.honey.account.s0;

import android.content.Context;
import com.airbnb.lottie.LottieCompositionFactory;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

public final /* synthetic */ class m implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WeakReference f3100a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;

    public /* synthetic */ m(WeakReference weakReference, Context context, int i, String str) {
        this.f3100a = weakReference;
        this.b = context;
        this.c = i;
        this.d = str;
    }

    public final Object call() {
        return LottieCompositionFactory.lambda$fromRawRes$2(this.f3100a, this.b, this.c, this.d);
    }
}
