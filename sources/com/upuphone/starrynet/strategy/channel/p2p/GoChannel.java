package com.upuphone.starrynet.strategy.channel.p2p;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.upuphone.starrynet.api.IPublisher;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.StTestConstant;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.tracker.TrackerManager;
import com.upuphone.starrynet.core.p2p.WiFiP2pGOManager;
import com.upuphone.starrynet.core.p2p.bean.GoInfo;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IChannelCallback;
import com.upuphone.starrynet.strategy.config.CarConfigs;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.encrypt.StarryNetEncryptHelper;
import java.util.ArrayList;
import java.util.List;

public class GoChannel extends P2PChannel {
    private static final int MSG_RETRY_GET_DEVICE = 0;
    private static final String TAG = "GoChannel";
    private final int[] CHANNEL_SUPPORT_5G_ALL = {5180, 5200, 5220, 5240, 5260, 5280, 5300, 5320, WiFiP2pGOManager.DEFAULT_GO_FREQUENCY, 5765, 5785, 5805, 5825};
    private final int[] CHANNEL_SUPPORT_5G_HIGH_FREQ = {WiFiP2pGOManager.DEFAULT_GO_FREQUENCY, 5765, 5785, 5805};
    private final int[] CHANNEL_SUPPORT_5G_REMOVE_DFS = {5180, 5200, 5220, 5240, WiFiP2pGOManager.DEFAULT_GO_FREQUENCY, 5765, 5785, 5805, 5825};
    private boolean isGoCreated;
    /* access modifiers changed from: private */
    public boolean isNeedLastReport = true;
    private final List<StDevice> mCreateGoList = new ArrayList();
    private int mDefaultPort;
    protected final Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(@NonNull Message message) {
            if (message.what == 0) {
                boolean unused = GoChannel.this.isNeedLastReport = false;
                GoChannel.this.onP2pGoConnected((String) message.obj);
            }
        }
    };
    private final WiFiP2pGOManager mManager = new WiFiP2pGOManager(StarryNetData.getInstance().getApplicationContext(), this);

    private int[] getSupportChannel(StDevice stDevice) {
        byte terminalType = StarryNetData.getInstance().getOwnDevice().getTerminalType();
        return terminalType == 1 ? CarConfigs.MODEL_NAME_CAR_CS11_PLUS.equals(stDevice.getModelName()) ? this.CHANNEL_SUPPORT_5G_HIGH_FREQ : this.CHANNEL_SUPPORT_5G_ALL : (terminalType != 3 || (!StarryNetData.getInstance().isMatchModel(CarConfigs.MODEL_NAME_CAR_DX11) && !StarryNetData.getInstance().isMatchModel(CarConfigs.MODEL_NAME_CAR_DS11))) ? this.CHANNEL_SUPPORT_5G_REMOVE_DFS : this.CHANNEL_SUPPORT_5G_ALL;
    }

    public int connect(StDevice stDevice) {
        boolean z = stDevice.getDeviceType() == 2;
        this.mManager.setSupportChannel(getSupportChannel(stDevice));
        synchronized (this) {
            try {
                if (!this.mCreateGoList.contains(stDevice)) {
                    this.mCreateGoList.add(stDevice);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        TrackerManager.getInstance().getP2PConnectionTracker().startConnect(stDevice.getTerminalType(), stDevice.getIdentifier2String());
        this.mManager.createP2pGroup(z ? 0 : this.mDefaultPort);
        return 0;
    }

    public int disconnect(StDevice stDevice) {
        boolean disconnect = this.mManager.disconnect();
        StLog.d(TAG, "disconnectP2p go send msg to gc ret = " + disconnect);
        setMsg(stDevice, StarryNetEncryptHelper.generateDisconnectP2p());
        synchronized (this) {
            this.mCreateGoList.clear();
        }
        return 0;
    }

    public GoInfo getGoInfo() {
        return this.mManager.getInfo();
    }

    public String getP2pMacAddress() {
        return this.mManager.getP2pMacAddress();
    }

    public int getProfile() {
        return 10;
    }

    public boolean isGoCreated() {
        return this.isGoCreated;
    }

    public void onConnectedFail(int i, byte[] bArr) {
        ArrayList<StDevice> arrayList;
        synchronized (this) {
            arrayList = new ArrayList<>(this.mCreateGoList);
            this.mCreateGoList.clear();
        }
        if (!TrackerManager.getInstance().getP2PConnectionTracker().isConnected()) {
            TrackerManager.getInstance().getP2PConnectionTracker().connectFailReason(String.valueOf(i)).startReport();
        }
        for (StDevice connectFail : arrayList) {
            StarryDeviceManager.getInstance().connectFail(connectFail, i, 2);
        }
    }

    public /* bridge */ /* synthetic */ void onP2pGcConnected(int i, String str, byte[] bArr, String str2) {
        super.onP2pGcConnected(i, str, bArr, str2);
    }

    public /* bridge */ /* synthetic */ void onP2pGcDisconnected(String str, byte[] bArr) {
        super.onP2pGcDisconnected(str, bArr);
    }

    public void onP2pGoConnected(String str) {
        if (TextUtils.isEmpty(str)) {
            StLog.d(TAG, "onP2pGoConnected mac is empty");
            return;
        }
        TrackerManager.getInstance().getP2PConnectionTracker().p2pConnected();
        StLog.d(TAG, "onP2pGoConnected p2p mac: " + str);
        StLog.d(TAG, StTestConstant.POINT_P2P_CONNECT_STEP_3);
        List<StConnectDevice> connectDeviceByWifiMac = StarryDeviceManager.getInstance().getConnectDeviceByWifiMac(str);
        if (!connectDeviceByWifiMac.isEmpty()) {
            this.isNeedLastReport = true;
            for (StConnectDevice next : connectDeviceByWifiMac) {
                if (next == null) {
                    StLog.d(TAG, "onP2pGoConnected error param");
                    return;
                }
                StLog.d(TAG, "onP2pGoConnected ble : " + next.getBleMac() + " name : " + next.getDeviceName());
                IChannelCallback iChannelCallback = this.mCallback;
                if (iChannelCallback != null) {
                    iChannelCallback.onConnected(next, this);
                }
                StarryDeviceManager.getInstance().p2pConnectForDiscovery(next, true);
            }
            if (isPhone()) {
                StarryNetData.getInstance().setUupShareBusy(true);
            }
        } else if (this.isNeedLastReport) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, str), 200);
        } else {
            StLog.w(TAG, "retryReportConnected mac : " + str + " still not found");
            this.isNeedLastReport = true;
        }
    }

    public void onP2pGoCreated(GoInfo goInfo) {
        ArrayList<StDevice> arrayList;
        StLog.d(TAG, StTestConstant.POINT_P2P_CONNECT_STEP_2);
        this.isGoCreated = true;
        if (goInfo.isNeedReport()) {
            StarryDeviceManager.getInstance().goCreated(goInfo);
        }
        synchronized (this) {
            arrayList = new ArrayList<>(this.mCreateGoList);
            this.mCreateGoList.clear();
        }
        TrackerManager.getInstance().getP2PConnectionTracker().band(String.valueOf(goInfo.getFreq()));
        for (StDevice stDevice : arrayList) {
            StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
            if (connectDevice == null || connectDevice.getCipher() == null) {
                StLog.d(TAG, "onP2pGoCreated bond info is null, so cannot send p2pInfo to GC by ble");
                return;
            } else if (connectDevice.getDeviceType() == 2) {
                StLog.d(TAG, "onP2pGoCreated device is DEVICE_TYPE_UUP_SHARE, so cannot send p2pInfo to GC by ble");
                return;
            } else {
                StLog.d(TAG, "send connectP2p msg");
                setMsg(connectDevice.getDevice(), StarryNetEncryptHelper.generateConnectGo(connectDevice.getCipher(), stDevice.getWifiMac(), goInfo, connectDevice.getEncrypt()));
            }
        }
    }

    public void onP2pGoDisconnected(String str) {
        if (TextUtils.isEmpty(str)) {
            StLog.d(TAG, "onP2pGoDisconnected address is empty");
            return;
        }
        if (TrackerManager.getInstance().getP2PConnectionTracker().isConnected()) {
            TrackerManager.getInstance().getP2PConnectionTracker().onDisconnect().startReport();
        }
        StLog.d(TAG, "onP2pGoDisconnected mac : " + str);
        for (StConnectDevice next : StarryDeviceManager.getInstance().getConnectDeviceByWifiMac(str)) {
            if (next == null) {
                StLog.d(TAG, "onP2pGoDisconnected error param");
                return;
            }
            IChannelCallback iChannelCallback = this.mCallback;
            if (iChannelCallback != null) {
                iChannelCallback.onDisconnected(next, this);
            }
            StLog.d(TAG, "onP2pGoDisconnected p2pConnectForDiscovery");
            StarryDeviceManager.getInstance().p2pConnectForDiscovery(next, false);
        }
        if (isPhone()) {
            StarryNetData.getInstance().setUupShareBusy(false);
        }
    }

    public void onP2pGoRemoved() {
        if (!this.isGoCreated) {
            onConnectedFail(StErrorCode.CONNECT_STRATEGY_P2P_CREATE_GROUP_FAIL, (byte[]) null);
            return;
        }
        this.isGoCreated = false;
        synchronized (this) {
            this.mCreateGoList.clear();
        }
        StLog.d(TAG, "onP2pGoRemoved");
        StarryDeviceManager.getInstance().goRemoved();
        if (isPhone()) {
            StarryNetData.getInstance().setUupShareBusy(false);
        }
    }

    public /* bridge */ /* synthetic */ void registerPublisher(IPublisher iPublisher) {
        super.registerPublisher(iPublisher);
    }

    public /* bridge */ /* synthetic */ boolean sendP2pMsg(StDevice stDevice, byte[] bArr) {
        return super.sendP2pMsg(stDevice, bArr);
    }

    public /* bridge */ /* synthetic */ void setCallback(IChannelCallback iChannelCallback) {
        super.setCallback(iChannelCallback);
    }

    public void setDefaultPort(int i) {
        this.mDefaultPort = i;
    }
}
