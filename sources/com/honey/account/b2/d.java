package com.honey.account.b2;

import com.here.sdk.mapview.MapSurface;
import com.here.sdk.mapview.MapViewInternalHsdk;

public final /* synthetic */ class d implements MapViewInternalHsdk.RedrawCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f9182a;

    public /* synthetic */ d(Runnable runnable) {
        this.f9182a = runnable;
    }

    public final void onRedrawCompleted() {
        MapSurface.lambda$redraw$2(this.f9182a);
    }
}
