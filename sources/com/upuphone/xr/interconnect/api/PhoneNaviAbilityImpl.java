package com.upuphone.xr.interconnect.api;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.common.INaviActionResult;
import com.upuphone.xr.interconnect.common.INaviLocationCallback;
import com.upuphone.xr.interconnect.common.INaviPoiCallback;
import com.upuphone.xr.interconnect.entity.PoiResult;
import com.upuphone.xr.interconnect.remote.BinderClient;
import java.util.List;

public class PhoneNaviAbilityImpl implements PhoneNaviAbility {
    private static final String TAG = "PhoneNaviAbilityImpl";
    private INaviAbilityResponse mINaviAbilityResponse;

    public interface INaviAbilityResponse {
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

        boolean saveNaviAddress(PoiResult poiResult, int i);

        void setNaviSpeak(boolean z);

        void setTrafficEnabled(boolean z);

        void startLocation(INaviLocationCallback iNaviLocationCallback);

        void startNavi(int i, int i2, PoiResult poiResult, INaviActionResult iNaviActionResult);

        void startNaviToAddress(int i, INaviActionResult iNaviActionResult);

        void stopLocation(INaviLocationCallback iNaviLocationCallback);
    }

    public void changeNavi(int i, INaviActionResult iNaviActionResult) {
        ULog.d(TAG, "do changeNavi============");
        INaviAbilityResponse iNaviAbilityResponse = this.mINaviAbilityResponse;
        if (iNaviAbilityResponse != null) {
            iNaviAbilityResponse.changeNavi(i, iNaviActionResult);
        }
    }

    public void changeRoute(int i, INaviActionResult iNaviActionResult) {
        ULog.d(TAG, "do changeRoute============");
        INaviAbilityResponse iNaviAbilityResponse = this.mINaviAbilityResponse;
        if (iNaviAbilityResponse != null) {
            iNaviAbilityResponse.changeRoute(i, iNaviActionResult);
        }
    }

    public List<String> findDeniedPermissions() {
        ULog.d(TAG, "do findDeniedPermissions============");
        INaviAbilityResponse iNaviAbilityResponse = this.mINaviAbilityResponse;
        if (iNaviAbilityResponse != null) {
            return iNaviAbilityResponse.findDeniedPermissions();
        }
        return null;
    }

    public List<PoiResult> getFreqVisitedAddress() {
        ULog.d(TAG, "do getFreqVisitedAddress============");
        INaviAbilityResponse iNaviAbilityResponse = this.mINaviAbilityResponse;
        if (iNaviAbilityResponse != null) {
            return iNaviAbilityResponse.getFreqVisitedAddress();
        }
        return null;
    }

    public double[] getLocation() {
        ULog.d(TAG, "do getLocation============");
        INaviAbilityResponse iNaviAbilityResponse = this.mINaviAbilityResponse;
        if (iNaviAbilityResponse != null) {
            return iNaviAbilityResponse.getLocation();
        }
        return null;
    }

    public boolean hasAddress(int i) {
        ULog.d(TAG, "do hasAddress============");
        INaviAbilityResponse iNaviAbilityResponse = this.mINaviAbilityResponse;
        if (iNaviAbilityResponse != null) {
            return iNaviAbilityResponse.hasAddress(i);
        }
        return false;
    }

    public boolean isNaviOpened() {
        ULog.d(TAG, "do isNaviOpened============");
        INaviAbilityResponse iNaviAbilityResponse = this.mINaviAbilityResponse;
        if (iNaviAbilityResponse != null) {
            return iNaviAbilityResponse.isNaviOpened();
        }
        return false;
    }

    public boolean isNaviSpeakOn() {
        ULog.d(TAG, "do isNaviSpeakOn============");
        INaviAbilityResponse iNaviAbilityResponse = this.mINaviAbilityResponse;
        if (iNaviAbilityResponse != null) {
            return iNaviAbilityResponse.isNaviSpeakOn();
        }
        return false;
    }

    public boolean isNaving() {
        ULog.d(TAG, "do isNaving============");
        INaviAbilityResponse iNaviAbilityResponse = this.mINaviAbilityResponse;
        if (iNaviAbilityResponse != null) {
            return iNaviAbilityResponse.isNaving();
        }
        return false;
    }

    public boolean isTrafficEnabled() {
        ULog.d(TAG, "do isTrafficEnabled============");
        INaviAbilityResponse iNaviAbilityResponse = this.mINaviAbilityResponse;
        if (iNaviAbilityResponse != null) {
            return iNaviAbilityResponse.isTrafficEnabled();
        }
        return false;
    }

    public void onClientDied(BinderClient binderClient) {
        if (binderClient.getPackageName().equals("com.upuphone.star.launcher")) {
            this.mINaviAbilityResponse = null;
        }
    }

    public void poiSearch(int i, String str, INaviPoiCallback iNaviPoiCallback) {
        ULog.d(TAG, "do poiSearch============");
        INaviAbilityResponse iNaviAbilityResponse = this.mINaviAbilityResponse;
        if (iNaviAbilityResponse != null) {
            iNaviAbilityResponse.poiSearch(i, str, iNaviPoiCallback);
        }
    }

    public boolean readTrafficInfo(int i) {
        ULog.d(TAG, "do readTrafficInfo============");
        INaviAbilityResponse iNaviAbilityResponse = this.mINaviAbilityResponse;
        if (iNaviAbilityResponse != null) {
            return iNaviAbilityResponse.readTrafficInfo(i);
        }
        return false;
    }

    public boolean refreshNavi() {
        ULog.d(TAG, "do refreshNavi============");
        INaviAbilityResponse iNaviAbilityResponse = this.mINaviAbilityResponse;
        if (iNaviAbilityResponse != null) {
            return iNaviAbilityResponse.refreshNavi();
        }
        return false;
    }

    public void registerNaviResponse(INaviAbilityResponse iNaviAbilityResponse) {
        this.mINaviAbilityResponse = iNaviAbilityResponse;
    }

    public void removeNaviResponse() {
        this.mINaviAbilityResponse = null;
    }

    public boolean saveNaviAddress(PoiResult poiResult, int i) {
        ULog.d(TAG, "do saveNaviAddress============");
        INaviAbilityResponse iNaviAbilityResponse = this.mINaviAbilityResponse;
        if (iNaviAbilityResponse != null) {
            return iNaviAbilityResponse.saveNaviAddress(poiResult, i);
        }
        return false;
    }

    public void setNaviSpeak(boolean z) {
        ULog.d(TAG, "do setNaviSpeak============");
        INaviAbilityResponse iNaviAbilityResponse = this.mINaviAbilityResponse;
        if (iNaviAbilityResponse != null) {
            iNaviAbilityResponse.setNaviSpeak(z);
        }
    }

    public void setTrafficEnabled(boolean z) {
        ULog.d(TAG, "do setTrafficEnabled============");
        INaviAbilityResponse iNaviAbilityResponse = this.mINaviAbilityResponse;
        if (iNaviAbilityResponse != null) {
            iNaviAbilityResponse.setTrafficEnabled(z);
        }
    }

    public void startLocation(INaviLocationCallback iNaviLocationCallback) {
        ULog.d(TAG, "do startLocation============");
        INaviAbilityResponse iNaviAbilityResponse = this.mINaviAbilityResponse;
        if (iNaviAbilityResponse != null) {
            iNaviAbilityResponse.startLocation(iNaviLocationCallback);
        }
    }

    public void startNavi(int i, int i2, PoiResult poiResult, INaviActionResult iNaviActionResult) {
        ULog.d(TAG, "do startNavi============");
        INaviAbilityResponse iNaviAbilityResponse = this.mINaviAbilityResponse;
        if (iNaviAbilityResponse != null) {
            iNaviAbilityResponse.startNavi(i, i2, poiResult, iNaviActionResult);
        }
    }

    public void startNaviToAddress(int i, INaviActionResult iNaviActionResult) {
        ULog.d(TAG, "do startNaviToAddress============");
        INaviAbilityResponse iNaviAbilityResponse = this.mINaviAbilityResponse;
        if (iNaviAbilityResponse != null) {
            iNaviAbilityResponse.startNaviToAddress(i, iNaviActionResult);
        }
    }

    public void stopLocation(INaviLocationCallback iNaviLocationCallback) {
        ULog.d(TAG, "do stopLocation============");
        INaviAbilityResponse iNaviAbilityResponse = this.mINaviAbilityResponse;
        if (iNaviAbilityResponse != null) {
            iNaviAbilityResponse.stopLocation(iNaviLocationCallback);
        }
    }
}
