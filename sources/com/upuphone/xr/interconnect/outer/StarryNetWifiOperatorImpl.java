package com.upuphone.xr.interconnect.outer;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.api.StarryNetWifiOperator;
import com.upuphone.xr.interconnect.common.IWifiManager;
import com.upuphone.xr.interconnect.entity.StarryNetWifiInfo;
import com.upuphone.xr.interconnect.listener.WifiConnectCallback;
import com.upuphone.xr.interconnect.listener.WifiInfoCallback;

public class StarryNetWifiOperatorImpl implements StarryNetWifiOperator, SuperServiceStateListener {
    private SuperServiceProvider mProvider;

    public void connectWifi(String str, String str2, int i, WifiConnectCallback wifiConnectCallback) {
        IWifiManager wifiManager = this.mProvider.getWifiManager();
        if (wifiManager != null) {
            try {
                wifiManager.connectWifi(str, str2, i, wifiConnectCallback);
            } catch (RemoteException e) {
                e.printStackTrace();
                try {
                    wifiConnectCallback.onResult(-1);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void getConnectedWifiInfo(WifiInfoCallback wifiInfoCallback) {
        IWifiManager wifiManager = this.mProvider.getWifiManager();
        if (wifiManager != null) {
            try {
                wifiManager.getConnectedWifiInfo(wifiInfoCallback);
            } catch (RemoteException e) {
                e.printStackTrace();
                try {
                    wifiInfoCallback.onResult((StarryNetWifiInfo) null);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void onServiceConnected() {
    }

    public void onServiceDied() {
    }

    public void setProvider(SuperServiceProvider superServiceProvider) {
        this.mProvider = superServiceProvider;
    }
}
