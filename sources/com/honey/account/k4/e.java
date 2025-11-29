package com.honey.account.k4;

import com.here.sdk.maploader.CatalogsUpdateInfoCallback;
import com.here.sdk.maploader.MapLoaderError;
import com.upuphone.ar.navi.lite.offlinemap.HereOfflineMap;
import java.util.List;

public final /* synthetic */ class e implements CatalogsUpdateInfoCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereOfflineMap f4906a;

    public /* synthetic */ e(HereOfflineMap hereOfflineMap) {
        this.f4906a = hereOfflineMap;
    }

    public final void apply(MapLoaderError mapLoaderError, List list) {
        this.f4906a.A(mapLoaderError, list);
    }
}
