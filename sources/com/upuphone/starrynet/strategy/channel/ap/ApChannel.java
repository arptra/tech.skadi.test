package com.upuphone.starrynet.strategy.channel.ap;

import Starry.StarryLinkEncrypt;
import android.text.TextUtils;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ap.IWiFiApCallback;
import com.upuphone.starrynet.core.ap.WiFiApInfo;
import com.upuphone.starrynet.core.ap.WiFiApManager;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IChannelCallback;
import com.upuphone.starrynet.strategy.channel.IMessageChannel;
import com.upuphone.starrynet.strategy.channel.IStarryUpChannel;
import com.upuphone.starrynet.strategy.channel.StarryNetChannelManager;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.encrypt.StarryNetEncryptHelper;

public class ApChannel implements IStarryUpChannel, IWiFiApCallback {
    private static final String TAG = "ApChannel";
    private int mDefaultPort;
    private final WiFiApManager mWifiApManager = new WiFiApManager(StarryNetData.getInstance().getApplicationContext(), this);

    private void sendMsg(WiFiApInfo wiFiApInfo) {
        IMessageChannel messageChannel;
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(wiFiApInfo.getPeerId());
        if (connectDevice != null && connectDevice.getCipher() != null && (messageChannel = StarryNetChannelManager.getInstance().getMessageChannel(connectDevice.getDevice(), 1)) != null) {
            StLog.d(TAG, "sendConnectApMsg " + wiFiApInfo);
            StarryLinkEncrypt.WifiApInfo.Builder port = StarryLinkEncrypt.WifiApInfo.newBuilder().setIp(wiFiApInfo.getIp()).setSsid(wiFiApInfo.getSsid()).setPort(wiFiApInfo.getPort());
            if (wiFiApInfo.getPwd() != null) {
                port.setPsk(wiFiApInfo.getPwd());
            } else {
                port.setPsk("");
            }
            messageChannel.sendMsg(connectDevice.getDevice(), StarryNetEncryptHelper.generateConnectAp(connectDevice.getCipher(), port.build().toByteArray(), connectDevice.getEncrypt()), 10);
        }
    }

    public void closeAp() {
        this.mWifiApManager.closeAp();
    }

    public int connect(StDevice stDevice) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice == null || connectDevice.getCipher() == null) {
            return -1;
        }
        if (StarryNetChannelManager.getInstance().getMessageChannel(stDevice, 1) == null) {
            StLog.d(TAG, "connectAp isBleServerConnected = false, so cannot send ap info by ble");
            return -2;
        }
        createAp(connectDevice);
        return 0;
    }

    public void createAp(StConnectDevice stConnectDevice) {
        this.mWifiApManager.createAp(stConnectDevice.getIdentifier(), this.mDefaultPort);
    }

    public int disconnect(StDevice stDevice) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice == null || connectDevice.getCipher() == null) {
            return -1;
        }
        IMessageChannel messageChannel = StarryNetChannelManager.getInstance().getMessageChannel(stDevice, 1);
        if (messageChannel == null) {
            StLog.d(TAG, "connectAp isBleServerConnected = false, so cannot send ap info by ble");
            return -2;
        }
        String networkName = this.mWifiApManager.getNetworkName();
        if (TextUtils.isEmpty(networkName)) {
            return -3;
        }
        StarryLinkEncrypt.WifiApInfo build = StarryLinkEncrypt.WifiApInfo.newBuilder().setSsid(networkName).build();
        StLog.d(TAG, "sendConnectApMsg");
        messageChannel.sendMsg(stDevice, StarryNetEncryptHelper.generateDisconnectAp(connectDevice.getCipher(), build.toByteArray(), connectDevice.getEncrypt()), 10);
        return 0;
    }

    public int getProfile() {
        return 12;
    }

    public boolean isApCreated() {
        return this.mWifiApManager.isApCreated();
    }

    public void onApClosed() {
        StLog.d(TAG, "onApClosed");
        StarryDeviceManager.getInstance().apClosed();
    }

    public void onApCreated(WiFiApInfo wiFiApInfo) {
        StLog.d(TAG, "onApCreated");
        sendMsg(wiFiApInfo);
        StarryDeviceManager.getInstance().apCreated(wiFiApInfo);
    }

    public void setCallback(IChannelCallback iChannelCallback) {
    }

    public void setDefaultPort(int i) {
        this.mDefaultPort = i;
    }
}
