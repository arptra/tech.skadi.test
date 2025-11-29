package com.honey.account.j4;

import com.here.sdk.navigation.SpeedWarningListener;
import com.here.sdk.navigation.SpeedWarningStatus;
import com.upuphone.ar.navi.lite.navi.HereNaviManager;

public final /* synthetic */ class d implements SpeedWarningListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereNaviManager f4868a;

    public /* synthetic */ d(HereNaviManager hereNaviManager) {
        this.f4868a = hereNaviManager;
    }

    public final void onSpeedWarningStatusChanged(SpeedWarningStatus speedWarningStatus) {
        this.f4868a.k1(speedWarningStatus);
    }
}
