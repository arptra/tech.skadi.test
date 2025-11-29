package com.upuphone.runasone.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.upuphone.runasone.device.DeviceManagerImpl;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.service.StarrynetApiImpl;
import com.upuphone.runasone.utils.LogUtil;

public class WlanStateReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        LogUtil.d(intent.getAction());
        if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
            byte terminalType = StarrynetApiImpl.getInstance().getOwnDevice().getTerminalType();
            LogUtil.d("terminalType : " + terminalType);
            if (terminalType == 2) {
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                if (networkInfo.getState().equals(NetworkInfo.State.DISCONNECTED)) {
                    LogUtil.d("wifi断开");
                } else if (networkInfo.getState().equals(NetworkInfo.State.CONNECTED)) {
                    WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                    LogUtil.d("连接到网络 " + connectionInfo.getSSID());
                    for (StarryDevice next : DeviceManagerImpl.getInstance().getConnectedDevice()) {
                        if (next.checkStatus(2)) {
                            StarrynetApiImpl.getInstance().disconnectP2p(next.getStarryDevice());
                            return;
                        }
                    }
                }
            }
        }
    }
}
