package com.here.sdk.core.engine;

import android.content.Context;
import com.here.sdk.core.engine.PlatformUtilsInitializer;

public final /* synthetic */ class a implements PlatformUtilsInitializer.PathRetrieval {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f9159a;

    public /* synthetic */ a(Context context) {
        this.f9159a = context;
    }

    public final String getPath() {
        return this.f9159a.getCacheDir().getPath();
    }
}
