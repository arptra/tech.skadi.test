package com.honey.account.s0;

import android.content.Context;
import com.airbnb.lottie.LottieCompositionFactory;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

public final /* synthetic */ class e implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f3092a;
    public final /* synthetic */ ZipInputStream b;
    public final /* synthetic */ String c;

    public /* synthetic */ e(Context context, ZipInputStream zipInputStream, String str) {
        this.f3092a = context;
        this.b = zipInputStream;
        this.c = str;
    }

    public final Object call() {
        return LottieCompositionFactory.fromZipStreamSync(this.f3092a, this.b, this.c);
    }
}
