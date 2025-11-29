package com.honey.account.b2;

import com.here.sdk.mapview.MapSurface;
import com.here.sdk.mapview.MapViewInternalHsdk;
import java.lang.ref.WeakReference;

public final /* synthetic */ class a implements MapViewInternalHsdk.SetValidSceneConfigurationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WeakReference f9179a;

    public /* synthetic */ a(WeakReference weakReference) {
        this.f9179a = weakReference;
    }

    public final void onSceneConfigurationSet(boolean z) {
        MapSurface.lambda$setSurface$1(this.f9179a, z);
    }
}
