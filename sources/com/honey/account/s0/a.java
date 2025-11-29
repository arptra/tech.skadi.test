package com.honey.account.s0;

import android.content.Context;
import com.airbnb.lottie.L;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import java.io.File;

public final /* synthetic */ class a implements LottieNetworkCacheProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f3089a;

    public /* synthetic */ a(Context context) {
        this.f3089a = context;
    }

    public final File getCacheDir() {
        return L.lambda$networkCache$0(this.f3089a);
    }
}
