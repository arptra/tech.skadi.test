package com.upuphone.starrynet.strategy.channel.p2p;

import android.os.RemoteException;
import com.upuphone.starrynet.api.IPublisher;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.tracker.TrackerManager;
import com.upuphone.starrynet.core.p2p.WiFiP2pGCManager;
import com.upuphone.starrynet.core.p2p.bean.GoInfo;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IChannelCallback;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.encrypt.StarryNetEncryptHelper;
import com.upuphone.starrynet.strategy.netstack.XdpLinkManager;
import java.util.Arrays;

public class GcChannel extends P2PChannel {
    private static final String TAG = "GcChannel";
    private final WiFiP2pGCManager mManager = new WiFiP2pGCManager(StarryNetData.getInstance().getApplicationContext(), this);
    private int mVpnTcpPort = 0;
    private int mVpnUdpPort = 0;

    public int connect(StDevice stDevice) {
        if (stDevice == null) {
            StLog.d(TAG, "connectP2p StDevice is null");
            return -1;
        }
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice == null || connectDevice.getCipher() == null) {
            StLog.d(TAG, "connectP2p BondInfo is null");
            return -2;
        }
        setMsg(stDevice, StarryNetEncryptHelper.generateConnectGc(connectDevice.getCipher(), getP2pMacAddress(), true, connectDevice.getEncrypt()));
        return 0;
    }

    public int disconnect(StDevice stDevice) {
        this.mManager.disconnect();
        return 0;
    }

    public String getP2pMacAddress() {
        return this.mManager.getP2pMacAddress();
    }

    public int getProfile() {
        return 11;
    }

    public /* bridge */ /* synthetic */ void onConnectedFail(int i, byte[] bArr) {
        super.onConnectedFail(i, bArr);
    }

    public void onP2pGcConnected(int i, String str, byte[] bArr, String str2) {
        StLog.d(TAG, "onP2pGcConnected port : " + i + " address : " + str + " identifier " + Arrays.toString(bArr));
        TrackerManager.getInstance().getP2PConnectionTracker().p2pConnected();
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(bArr);
        if (connectDevice == null) {
            StLog.d(TAG, "onP2pGcConnected error param");
            return;
        }
        connectDevice.setAddress(str);
        if (connectDevice.isP2pConnected()) {
            StLog.i(TAG, "P2pGc already Connected, Channel Switch");
            return;
        }
        IChannelCallback iChannelCallback = this.mCallback;
        if (iChannelCallback != null) {
            iChannelCallback.onConnected(connectDevice, this);
        }
        if (isPhone()) {
            StarryNetData.getInstance().setUupShareBusy(true);
        }
        if (str2 != null) {
            StarryNetData.getInstance().getOwnDevice().setLocalIpAddress(str2);
        }
    }

    public void onP2pGcDisconnected(String str, byte[] bArr) {
        int i;
        StLog.d(TAG, "onP2pGcDisconnected address : " + str);
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(bArr);
        if (connectDevice == null) {
            StLog.d(TAG, "error param");
            return;
        }
        if (TrackerManager.getInstance().getP2PConnectionTracker().isConnected()) {
            TrackerManager.getInstance().getP2PConnectionTracker().onDisconnect().startReport();
        }
        IChannelCallback iChannelCallback = this.mCallback;
        if (iChannelCallback != null) {
            iChannelCallback.onDisconnected(connectDevice, this);
        }
        if (isPhone()) {
            StarryNetData.getInstance().setUupShareBusy(false);
        }
        try {
            i = XdpLinkManager.getInstance().unload("p2p0");
        } catch (RemoteException e) {
            e.printStackTrace();
            i = -2;
        }
        StLog.d(TAG, "xdp unload ret:" + i);
    }

    public /* bridge */ /* synthetic */ void onP2pGoConnected(String str) {
        super.onP2pGoConnected(str);
    }

    public /* bridge */ /* synthetic */ void onP2pGoCreated(GoInfo goInfo) {
        super.onP2pGoCreated(goInfo);
    }

    public /* bridge */ /* synthetic */ void onP2pGoDisconnected(String str) {
        super.onP2pGoDisconnected(str);
    }

    public /* bridge */ /* synthetic */ void onP2pGoRemoved() {
        super.onP2pGoRemoved();
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

    public void connect(String str, String str2, int i, int i2, byte[] bArr, String str3) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(bArr);
        if (connectDevice != null) {
            TrackerManager.getInstance().getP2PConnectionTracker().startConnect(connectDevice.getTerminalType(), connectDevice.getIdentifier2String()).band(String.valueOf(i));
        }
        this.mManager.connect(str, str2, i, i2, bArr, str3);
    }

    public void connect(String str, String str2, String str3, int i, int i2, byte[] bArr, String str4) {
        byte[] bArr2 = bArr;
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(bArr);
        if (connectDevice != null) {
            TrackerManager.getInstance().getP2PConnectionTracker().startConnect(connectDevice.getTerminalType(), connectDevice.getIdentifier2String()).band(String.valueOf(i));
        }
        this.mManager.connect(str, str2, str3, i, i2, bArr, str4);
    }
}
