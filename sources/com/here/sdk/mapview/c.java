package com.here.sdk.mapview;

import com.here.sdk.mapview.MapView;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f9172a;
    public final /* synthetic */ Runnable b;

    public /* synthetic */ c(Runnable runnable, Runnable runnable2) {
        this.f9172a = runnable;
        this.b = runnable2;
    }

    public final void run() {
        MapView.RenderSurfaceHandler.lambda$surfaceRedrawNeededAsync$0(this.f9172a, this.b);
    }
}
