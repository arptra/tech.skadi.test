package com.honey.account.j4;

import com.here.sdk.mapview.MapView;
import com.upuphone.ar.navi.lite.navi.HereNaviManager;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereNaviManager f4875a;
    public final /* synthetic */ MapView b;

    public /* synthetic */ l(HereNaviManager hereNaviManager, MapView mapView) {
        this.f4875a = hereNaviManager;
        this.b = mapView;
    }

    public final void run() {
        this.f4875a.Y0(this.b);
    }
}
