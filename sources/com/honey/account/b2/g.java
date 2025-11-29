package com.honey.account.b2;

import com.here.sdk.mapview.MapView;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MapView f9185a;

    public /* synthetic */ g(MapView mapView) {
        this.f9185a = mapView;
    }

    public final void run() {
        this.f9185a.forceRedraw();
    }
}
