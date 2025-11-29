package com.upuphone.ar.navi.lite.model;

import android.app.Notification;
import android.content.Context;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.xr.interconnect.common.INaviActionResult;
import com.upuphone.xr.interconnect.common.INaviLocationCallback;
import com.upuphone.xr.interconnect.common.INaviPoiCallback;
import com.upuphone.xr.interconnect.entity.PoiResult;
import java.util.List;

public interface INaviOperator {
    void changeNavi(int i, INaviActionResult iNaviActionResult);

    void changeRoute(int i, INaviActionResult iNaviActionResult);

    void company(Context context);

    void custom(Context context);

    void disableBackgroundLocation(boolean z);

    void enableBackgroundLocation(int i, Notification notification);

    List findDeniedPermissions();

    String getCompanyName();

    String getCustomName();

    List getFreqVisitedAddress(Context context);

    String getHomeName();

    double[] getLocation();

    void getLocationInfo(Context context, IPlaceInfo iPlaceInfo);

    String getNaviDestination();

    boolean getNaviVoiceState(Context context);

    boolean hasAddress(int i);

    void home(Context context);

    boolean isNaviOpened();

    boolean isNaviSpeakOn();

    boolean isNaving();

    boolean isTrafficEnabled();

    void naviSetting(Context context);

    void poiSearch(Context context, String str, INaviPoiCallback iNaviPoiCallback);

    boolean readTrafficInfo(int i);

    boolean refreshNavi();

    void restartNaviTask(SearchModel searchModel, int i, boolean z);

    boolean saveNaviAddress(PoiResult poiResult, int i);

    void setAccountInfo(String str);

    void setAppForeground(boolean z);

    void setGlassLanguage(String str, String str2);

    void setNaviSpeak(boolean z);

    void setNaviStateChangedListener(INaviState iNaviState);

    void setNaviVoiceState(Context context, boolean z);

    void setNaviVoiceStateChanged(INaviVoiceStateChanged iNaviVoiceStateChanged);

    void setTrafficEnabled(boolean z);

    void setWeatherInfo(String str, String str2);

    void startContinueLocation(Context context, ILocation iLocation);

    void startLocation(Context context);

    void startLocation(Context context, INaviLocationCallback iNaviLocationCallback);

    void startMap(Context context);

    void startNavi(Context context, int i, int i2, PoiResult poiResult, INaviActionResult iNaviActionResult);

    void startNaviFromAI(Context context);

    void startNaviToAddress(Context context, int i, INaviActionResult iNaviActionResult);

    void startSearch(Context context);

    void stopContinueLocation(ILocation iLocation);

    void stopLocation();

    void stopLocation(INaviLocationCallback iNaviLocationCallback);

    void stopNavi();
}
