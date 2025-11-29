package com.upuphone.starrynet.core.p2p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import com.honey.account.y6.f;
import com.honey.account.y6.g;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.StErrorTips;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.RandomPwdHelper;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.common.utils.WifiUtil;
import com.upuphone.starrynet.core.p2p.bean.GoInfo;
import com.upuphone.starrynet.core.p2p.halbinder.WifiXjSupplicantService;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class WiFiP2pGOManager extends WiFiP2pBaseManager implements WifiP2pManager.ChannelListener {
    public static final int DEFAULT_GO_FREQUENCY = 5745;
    private static final long MAX_WAIT_RECREATE_P2P_TIME = 500;
    private static final String TAG = "WiFiP2pGOManager";
    private final Map<String, WifiP2pDevice> hmPeerGcDevices = new ConcurrentHashMap();
    private boolean isGoCreating;
    /* access modifiers changed from: private */
    public boolean mHadRemovedNoneStarryNetP2p = false;
    private String mHostAddress;
    private final GoInfo mInfo = new GoInfo();
    private int mLocalPort;
    private final String mPwd = RandomPwdHelper.getRandomPwd(8);
    /* access modifiers changed from: private */
    public long mRemovedNoneStarryNetP2pTimeStamp = -1;
    private WifiXjSupplicantService mSupplicantService;
    private int[] mSupportChannel;
    private WifiP2pGroup mWifiP2pGroup;

    public WiFiP2pGOManager(Context context, IP2pConnectCallback iP2pConnectCallback) {
        super(context, iP2pConnectCallback);
        this.mSupplicantService = new WifiXjSupplicantService(context);
        this.mP2pManager.requestGroupInfo(this.mP2pChannel, new g(this));
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    private void createGroup() {
        if (this.isGoCreating) {
            StLog.i(TAG, "group is creating");
            return;
        }
        this.isGoCreating = true;
        checkCloseDualWifi();
        int goFrequency = getGoFrequency();
        WifiP2pConfig build = new WifiP2pConfig.Builder().enablePersistentMode(false).setNetworkName(WiFiP2pBaseManager.STARRYNET_P2P_GROUP + Utils.getRandomString(8)).setGroupOperatingFrequency(goFrequency).setPassphrase(this.mPwd).build();
        StLog.i(TAG, "createGroup config = " + build.toString());
        this.mP2pManager.createGroup(this.mP2pChannel, build, this);
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
            java.lang.String r1 = "WiFiP2pGOManager"
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
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.core.p2p.WiFiP2pGOManager.generateGoDefaultPort():int");
    }

    private int getGoFrequency() {
        int[] iArr;
        WifiInfo connectionInfo = this.mWifiManager.getConnectionInfo();
        int i = DEFAULT_GO_FREQUENCY;
        if (connectionInfo != null) {
            int frequency = connectionInfo.getFrequency();
            StLog.d(TAG, "current connect ssid=%s, frequency=%d", connectionInfo.getSSID(), Integer.valueOf(frequency));
            if (WifiUtil.is5G(frequency) && (iArr = this.mSupportChannel) != null) {
                List list = (List) Arrays.stream(iArr).boxed().collect(Collectors.toList());
                StLog.d(TAG, "support channel list = " + list);
                if (list.contains(Integer.valueOf(frequency))) {
                    i = frequency;
                }
            }
        } else {
            StLog.e(TAG, "current wifi info is null!");
        }
        StLog.d(TAG, "buildConfig mGoFrequency=" + i);
        return i;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$createP2pGroup$1(WifiP2pGroup wifiP2pGroup) {
        boolean z = true;
        if (wifiP2pGroup != null) {
            String networkName = wifiP2pGroup.getNetworkName();
            String passphrase = wifiP2pGroup.getPassphrase();
            StLog.d(TAG, "networkName = " + networkName + ", passphrase = " + passphrase);
            if (!isStarryNetCreatedNetwork(networkName) || passphrase == null || passphrase.length() <= 0 || this.mHostAddress == null) {
                removeGroup(true);
                return;
            }
            this.mWifiP2pGroup = wifiP2pGroup;
            int port = this.mInfo.getPort();
            StLog.d(TAG, "same p2p go do nothing last port = " + port);
            this.mInfo.setSsid(networkName);
            this.mInfo.setPwd(passphrase);
            this.mInfo.setMac(getP2pMacAddress());
            this.mInfo.setFreq(wifiP2pGroup.getFrequency());
            this.mInfo.setAddress(this.mHostAddress);
            this.mInfo.setPort(this.mLocalPort);
            GoInfo goInfo = this.mInfo;
            if (port == this.mLocalPort) {
                z = false;
            }
            goInfo.setNeedReport(z);
            IP2pConnectCallback iP2pConnectCallback = this.mConnectCallback;
            if (iP2pConnectCallback != null) {
                iP2pConnectCallback.onP2pGoCreated(this.mInfo);
                return;
            }
            return;
        }
        this.mSupplicantService.enableGoForceScc(true);
        this.mSupplicantService.enableGoSccDfs(true);
        createGroup();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(WifiP2pGroup wifiP2pGroup) {
        if (wifiP2pGroup != null) {
            String networkName = wifiP2pGroup.getNetworkName();
            if (isStarryNetCreatedNetwork(networkName)) {
                StLog.d(TAG, "remove created group when launch application firstly :" + networkName);
                removeGroup(false);
            }
        }
    }

    private void onP2pChangeGroupOwner(NetworkInfo networkInfo, WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo, boolean z) {
        if (this.mWifiP2pGroup != null) {
            this.mWifiP2pGroup = wifiP2pGroup;
            onP2pGoConnectDeviceChange(wifiP2pGroup.getClientList());
        } else if ((networkInfo != null && !networkInfo.isConnected()) || wifiP2pInfo == null || wifiP2pInfo.groupOwnerAddress == null) {
            StLog.d(TAG, "P2p group create fail");
        } else {
            String networkName = wifiP2pGroup.getNetworkName();
            if (networkName == null || !isStarryNetCreatedNetwork(networkName)) {
                StLog.d(TAG, "not starry net go");
                if (z) {
                    StErrorTips.showErrorTips(StErrorTips.ErrorTips.P2P_GO_NAME_INVALID);
                    return;
                }
                return;
            }
            this.mWifiP2pGroup = wifiP2pGroup;
            this.mHostAddress = wifiP2pInfo.groupOwnerAddress.getHostAddress();
            onP2pGoCreated();
        }
    }

    private void onP2pGoConnectDeviceChange(Collection<WifiP2pDevice> collection) {
        if (collection == null || collection.isEmpty()) {
            for (WifiP2pDevice next : this.hmPeerGcDevices.values()) {
                this.hmPeerGcDevices.remove(next.deviceAddress);
                onP2pGoDisconnected(next.deviceAddress);
            }
            return;
        }
        for (WifiP2pDevice next2 : collection) {
            if (!this.hmPeerGcDevices.containsKey(next2.deviceAddress)) {
                this.hmPeerGcDevices.put(next2.deviceAddress, next2);
                onP2pGoConnected(next2.deviceAddress);
            }
        }
        for (WifiP2pDevice next3 : this.hmPeerGcDevices.values()) {
            if (!collection.contains(next3)) {
                this.hmPeerGcDevices.remove(next3.deviceAddress);
                onP2pGoDisconnected(next3.deviceAddress);
            }
        }
    }

    private void onP2pGoConnected(String str) {
        IP2pConnectCallback iP2pConnectCallback = this.mConnectCallback;
        if (iP2pConnectCallback != null) {
            iP2pConnectCallback.onP2pGoConnected(str);
        }
    }

    private void onP2pGoCreated() {
        this.mInfo.setPwd(this.mWifiP2pGroup.getPassphrase());
        this.mInfo.setSsid(this.mWifiP2pGroup.getNetworkName());
        this.mInfo.setFreq(this.mWifiP2pGroup.getFrequency());
        this.mInfo.setMac(getP2pMacAddress());
        this.mInfo.setAddress(this.mHostAddress);
        this.mInfo.setPort(this.mLocalPort);
        this.mInfo.setNeedReport(true);
        IP2pConnectCallback iP2pConnectCallback = this.mConnectCallback;
        if (iP2pConnectCallback != null) {
            iP2pConnectCallback.onP2pGoCreated(this.mInfo);
        }
    }

    private void onP2pGoDisconnected(String str) {
        IP2pConnectCallback iP2pConnectCallback = this.mConnectCallback;
        if (iP2pConnectCallback != null) {
            iP2pConnectCallback.onP2pGoDisconnected(str);
            if (this.hmPeerGcDevices.size() == 0) {
                removeP2pGroup();
            }
        }
    }

    private void onP2pGoRemoved() {
        if (this.mConnectCallback != null) {
            for (WifiP2pDevice wifiP2pDevice : this.hmPeerGcDevices.values()) {
                this.mConnectCallback.onP2pGoDisconnected(wifiP2pDevice.deviceAddress);
            }
            this.mConnectCallback.onP2pGoRemoved();
            this.mSupplicantService.enableGoForceScc(false);
            this.mSupplicantService.enableGoSccDfs(false);
            checkOpenDualWifi();
        }
    }

    private void removeGroup(final boolean z) {
        this.mP2pManager.removeGroup(this.mP2pChannel, new WifiP2pManager.ActionListener() {
            public void onFailure(int i) {
                StLog.d(WiFiP2pGOManager.TAG, "removeGroup failure : " + i);
                IP2pConnectCallback iP2pConnectCallback = WiFiP2pGOManager.this.mConnectCallback;
                if (iP2pConnectCallback != null) {
                    iP2pConnectCallback.onConnectedFail(StErrorCode.CONNECT_STRATEGY_P2P_REMOVE_GROUP_FAIL, (byte[]) null);
                }
            }

            public void onSuccess() {
                StLog.d(WiFiP2pGOManager.TAG, "removeGroup Success, isNeedCreate =" + z);
                if (z) {
                    boolean unused = WiFiP2pGOManager.this.mHadRemovedNoneStarryNetP2p = true;
                    long unused2 = WiFiP2pGOManager.this.mRemovedNoneStarryNetP2pTimeStamp = System.currentTimeMillis();
                }
            }
        });
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public void createP2pGroup(int i) {
        StLog.d(TAG, "createP2pGroup, port: " + i);
        if (i != 0) {
            this.mLocalPort = i;
        }
        this.mP2pManager.requestGroupInfo(this.mP2pChannel, new f(this));
    }

    public boolean disconnect() {
        if (this.hmPeerGcDevices.size() > 1) {
            return false;
        }
        removeGroup(false);
        return true;
    }

    public GoInfo getInfo() {
        return this.mInfo;
    }

    public void initSupplicantStaIfaceHal() {
        WifiXjSupplicantService wifiXjSupplicantService = this.mSupplicantService;
        if (wifiXjSupplicantService != null) {
            wifiXjSupplicantService.initSupplicantStaIfaceHal();
        }
    }

    public void onChannelDisconnected() {
        StLog.d(TAG, "onChannelDisconnected");
    }

    public void onFailure(int i) {
        StLog.d(TAG, "createP2pGroup Failure : " + i);
        this.isGoCreating = false;
        IP2pConnectCallback iP2pConnectCallback = this.mConnectCallback;
        if (iP2pConnectCallback != null) {
            iP2pConnectCallback.onConnectedFail(StErrorCode.CONNECT_STRATEGY_P2P_CREATE_GROUP_FAIL, (byte[]) null);
        }
        this.mSupplicantService.enableGoForceScc(false);
        this.mSupplicantService.enableGoSccDfs(false);
        checkOpenDualWifi();
    }

    public void onP2pConnectChange(Intent intent) {
        WifiP2pInfo wifiP2pInfo = (WifiP2pInfo) intent.getParcelableExtra("wifiP2pInfo");
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        WifiP2pGroup wifiP2pGroup = (WifiP2pGroup) intent.getParcelableExtra("p2pGroupInfo");
        StLog.d(TAG, "WifiP2pInfo " + Optional.ofNullable(wifiP2pInfo));
        StLog.d(TAG, "NetworkInfo: " + Optional.ofNullable(networkInfo));
        StLog.d(TAG, "WifiP2pGroup : " + Optional.ofNullable(wifiP2pGroup));
        if (wifiP2pGroup == null || !wifiP2pGroup.isGroupOwner()) {
            if (!(networkInfo == null || networkInfo.getDetailedState() == NetworkInfo.DetailedState.IDLE || networkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTING || !this.mHadRemovedNoneStarryNetP2p)) {
                long j = this.mRemovedNoneStarryNetP2pTimeStamp;
                if (j > 0 && Math.abs(j - System.currentTimeMillis()) < 500) {
                    this.mHadRemovedNoneStarryNetP2p = false;
                    this.mRemovedNoneStarryNetP2pTimeStamp = -1;
                    StLog.d(TAG, "remove group,and need to create group again.");
                    createGroup();
                    return;
                }
            }
            if ((this.mWifiP2pGroup != null || this.isGoCreating) && networkInfo != null && networkInfo.getDetailedState() != NetworkInfo.DetailedState.IDLE && networkInfo.getDetailedState() != NetworkInfo.DetailedState.CONNECTING && wifiP2pGroup == null) {
                this.isGoCreating = false;
                onP2pGoRemoved();
                this.mWifiP2pGroup = null;
                this.hmPeerGcDevices.clear();
                return;
            }
            return;
        }
        boolean z = this.isGoCreating;
        this.isGoCreating = false;
        onP2pChangeGroupOwner(networkInfo, wifiP2pGroup, wifiP2pInfo, z);
    }

    public void onSuccess() {
        StLog.d(TAG, "createP2pGroup Success");
        if (this.mLocalPort <= 0) {
            this.mLocalPort = generateGoDefaultPort();
        }
    }

    public void onWifiDisable() {
        this.isGoCreating = false;
    }

    public void removeP2pGroup() {
        StLog.d(TAG, "removeP2pGroup");
        this.mLocalPort = 0;
        removeGroup(false);
    }

    public void resetSupplicantStaIfaceHal() {
        WifiXjSupplicantService wifiXjSupplicantService = this.mSupplicantService;
        if (wifiXjSupplicantService != null) {
            wifiXjSupplicantService.resetSupplicantStaIfaceHal();
        }
    }

    public void setSupportChannel(int[] iArr) {
        this.mSupportChannel = iArr;
    }
}
