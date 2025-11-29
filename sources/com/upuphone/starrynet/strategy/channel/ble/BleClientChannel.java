package com.upuphone.starrynet.strategy.channel.ble;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.honey.account.z6.a;
import com.honey.account.z6.b;
import com.honey.account.z6.c;
import com.honey.account.z6.d;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.StTestConstant;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.tracker.TrackerManager;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.channel.ChannelTag;
import com.upuphone.starrynet.core.ble.channel.IBleChannelReader;
import com.upuphone.starrynet.core.ble.client.BleClientCache;
import com.upuphone.starrynet.core.ble.client.BleConnectConfig;
import com.upuphone.starrynet.core.ble.client.BleConnectManager;
import com.upuphone.starrynet.core.ble.client.response.BleConnectResponse;
import com.upuphone.starrynet.core.ble.event.BleEventBus;
import com.upuphone.starrynet.core.ble.event.ClientConnectChangeEvent;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.channel.IChannelCallback;
import com.upuphone.starrynet.strategy.channel.IMessageCallback;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.message.ISendMessageListener;
import com.upuphone.starrynet.strategy.message.MessageManager;
import com.upuphone.starrynet.strategy.message.StarryMessage;
import com.upuphone.starrynet.strategy.message.channelmanager.ClientChannelManager;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersionsCache;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BleClientChannel extends BleChannel implements IBleChannelReader {
    private static final String TAG = "BleClientChannel";
    private List<String> prepareConnectMacList = new ArrayList();

    public BleClientChannel() {
        BleEventBus.get().register(ClientConnectChangeEvent.class, this);
    }

    @NonNull
    private static BleConnectConfig getBleConnectConfig(@NonNull StDevice stDevice, String str) {
        BleConnectConfig bleConnectConfig = new BleConnectConfig(str);
        if ("1003".equals(stDevice.getModelID()) || "1004".equals(stDevice.getModelID())) {
            bleConnectConfig.activelyOpen2MPhy(true);
            if (StarryNetData.getInstance().getOwnDevice().getTerminalType() == 4) {
                bleConnectConfig.heartBeatUUID(BluetoothConstants.STARRY_NET_AIR_URGENT_EXTERNAL_MESSAGE_UUID);
            }
        }
        return bleConnectConfig;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$connectBle$0(StDevice stDevice, int i, Bundle bundle) {
        if (i != 0) {
            onConnectResult(stDevice, i, "connect ble fail");
            return;
        }
        StLog.i(TAG, "connectBle onResponse code = " + i + ", bundle = " + bundle);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$requestMtu$1(String str, int i, Integer num) {
        StLog.i(TAG, "requestMtu onResponse, code=%d,mtu=" + num, Integer.valueOf(i));
        if (i == 0) {
            BleClientCache.getInstance().updateMtu(str, num.intValue());
        } else {
            BleClientCache.getInstance().clearMtu(str);
        }
        StConnectDevice connectDeviceByBleMac = StarryDeviceManager.getInstance().getConnectDeviceByBleMac(str);
        if (connectDeviceByBleMac == null) {
            StLog.d(TAG, "onBleConnected device info is null");
            return;
        }
        connectDeviceByBleMac.setCharacterCategory(BleClientCache.getInstance().getCharacterCategory(str));
        IChannelCallback iChannelCallback = this.mCallback;
        if (iChannelCallback != null) {
            iChannelCallback.onConnected(connectDeviceByBleMac, this);
        }
    }

    private void onBleConnected(String str) {
        StLog.d(TAG, "onBleConnected addr = " + str);
        StLog.i(TAG, StTestConstant.POINT_BLE_CONNECT_CONNECTED);
        int characterCategory = BleClientCache.getInstance().getCharacterCategory(str);
        StConnectDevice connectDeviceByBleMac = StarryDeviceManager.getInstance().getConnectDeviceByBleMac(str);
        if (characterCategory == 2) {
            StLog.d(TAG, "exist air uuid");
            ClientChannelManager.getInstance().registerChannelReader(new ChannelTag(str, BluetoothConstants.STARRY_NET_AIR_INTERNAL_MESSAGE_UUID), this);
            openNotify(str, BluetoothConstants.STARRY_NET_AIR_EXTERNAL_MESSAGE_UUID);
        } else {
            ClientChannelManager.getInstance().registerChannelReader(new ChannelTag(str, BluetoothConstants.STARRY_NET_MULTI_WRITE_UUID), this);
            openNotify4Message(str);
        }
        requestMtu(str);
        if (connectDeviceByBleMac == null || !connectDeviceByBleMac.isBleConnected()) {
            StarryDeviceManager.getInstance().bleConnectForDiscovery(str, true);
            this.mConnectedCache.add(str);
            return;
        }
        StLog.d(TAG, "ble already connected, not report");
    }

    private void onBleDisconnected(String str, int i) {
        StLog.i(TAG, "onBleDisconnected mac = " + str);
        this.mConnectedCache.remove(str);
        BleClientCache.getInstance().putReadyClient(str, false);
        StConnectDevice connectDeviceByBleMac = StarryDeviceManager.getInstance().getConnectDeviceByBleMac(str);
        if (connectDeviceByBleMac != null) {
            trackDisconnect(connectDeviceByBleMac, i);
            ProtocolVersionsCache.remove(connectDeviceByBleMac.getIdentifier2String());
            if (connectDeviceByBleMac.getBleBondStatus() != 4) {
                StarryDeviceManager.getInstance().updateBondInfo(connectDeviceByBleMac, 0);
            }
            IChannelCallback iChannelCallback = this.mCallback;
            if (iChannelCallback != null) {
                iChannelCallback.onDisconnected(connectDeviceByBleMac, this);
            }
        } else {
            StLog.i(TAG, "onBleDisconnected device info is null");
        }
        StarryDeviceManager.getInstance().bleConnectForDiscovery(str, false);
    }

    private void onConnectResult(StDevice stDevice, int i, String str) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (i == 0) {
            this.mCallback.onConnected(connectDevice, this);
            return;
        }
        StLog.i(TAG, "onConnectResult error " + str);
        if (connectDevice == null || stDevice.getBleMac().equals(connectDevice.getBleMac())) {
            StarryDeviceManager.getInstance().connectFail(stDevice, StErrorCode.CONNECT_STRATEGY_BLE_CONNECT_FAIL, 1);
        } else {
            StLog.i(TAG, "onConnectResult ble mac change");
        }
    }

    private void openNotify(String str, UUID uuid) {
        BleConnectManager.getInstance().notify(str, BluetoothConstants.STARRY_NET_SERVICE_UUID, uuid, new d(uuid));
    }

    private void openNotify4Message(String str) {
        BleConnectManager.getInstance().notify(str, BluetoothConstants.STARRY_NET_SERVICE_UUID, BluetoothConstants.STARRY_NET_WRITE_MESSAGE_UUID, new a());
    }

    private void requestMtu(String str) {
        StLog.i(TAG, "start request mtu");
        BleConnectManager.getInstance().requestMtu(str, 512, new b(this, str));
    }

    private void trackDisconnect(StConnectDevice stConnectDevice, int i) {
        boolean z;
        if (!stConnectDevice.isBleConnected()) {
            return;
        }
        if (stConnectDevice.getTerminalType() != 3 || stConnectDevice.getConnectVersion() <= 2) {
            if (!BluetoothUtils.isBluetoothEnabled()) {
                z = false;
                i = -5;
            } else {
                z = stConnectDevice.isBtConnected();
            }
            TrackerManager.getInstance().getBluetoothDisconnectTracker().bleDisconnectResult(stConnectDevice.getTerminalType(), stConnectDevice.getIdentifier2String(), i).isBtOn(z).peerModelID(stConnectDevice.getModelID()).startReport();
        }
    }

    public int connect(StDevice stDevice) {
        StDiscoveryDevice discoveryDevice = StarryDeviceManager.getInstance().getDiscoveryDevice(stDevice.getIdentifier());
        if (discoveryDevice == null || TextUtils.isEmpty(discoveryDevice.getBleMac())) {
            StLog.i(TAG, "connect device mac is null");
            return StErrorCode.CONNECT_STRATEGY_BLE_CONNECT_PARAM_ERROR;
        }
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice == null || !connectDevice.isBleConnected()) {
            StDevice clone = discoveryDevice.clone();
            StLog.d(TAG, "connect device = " + clone);
            connectBle(clone);
            this.prepareConnectMacList.add(clone.getBleMac());
            return 0;
        }
        StLog.i(TAG, "connect device is connected");
        return StErrorCode.CONNECT_STRATEGY_BLE_CONNECTED;
    }

    public synchronized void connectBle(@NonNull StDevice stDevice) {
        StLog.i(TAG, "connectBle " + stDevice);
        String bleMac = stDevice.getBleMac();
        if (BluetoothUtils.isBleDeviceConnected(bleMac)) {
            if (StarryNetData.getInstance().getOwnDevice().getTerminalType() != 4) {
                onConnectResult(stDevice, -13, "device had connected");
                return;
            }
            StLog.i(TAG, "third device, ignore device connected,continue connect ble");
        }
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice == null) {
            connectDevice = new StConnectDevice();
        }
        connectDevice.setDevice(stDevice);
        connectDevice.setDeviceType((byte) 1);
        StarryDeviceManager.getInstance().updateBondInfo(connectDevice);
        StLog.i(TAG, "connectBle add device " + connectDevice);
        BleConnectManager.getInstance().connect(getBleConnectConfig(stDevice, bleMac), (BleConnectResponse) new c(this, stDevice));
    }

    public int disconnect(StDevice stDevice) {
        StLog.i(TAG, "disconnect device = " + stDevice);
        BleConnectManager.getInstance().disconnect(stDevice.getBleMac());
        return 0;
    }

    public int getProfile() {
        return 1;
    }

    public /* bridge */ /* synthetic */ boolean isConnected(String str) {
        return super.isConnected(str);
    }

    public void onBleClientConnectChangeEvent(ClientConnectChangeEvent clientConnectChangeEvent) {
        String mac = clientConnectChangeEvent.getMac();
        if (!TextUtils.isEmpty(mac)) {
            if (!clientConnectChangeEvent.isConnected()) {
                BleClientCache.getInstance().clearCharacterCategory(mac);
                if (this.prepareConnectMacList.remove(mac)) {
                    onBleDisconnected(mac, clientConnectChangeEvent.getGattStatus());
                }
            } else if (!this.prepareConnectMacList.contains(mac)) {
                StLog.w(TAG, "%s connected, but operator is not %s, then ignore it!", mac, TAG);
            } else {
                onBleConnected(mac);
            }
        }
    }

    public void onEvent(Object obj) {
        if (obj instanceof ClientConnectChangeEvent) {
            onBleClientConnectChangeEvent((ClientConnectChangeEvent) obj);
        }
    }

    public void onRead(ChannelTag channelTag, byte[] bArr, int i) {
        if (!BluetoothConstants.STARRY_NET_AIR_EXTERNAL_MESSAGE_UUID.equals(channelTag.getCharacter())) {
            StConnectDevice connectDeviceByBleMac = StarryDeviceManager.getInstance().getConnectDeviceByBleMac(channelTag.getBleMac());
            IChannelCallback iChannelCallback = this.mCallback;
            if (iChannelCallback != null) {
                iChannelCallback.onRecv(connectDeviceByBleMac, bArr, getMsgType(i), this);
            }
        }
    }

    public /* bridge */ /* synthetic */ int sendMsg(StDevice stDevice, byte[] bArr) {
        return super.sendMsg(stDevice, bArr);
    }

    public /* bridge */ /* synthetic */ void setCallback(IChannelCallback iChannelCallback) {
        super.setCallback(iChannelCallback);
    }

    public /* bridge */ /* synthetic */ int sendMsg(StDevice stDevice, byte[] bArr, int i) {
        return super.sendMsg(stDevice, bArr, i);
    }

    public /* bridge */ /* synthetic */ int sendMsg(StDevice stDevice, byte[] bArr, int i, IMessageCallback iMessageCallback) {
        return super.sendMsg(stDevice, bArr, i, iMessageCallback);
    }

    public /* bridge */ /* synthetic */ int sendMsg(StDevice stDevice, byte[] bArr, IMessageCallback iMessageCallback) {
        return super.sendMsg(stDevice, bArr, iMessageCallback);
    }

    public int sendMsg(StDevice stDevice, boolean z, byte[] bArr, int i, IMessageCallback iMessageCallback) {
        final int i2 = i;
        final byte[] bArr2 = bArr;
        final boolean z2 = z;
        final IMessageCallback iMessageCallback2 = iMessageCallback;
        MessageManager.getInstance().sendInnerBleClientMultipleMessage(stDevice, z, getCTR(i), bArr2, new ISendMessageListener() {
            public void onSendFail(StarryMessage starryMessage, int i, String str) {
                Integer valueOf = Integer.valueOf(i2);
                Integer valueOf2 = Integer.valueOf(bArr2.length);
                Boolean valueOf3 = Boolean.valueOf(z2);
                Integer valueOf4 = Integer.valueOf(i);
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                StLog.w(BleClientChannel.TAG, "sendMsg (msgType =%d, data length =%d, withAck = %s) fail (code=%d, msg=%s)", valueOf, valueOf2, valueOf3, valueOf4, str);
                IMessageCallback iMessageCallback = iMessageCallback2;
                if (iMessageCallback != null) {
                    iMessageCallback.onResult(i);
                }
            }

            public void onSendSuccess(StarryMessage starryMessage) {
                StLog.d(BleClientChannel.TAG, "sendMsg (msgType =%d, data length =%d, withAck = %s) success", Integer.valueOf(i2), Integer.valueOf(bArr2.length), Boolean.valueOf(z2));
                IMessageCallback iMessageCallback = iMessageCallback2;
                if (iMessageCallback != null) {
                    iMessageCallback.onResult(0);
                }
            }
        });
        return 0;
    }
}
