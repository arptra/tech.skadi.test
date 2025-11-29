package com.honey.account.j4;

import com.here.sdk.navigation.RouteProgress;
import com.here.sdk.navigation.RouteProgressListener;
import com.upuphone.ar.navi.lite.navi.HereNaviManager;

public final /* synthetic */ class c implements RouteProgressListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereNaviManager f4867a;

    public /* synthetic */ c(HereNaviManager hereNaviManager) {
        this.f4867a = hereNaviManager;
    }

    public final void onRouteProgressUpdated(RouteProgress routeProgress) {
        this.f4867a.i1(routeProgress);
    }
}
