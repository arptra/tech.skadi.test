package com.honey.account.j4;

import com.here.sdk.navigation.RoadAttributes;
import com.here.sdk.navigation.RoadAttributesListener;
import com.upuphone.ar.navi.lite.navi.HereNaviManager;

public final /* synthetic */ class p implements RoadAttributesListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereNaviManager f4879a;

    public /* synthetic */ p(HereNaviManager hereNaviManager) {
        this.f4879a = hereNaviManager;
    }

    public final void onRoadAttributesUpdated(RoadAttributes roadAttributes) {
        this.f4879a.h1(roadAttributes);
    }
}
