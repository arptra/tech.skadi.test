package com.upuphone.starrynet.core.p2p;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.HandlerThread;
import android.provider.Settings;
import android.text.TextUtils;
import com.honey.account.y6.a;
import com.honey.account.y6.b;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.tracker.TrackerManager;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class WiFiP2pBaseManager implements WifiP2pManager.ActionListener {
    public static final int BAND_24_GHZ_14_CH_NUM = 14;
    public static final int BAND_24_GHZ_2484_FREQ_MHZ = 2484;
    public static final int BAND_24_GHZ_END_FREQ_MHZ = 2484;
    public static final int BAND_24_GHZ_FIRST_CH_NUM = 1;
    public static final int BAND_24_GHZ_START_FREQ_MHZ = 2412;
    public static final int BAND_5_GHZ_END_FREQ_MHZ = 5885;
    public static final int BAND_5_GHZ_FIRST_CH_NUM = 32;
    public static final int BAND_5_GHZ_START_FREQ_MHZ = 5160;
    public static final int DUAL_WIFI_DISABLE = 0;
    public static final int DUAL_WIFI_ENABLE = 1;
    public static final String DUAL_WIFI_ENABLED_STATE = "dual_wifi_enabled";
    public static final String STARRYNET_P2P_GROUP = "DIRECT-STARRYNET-";
    public static final String STARRYNET_P2P_GROUP_ENDOF = "STARRYNET";
    private static final String TAG = "WiFiP2pBaseManager";
    public static final int UNSPECIFIED = -1;
    protected boolean isActiveCloseDualWifi;
    protected final IP2pConnectCallback mConnectCallback;
    protected final Context mContext;
    protected WifiP2pManager.Channel mP2pChannel;
    protected HandlerThread mP2pChannelThread = new HandlerThread("P2pChannelThread");
    protected String mP2pMacAddress = "";
    private int mP2pMacRetryCount = 0;
    protected final WifiP2pManager mP2pManager;
    protected final WifiManager mWifiManager;
    /* access modifiers changed from: private */
    public WifiP2pDevice mWifiP2pDevice;

    public class P2pReceiver extends BroadcastReceiver {
        private P2pReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            StLog.d(WiFiP2pBaseManager.TAG, "onReceive : " + action);
            if ("android.net.wifi.p2p.CONNECTION_STATE_CHANGE".equals(action)) {
                WiFiP2pBaseManager.this.onP2pConnectChange(intent);
            } else if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action)) {
                int intExtra = intent.getIntExtra("wifi_state", 0);
                if (intExtra == 3) {
                    WiFiP2pBaseManager wiFiP2pBaseManager = WiFiP2pBaseManager.this;
                    wiFiP2pBaseManager.mP2pMacAddress = "";
                    wiFiP2pBaseManager.initSupplicantStaIfaceHal();
                } else if (intExtra == 1) {
                    WiFiP2pBaseManager wiFiP2pBaseManager2 = WiFiP2pBaseManager.this;
                    wiFiP2pBaseManager2.mP2pMacAddress = "";
                    wiFiP2pBaseManager2.resetSupplicantStaIfaceHal();
                    WiFiP2pBaseManager.this.onWifiDisable();
                }
            } else if ("android.net.wifi.p2p.STATE_CHANGED".equals(action)) {
                if (intent.getIntExtra("wifi_p2p_state", 0) == 2) {
                    WiFiP2pBaseManager.this.onP2pEnable();
                } else {
                    WiFiP2pBaseManager.this.onP2pDisable();
                }
            } else if ("android.net.wifi.p2p.THIS_DEVICE_CHANGED".equals(action)) {
                WifiP2pDevice wifiP2pDevice = (WifiP2pDevice) intent.getParcelableExtra("wifiP2pDevice");
                StLog.d(WiFiP2pBaseManager.TAG, "device status:" + wifiP2pDevice.status);
                int i = wifiP2pDevice.status;
                if (i == 4 || i == 2) {
                    WiFiP2pBaseManager.this.mP2pMacAddress = "";
                } else {
                    WiFiP2pBaseManager.this.requestP2pDevice();
                }
            }
        }
    }

    public WiFiP2pBaseManager(Context context, IP2pConnectCallback iP2pConnectCallback) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mConnectCallback = iP2pConnectCallback;
        this.mP2pChannelThread.start();
        WifiP2pManager wifiP2pManager = (WifiP2pManager) applicationContext.getSystemService("wifip2p");
        this.mP2pManager = wifiP2pManager;
        this.mP2pChannel = wifiP2pManager.initialize(applicationContext, this.mP2pChannelThread.getLooper(), (WifiP2pManager.ChannelListener) null);
        this.mWifiManager = (WifiManager) applicationContext.getSystemService("wifi");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.p2p.STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.p2p.THIS_DEVICE_CHANGED");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        applicationContext.registerReceiver(new P2pReceiver(), intentFilter);
        requestP2pDevice();
    }

    private boolean isCtsRunning() {
        boolean z;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            z = ((Boolean) cls.getDeclaredMethod("getBoolean", new Class[]{String.class, Boolean.TYPE}).invoke(cls, new Object[]{"persist.sys.cts_state", Boolean.FALSE})).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            z = false;
        }
        StLog.d(TAG, "IsCtsRunning : " + z);
        return z;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getP2pMacAddress$1(CountDownLatch countDownLatch, WifiP2pDevice wifiP2pDevice) {
        StLog.d(TAG, "onDeviceInfoAvailable, p2pDevice= " + wifiP2pDevice);
        if (wifiP2pDevice != null) {
            this.mP2pMacRetryCount = 0;
            if (wifiP2pDevice.status != 4) {
                this.mWifiP2pDevice = wifiP2pDevice;
                this.mP2pMacAddress = wifiP2pDevice.deviceAddress;
            }
        }
        countDownLatch.countDown();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$requestP2pDevice$0(WifiP2pDevice wifiP2pDevice) {
        StLog.d(TAG, "onDeviceInfoAvailable, p2pDevice= " + wifiP2pDevice);
        if (wifiP2pDevice != null) {
            this.mP2pMacRetryCount = 0;
            if (wifiP2pDevice.status != 4) {
                this.mWifiP2pDevice = wifiP2pDevice;
                this.mP2pMacAddress = wifiP2pDevice.deviceAddress;
            }
        } else if (this.mWifiManager.isWifiEnabled() && this.mP2pMacRetryCount < 10) {
            StringBuilder sb = new StringBuilder();
            sb.append("retry get p2p mac : ");
            int i = this.mP2pMacRetryCount;
            this.mP2pMacRetryCount = i + 1;
            sb.append(i);
            StLog.d(TAG, sb.toString());
            requestP2pDevice();
        }
    }

    public void checkCloseDualWifi() {
        int i = Settings.Global.getInt(this.mContext.getContentResolver(), DUAL_WIFI_ENABLED_STATE, 0);
        StLog.d(TAG, "checkCloseDualWifi, dualState = " + i);
        if (i == 1) {
            Settings.Global.putInt(this.mContext.getContentResolver(), DUAL_WIFI_ENABLED_STATE, 0);
            this.isActiveCloseDualWifi = true;
        }
    }

    public void checkOpenDualWifi() {
        StLog.d(TAG, "checkOpenDualWifi, isActiveClose = " + this.isActiveCloseDualWifi);
        if (this.isActiveCloseDualWifi) {
            Settings.Global.putInt(this.mContext.getContentResolver(), DUAL_WIFI_ENABLED_STATE, 1);
            this.isActiveCloseDualWifi = false;
        }
    }

    public int coverFreq2Channel(int i) {
        if (i == 2484) {
            return 14;
        }
        if (is24GHz(i)) {
            return ((i - 2412) / 5) + 1;
        }
        if (is5GHz(i)) {
            return ((i - 5160) / 5) + 32;
        }
        return -1;
    }

    @SuppressLint({"MissingPermission"})
    public String getP2pMacAddress() {
        if (TextUtils.isEmpty(this.mP2pMacAddress)) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.mP2pManager.requestDeviceInfo(this.mP2pChannel, new b(this, countDownLatch));
            try {
                if (countDownLatch.await(1000, TimeUnit.MILLISECONDS)) {
                    StLog.d(TAG, "countDownLatch count already reached zero");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                StLog.e(TAG, "p2p latch: " + e);
            }
        }
        return this.mP2pMacAddress;
    }

    public void initSupplicantStaIfaceHal() {
    }

    public boolean is24GHz(int i) {
        return i >= 2412 && i <= 2484;
    }

    public boolean is5GHz(int i) {
        return i >= 5160 && i <= 5885;
    }

    public boolean isStarryNetCreatedNetwork(String str) {
        return str.startsWith(STARRYNET_P2P_GROUP) || str.endsWith(STARRYNET_P2P_GROUP_ENDOF);
    }

    public void onFailure(int i) {
        StLog.d(TAG, "connect failure : " + i);
    }

    public void onP2pConnectChange(Intent intent) {
    }

    public void onP2pDisable() {
        StLog.d(TAG, "onP2pDisable");
        this.mP2pMacAddress = "";
    }

    public void onP2pEnable() {
        StLog.d(TAG, "onP2pEnable");
        WifiP2pManager.Channel channel = this.mP2pChannel;
        if (channel != null) {
            channel.close();
        }
        this.mP2pChannel = this.mP2pManager.initialize(this.mContext, this.mP2pChannelThread.getLooper(), (WifiP2pManager.ChannelListener) null);
        if (!TextUtils.isEmpty(this.mP2pMacAddress)) {
            StLog.d(TAG, "already get p2pInfo, mac = " + this.mP2pMacAddress);
        } else if (!isCtsRunning()) {
            requestP2pDevice();
        }
    }

    public void onSuccess() {
        StLog.d(TAG, "connect success");
    }

    public void onWifiDisable() {
        StLog.d(TAG, "onWifiDisable");
        if (TrackerManager.getInstance().getP2PConnectionTracker().isConnected()) {
            TrackerManager.getInstance().getP2PConnectionTracker().onDisconnect().startReport();
        } else if (TrackerManager.getInstance().getP2PConnectionTracker().isConnecting()) {
            TrackerManager.getInstance().getP2PConnectionTracker().connectFailReason(String.valueOf(WiFiP2pGCManager.ERROR_P2P_STATE_DISABLE)).startReport();
        }
    }

    @SuppressLint({"MissingPermission"})
    public void requestP2pDevice() {
        this.mP2pManager.requestDeviceInfo(this.mP2pChannel, new a(this));
    }

    public void resetSupplicantStaIfaceHal() {
    }
}
