package com.honey.account.k4;

import com.here.sdk.maploader.DownloadableRegionsCallback;
import com.here.sdk.maploader.MapLoaderError;
import com.upuphone.ar.navi.lite.offlinemap.HereOfflineMap;
import java.util.List;

public final /* synthetic */ class c implements DownloadableRegionsCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereOfflineMap f4905a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ c(HereOfflineMap hereOfflineMap, String str, String str2) {
        this.f4905a = hereOfflineMap;
        this.b = str;
        this.c = str2;
    }

    public final void onCompleted(MapLoaderError mapLoaderError, List list) {
        this.f4905a.F(this.b, this.c, mapLoaderError, list);
    }
}
