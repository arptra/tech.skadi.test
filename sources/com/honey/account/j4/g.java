package com.honey.account.j4;

import com.here.sdk.navigation.ManeuverNotificationListener;
import com.upuphone.ar.navi.lite.navi.HereNaviManager;

public final /* synthetic */ class g implements ManeuverNotificationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereNaviManager f4871a;

    public /* synthetic */ g(HereNaviManager hereNaviManager) {
        this.f4871a = hereNaviManager;
    }

    public final void onManeuverNotification(String str) {
        this.f4871a.f1(str);
    }
}
