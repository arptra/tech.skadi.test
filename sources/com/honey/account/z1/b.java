package com.honey.account.z1;

import android.content.Context;
import com.here.sdk.core.engine.PlatformUtilsInitializer;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f9237a;

    public /* synthetic */ b(Context context) {
        this.f9237a = context;
    }

    public final Object call() {
        return PlatformUtilsInitializer.getCachePathRetrieval(this.f9237a).getPath();
    }
}
