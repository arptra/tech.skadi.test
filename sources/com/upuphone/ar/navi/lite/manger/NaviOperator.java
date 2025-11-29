package com.upuphone.ar.navi.lite.manger;

import android.app.Notification;
import android.content.Context;
import android.text.TextUtils;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.model.ILocation;
import com.upuphone.ar.navi.lite.model.INaviOperator;
import com.upuphone.ar.navi.lite.model.INaviState;
import com.upuphone.ar.navi.lite.model.INaviVoiceStateChanged;
import com.upuphone.ar.navi.lite.model.INavigation;
import com.upuphone.ar.navi.lite.model.INavigationManager;
import com.upuphone.ar.navi.lite.model.IPlaceInfo;
import com.upuphone.ar.navi.lite.protocol.ProtocolUtils;
import com.upuphone.ar.navi.lite.protocol.WeatherBean;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.xr.interconnect.common.INaviActionResult;
import com.upuphone.xr.interconnect.common.INaviLocationCallback;
import com.upuphone.xr.interconnect.common.INaviPoiCallback;
import com.upuphone.xr.interconnect.entity.PoiResult;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import java.util.ArrayList;
import java.util.List;

public class NaviOperator implements INaviOperator {
    private static final String TAG = ("NAVI-" + NaviOperator.class.getSimpleName());
    private NaviOperatorManager naviOperatorManager;

    public NaviOperator(NaviOperatorManager naviOperatorManager2) {
        this.naviOperatorManager = naviOperatorManager2;
    }

    public void changeNavi(int i, INaviActionResult iNaviActionResult) {
        if (!this.naviOperatorManager.isDriveRegion(i, iNaviActionResult)) {
            CLog.b(TAG, "changeNavi()  Current Region is not support drive.");
            return;
        }
        ArrayList c = INavigationManager.b().c();
        for (int i2 = 0; i2 < c.size(); i2++) {
            ((INavigation) c.get(i2)).changeNavi(i, iNaviActionResult);
        }
    }

    public void changeRoute(int i, INaviActionResult iNaviActionResult) {
        if (!this.naviOperatorManager.isDriveRegion(0, iNaviActionResult)) {
            CLog.b(TAG, "changeRoute()  Current Region is not support drive.");
            return;
        }
        ArrayList c = INavigationManager.b().c();
        for (int i2 = 0; i2 < c.size(); i2++) {
            ((INavigation) c.get(i2)).changeRoute(i, iNaviActionResult);
        }
    }

    public void company(Context context) {
        this.naviOperatorManager.company(context);
    }

    public void custom(Context context) {
        this.naviOperatorManager.custom(context);
    }

    public void disableBackgroundLocation(boolean z) {
        this.naviOperatorManager.disableBackgroundLocation(z);
    }

    public void enableBackgroundLocation(int i, Notification notification) {
        this.naviOperatorManager.enableBackgroundLocation(i, notification);
    }

    public List<String> findDeniedPermissions() {
        return this.naviOperatorManager.findDeniedPermissions();
    }

    public String getCompanyName() {
        return this.naviOperatorManager.getCompanyName();
    }

    public String getCustomName() {
        return this.naviOperatorManager.getCustomName();
    }

    public List<PoiResult> getFreqVisitedAddress(Context context) {
        return NaviUtil.I(context);
    }

    public String getHomeName() {
        return this.naviOperatorManager.getHomeName();
    }

    public double[] getLocation() {
        return this.naviOperatorManager.getLocation();
    }

    public void getLocationInfo(Context context, IPlaceInfo iPlaceInfo) {
        this.naviOperatorManager.getLocationInfo(context, iPlaceInfo);
    }

    public String getNaviDestination() {
        ArrayList c = INavigationManager.b().c();
        String str = "";
        for (int i = 0; i < c.size(); i++) {
            str = ((INavigation) c.get(i)).getNaviDestination();
        }
        return str;
    }

    public boolean getNaviVoiceState(Context context) {
        boolean m = CSharedPreferences.m(context);
        String str = TAG;
        CLog.b(str, "getNaviVoiceState  ######## voiceState=" + m);
        return m;
    }

    public boolean hasAddress(int i) {
        return this.naviOperatorManager.hasAddress(i);
    }

    public void home(Context context) {
        this.naviOperatorManager.home(context);
    }

    public boolean isNaviOpened() {
        String str = TAG;
        CLog.b(str, "isNaviOpened() isIsNaviOpened():" + NaviUtil.t0() + " isNaviStarted()=" + NaviUtil.B0());
        return NaviUtil.t0() || NaviUtil.B0();
    }

    public boolean isNaviSpeakOn() {
        return this.naviOperatorManager.isNaviSpeakOn();
    }

    public boolean isNaving() {
        return NaviUtil.u0();
    }

    public boolean isTrafficEnabled() {
        ArrayList c = INavigationManager.b().c();
        boolean z = false;
        for (int i = 0; i < c.size(); i++) {
            z = ((INavigation) c.get(i)).isTrafficEnabled();
        }
        return z;
    }

    public void naviSetting(Context context) {
        this.naviOperatorManager.naviSetting(context);
    }

    public void poiSearch(Context context, String str, INaviPoiCallback iNaviPoiCallback) {
        this.naviOperatorManager.poiSearch(context, str, iNaviPoiCallback);
    }

    public boolean readTrafficInfo(int i) {
        ArrayList c = INavigationManager.b().c();
        boolean z = false;
        for (int i2 = 0; i2 < c.size(); i2++) {
            z = ((INavigation) c.get(i2)).readTrafficInfo(i);
        }
        return z;
    }

    public boolean refreshNavi() {
        ArrayList c = INavigationManager.b().c();
        boolean z = false;
        for (int i = 0; i < c.size(); i++) {
            z = ((INavigation) c.get(i)).refreshNavi();
        }
        return z;
    }

    public void restartNaviTask(SearchModel searchModel, int i, boolean z) {
        ArrayList c = INavigationManager.b().c();
        for (int i2 = 0; i2 < c.size(); i2++) {
            ((INavigation) c.get(i2)).restartNaviTask(searchModel, i, z);
        }
    }

    public boolean saveNaviAddress(PoiResult poiResult, int i) {
        return this.naviOperatorManager.saveNaviAddress(poiResult, i);
    }

    public void setAccountInfo(String str) {
        this.naviOperatorManager.setAccountInfo(str);
    }

    public void setAppForeground(boolean z) {
        NaviUtil.e1(z);
    }

    public void setGlassLanguage(String str, String str2) {
        this.naviOperatorManager.setGlassLanguage(str, str2);
    }

    public void setNaviSpeak(boolean z) {
        ArrayList c = INavigationManager.b().c();
        for (int i = 0; i < c.size(); i++) {
            ((INavigation) c.get(i)).setNaviSpeak(z);
        }
    }

    public void setNaviStateChangedListener(INaviState iNaviState) {
        this.naviOperatorManager.setNaviStateChangedListener(iNaviState);
    }

    public void setNaviVoiceState(Context context, boolean z) {
        String str = TAG;
        CLog.b(str, "setNaviVoiceState  ######## state=" + z);
        if (NaviUtil.u0()) {
            NaviManager.getInstance(context).setNaviSpeak(z);
        } else {
            CSharedPreferences.o(context, "voice_state", z);
        }
    }

    public void setNaviVoiceStateChanged(INaviVoiceStateChanged iNaviVoiceStateChanged) {
        this.naviOperatorManager.setNaviVoiceStateChanged(iNaviVoiceStateChanged);
    }

    public void setTrafficEnabled(boolean z) {
        ArrayList c = INavigationManager.b().c();
        for (int i = 0; i < c.size(); i++) {
            ((INavigation) c.get(i)).setTrafficEnabled(z);
        }
    }

    public void setWeatherInfo(String str, String str2) {
        String str3 = TAG;
        CLog.b(str3, "setWeatherInfo sunriseTime=" + str + " sunsetTime=" + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            CLog.b(str3, "setWeatherInfo sunriseTime or sunriseTime is empty.");
            return;
        }
        WeatherBean b0 = NaviUtil.b0();
        if (b0 == null) {
            b0 = new WeatherBean();
            NaviUtil.v1(b0);
        }
        b0.setSunriseTime(str);
        b0.setSunsetTime(str2);
    }

    public void startContinueLocation(Context context, ILocation iLocation) {
        this.naviOperatorManager.startContinueLocation(context, iLocation);
    }

    public void startLocation(Context context) {
        NaviOperatorManager.getInstance(context).startLocation(context);
    }

    public void startMap(Context context) {
        this.naviOperatorManager.startMap(context);
    }

    public void startNavi(Context context, int i, int i2, PoiResult poiResult, INaviActionResult iNaviActionResult) {
        this.naviOperatorManager.startNavi(context, i, i2, poiResult, iNaviActionResult);
    }

    public void startNaviFromAI(Context context) {
        this.naviOperatorManager.startNaviFromAI(context);
    }

    public void startNaviToAddress(Context context, int i, INaviActionResult iNaviActionResult) {
        this.naviOperatorManager.startNaviToAddress(context, i, iNaviActionResult);
    }

    public void startSearch(Context context) {
        this.naviOperatorManager.startSearch(context);
    }

    public void stopContinueLocation(ILocation iLocation) {
        this.naviOperatorManager.stopContinueLocation(iLocation);
    }

    public void stopLocation() {
        this.naviOperatorManager.stopLocation();
    }

    public void stopNavi() {
        ArrayList c = INavigationManager.b().c();
        for (int i = 0; i < c.size(); i++) {
            ((INavigation) c.get(i)).stopNavi();
        }
        CLog.b(TAG, "stopNavi() isIsNaviOpened():" + NaviUtil.t0() + " isNaviStarted()=" + NaviUtil.B0());
        if (!NaviUtil.t0() && NaviUtil.B0()) {
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.g("navi_event", 0, "navi_stop"), (SendMessageListener) null);
            NaviUtil.q1(false);
        }
    }

    public void startLocation(Context context, INaviLocationCallback iNaviLocationCallback) {
        this.naviOperatorManager.startLocation(context, iNaviLocationCallback);
    }

    public void stopLocation(INaviLocationCallback iNaviLocationCallback) {
        this.naviOperatorManager.stopLocation(iNaviLocationCallback);
    }
}
