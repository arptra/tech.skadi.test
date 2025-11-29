package com.upuphone.starrynet.strategy.channel;

import android.util.SparseArray;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.ap.ApChannel;
import com.upuphone.starrynet.strategy.channel.ap.StaChannel;
import com.upuphone.starrynet.strategy.channel.ble.BleClientChannel;
import com.upuphone.starrynet.strategy.channel.ble.BleServerChannel;
import com.upuphone.starrynet.strategy.channel.bredr.BrEdrMasterChannel;
import com.upuphone.starrynet.strategy.channel.bredr.BrEdrSlaveChannel;
import com.upuphone.starrynet.strategy.channel.p2p.GcChannel;
import com.upuphone.starrynet.strategy.channel.p2p.GoChannel;
import com.upuphone.starrynet.strategy.channel.simpleble.MyvuRingBleClientChannel;
import com.upuphone.starrynet.strategy.channel.simpleble.RingBleClientChannel;
import com.upuphone.starrynet.strategy.channel.spp.SppClientChannel;
import com.upuphone.starrynet.strategy.channel.spp.SppServerChannel;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.protocol.IProtocol;

public final class StarryNetChannelManager extends SysActionManager.StateChangeSimpleCallback implements IChannelCallback {
    private static final String TAG = "StarryNetChannelManager";
    private final SparseArray<IConnectChannel> mChannelMap;
    private final SparseArray<IProtocol> mProtocolMap;

    public static class Holder {
        /* access modifiers changed from: private */
        public static final StarryNetChannelManager INSTANCE = new StarryNetChannelManager();

        private Holder() {
        }
    }

    private int getConnectProfile(int i) {
        if (i == 1 || 22 == i || 25 == i) {
            return 2;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 10) {
            return 4;
        }
        if (i == 11) {
            return 8;
        }
        if (i == 12) {
            return 16;
        }
        if (i == 13) {
            return 32;
        }
        if (i == 20 || i == 21) {
            return 64;
        }
        if (i == 23) {
            return 2048;
        }
        if (i == 24) {
            return 1024;
        }
        return i;
    }

    public static StarryNetChannelManager getInstance() {
        return Holder.INSTANCE;
    }

    private void loadChannel() {
        byte terminalType = StarryNetData.getInstance().getOwnDevice().getTerminalType();
        if (terminalType == 4) {
            this.mChannelMap.put(1, new BleClientChannel());
            this.mChannelMap.put(20, new BrEdrMasterChannel());
            this.mChannelMap.put(23, new SppClientChannel());
            this.mChannelMap.put(25, new MyvuRingBleClientChannel());
            this.mChannelMap.put(10, new GoChannel());
            return;
        }
        this.mChannelMap.put(2, new BleServerChannel());
        this.mChannelMap.put(11, new GcChannel());
        if (terminalType == 1 || terminalType == 9) {
            this.mChannelMap.put(1, new BleClientChannel());
            this.mChannelMap.put(10, new GoChannel());
            this.mChannelMap.put(12, new ApChannel());
            this.mChannelMap.put(13, new StaChannel());
            this.mChannelMap.put(20, new BrEdrMasterChannel());
            this.mChannelMap.put(23, new SppClientChannel());
            this.mChannelMap.put(25, new MyvuRingBleClientChannel());
            return;
        }
        if (terminalType == 2) {
            this.mChannelMap.put(13, new StaChannel());
            this.mChannelMap.put(22, new RingBleClientChannel());
            this.mChannelMap.put(24, new SppServerChannel());
        } else if (terminalType == 3) {
            this.mChannelMap.put(12, new ApChannel());
            this.mChannelMap.put(10, new GoChannel());
        }
        this.mChannelMap.put(21, new BrEdrSlaveChannel());
    }

    private void setCallback() {
        int size = this.mChannelMap.size();
        for (int i = 0; i < size; i++) {
            this.mChannelMap.valueAt(i).setCallback(this);
        }
    }

    public void addProtocol(IProtocol iProtocol) {
        this.mProtocolMap.put(iProtocol.getProfile(), iProtocol);
    }

    public IConnectChannel getConnectChannel(int i) {
        return this.mChannelMap.get(i);
    }

    public IMessageChannel getMessageChannel(StDevice stDevice, int i) {
        IProtocol iProtocol = this.mProtocolMap.get(i);
        if (iProtocol == null) {
            return null;
        }
        return iProtocol.getMessageChannel(stDevice);
    }

    public IStarryNetChannel getStarryNetChannel(int i) {
        IConnectChannel iConnectChannel = this.mChannelMap.get(i);
        if (iConnectChannel instanceof IStarryNetChannel) {
            return (IStarryNetChannel) iConnectChannel;
        }
        return null;
    }

    public void onBrEdrBondStateChange(StConnectDevice stConnectDevice, int i, int i2) {
        IProtocol iProtocol = this.mProtocolMap.get(stConnectDevice.getDeviceType());
        if (iProtocol != null) {
            iProtocol.onBrEdrBondStateChange(stConnectDevice, i, i2);
        }
    }

    public void onConnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel) {
        StLog.d(TAG, "onConnected " + stConnectDevice);
        if (stConnectDevice != null) {
            IProtocol iProtocol = this.mProtocolMap.get(stConnectDevice.getDeviceType());
            if (iProtocol == null || !iProtocol.onConnected(stConnectDevice, iConnectChannel)) {
                onConnected(stConnectDevice, getConnectProfile(iConnectChannel.getProfile()));
            }
        }
    }

    public void onDisconnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel) {
        StLog.d(TAG, "onDisconnected " + stConnectDevice);
        if (stConnectDevice != null) {
            IProtocol iProtocol = this.mProtocolMap.get(stConnectDevice.getDeviceType());
            if (iProtocol == null || !iProtocol.onDisconnected(stConnectDevice, iConnectChannel)) {
                int connectProfile = getConnectProfile(iConnectChannel.getProfile());
                if (!stConnectDevice.isProtocolConnected(connectProfile)) {
                    StLog.d(TAG, "onDisconnected connectDevice is not connected profile = " + connectProfile);
                    return;
                }
                onDisconnected(stConnectDevice, connectProfile);
            }
        }
    }

    public void onRecv(StConnectDevice stConnectDevice, byte[] bArr, int i, IStarryNetChannel iStarryNetChannel) {
        IProtocol iProtocol = this.mProtocolMap.get(stConnectDevice.getDeviceType());
        if (iProtocol != null) {
            iProtocol.onRecv(stConnectDevice, bArr, i, iStarryNetChannel);
        }
    }

    private StarryNetChannelManager() {
        this.mChannelMap = new SparseArray<>();
        this.mProtocolMap = new SparseArray<>();
        try {
            loadChannel();
            setCallback();
        } catch (Exception e) {
            StLog.e(TAG, "Exception = ", (Throwable) e);
        }
    }

    private void onConnected(StConnectDevice stConnectDevice, int i) {
        if (stConnectDevice == null) {
            StLog.d(TAG, "onBleServerConnected connectDevice is null");
        } else {
            StarryDeviceManager.getInstance().deviceConnected(stConnectDevice, i);
        }
    }

    private void onDisconnected(StConnectDevice stConnectDevice, int i) {
        if (stConnectDevice == null) {
            StLog.d(TAG, "onBleServerDisconnected connectDevice is null");
        } else {
            StarryDeviceManager.getInstance().deviceDisconnected(stConnectDevice, i);
        }
    }
}
