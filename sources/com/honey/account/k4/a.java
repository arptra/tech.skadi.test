package com.honey.account.k4;

import com.here.sdk.maploader.MapDownloader;
import com.here.sdk.maploader.MapDownloaderConstructionCallback;
import com.upuphone.ar.navi.lite.offlinemap.HereOfflineMap;

public final /* synthetic */ class a implements MapDownloaderConstructionCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereOfflineMap f4903a;

    public /* synthetic */ a(HereOfflineMap hereOfflineMap) {
        this.f4903a = hereOfflineMap;
    }

    public final void onMapDownloaderConstructedCompleted(MapDownloader mapDownloader) {
        this.f4903a.D(mapDownloader);
    }
}
