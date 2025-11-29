package com.upuphone.ar.navi.lite.manger;

import com.upuphone.ar.navi.lite.location.AbsLocation;
import com.upuphone.ar.navi.lite.location.HereLocation;
import com.upuphone.ar.navi.lite.navi.AbsNaviManager;
import com.upuphone.ar.navi.lite.navi.HereNaviManager;
import com.upuphone.ar.navi.lite.offlinemap.AbsOfflineMap;
import com.upuphone.ar.navi.lite.offlinemap.HereOfflineMap;
import com.upuphone.ar.navi.lite.search.AbsPoiSearch;
import com.upuphone.ar.navi.lite.search.HerePoiSearch;
import com.upuphone.ar.navi.lite.simulate.HereNaviSimulate;
import com.upuphone.ar.navi.lite.simulate.INaviSimulate;

public class ManagerUtils {
    public static INaviSimulate getINaviSimulate() {
        return HereNaviSimulate.d();
    }

    public static AbsLocation getLocationManager() {
        return HereLocation.v();
    }

    public static AbsNaviManager getNaviControlManager() {
        return HereNaviManager.v0();
    }

    public static AbsOfflineMap getOfflineMapManager() {
        return HereOfflineMap.y();
    }

    public static AbsPoiSearch getPoiSearchManager() {
        return HerePoiSearch.p();
    }
}
