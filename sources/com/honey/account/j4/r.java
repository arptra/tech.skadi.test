package com.honey.account.j4;

import com.here.sdk.navigation.NavigableLocation;
import com.here.sdk.navigation.NavigableLocationListener;
import com.upuphone.ar.navi.lite.navi.HereNaviManager;

public final /* synthetic */ class r implements NavigableLocationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereNaviManager f4880a;

    public /* synthetic */ r(HereNaviManager hereNaviManager) {
        this.f4880a = hereNaviManager;
    }

    public final void onNavigableLocationUpdated(NavigableLocation navigableLocation) {
        this.f4880a.e1(navigableLocation);
    }
}
