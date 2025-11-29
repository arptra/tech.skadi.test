package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.entity.PoiResult;
import com.upuphone.xr.interconnect.listener.NaviActionResult;
import com.upuphone.xr.interconnect.listener.NaviLocationCallback;
import com.upuphone.xr.interconnect.listener.NaviPoiCallback;
import java.util.List;

public interface NaviAbilityOperator {
    void changeNavi(int i, NaviActionResult naviActionResult);

    void changeRoute(int i, NaviActionResult naviActionResult);

    List<String> findDeniedPermissions();

    List<PoiResult> getFreqVisitedAddress();

    double[] getLocation();

    boolean hasAddress(int i);

    boolean isNaviOpened();

    boolean isNaviSpeakOn();

    boolean isNaving();

    boolean isTrafficEnabled();

    void poiSearch(int i, String str, NaviPoiCallback naviPoiCallback);

    boolean readTrafficInfo(int i);

    boolean refreshNavi();

    boolean saveNaviAddress(PoiResult poiResult, int i);

    void setNaviSpeak(boolean z);

    void setTrafficEnabled(boolean z);

    void startLocation(NaviLocationCallback naviLocationCallback);

    void startNavi(int i, int i2, PoiResult poiResult, NaviActionResult naviActionResult);

    void startNaviToAddress(int i, NaviActionResult naviActionResult);

    void stopLocation(NaviLocationCallback naviLocationCallback);
}
