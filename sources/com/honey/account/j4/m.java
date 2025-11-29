package com.honey.account.j4;

import com.here.sdk.routing.CalculateRouteCallback;
import com.here.sdk.routing.RoutingError;
import com.upuphone.ar.navi.lite.navi.HereNaviManager;
import java.util.List;

public final /* synthetic */ class m implements CalculateRouteCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereNaviManager f4876a;

    public /* synthetic */ m(HereNaviManager hereNaviManager) {
        this.f4876a = hereNaviManager;
    }

    public final void onRouteCalculated(RoutingError routingError, List list) {
        this.f4876a.V0(routingError, list);
    }
}
