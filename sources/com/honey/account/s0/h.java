package com.honey.account.s0;

import android.content.Context;
import com.airbnb.lottie.LottieCompositionFactory;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

public final /* synthetic */ class h implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f3095a;
    public final /* synthetic */ ZipInputStream b;
    public final /* synthetic */ String c;

    public /* synthetic */ h(Context context, ZipInputStream zipInputStream, String str) {
        this.f3095a = context;
        this.b = zipInputStream;
        this.c = str;
    }

    public final Object call() {
        return LottieCompositionFactory.fromZipStreamSync(this.f3095a, this.b, this.c);
    }
}
