package com.honey.account.k4;

import com.here.sdk.maploader.MapUpdater;
import com.here.sdk.maploader.MapUpdaterConstructionCallback;
import com.upuphone.ar.navi.lite.offlinemap.HereOfflineMap;

public final /* synthetic */ class b implements MapUpdaterConstructionCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereOfflineMap f4904a;

    public /* synthetic */ b(HereOfflineMap hereOfflineMap) {
        this.f4904a = hereOfflineMap;
    }

    public final void onMapUpdaterConstructe(MapUpdater mapUpdater) {
        this.f4904a.E(mapUpdater);
    }
}
