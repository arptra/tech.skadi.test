package com.upuphone.starrynet.strategy.channel.ap;

import Starry.StarryLinkEncrypt;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ap.IWiFiStaCallback;
import com.upuphone.starrynet.core.ap.WiFiApInfo;
import com.upuphone.starrynet.core.ap.WiFiApStaManager;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IChannelCallback;
import com.upuphone.starrynet.strategy.channel.IMessageChannel;
import com.upuphone.starrynet.strategy.channel.IStarryUpChannel;
import com.upuphone.starrynet.strategy.channel.StarryNetChannelManager;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.encrypt.StarryNetEncryptHelper;

public class StaChannel implements IStarryUpChannel, IWiFiStaCallback {
    private static final String TAG = "StaChannel";
    private final WiFiApStaManager mApClientManager = new WiFiApStaManager(StarryNetData.getInstance().getApplicationContext(), this);

    private void sendMsg(StDevice stDevice, byte[] bArr) {
        IMessageChannel messageChannel = StarryNetChannelManager.getInstance().getMessageChannel(stDevice, 1);
        if (messageChannel == null) {
            StLog.d(TAG, "sendMsg channel is null");
        } else {
            messageChannel.sendMsg(stDevice, bArr, 10);
        }
    }

    public int connect(StDevice stDevice) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice == null || connectDevice.getCipher() == null) {
            return -1;
        }
        StLog.d(TAG, "sendCreateApMsg");
        sendMsg(connectDevice.getDevice(), StarryNetEncryptHelper.generateCreateAp());
        return 0;
    }

    public int disconnect(StDevice stDevice) {
        this.mApClientManager.disconnectAp();
        return 0;
    }

    public int getProfile() {
        return 13;
    }

    public void onApDisconnectFail(int i) {
        StLog.d(TAG, "onApDisconnectFail");
    }

    public void onApDisconnected(byte[] bArr, String str) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(bArr);
        if (connectDevice != null) {
            StarryDeviceManager.getInstance().deviceDisconnected(connectDevice, 32);
            if (connectDevice.getDeviceType() != 3) {
                StarryLinkEncrypt.WifiStaInfo build = StarryLinkEncrypt.WifiStaInfo.newBuilder().setIp(str).build();
                StLog.d(TAG, "onApDisconnected address = " + str);
                sendMsg(connectDevice.getDevice(), StarryNetEncryptHelper.generateApDisconnected(connectDevice.getCipher(), build.toByteArray(), connectDevice.getEncrypt()));
            }
        }
    }

    public void onApStaConnectFail(byte[] bArr, int i) {
        StLog.d(TAG, "onApStaConnectFail");
    }

    public void onApStaConnected(byte[] bArr, String str, String str2) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(bArr);
        if (connectDevice != null) {
            connectDevice.setAddress(this.mApClientManager.getServerAddress());
            connectDevice.setPort(this.mApClientManager.getServerPort());
            connectDevice.setWifiMac(str2);
            StarryDeviceManager.getInstance().deviceConnected(connectDevice, 32);
            if (connectDevice.getDeviceType() != 3) {
                if (connectDevice.getCipher() == null) {
                    StLog.e(TAG, "onApStaConnected address = " + str + " mac = " + str2 + ", device cipher is null, return!");
                    return;
                }
                StarryLinkEncrypt.WifiStaInfo build = StarryLinkEncrypt.WifiStaInfo.newBuilder().setIp(str).setMac(str2).build();
                StLog.d(TAG, "onApStaConnected address = " + str + " mac = " + str2);
                sendMsg(connectDevice.getDevice(), StarryNetEncryptHelper.generateApConnected(connectDevice.getCipher(), build.toByteArray(), connectDevice.getEncrypt()));
            }
        }
    }

    public void setCallback(IChannelCallback iChannelCallback) {
    }

    public void disconnect(String str) {
        this.mApClientManager.disconnectAp(str);
    }

    public void connect(WiFiApInfo wiFiApInfo) {
        this.mApClientManager.connectAp(wiFiApInfo);
    }
}
