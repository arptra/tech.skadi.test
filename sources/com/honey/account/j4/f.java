package com.honey.account.j4;

import com.here.sdk.navigation.SpeedLimit;
import com.here.sdk.navigation.SpeedLimitListener;
import com.upuphone.ar.navi.lite.navi.HereNaviManager;

public final /* synthetic */ class f implements SpeedLimitListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereNaviManager f4870a;

    public /* synthetic */ f(HereNaviManager hereNaviManager) {
        this.f4870a = hereNaviManager;
    }

    public final void onSpeedLimitUpdated(SpeedLimit speedLimit) {
        this.f4870a.j1(speedLimit);
    }
}
