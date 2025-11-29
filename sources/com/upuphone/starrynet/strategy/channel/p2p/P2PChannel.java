package com.upuphone.starrynet.strategy.channel.p2p;

import com.upuphone.starrynet.api.IPublisher;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.tracker.TrackerManager;
import com.upuphone.starrynet.core.p2p.IP2pConnectCallback;
import com.upuphone.starrynet.core.p2p.bean.GoInfo;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.channel.IChannelCallback;
import com.upuphone.starrynet.strategy.channel.IMessageChannel;
import com.upuphone.starrynet.strategy.channel.IStarryUpChannel;
import com.upuphone.starrynet.strategy.channel.StarryNetChannelManager;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;

abstract class P2PChannel implements IStarryUpChannel, IP2pConnectCallback {
    private static final String TAG = "P2PChannel";
    protected IChannelCallback mCallback;
    private IPublisher mPublisher;

    public String getP2pMacAddress() {
        return "";
    }

    public boolean isPhone() {
        StDevice ownDevice = StarryNetData.getInstance().getOwnDevice();
        return ownDevice != null && ownDevice.getTerminalType() == 1;
    }

    public void onConnectedFail(int i, byte[] bArr) {
        StDevice device = StarryDeviceManager.getInstance().getDevice(bArr);
        if (device != null) {
            if (!TrackerManager.getInstance().getP2PConnectionTracker().isConnected()) {
                TrackerManager.getInstance().getP2PConnectionTracker().connectFailReason(String.valueOf(i)).startReport();
            }
            StarryDeviceManager.getInstance().connectFail(device, i, 2);
        }
    }

    public void onP2pGcConnected(int i, String str, byte[] bArr, String str2) {
    }

    public void onP2pGcDisconnected(String str, byte[] bArr) {
    }

    public void onP2pGoConnected(String str) {
    }

    public void onP2pGoCreated(GoInfo goInfo) {
    }

    public void onP2pGoDisconnected(String str) {
    }

    public void onP2pGoRemoved() {
    }

    public void registerPublisher(IPublisher iPublisher) {
        this.mPublisher = iPublisher;
    }

    public boolean sendP2pMsg(StDevice stDevice, byte[] bArr) {
        IPublisher iPublisher = this.mPublisher;
        if (iPublisher == null) {
            return false;
        }
        return iPublisher.publish(stDevice.getIdentifier2String(), bArr);
    }

    public void setCallback(IChannelCallback iChannelCallback) {
        this.mCallback = iChannelCallback;
    }

    public void setMsg(StDevice stDevice, byte[] bArr) {
        IMessageChannel messageChannel = StarryNetChannelManager.getInstance().getMessageChannel(stDevice, 1);
        if (messageChannel == null) {
            StLog.i(TAG, "setMsg channel is null");
        } else {
            messageChannel.sendMsg(stDevice, bArr, 10);
        }
    }
}
