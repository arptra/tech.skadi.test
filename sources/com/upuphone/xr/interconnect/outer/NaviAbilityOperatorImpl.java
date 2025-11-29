package com.upuphone.xr.interconnect.outer;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.api.NaviAbilityOperator;
import com.upuphone.xr.interconnect.common.INaviAbility;
import com.upuphone.xr.interconnect.entity.PoiResult;
import com.upuphone.xr.interconnect.listener.NaviActionResult;
import com.upuphone.xr.interconnect.listener.NaviLocationCallback;
import com.upuphone.xr.interconnect.listener.NaviPoiCallback;
import java.util.List;

public class NaviAbilityOperatorImpl implements NaviAbilityOperator, SuperServiceStateListener {
    private SuperServiceProvider mProvider;

    public void changeNavi(int i, NaviActionResult naviActionResult) {
        INaviAbility iNaviAbility = this.mProvider.getINaviAbility();
        if (iNaviAbility != null) {
            try {
                iNaviAbility.changeNavi(i, naviActionResult);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void changeRoute(int i, NaviActionResult naviActionResult) {
        INaviAbility iNaviAbility = this.mProvider.getINaviAbility();
        if (iNaviAbility != null) {
            try {
                iNaviAbility.changeRoute(i, naviActionResult);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> findDeniedPermissions() {
        INaviAbility iNaviAbility = this.mProvider.getINaviAbility();
        if (iNaviAbility == null) {
            return null;
        }
        try {
            return iNaviAbility.findDeniedPermissions();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<PoiResult> getFreqVisitedAddress() {
        INaviAbility iNaviAbility = this.mProvider.getINaviAbility();
        if (iNaviAbility == null) {
            return null;
        }
        try {
            return iNaviAbility.getFreqVisitedAddress();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public double[] getLocation() {
        INaviAbility iNaviAbility = this.mProvider.getINaviAbility();
        if (iNaviAbility == null) {
            return null;
        }
        try {
            return iNaviAbility.getLocation();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean hasAddress(int i) {
        INaviAbility iNaviAbility = this.mProvider.getINaviAbility();
        if (iNaviAbility == null) {
            return false;
        }
        try {
            return iNaviAbility.hasAddress(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isNaviOpened() {
        INaviAbility iNaviAbility = this.mProvider.getINaviAbility();
        if (iNaviAbility == null) {
            return false;
        }
        try {
            return iNaviAbility.isNaviOpened();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isNaviSpeakOn() {
        INaviAbility iNaviAbility = this.mProvider.getINaviAbility();
        if (iNaviAbility == null) {
            return false;
        }
        try {
            return iNaviAbility.isNaviSpeakOn();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isNaving() {
        INaviAbility iNaviAbility = this.mProvider.getINaviAbility();
        if (iNaviAbility == null) {
            return false;
        }
        try {
            return iNaviAbility.isNaving();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isTrafficEnabled() {
        INaviAbility iNaviAbility = this.mProvider.getINaviAbility();
        if (iNaviAbility == null) {
            return false;
        }
        try {
            return iNaviAbility.isTrafficEnabled();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void onServiceConnected() {
    }

    public void onServiceDied() {
    }

    public void poiSearch(int i, String str, NaviPoiCallback naviPoiCallback) {
        INaviAbility iNaviAbility = this.mProvider.getINaviAbility();
        if (iNaviAbility != null) {
            try {
                iNaviAbility.PoiSearch(i, str, naviPoiCallback);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean readTrafficInfo(int i) {
        INaviAbility iNaviAbility = this.mProvider.getINaviAbility();
        if (iNaviAbility == null) {
            return false;
        }
        try {
            return iNaviAbility.readTrafficInfo(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean refreshNavi() {
        INaviAbility iNaviAbility = this.mProvider.getINaviAbility();
        if (iNaviAbility == null) {
            return false;
        }
        try {
            return iNaviAbility.refreshNavi();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveNaviAddress(PoiResult poiResult, int i) {
        INaviAbility iNaviAbility = this.mProvider.getINaviAbility();
        if (iNaviAbility == null) {
            return false;
        }
        try {
            return iNaviAbility.saveNaviAddress(poiResult, i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setNaviSpeak(boolean z) {
        INaviAbility iNaviAbility = this.mProvider.getINaviAbility();
        if (iNaviAbility != null) {
            try {
                iNaviAbility.setNaviSpeak(z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setProvider(SuperServiceProvider superServiceProvider) {
        this.mProvider = superServiceProvider;
    }

    public void setTrafficEnabled(boolean z) {
        INaviAbility iNaviAbility = this.mProvider.getINaviAbility();
        if (iNaviAbility != null) {
            try {
                iNaviAbility.setTrafficEnabled(z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void startLocation(NaviLocationCallback naviLocationCallback) {
        INaviAbility iNaviAbility = this.mProvider.getINaviAbility();
        if (iNaviAbility != null) {
            try {
                iNaviAbility.startLocation(naviLocationCallback);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void startNavi(int i, int i2, PoiResult poiResult, NaviActionResult naviActionResult) {
        INaviAbility iNaviAbility = this.mProvider.getINaviAbility();
        if (iNaviAbility != null) {
            try {
                iNaviAbility.startNavi(i, i2, poiResult, naviActionResult);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void startNaviToAddress(int i, NaviActionResult naviActionResult) {
        INaviAbility iNaviAbility = this.mProvider.getINaviAbility();
        if (iNaviAbility != null) {
            try {
                iNaviAbility.startNaviToAddress(i, naviActionResult);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopLocation(NaviLocationCallback naviLocationCallback) {
        INaviAbility iNaviAbility = this.mProvider.getINaviAbility();
        if (iNaviAbility != null) {
            try {
                iNaviAbility.stopLocation(naviLocationCallback);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
