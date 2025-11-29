package com.upuphone.starrynet.core.p2p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.MacAddress;
import android.net.NetworkInfo;
import android.net.wifi.XjWifiManager;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.honey.account.y6.c;
import com.honey.account.y6.d;
import com.honey.account.y6.e;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.common.StLog;
import java.lang.reflect.Field;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Optional;

public class WiFiP2pGCManager extends WiFiP2pBaseManager {
    private static final int DELAY_TIME_CONNECT_TIMEOUT = 32000;
    public static final int ERROR_P2P_STATE_DISABLE = 997;
    private static final int ERROR_TIME_OUT = 999;
    private static final int ERROR_WIFI_ERROR = 998;
    private static final int MSG_CONNECT_TIMEOUT = 0;
    private static final String TAG = "WiFiP2pGCManager";
    private volatile boolean isConnecting;
    private final Handler mHandler = new P2pHandler(Looper.getMainLooper());
    private byte[] mIdentifier;
    private String mNetWork;
    private String mPeerGoMac;
    private int mPeerPort;
    private XjWifiManager mXjWifiManager;

    public class P2pHandler extends Handler {
        public P2pHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(@NonNull Message message) {
            if (message.what == 0) {
                WiFiP2pGCManager.this.disconnect();
                WiFiP2pGCManager.this.onP2pConnectFail(999);
            }
        }
    }

    public WiFiP2pGCManager(Context context, IP2pConnectCallback iP2pConnectCallback) {
        super(context, iP2pConnectCallback);
        this.mXjWifiManager = (XjWifiManager) context.getSystemService(XjWifiManager.class);
        checkStarryP2pConnected();
    }

    private void checkStarryP2pConnected() {
        this.mP2pManager.requestGroupInfo(this.mP2pChannel, new d(this));
    }

    private String getGcIpBackup() {
        StLog.e(TAG, "getGcIpBackup");
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                String displayName = nextElement.getDisplayName();
                if (displayName.toLowerCase().contains("p2p")) {
                    StLog.d(TAG, "Network Interface Name: " + displayName);
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        StLog.d(TAG, "Network Interface address: " + nextElement2);
                        if (nextElement2 instanceof Inet4Address) {
                            StLog.d(TAG, "GC address: " + nextElement2);
                            return nextElement2.getHostAddress();
                        }
                    }
                    continue;
                }
            }
            return null;
        } catch (Exception e) {
            StLog.e(TAG, "Exception e = " + e);
            return null;
        }
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    private void invokeP2PConfigNetWorkName(WifiP2pConfig.Builder builder, String str) {
        if (str.matches("^DIRECT-[a-zA-Z0-9]{2}.*")) {
            builder.setNetworkName(str);
            return;
        }
        Class<?> cls = builder.getClass();
        try {
            StLog.d(TAG, "config cls=" + cls.getName());
            Field declaredField = cls.getDeclaredField("mNetworkName");
            declaredField.setAccessible(true);
            declaredField.set(builder, str);
        } catch (NoSuchFieldException e) {
            StLog.d(TAG, "invokeP2PConfigNetWorkName NoSuchFieldException:", (Throwable) e);
        } catch (IllegalAccessException e2) {
            StLog.d(TAG, "invokeP2PConfigNetWorkName IllegalAccessException:", (Throwable) e2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$checkStarryP2pConnected$0(WifiP2pGroup wifiP2pGroup) {
        String networkName;
        if (wifiP2pGroup != null && (networkName = wifiP2pGroup.getNetworkName()) != null && isStarryNetCreatedNetwork(networkName)) {
            this.mPeerGoMac = wifiP2pGroup.getOwner().deviceAddress;
            StLog.i(TAG, "p2p network " + networkName + " has connected, need disconnect");
            disconnect();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$connect$1(String str, String str2, byte[] bArr, int i, int i2, String str3, WifiP2pGroup wifiP2pGroup) {
        if (wifiP2pGroup != null) {
            StLog.d(TAG, "p2p already connect, disconnect");
            this.mPeerGoMac = wifiP2pGroup.getOwner().deviceAddress;
            StLog.e(TAG, "mPeerGoMac = " + this.mPeerGoMac);
            disconnect();
            return;
        }
        synchronized (this) {
            this.isConnecting = true;
        }
        XjWifiManager xjWifiManager = this.mXjWifiManager;
        if (xjWifiManager != null) {
            xjWifiManager.a(str);
        }
        checkCloseDualWifi();
        this.mNetWork = str2;
        this.mIdentifier = bArr;
        this.mPeerPort = i;
        this.mP2pManager.connect(this.mP2pChannel, i2 == 0 ? new WifiP2pConfig.Builder().setNetworkName(str2).setPassphrase(str3).build() : new WifiP2pConfig.Builder().setNetworkName(str2).setPassphrase(str3).setGroupOperatingFrequency(i2).build(), this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$connect$2(String str, String str2, byte[] bArr, int i, String str3, String str4, int i2, WifiP2pGroup wifiP2pGroup) {
        if (wifiP2pGroup != null) {
            StLog.d(TAG, "p2p already connect, disconnect");
            this.mPeerGoMac = wifiP2pGroup.getOwner().deviceAddress;
            StLog.e(TAG, "mPeerGoMac = " + this.mPeerGoMac);
            disconnect();
            return;
        }
        synchronized (this) {
            this.isConnecting = true;
        }
        XjWifiManager xjWifiManager = this.mXjWifiManager;
        if (xjWifiManager != null) {
            xjWifiManager.a(str);
        }
        checkCloseDualWifi();
        this.mNetWork = str2;
        this.mIdentifier = bArr;
        this.mPeerPort = i;
        WifiP2pConfig.Builder groupOperatingFrequency = new WifiP2pConfig.Builder().setPassphrase(str3).setDeviceAddress(MacAddress.fromString(str4)).setGroupOperatingFrequency(i2);
        invokeP2PConfigNetWorkName(groupOperatingFrequency, str2);
        WifiP2pConfig build = groupOperatingFrequency.build();
        StLog.d(TAG, "WifiP2pConfig =" + build);
        this.mP2pManager.connect(this.mP2pChannel, build, this);
    }

    /* access modifiers changed from: private */
    public void onP2pConnectFail(int i) {
        synchronized (this) {
            this.isConnecting = false;
        }
        this.mPeerGoMac = null;
        this.mNetWork = null;
        StLog.d(TAG, "onP2pConnectFail " + i);
        IP2pConnectCallback iP2pConnectCallback = this.mConnectCallback;
        if (iP2pConnectCallback != null) {
            if (i == 999) {
                iP2pConnectCallback.onConnectedFail(StErrorCode.CONNECT_STRATEGY_P2P_CONNECT_TIMEOUT, this.mIdentifier);
            } else if (i == ERROR_WIFI_ERROR) {
                iP2pConnectCallback.onConnectedFail(StErrorCode.CONNECT_STRATEGY_P2P_CONNECT_WIFI_FAIL, this.mIdentifier);
            } else {
                iP2pConnectCallback.onConnectedFail(StErrorCode.CONNECT_STRATEGY_P2P_CONNECT_FAIL, this.mIdentifier);
            }
        }
        this.mIdentifier = null;
        checkOpenDualWifi();
    }

    private void onP2pGcConnected(int i, String str, String str2, String str3) {
        this.mPeerGoMac = str2;
        synchronized (this) {
            this.isConnecting = false;
        }
        IP2pConnectCallback iP2pConnectCallback = this.mConnectCallback;
        if (iP2pConnectCallback != null) {
            iP2pConnectCallback.onP2pGcConnected(i, str, this.mIdentifier, str3);
        }
    }

    private void onP2pGcDisconnected(String str) {
        this.mPeerGoMac = null;
        this.mNetWork = null;
        IP2pConnectCallback iP2pConnectCallback = this.mConnectCallback;
        if (iP2pConnectCallback != null) {
            iP2pConnectCallback.onP2pGcDisconnected(str, this.mIdentifier);
        }
        checkOpenDualWifi();
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public void connect(String str, String str2, int i, int i2, byte[] bArr, String str3) {
        String str4 = str;
        StringBuilder sb = new StringBuilder();
        sb.append("connect ");
        sb.append(str);
        sb.append(", freq = ");
        int i3 = i;
        sb.append(i);
        StLog.d(TAG, sb.toString());
        if (str2 == null || str2.length() == 0) {
            StLog.w(TAG, "pwd length is error");
            onP2pConnectFail(ERROR_WIFI_ERROR);
        } else if (this.mPeerGoMac == null || !str.equals(this.mNetWork)) {
            synchronized (this) {
                try {
                    if (this.isConnecting) {
                        StLog.d(TAG, "gc is connecting, return");
                    } else {
                        this.mP2pManager.requestGroupInfo(this.mP2pChannel, new c(this, str3, str, bArr, i2, i, str2));
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        } else {
            StLog.d(TAG, "go " + str + " is connected");
        }
    }

    public void disconnect() {
        if (this.isConnecting) {
            this.mP2pManager.cancelConnect(this.mP2pChannel, new WifiP2pManager.ActionListener() {
                public void onFailure(int i) {
                    StLog.d(WiFiP2pGCManager.TAG, "cancelConnect onFailure");
                }

                public void onSuccess() {
                    StLog.d(WiFiP2pGCManager.TAG, "cancelConnect success");
                }
            });
        } else if (this.mPeerGoMac == null) {
            StLog.d(TAG, "gc not connect");
        } else {
            this.mP2pManager.removeGroup(this.mP2pChannel, new WifiP2pManager.ActionListener() {
                public void onFailure(int i) {
                    StLog.d(WiFiP2pGCManager.TAG, "disconnect fail code = " + i);
                }

                public void onSuccess() {
                    StLog.d(WiFiP2pGCManager.TAG, "disconnect success");
                }
            });
        }
    }

    public boolean networkInfoError(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return true;
        }
        NetworkInfo.DetailedState detailedState = networkInfo.getDetailedState();
        return (detailedState == NetworkInfo.DetailedState.IDLE || detailedState == NetworkInfo.DetailedState.CONNECTING) ? false : true;
    }

    public void onFailure(int i) {
        StLog.d(TAG, "connect failure remove time out msg " + i);
        this.mHandler.removeMessages(0);
        onP2pConnectFail(i);
    }

    public void onP2pConnectChange(Intent intent) {
        StLog.d(TAG, "CONNECTION_STATE_CHANGE");
        WifiP2pInfo wifiP2pInfo = (WifiP2pInfo) intent.getParcelableExtra("wifiP2pInfo");
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        WifiP2pGroup wifiP2pGroup = (WifiP2pGroup) intent.getParcelableExtra("p2pGroupInfo");
        String stringExtra = intent.getStringExtra("GcIpAddress");
        StLog.d(TAG, "WifiP2pInfo " + Optional.ofNullable(wifiP2pInfo));
        StLog.d(TAG, "NetworkInfo: " + Optional.ofNullable(networkInfo));
        StLog.d(TAG, "WifiP2pGroup : " + Optional.ofNullable(wifiP2pGroup));
        StLog.d(TAG, "WifiP2pGcIp : " + stringExtra);
        if (wifiP2pInfo != null && !wifiP2pInfo.isGroupOwner) {
            this.mHandler.removeMessages(0);
            if (networkInfo == null || !networkInfo.isConnected() || wifiP2pGroup == null) {
                if ((networkInfo != null && !networkInfo.isConnected()) || wifiP2pGroup == null) {
                    String str = this.mPeerGoMac;
                    if (str != null) {
                        onP2pGcDisconnected(str);
                    } else if (this.isConnecting && networkInfoError(networkInfo)) {
                        onP2pConnectFail(ERROR_WIFI_ERROR);
                    }
                }
            } else if (wifiP2pGroup.getNetworkName().equals(this.mNetWork)) {
                if (TextUtils.isEmpty(stringExtra)) {
                    stringExtra = getGcIpBackup();
                }
                onP2pGcConnected(this.mPeerPort, wifiP2pInfo.groupOwnerAddress.getHostAddress(), wifiP2pGroup.getOwner().deviceAddress, stringExtra);
            }
        }
    }

    public void onP2pDisable() {
        super.onP2pDisable();
        if (this.isConnecting) {
            onP2pConnectFail(ERROR_P2P_STATE_DISABLE);
        }
    }

    public void onSuccess() {
        StLog.d(TAG, "connect success start time out msg");
        this.mHandler.sendEmptyMessageDelayed(0, 32000);
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public void connect(String str, String str2, String str3, int i, int i2, byte[] bArr, String str4) {
        String str5 = str;
        StLog.d(TAG, "connect " + str + " mac " + str3);
        if (this.mPeerGoMac == null || !str.equals(this.mNetWork)) {
            synchronized (this) {
                try {
                    if (this.isConnecting) {
                        StLog.d(TAG, "gc is connecting, return");
                    } else {
                        this.mP2pManager.requestGroupInfo(this.mP2pChannel, new e(this, str4, str, bArr, i2, str2, str3, i));
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        } else {
            StLog.d(TAG, "go " + str + " is connected");
        }
    }
}
