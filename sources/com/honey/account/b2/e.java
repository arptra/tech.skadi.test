package com.honey.account.b2;

import com.here.sdk.mapview.MapView;
import com.here.sdk.mapview.MapViewInternalHsdk;
import java.lang.ref.WeakReference;

public final /* synthetic */ class e implements MapViewInternalHsdk.SetValidSceneConfigurationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WeakReference f9183a;

    public /* synthetic */ e(WeakReference weakReference) {
        this.f9183a = weakReference;
    }

    public final void onSceneConfigurationSet(boolean z) {
        MapView.lambda$onCreate$0(this.f9183a, z);
    }
}
