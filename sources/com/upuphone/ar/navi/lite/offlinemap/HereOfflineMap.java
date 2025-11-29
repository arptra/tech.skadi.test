package com.upuphone.ar.navi.lite.offlinemap;

import android.content.Context;
import android.text.TextUtils;
import com.here.sdk.core.LanguageCode;
import com.here.sdk.core.engine.SDKBuildInformation;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.maploader.CatalogUpdateInfo;
import com.here.sdk.maploader.CatalogUpdateProgressListener;
import com.here.sdk.maploader.DownloadRegionsStatusListener;
import com.here.sdk.maploader.InstalledRegion;
import com.here.sdk.maploader.MapDownloader;
import com.here.sdk.maploader.MapDownloaderTask;
import com.here.sdk.maploader.MapLoaderError;
import com.here.sdk.maploader.MapLoaderException;
import com.here.sdk.maploader.MapUpdater;
import com.here.sdk.maploader.MapVersionHandle;
import com.here.sdk.maploader.PersistentMapRepairError;
import com.here.sdk.maploader.PersistentMapStatus;
import com.here.sdk.maploader.Region;
import com.here.sdk.maploader.RegionId;
import com.honey.account.k4.a;
import com.honey.account.k4.b;
import com.honey.account.k4.c;
import com.honey.account.k4.d;
import com.honey.account.k4.e;
import com.honey.account.k4.f;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.location.LocationManager;
import com.upuphone.ar.navi.lite.navi.HereNaviManager;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.ar.navi.lite.util.NetworkUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;

public final class HereOfflineMap extends AbsOfflineMap {
    public static final String m = ("NAVI-" + HereOfflineMap.class.getSimpleName());
    public static HereOfflineMap n;
    public MapDownloader h;
    public MapUpdater i;
    public final List j = new ArrayList();
    public Region k = null;
    public Region l = null;

    public static /* synthetic */ void B(PersistentMapRepairError persistentMapRepairError) {
        if (persistentMapRepairError == null) {
            CLog.a(m, "RepairPersistentMap Repair operation completed successfully!");
            return;
        }
        String str = m;
        CLog.a(str, "RepairPersistentMap Repair operation failed: " + persistentMapRepairError.name());
    }

    public static HereOfflineMap y() {
        synchronized (HereOfflineMap.class) {
            try {
                if (n == null) {
                    n = new HereOfflineMap();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return n;
    }

    public final /* synthetic */ void A(MapLoaderError mapLoaderError, List list) {
        if (mapLoaderError != null) {
            String str = m;
            CLog.b(str, "CatalogUpdateCheck Error: " + mapLoaderError.name());
            return;
        }
        if (list.isEmpty()) {
            CLog.a(m, "CatalogUpdateCheck No map updates are available.");
        }
        G();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CatalogUpdateInfo catalogUpdateInfo = (CatalogUpdateInfo) it.next();
            String str2 = m;
            CLog.a(str2, "CatalogUpdateCheck Catalog name:" + catalogUpdateInfo.installedCatalog.catalogIdentifier.hrn + " Installed map version:" + catalogUpdateInfo.installedCatalog.catalogIdentifier.version + " Latest available map version:" + catalogUpdateInfo.latestVersion);
            I(catalogUpdateInfo);
        }
    }

    public final /* synthetic */ void C(List list, Region region, MapLoaderError mapLoaderError, List list2) {
        String str = m;
        CLog.d(str, "downLoadRegionMap() mapLoaderError=" + mapLoaderError + " list=" + list2);
        if (list2 != null) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                String str2 = m;
                CLog.d(str2, "downLoadRegionMap() regionId.id=" + ((RegionId) it.next()).id);
            }
        }
        list.clear();
        M(region);
    }

    public final /* synthetic */ void D(MapDownloader mapDownloader) {
        this.h = mapDownloader;
        t();
    }

    public final /* synthetic */ void E(MapUpdater mapUpdater) {
        this.i = mapUpdater;
        J();
    }

    public final /* synthetic */ void F(String str, String str2, MapLoaderError mapLoaderError, List list) {
        if (mapLoaderError != null) {
            String str3 = m;
            CLog.a(str3, "queryDownloadRegionsList() regions error: " + mapLoaderError);
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Region region = (Region) it.next();
            List<Region> list2 = region.childRegions;
            if (list2 != null) {
                L(region, str, str2);
                for (Region next : list2) {
                    long j2 = next.sizeOnDiskInBytes;
                    L(next, str, str2);
                    z(next, str, str2);
                }
            }
        }
        String str4 = m;
        CLog.b(str4, "queryDownloadRegionsList() Found " + list.size() + " continents with various countries. See log for details.");
        Region region2 = this.k;
        if (region2 == null) {
            region2 = this.l;
        }
        v(region2, str, str2);
    }

    public final void G() {
        MapUpdater mapUpdater = this.i;
        if (mapUpdater == null) {
            CLog.a(m, "logCurrentMapVersion()  MapUpdater instance not ready. Try again.");
            return;
        }
        try {
            MapVersionHandle currentMapVersion = mapUpdater.getCurrentMapVersion();
            String str = m;
            CLog.a(str, "Installed map version: " + currentMapVersion.stringRepresentation(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA));
        } catch (MapLoaderException e) {
            MapLoaderError mapLoaderError = e.error;
            String str2 = m;
            CLog.b(str2, "MapLoaderError Fetching current map version failed: " + mapLoaderError.toString());
        }
    }

    public final void H() {
        String str = m;
        CLog.a(str, "HERE SDK version: " + SDKBuildInformation.sdkVersion().versionName);
    }

    public final void I(CatalogUpdateInfo catalogUpdateInfo) {
        MapUpdater mapUpdater = this.i;
        if (mapUpdater == null) {
            CLog.a(m, "MapUpdater instance not ready. Try again.");
        } else {
            mapUpdater.updateCatalog(catalogUpdateInfo, new CatalogUpdateProgressListener() {
                public void onComplete(MapLoaderError mapLoaderError) {
                    if (mapLoaderError != null) {
                        String r = HereOfflineMap.m;
                        CLog.a(r, "CatalogUpdate()  onComplete Map update completion error: " + mapLoaderError);
                        return;
                    }
                    CLog.a(HereOfflineMap.m, "CatalogUpdate()  One or more map update has been successfully installed.");
                    HereOfflineMap.this.G();
                }

                public void onPause(MapLoaderError mapLoaderError) {
                    if (mapLoaderError == null) {
                        CLog.a(HereOfflineMap.m, "CatalogUpdate()  onPause The map update was paused by the user calling catalogUpdateTask.pause().");
                        return;
                    }
                    String r = HereOfflineMap.m;
                    CLog.a(r, "CatalogUpdate()  onPause Map update onPause error. The task tried to often to retry the update: " + mapLoaderError);
                }

                public void onProgress(RegionId regionId, int i) {
                    String r = HereOfflineMap.m;
                    CLog.a(r, " CatalogUpdate() onProgress Downloading and installing a map update. Progress for " + regionId.id + ": " + i);
                }

                public void onResume() {
                    CLog.a(HereOfflineMap.m, "CatalogUpdate()  onResume A previously paused map update has been resumed.");
                }
            });
        }
    }

    public final void J() {
        H();
        G();
        s();
    }

    public void K() {
        if (this.h == null) {
            CLog.a(m, "queryDownloadRegionsList() instance not ready. Try again.");
            return;
        }
        PlaceBean j2 = LocationManager.f().j();
        String str = "";
        String country = j2 != null ? j2.getCountry() : str;
        if (j2 != null) {
            str = j2.getCity();
        }
        String str2 = m;
        CLog.a(str2, "downloadOfflineMap country:" + country + " city=" + str);
        if (TextUtils.isEmpty(country) || TextUtils.isEmpty(str)) {
            CLog.d(str2, "queryDownloadRegionsList() country or city is empty.");
            return;
        }
        LanguageCode y0 = HereNaviManager.v0().y0();
        CLog.a(str2, "queryDownloadRegionsList() languageCode: " + y0);
        this.h.getDownloadableRegions(y0, new c(this, country, str));
    }

    public final void L(Region region, String str, String str2) {
        if (region != null && region.name.equals(str2)) {
            this.k = region;
        }
        if (region != null && region.name.equals(str)) {
            this.l = region;
        }
    }

    public final void M(Region region) {
        this.j.add(this.h.downloadRegions(Collections.singletonList(region.regionId), new DownloadRegionsStatusListener() {
            public void onDownloadRegionsComplete(MapLoaderError mapLoaderError, List list) {
                if (mapLoaderError != null) {
                    String r = HereOfflineMap.m;
                    CLog.a(r, "Download regions completion error: " + mapLoaderError);
                    return;
                }
                RegionId regionId = list != null ? (RegionId) list.get(0) : null;
                if (regionId != null) {
                    String r2 = HereOfflineMap.m;
                    CLog.a(r2, "Completed 100% for ID: " + regionId.id);
                }
            }

            public void onPause(MapLoaderError mapLoaderError) {
                if (mapLoaderError == null) {
                    CLog.a(HereOfflineMap.m, "The download was paused by the user calling mapDownloaderTask.pause(). ");
                    return;
                }
                String r = HereOfflineMap.m;
                CLog.a(r, "Download regions onPause error. The task tried to often to retry the download: " + mapLoaderError);
            }

            public void onProgress(RegionId regionId, int i) {
                String r = HereOfflineMap.m;
                CLog.a(r, "Download for ID: " + regionId.id + ". Progress: " + i + "%.");
            }

            public void onResume() {
                CLog.a(HereOfflineMap.m, "A previously paused download has been resumed.");
            }
        }));
    }

    public void a() {
        w("");
    }

    public void c() {
        if (!NaviUtil.D0(this.f5793a) || !NetworkUtil.a(this.f5793a) || !e()) {
            CLog.a(m, "[handleOfflineMapDownload]: pauseOfflineMap!");
            g();
            return;
        }
        CLog.a(m, "[handleOfflineMapDownload]: downloadOfflineMap!");
        a();
    }

    public void d(Context context) {
        this.f5793a = context;
        SDKNativeEngine sharedInstance = SDKNativeEngine.getSharedInstance();
        if (sharedInstance == null) {
            CLog.a(m, "SDKNativeEngine not initialized.");
            return;
        }
        String str = sharedInstance.getOptions().cachePath;
        String str2 = m;
        CLog.d(str2, "StoragePath: " + str + " getCacheDir=" + context.getCacheDir().getPath());
        MapDownloader.fromEngineAsync(sharedInstance, new a(this));
        MapUpdater.fromEngineAsync(sharedInstance, new b(this));
    }

    public void g() {
        for (MapDownloaderTask pause : this.j) {
            pause.pause();
        }
    }

    public void h() {
        for (MapDownloaderTask resume : this.j) {
            resume.resume();
        }
    }

    public final void s() {
        MapUpdater mapUpdater = this.i;
        if (mapUpdater == null) {
            CLog.a(m, "checkForMapUpdates() MapUpdater instance not ready. Try again.");
        } else {
            mapUpdater.retrieveCatalogsUpdateInfo(new e(this));
        }
    }

    public final void t() {
        MapDownloader mapDownloader = this.h;
        if (mapDownloader == null) {
            CLog.a(m, "MapDownloader instance not ready. Try again.");
        } else if (mapDownloader.getInitialPersistentMapStatus() != PersistentMapStatus.OK) {
            CLog.a(m, "PersistentMapStatus The persistent map data seems to be corrupted. Trying to repair.");
            this.h.repairPersistentMap(new d());
        }
    }

    public final void u() {
        if (!CSharedPreferences.b(this.f5793a, "auto_down", true)) {
            CLog.a(m, "downLoad  not auto down.");
        } else if (!NetworkUtil.a(this.f5793a)) {
            CLog.a(m, "downLoad Wifi is not ready.");
        } else if (this.h == null) {
            CLog.a(m, "MapDownloader instance not ready. Try again.");
        } else {
            K();
        }
    }

    public final void v(Region region, String str, String str2) {
        if (region == null) {
            String str3 = m;
            CLog.a(str3, "downLoadRegionMap() The region was not found.  country is:" + str + " city is:" + str2);
            return;
        }
        String str4 = m;
        CLog.d(str4, "downLoadRegionMap() ####### Child region: " + region.name + ", ID: " + region.regionId.id + ", Size: " + (region.sizeOnDiskInBytes / 1048576) + "MB");
        List x = x();
        this.h.deleteRegions(x, new f(this, x, region));
    }

    public void w(String str) {
        i(false);
        TimerTask timerTask = this.e;
        if (timerTask != null) {
            boolean cancel = timerTask.cancel();
            String str2 = m;
            CLog.a(str2, "downloadOfflineMap: " + cancel);
        }
        this.e = new TimerTask() {
            public void run() {
                HereOfflineMap.this.u();
            }
        };
        this.d.purge();
        this.d.schedule(this.e, 20000);
    }

    public final List x() {
        ArrayList arrayList = new ArrayList();
        try {
            for (InstalledRegion installedRegion : this.h.getInstalledRegions()) {
                arrayList.add(installedRegion.regionId);
            }
        } catch (MapLoaderException e) {
            String str = m;
            CLog.b(str, "getInstalledRegions() except=" + e);
        }
        return arrayList;
    }

    public final void z(Region region, String str, String str2) {
        List<Region> list = region.childRegions;
        if (list != null) {
            for (Region next : list) {
                long j2 = next.sizeOnDiskInBytes;
                L(next, str, str2);
                z(next, str, str2);
            }
        }
    }
}
