package com.honey.account.k4;

import com.here.sdk.maploader.DeletedRegionsCallback;
import com.here.sdk.maploader.MapLoaderError;
import com.here.sdk.maploader.Region;
import com.upuphone.ar.navi.lite.offlinemap.HereOfflineMap;
import java.util.List;

public final /* synthetic */ class f implements DeletedRegionsCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereOfflineMap f4907a;
    public final /* synthetic */ List b;
    public final /* synthetic */ Region c;

    public /* synthetic */ f(HereOfflineMap hereOfflineMap, List list, Region region) {
        this.f4907a = hereOfflineMap;
        this.b = list;
        this.c = region;
    }

    public final void onCompleted(MapLoaderError mapLoaderError, List list) {
        this.f4907a.C(this.b, this.c, mapLoaderError, list);
    }
}
