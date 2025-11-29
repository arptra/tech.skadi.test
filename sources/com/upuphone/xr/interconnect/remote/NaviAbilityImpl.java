package com.upuphone.xr.interconnect.remote;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.PhoneNaviAbility;
import com.upuphone.xr.interconnect.common.INaviAbility;
import com.upuphone.xr.interconnect.common.INaviActionResult;
import com.upuphone.xr.interconnect.common.INaviLocationCallback;
import com.upuphone.xr.interconnect.common.INaviPoiCallback;
import com.upuphone.xr.interconnect.entity.PoiResult;
import com.upuphone.xr.interconnect.ipc.IpcClientManager;
import java.util.List;

public class NaviAbilityImpl extends INaviAbility.Stub {
    private static final String TAG = "NaviAbilityImpl";
    private final PhoneNaviAbility naviAbility;

    public NaviAbilityImpl() {
        PhoneNaviAbility phoneNaviAbility = InterconnectManager.getInstance().getPhoneNaviAbility();
        this.naviAbility = phoneNaviAbility;
        IpcClientManager.INSTANCE.addListener(phoneNaviAbility);
    }

    public void PoiSearch(int i, String str, INaviPoiCallback iNaviPoiCallback) {
        this.naviAbility.poiSearch(i, str, iNaviPoiCallback);
    }

    public void changeNavi(int i, INaviActionResult iNaviActionResult) {
        this.naviAbility.changeNavi(i, iNaviActionResult);
    }

    public void changeRoute(int i, INaviActionResult iNaviActionResult) {
        this.naviAbility.changeRoute(i, iNaviActionResult);
    }

    public List<String> findDeniedPermissions() {
        return this.naviAbility.findDeniedPermissions();
    }

    public List<PoiResult> getFreqVisitedAddress() {
        return this.naviAbility.getFreqVisitedAddress();
    }

    public double[] getLocation() {
        return this.naviAbility.getLocation();
    }

    public boolean hasAddress(int i) {
        return this.naviAbility.hasAddress(i);
    }

    public boolean isNaviOpened() {
        return this.naviAbility.isNaviOpened();
    }

    public boolean isNaviSpeakOn() {
        return this.naviAbility.isNaviSpeakOn();
    }

    public boolean isNaving() {
        return this.naviAbility.isNaving();
    }

    public boolean isTrafficEnabled() {
        return this.naviAbility.isTrafficEnabled();
    }

    public boolean readTrafficInfo(int i) {
        return this.naviAbility.readTrafficInfo(i);
    }

    public boolean refreshNavi() {
        return this.naviAbility.refreshNavi();
    }

    public boolean saveNaviAddress(PoiResult poiResult, int i) {
        return this.naviAbility.saveNaviAddress(poiResult, i);
    }

    public void setNaviSpeak(boolean z) {
        this.naviAbility.setNaviSpeak(z);
    }

    public void setTrafficEnabled(boolean z) {
        this.naviAbility.setTrafficEnabled(z);
    }

    public void startLocation(INaviLocationCallback iNaviLocationCallback) {
        this.naviAbility.startLocation(iNaviLocationCallback);
    }

    public void startNavi(int i, int i2, PoiResult poiResult, INaviActionResult iNaviActionResult) {
        this.naviAbility.startNavi(i, i2, poiResult, iNaviActionResult);
    }

    public void startNaviToAddress(int i, INaviActionResult iNaviActionResult) {
        this.naviAbility.startNaviToAddress(i, iNaviActionResult);
    }

    public void stopLocation(INaviLocationCallback iNaviLocationCallback) {
        this.naviAbility.stopLocation(iNaviLocationCallback);
    }
}
