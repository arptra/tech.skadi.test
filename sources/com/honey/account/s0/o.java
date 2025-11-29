package com.honey.account.s0;

import android.content.Context;
import com.airbnb.lottie.LottieCompositionFactory;
import java.util.concurrent.Callable;

public final /* synthetic */ class o implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f3102a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ o(Context context, String str, String str2) {
        this.f3102a = context;
        this.b = str;
        this.c = str2;
    }

    public final Object call() {
        return LottieCompositionFactory.lambda$fromUrl$0(this.f3102a, this.b, this.c);
    }
}
