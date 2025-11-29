package com.honey.account.j4;

import com.here.sdk.navigation.DestinationReachedListener;
import com.upuphone.ar.navi.lite.navi.HereNaviManager;

public final /* synthetic */ class o implements DestinationReachedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereNaviManager f4878a;

    public /* synthetic */ o(HereNaviManager hereNaviManager) {
        this.f4878a = hereNaviManager;
    }

    public final void onDestinationReached() {
        this.f4878a.a1();
    }
}
