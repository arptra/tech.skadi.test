package com.upuphone.xr.interconnect.listener;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.IWifiInfoCallback;
import com.upuphone.xr.interconnect.entity.StarryNetWifiInfo;

public abstract class WifiInfoCallback extends IWifiInfoCallback.Stub {
    public void onResult(StarryNetWifiInfo starryNetWifiInfo) throws RemoteException {
    }
}
