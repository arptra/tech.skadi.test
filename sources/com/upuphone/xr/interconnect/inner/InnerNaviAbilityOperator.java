package com.upuphone.xr.interconnect.inner;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.NaviAbilityOperator;
import com.upuphone.xr.interconnect.api.PhoneNaviAbility;
import com.upuphone.xr.interconnect.entity.PoiResult;
import com.upuphone.xr.interconnect.listener.NaviActionResult;
import com.upuphone.xr.interconnect.listener.NaviLocationCallback;
import com.upuphone.xr.interconnect.listener.NaviPoiCallback;
import java.util.List;

class InnerNaviAbilityOperator implements NaviAbilityOperator {
    private PhoneNaviAbility mNaviAbility = InterconnectManager.getInstance().getPhoneNaviAbility();

    public void changeNavi(int i, NaviActionResult naviActionResult) {
        this.mNaviAbility.changeNavi(i, naviActionResult);
    }

    public void changeRoute(int i, NaviActionResult naviActionResult) {
        this.mNaviAbility.changeRoute(i, naviActionResult);
    }

    public List<String> findDeniedPermissions() {
        return this.mNaviAbility.findDeniedPermissions();
    }

    public List<PoiResult> getFreqVisitedAddress() {
        return this.mNaviAbility.getFreqVisitedAddress();
    }

    public double[] getLocation() {
        return this.mNaviAbility.getLocation();
    }

    public boolean hasAddress(int i) {
        return this.mNaviAbility.hasAddress(i);
    }

    public boolean isNaviOpened() {
        return this.mNaviAbility.isNaviOpened();
    }

    public boolean isNaviSpeakOn() {
        return this.mNaviAbility.isNaviSpeakOn();
    }

    public boolean isNaving() {
        return this.mNaviAbility.isNaving();
    }

    public boolean isTrafficEnabled() {
        return this.mNaviAbility.isTrafficEnabled();
    }

    public void poiSearch(int i, String str, NaviPoiCallback naviPoiCallback) {
        this.mNaviAbility.poiSearch(i, str, naviPoiCallback);
    }

    public boolean readTrafficInfo(int i) {
        return this.mNaviAbility.readTrafficInfo(i);
    }

    public boolean refreshNavi() {
        return this.mNaviAbility.refreshNavi();
    }

    public boolean saveNaviAddress(PoiResult poiResult, int i) {
        return this.mNaviAbility.saveNaviAddress(poiResult, i);
    }

    public void setNaviSpeak(boolean z) {
        this.mNaviAbility.setNaviSpeak(z);
    }

    public void setTrafficEnabled(boolean z) {
        this.mNaviAbility.setTrafficEnabled(z);
    }

    public void startLocation(NaviLocationCallback naviLocationCallback) {
        this.mNaviAbility.startLocation(naviLocationCallback);
    }

    public void startNavi(int i, int i2, PoiResult poiResult, NaviActionResult naviActionResult) {
        this.mNaviAbility.startNavi(i, i2, poiResult, naviActionResult);
    }

    public void startNaviToAddress(int i, NaviActionResult naviActionResult) {
        this.mNaviAbility.startNaviToAddress(i, naviActionResult);
    }

    public void stopLocation(NaviLocationCallback naviLocationCallback) {
        this.mNaviAbility.stopLocation(naviLocationCallback);
    }
}
