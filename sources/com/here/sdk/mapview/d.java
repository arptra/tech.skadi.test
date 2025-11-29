package com.here.sdk.mapview;

import com.here.sdk.mapview.MapView;
import com.here.sdk.mapview.MapViewInternalHsdk;

public final /* synthetic */ class d implements MapViewInternalHsdk.RedrawCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MapView.RenderSurfaceHandler f9173a;

    public /* synthetic */ d(MapView.RenderSurfaceHandler renderSurfaceHandler) {
        this.f9173a = renderSurfaceHandler;
    }

    public final void onRedrawCompleted() {
        this.f9173a.lambda$surfaceRedrawNeededAsync$1();
    }
}
