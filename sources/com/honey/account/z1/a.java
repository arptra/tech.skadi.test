package com.honey.account.z1;

import android.content.Context;
import com.here.sdk.core.engine.PlatformUtilsInitializer;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f9236a;

    public /* synthetic */ a(Context context) {
        this.f9236a = context;
    }

    public final Object call() {
        return PlatformUtilsInitializer.getFilesPathRetrieval(this.f9236a).getPath();
    }
}
