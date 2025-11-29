package com.here.sdk.core.engine;

import android.content.Context;
import com.here.sdk.core.engine.PlatformUtilsInitializer;

public final /* synthetic */ class b implements PlatformUtilsInitializer.PathRetrieval {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f9160a;

    public /* synthetic */ b(Context context) {
        this.f9160a = context;
    }

    public final String getPath() {
        return this.f9160a.getFilesDir().getAbsolutePath();
    }
}
