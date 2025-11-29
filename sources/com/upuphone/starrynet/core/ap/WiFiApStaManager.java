package com.upuphone.starrynet.core.ap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.text.TextUtils;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.common.StLog;

@SuppressLint({"MissingPermission"})
public class WiFiApStaManager extends WiFiApBaseManager {
    private static final int STATE_CONNECTED = 2;
    private static final int STATE_CONNECTING = 1;
    private static final int STATE_DISCONNECTED = 12;
    private static final int STATE_DISCONNECTING = 11;
    private static final int STATE_NONE = 0;
    private static final String TAG = "WifiApClientManager";
    private String mAddress;
    private final IWiFiStaCallback mCallback;
    private WifiConfiguration mConfig;
    private byte[] mIdentifier;
    private int mNetId = -1;
    private int mPort;
    private String mServerIp;
    private int mState;

    public WiFiApStaManager(Context context, IWiFiStaCallback iWiFiStaCallback) {
        super(context);
        this.mCallback = iWiFiStaCallback;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(this, intentFilter);
    }

    private boolean isConnected(String str) {
        WifiInfo connectionInfo = this.mWifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            return false;
        }
        return ("\"" + str + "\"").equals(connectionInfo.getSSID());
    }

    private void onConnected(WifiInfo wifiInfo) {
        if (wifiInfo == null || this.mConfig == null) {
            onConnectFail();
        } else if (wifiInfo.getSSID().equals(this.mConfig.SSID)) {
            String intToAddress = intToAddress(wifiInfo.getIpAddress());
            this.mAddress = intToAddress;
            onConnected(intToAddress, wifiInfo.getMacAddress());
        } else {
            onConnectFail();
        }
    }

    private void onDisconnected(WifiInfo wifiInfo) {
        if (this.mConfig == null) {
            onDisconnectFail();
        } else if (wifiInfo == null) {
            onDisconnected();
        } else {
            this.mNetId = -1;
            if (wifiInfo.getSSID().equals(this.mConfig.SSID)) {
                onDisconnectFail();
            } else {
                onDisconnected();
            }
        }
    }

    public void connectAp(WiFiApInfo wiFiApInfo) {
        this.mIdentifier = wiFiApInfo.getPeerId();
        this.mPort = wiFiApInfo.getPort();
        this.mServerIp = wiFiApInfo.getIp();
        this.mConfig = getConfig(wiFiApInfo.getSsid(), wiFiApInfo.getPwd());
        WifiInfo connectionInfo = this.mWifiManager.getConnectionInfo();
        if (connectionInfo != null) {
            if (("\"" + wiFiApInfo.getSsid() + "\"").equals(connectionInfo.getSSID())) {
                String intToAddress = intToAddress(connectionInfo.getIpAddress());
                this.mAddress = intToAddress;
                onConnected(intToAddress, connectionInfo.getMacAddress());
                return;
            }
        }
        int addNetwork = this.mWifiManager.addNetwork(this.mConfig);
        StLog.d(TAG, "connectAp netId = " + addNetwork);
        boolean enableNetwork = this.mWifiManager.enableNetwork(addNetwork, true);
        if (enableNetwork) {
            this.mNetId = addNetwork;
            this.mState = 1;
        } else {
            this.mNetId = -1;
            this.mConfig = null;
            this.mState = 0;
            this.mServerIp = null;
            onConnectFail();
        }
        StLog.d(TAG, "connectAp ret = " + enableNetwork);
    }

    public void disconnectAp() {
        this.mState = 11;
        int i = this.mNetId;
        if (i != -1) {
            this.mWifiManager.disableNetwork(i);
            this.mWifiManager.disconnect();
        }
    }

    public String getServerAddress() {
        if (!TextUtils.isEmpty(this.mServerIp)) {
            return this.mServerIp;
        }
        String intToAddress = intToAddress(this.mWifiManager.getDhcpInfo().serverAddress);
        this.mServerIp = intToAddress;
        return intToAddress;
    }

    public int getServerPort() {
        return this.mPort;
    }

    public String intToAddress(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    public void onConnectFail() {
        this.mState = 0;
        IWiFiStaCallback iWiFiStaCallback = this.mCallback;
        if (iWiFiStaCallback != null) {
            iWiFiStaCallback.onApStaConnectFail(this.mIdentifier, StErrorCode.CONNECT_CORE_AP_STA_CONNECT_FAIL);
        }
    }

    public void onDisconnectFail() {
        this.mState = 0;
        IWiFiStaCallback iWiFiStaCallback = this.mCallback;
        if (iWiFiStaCallback != null) {
            iWiFiStaCallback.onApDisconnectFail(StErrorCode.CONNECT_CORE_AP_STA_DISCONNECT_FAIL);
        }
    }

    public void onReceive(Context context, Intent intent) {
        NetworkInfo networkInfo;
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && (networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1)) != null) {
            if (this.mState != 1 || !networkInfo.isConnected()) {
                int i = this.mState;
                if ((i == 11 || i == 2) && !networkInfo.isConnected()) {
                    onDisconnected(this.mWifiManager.getConnectionInfo());
                    return;
                }
                return;
            }
            onConnected(this.mWifiManager.getConnectionInfo());
        }
    }

    public void disconnectAp(String str) {
        if (isConnected(str)) {
            disconnectAp();
        }
    }

    public void onConnected(String str, String str2) {
        this.mState = 2;
        IWiFiStaCallback iWiFiStaCallback = this.mCallback;
        if (iWiFiStaCallback != null) {
            iWiFiStaCallback.onApStaConnected(this.mIdentifier, str, str2);
        }
    }

    public void onDisconnected() {
        this.mState = 12;
        IWiFiStaCallback iWiFiStaCallback = this.mCallback;
        if (iWiFiStaCallback != null) {
            iWiFiStaCallback.onApDisconnected(this.mIdentifier, this.mAddress);
        }
    }
}
