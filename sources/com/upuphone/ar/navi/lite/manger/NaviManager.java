package com.upuphone.ar.navi.lite.manger;

import android.app.Notification;
import android.content.Context;
import androidx.annotation.Keep;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.model.ILocation;
import com.upuphone.ar.navi.lite.model.INaviOperator;
import com.upuphone.ar.navi.lite.model.INaviState;
import com.upuphone.ar.navi.lite.model.INaviVoiceStateChanged;
import com.upuphone.ar.navi.lite.model.IPlaceInfo;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.xr.interconnect.common.INaviActionResult;
import com.upuphone.xr.interconnect.common.INaviLocationCallback;
import com.upuphone.xr.interconnect.common.INaviPoiCallback;
import com.upuphone.xr.interconnect.entity.PoiResult;
import java.util.List;

@Keep
public class NaviManager {
    private static final String TAG = ("NAVI-" + NaviManager.class.getSimpleName());
    private static NaviManager instance = null;
    private INaviOperator naviOperator;

    public NaviManager(Context context) {
        NaviOperatorManager.getInstance(context.getApplicationContext()).init();
        this.naviOperator = NaviOperatorManager.getInstance(context.getApplicationContext()).getNaviOperator();
    }

    public static NaviManager getInstance(Context context) {
        if (instance == null) {
            instance = new NaviManager(context.getApplicationContext());
        }
        if (StarryNetManger.getInstance().getOperatorManager() == null) {
            StarryNetManger.getInstance().init(context.getApplicationContext());
        }
        return instance;
    }

    public void changeNavi(int i, INaviActionResult iNaviActionResult) {
        String str = TAG;
        CLog.b(str, "changeNavi Enter naviMode=" + i + " callBack=" + iNaviActionResult);
        this.naviOperator.changeNavi(i, iNaviActionResult);
    }

    public void changeRoute(int i, INaviActionResult iNaviActionResult) {
        String str = TAG;
        CLog.b(str, "changeRoute Enter strategy=" + i + " callBack=" + iNaviActionResult);
        this.naviOperator.changeRoute(i, iNaviActionResult);
    }

    public void company(Context context) {
        this.naviOperator.company(context);
    }

    public void custom(Context context) {
        this.naviOperator.custom(context.getApplicationContext());
    }

    public void disableBackgroundLocation(boolean z) {
        this.naviOperator.disableBackgroundLocation(z);
    }

    public void enableBackgroundLocation(int i, Notification notification) {
        this.naviOperator.enableBackgroundLocation(i, notification);
    }

    public List<String> findDeniedPermissions() {
        return this.naviOperator.findDeniedPermissions();
    }

    public String getCompanyName() {
        return this.naviOperator.getCompanyName();
    }

    public String getCustomName() {
        return this.naviOperator.getCustomName();
    }

    public List<PoiResult> getFreqVisitedAddress(Context context) {
        return this.naviOperator.getFreqVisitedAddress(context);
    }

    public String getHomeName() {
        return this.naviOperator.getHomeName();
    }

    public double[] getLocation() {
        return this.naviOperator.getLocation();
    }

    public void getLocationInfo(Context context, IPlaceInfo iPlaceInfo) {
        String str = TAG;
        CLog.b(str, "getLocationInfo() ### iPlace=" + iPlaceInfo);
        this.naviOperator.getLocationInfo(context.getApplicationContext(), iPlaceInfo);
    }

    public String getNaviDestination() {
        return this.naviOperator.getNaviDestination();
    }

    public boolean getNaviVoiceState(Context context) {
        return this.naviOperator.getNaviVoiceState(context);
    }

    public boolean hasAddress(int i) {
        return this.naviOperator.hasAddress(i);
    }

    public void home(Context context) {
        this.naviOperator.home(context);
    }

    public boolean isNaviOpened() {
        return this.naviOperator.isNaviOpened();
    }

    public boolean isNaviSpeakOn() {
        CLog.b(TAG, "isNaviSpeakOn  Enter.");
        return this.naviOperator.isNaviSpeakOn();
    }

    public boolean isNaving() {
        return this.naviOperator.isNaving();
    }

    public boolean isTrafficEnabled() {
        CLog.b(TAG, "isTrafficEnabled  Enter.");
        return this.naviOperator.isTrafficEnabled();
    }

    public void naviSetting(Context context) {
        this.naviOperator.naviSetting(context.getApplicationContext());
    }

    public void poiSearch(Context context, String str, INaviPoiCallback iNaviPoiCallback) {
        this.naviOperator.poiSearch(context.getApplicationContext(), str, iNaviPoiCallback);
    }

    public boolean readTrafficInfo(int i) {
        return this.naviOperator.readTrafficInfo(i);
    }

    public boolean refreshNavi() {
        CLog.b(TAG, "refreshNavi  Enter.");
        return this.naviOperator.refreshNavi();
    }

    public void restartNaviTask(SearchModel searchModel, int i, boolean z) {
        this.naviOperator.restartNaviTask(searchModel, i, z);
    }

    public boolean saveNaviAddress(PoiResult poiResult, int i) {
        String str = TAG;
        CLog.b(str, "saveNaviAddress Enter poi=" + poiResult + " type" + i);
        return this.naviOperator.saveNaviAddress(poiResult, i);
    }

    public void setAccountInfo(String str) {
        this.naviOperator.setAccountInfo(str);
    }

    public void setAppForeground(boolean z) {
        String str = TAG;
        CLog.b(str, "setAppForeground appForeground=" + z);
        this.naviOperator.setAppForeground(z);
    }

    public void setGlassLanguage(String str, String str2) {
        String str3 = TAG;
        CLog.b(str3, "setGlassLanguage local=" + str + " language=" + str2);
        this.naviOperator.setGlassLanguage(str, str2);
    }

    public void setNaviSpeak(boolean z) {
        String str = TAG;
        CLog.b(str, "setNaviSpeak Enter isOn=" + z);
        this.naviOperator.setNaviSpeak(z);
    }

    public void setNaviStateChangedListener(INaviState iNaviState) {
        this.naviOperator.setNaviStateChangedListener(iNaviState);
    }

    public void setNaviVoiceState(Context context, boolean z) {
        this.naviOperator.setNaviVoiceState(context, z);
    }

    public void setNaviVoiceStateChanged(INaviVoiceStateChanged iNaviVoiceStateChanged) {
        this.naviOperator.setNaviVoiceStateChanged(iNaviVoiceStateChanged);
    }

    public void setTrafficEnabled(boolean z) {
        String str = TAG;
        CLog.b(str, "setTrafficEnabled Enter enabled=" + z);
        this.naviOperator.setTrafficEnabled(z);
    }

    public void setWeatherInfo(String str, String str2) {
        this.naviOperator.setWeatherInfo(str, str2);
    }

    public void startContinueLocation(Context context, ILocation iLocation) {
        this.naviOperator.startContinueLocation(context, iLocation);
    }

    public void startLocation(Context context) {
        this.naviOperator.startLocation(context.getApplicationContext());
    }

    public void startMap(Context context) {
        this.naviOperator.startMap(context.getApplicationContext());
    }

    public void startNavi(Context context, int i, int i2, PoiResult poiResult, INaviActionResult iNaviActionResult) {
        this.naviOperator.startNavi(context.getApplicationContext(), i, i2, poiResult, iNaviActionResult);
    }

    public void startNaviFromAI(Context context) {
        this.naviOperator.startNaviFromAI(context.getApplicationContext());
    }

    public void startNaviToAddress(Context context, int i, INaviActionResult iNaviActionResult) {
        this.naviOperator.startNaviToAddress(context.getApplicationContext(), i, iNaviActionResult);
    }

    public void startSearch(Context context) {
        this.naviOperator.startSearch(context.getApplicationContext());
    }

    public void stopContinueLocation(ILocation iLocation) {
        this.naviOperator.stopContinueLocation(iLocation);
    }

    public void stopLocation() {
        this.naviOperator.stopLocation();
    }

    public void stopNavi() {
        this.naviOperator.stopNavi();
    }

    public void startLocation(Context context, INaviLocationCallback iNaviLocationCallback) {
        this.naviOperator.startLocation(context.getApplicationContext(), iNaviLocationCallback);
    }

    public void stopLocation(INaviLocationCallback iNaviLocationCallback) {
        this.naviOperator.stopLocation(iNaviLocationCallback);
    }
}
