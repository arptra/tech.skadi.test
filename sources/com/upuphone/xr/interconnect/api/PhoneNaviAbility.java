package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.api.PhoneNaviAbilityImpl;
import com.upuphone.xr.interconnect.common.INaviActionResult;
import com.upuphone.xr.interconnect.common.INaviLocationCallback;
import com.upuphone.xr.interconnect.common.INaviPoiCallback;
import com.upuphone.xr.interconnect.entity.PoiResult;
import com.upuphone.xr.interconnect.remote.BinderClientDiedCallback;
import java.util.List;

public interface PhoneNaviAbility extends BinderClientDiedCallback {
    void changeNavi(int i, INaviActionResult iNaviActionResult);

    void changeRoute(int i, INaviActionResult iNaviActionResult);

    List<String> findDeniedPermissions();

    List<PoiResult> getFreqVisitedAddress();

    double[] getLocation();

    boolean hasAddress(int i);

    boolean isNaviOpened();

    boolean isNaviSpeakOn();

    boolean isNaving();

    boolean isTrafficEnabled();

    void poiSearch(int i, String str, INaviPoiCallback iNaviPoiCallback);

    boolean readTrafficInfo(int i);

    boolean refreshNavi();

    void registerNaviResponse(PhoneNaviAbilityImpl.INaviAbilityResponse iNaviAbilityResponse);

    void removeNaviResponse();

    boolean saveNaviAddress(PoiResult poiResult, int i);

    void setNaviSpeak(boolean z);

    void setTrafficEnabled(boolean z);

    void startLocation(INaviLocationCallback iNaviLocationCallback);

    void startNavi(int i, int i2, PoiResult poiResult, INaviActionResult iNaviActionResult);

    void startNaviToAddress(int i, INaviActionResult iNaviActionResult);

    void stopLocation(INaviLocationCallback iNaviLocationCallback);
}
