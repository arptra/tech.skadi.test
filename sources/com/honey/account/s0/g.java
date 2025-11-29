package com.honey.account.s0;

import android.content.Context;
import com.airbnb.lottie.LottieCompositionFactory;
import java.util.concurrent.Callable;

public final /* synthetic */ class g implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f3094a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ g(Context context, String str, String str2) {
        this.f3094a = context;
        this.b = str;
        this.c = str2;
    }

    public final Object call() {
        return LottieCompositionFactory.fromAssetSync(this.f3094a, this.b, this.c);
    }
}
