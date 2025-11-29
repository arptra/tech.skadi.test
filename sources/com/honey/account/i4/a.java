package com.honey.account.i4;

import com.here.sdk.mapview.MapError;
import com.here.sdk.mapview.MapScene;
import com.upuphone.ar.navi.lite.mapview.HereMapView;

public final /* synthetic */ class a implements MapScene.LoadSceneCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereMapView f4838a;

    public /* synthetic */ a(HereMapView hereMapView) {
        this.f4838a = hereMapView;
    }

    public final void onLoadScene(MapError mapError) {
        this.f4838a.r(mapError);
    }
}
