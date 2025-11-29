package com.upuphone.starrynet.core.ap;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiConfiguration;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.RandomPwdHelper;
import com.upuphone.starrynet.common.utils.Utils;
import java.lang.reflect.InvocationTargetException;

public class WiFiApManager extends WiFiApBaseManager {
    private static final String TAG = "WifiApManager";
    public static final String WIFI_AP_STATE_CHANGED_ACTION = "android.net.wifi.WIFI_AP_STATE_CHANGED";
    public static final int WIFI_AP_STATE_DISABLED = 11;
    public static final int WIFI_AP_STATE_ENABLED = 13;
    private final IWiFiApCallback mCallback;
    private String mNetworkName;
    private byte[] mPeerId;
    private int mPort;
    private String mPwd;

    public WiFiApManager(Context context, IWiFiApCallback iWiFiApCallback) {
        super(context);
        this.mCallback = iWiFiApCallback;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WIFI_AP_STATE_CHANGED_ACTION);
        context.registerReceiver(this, intentFilter);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int generateGoDefaultPort() {
        /*
            r4 = this;
            java.security.SecureRandom r4 = new java.security.SecureRandom
            r4.<init>()
            r0 = 15534(0x3cae, float:2.1768E-41)
            int r4 = r4.nextInt(r0)
            r0 = 50000(0xc350, float:7.0065E-41)
            int r4 = r4 + r0
        L_0x000f:
            r1 = 65535(0xffff, float:9.1834E-41)
            if (r4 >= r1) goto L_0x003f
            javax.net.ServerSocketFactory r1 = javax.net.ssl.SSLServerSocketFactory.getDefault()     // Catch:{ IOException -> 0x002c }
            int r2 = r4 + 1
            java.net.ServerSocket r4 = r1.createServerSocket(r4)     // Catch:{ IOException -> 0x002a }
            int r1 = r4.getLocalPort()     // Catch:{ IOException -> 0x002a }
            r4.close()     // Catch:{ IOException -> 0x0027 }
            r4 = r1
            goto L_0x003f
        L_0x0027:
            r4 = move-exception
            r2 = r1
            goto L_0x002f
        L_0x002a:
            r4 = move-exception
            goto L_0x002f
        L_0x002c:
            r1 = move-exception
            r2 = r4
            r4 = r1
        L_0x002f:
            java.lang.String r1 = "WifiApManager"
            java.lang.String r3 = "IOException"
            com.upuphone.starrynet.common.StLog.e((java.lang.String) r1, (java.lang.String) r3, (java.lang.Throwable) r4)
            r4 = 65534(0xfffe, float:9.1833E-41)
            if (r2 != r4) goto L_0x003d
            r4 = r0
            goto L_0x000f
        L_0x003d:
            r4 = r2
            goto L_0x000f
        L_0x003f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.core.ap.WiFiApManager.generateGoDefaultPort():int");
    }

    private WifiConfiguration getConfig() {
        try {
            return (WifiConfiguration) this.mWifiManager.getClass().getDeclaredMethod("getWifiApConfiguration", (Class[]) null).invoke(this.mWifiManager, (Object[]) null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            StLog.e(TAG, "getConfig exception ,", e);
            e.printStackTrace();
            return null;
        }
    }

    private void onApClosed() {
        this.mPeerId = null;
        IWiFiApCallback iWiFiApCallback = this.mCallback;
        if (iWiFiApCallback != null) {
            iWiFiApCallback.onApClosed();
        }
    }

    private void onApCreated() {
        StLog.d(TAG, "onApCreated");
        if (this.mCallback != null) {
            if (this.mPort <= 0) {
                this.mPort = generateGoDefaultPort();
            }
            WiFiApInfo wiFiApInfo = new WiFiApInfo(this.mNetworkName, this.mPwd);
            wiFiApInfo.setIp("");
            wiFiApInfo.setPort(this.mPort);
            wiFiApInfo.setPeerId(this.mPeerId);
            this.mCallback.onApCreated(wiFiApInfo);
        }
    }

    public void closeAp() {
        try {
            StLog.d(TAG, "closeAp");
            this.mWifiManager.getClass().getDeclaredMethod("stopSoftAp", (Class[]) null).invoke(this.mWifiManager, (Object[]) null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            StLog.e(TAG, "closeAp", e);
        }
    }

    public void createAp(byte[] bArr, int i) {
        Class<WifiConfiguration> cls = WifiConfiguration.class;
        this.mPort = i;
        WifiConfiguration config = getConfig();
        if (config == null) {
            this.mNetworkName = "DIRECT-" + Utils.getRandomString(8);
            String randomPwd = RandomPwdHelper.getRandomPwd(8);
            this.mPwd = randomPwd;
            config = getConfig(this.mNetworkName, randomPwd);
        } else {
            this.mNetworkName = config.SSID;
            this.mPwd = config.preSharedKey;
        }
        if (isApCreated()) {
            this.mPeerId = bArr;
            onApCreated();
            return;
        }
        StLog.d(TAG, "createAp ssid = " + this.mNetworkName + " pwd = " + this.mPwd);
        try {
            this.mWifiManager.getClass().getMethod("setWifiApConfiguration", new Class[]{cls}).invoke(this.mWifiManager, new Object[]{config});
            if (((Boolean) this.mWifiManager.getClass().getMethod("startSoftAp", new Class[]{cls}).invoke(this.mWifiManager, new Object[]{config})).booleanValue()) {
                this.mPeerId = bArr;
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            StLog.e(TAG, "createAp", e);
        }
    }

    public void disconnect() {
    }

    public String getNetworkName() {
        return this.mNetworkName;
    }

    public int getPort() {
        return this.mPort;
    }

    public boolean isApCreated() {
        try {
            return ((Boolean) this.mWifiManager.getClass().getDeclaredMethod("isWifiApEnabled", (Class[]) null).invoke(this.mWifiManager, (Object[]) null)).booleanValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            StLog.e(TAG, "isApCreated", e);
            return false;
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (WIFI_AP_STATE_CHANGED_ACTION.equals(intent.getAction())) {
            int intExtra = intent.getIntExtra("wifi_state", 0);
            if (intExtra == 13) {
                onApCreated();
            } else if (intExtra == 11) {
                onApClosed();
            }
        }
    }
}
