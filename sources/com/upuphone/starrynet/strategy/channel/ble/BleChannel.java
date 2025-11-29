package com.upuphone.starrynet.strategy.channel.ble;

import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.core.ble.event.EventReceiver;
import com.upuphone.starrynet.strategy.channel.IChannelCallback;
import com.upuphone.starrynet.strategy.channel.IMessageCallback;
import com.upuphone.starrynet.strategy.channel.IStarryNetChannel;
import java.util.ArrayList;
import java.util.List;

abstract class BleChannel implements IStarryNetChannel, EventReceiver {
    protected static final String TAG = "BleChannel";
    protected IChannelCallback mCallback;
    protected final List<String> mConnectedCache = new ArrayList();

    public boolean isConnected(String str) {
        return this.mConnectedCache.contains(str);
    }

    public int sendMsg(StDevice stDevice, byte[] bArr) {
        return stDevice == null ? StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR : sendMsg(stDevice, false, bArr, 1, (IMessageCallback) null);
    }

    public void setCallback(IChannelCallback iChannelCallback) {
        this.mCallback = iChannelCallback;
    }

    public int sendMsg(StDevice stDevice, byte[] bArr, int i) {
        return stDevice == null ? StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR : sendMsg(stDevice, false, bArr, i, (IMessageCallback) null);
    }

    public int sendMsg(StDevice stDevice, byte[] bArr, IMessageCallback iMessageCallback) {
        return stDevice == null ? StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR : sendMsg(stDevice, true, bArr, 1, iMessageCallback);
    }

    public int sendMsg(StDevice stDevice, byte[] bArr, int i, IMessageCallback iMessageCallback) {
        return stDevice == null ? StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR : sendMsg(stDevice, true, bArr, i, iMessageCallback);
    }
}
