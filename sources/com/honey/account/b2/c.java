package com.honey.account.b2;

import com.here.sdk.mapview.MapSurface;
import com.here.sdk.mapview.MapViewInternalHsdk;
import java.lang.ref.WeakReference;

public final /* synthetic */ class c implements MapViewInternalHsdk.SetValidSceneConfigurationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WeakReference f9181a;

    public /* synthetic */ c(WeakReference weakReference) {
        this.f9181a = weakReference;
    }

    public final void onSceneConfigurationSet(boolean z) {
        MapSurface.lambda$new$0(this.f9181a, z);
    }
}
