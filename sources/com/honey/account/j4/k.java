package com.honey.account.j4;

import com.here.sdk.routing.CalculateRouteCallback;
import com.here.sdk.routing.RoutingError;
import com.upuphone.ar.navi.lite.navi.HereNaviManager;
import java.util.List;

public final /* synthetic */ class k implements CalculateRouteCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereNaviManager f4874a;

    public /* synthetic */ k(HereNaviManager hereNaviManager) {
        this.f4874a = hereNaviManager;
    }

    public final void onRouteCalculated(RoutingError routingError, List list) {
        this.f4874a.Z0(routingError, list);
    }
}
