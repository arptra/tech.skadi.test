package com.upuphone.starrynet.strategy.channel.spp;

import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.core.spp.SPPConnectionManager;
import com.upuphone.starrynet.strategy.channel.IChannelCallback;
import com.upuphone.starrynet.strategy.channel.IConnectChannel;
import com.upuphone.starrynet.strategy.channel.IMessageCallback;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;

public abstract class SppChannel implements IConnectChannel {
    protected IChannelCallback mIChannelCallback;
    protected IMessageCallback mMessageCallback;

    public boolean isConnected(String str) {
        return SPPConnectionManager.getInstance().isConnected(str);
    }

    public void onBleDisconnected(StDevice stDevice) {
        this.mIChannelCallback.onDisconnected(StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier()), this);
    }

    public int sendMsg(String str, byte[] bArr, IMessageCallback iMessageCallback) {
        if (!isConnected(str)) {
            iMessageCallback.onResult(-1);
            return -1;
        }
        this.mMessageCallback = iMessageCallback;
        SPPConnectionManager.getInstance().sendMessage(str, bArr);
        return 0;
    }

    public void setCallback(IChannelCallback iChannelCallback) {
        this.mIChannelCallback = iChannelCallback;
    }
}
