package com.upuphone.starrynet.strategy.channel.ble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattServer;
import android.text.TextUtils;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.api.bean.StMessage;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.channel.ChannelTag;
import com.upuphone.starrynet.core.ble.channel.IBleChannelReader;
import com.upuphone.starrynet.core.ble.client.BleClientCache;
import com.upuphone.starrynet.core.ble.event.BleEventBus;
import com.upuphone.starrynet.core.ble.event.BleMessageEvent;
import com.upuphone.starrynet.core.ble.event.BleOpenNotifyEvent;
import com.upuphone.starrynet.core.ble.event.ServerConnectChangeEvent;
import com.upuphone.starrynet.core.ble.manager.BleReceiveData;
import com.upuphone.starrynet.core.ble.manager.BleReceiveMsgManager;
import com.upuphone.starrynet.core.ble.manager.IBleDataReceiver;
import com.upuphone.starrynet.core.ble.server.BleServerCache;
import com.upuphone.starrynet.core.ble.server.BleServerManager;
import com.upuphone.starrynet.core.ble.server.handler.ICharacterHandler;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IChannelCallback;
import com.upuphone.starrynet.strategy.channel.IMessageCallback;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.encrypt.StarryNetEncryptHelper;
import com.upuphone.starrynet.strategy.message.ISendMessageListener;
import com.upuphone.starrynet.strategy.message.MessageManager;
import com.upuphone.starrynet.strategy.message.MessageManagerV2;
import com.upuphone.starrynet.strategy.message.StarryMessage;
import com.upuphone.starrynet.strategy.message.channelmanager.ServerChannelManager;
import com.upuphone.starrynet.strategy.pair.StarryNetPairUtil;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersionsCache;
import java.util.UUID;

@SuppressLint({"MissingPermission"})
public class BleServerChannel extends BleChannel implements ICharacterHandler, IBleChannelReader {
    private static final String TAG = "BleServerChannel";
    private IBleDataReceiver mShortMessageReceiver = new IBleDataReceiver() {
        public UUID getFocusUuid() {
            return BluetoothConstants.STARRY_NET_WRITE_MESSAGE_UUID;
        }

        public boolean isClient() {
            return false;
        }

        public boolean isSticky() {
            return false;
        }

        public void receiveData(BleReceiveData bleReceiveData) {
            MessageManagerV2.getInstance().receiveStMessage(StMessage.buildReceiveStMessage(bleReceiveData.getRemoteBleMac(), bleReceiveData.getData(), false, 0));
        }
    };

    public BleServerChannel() {
        BleEventBus.get().register(ServerConnectChangeEvent.class, this);
        BleEventBus.get().register(BleOpenNotifyEvent.class, this);
    }

    private void handleIOSNotificationEvent(boolean z, BleOpenNotifyEvent bleOpenNotifyEvent) {
        StLog.d(TAG, "handleIOSNotificationEvent enable =%s, event =%s", Boolean.valueOf(z), bleOpenNotifyEvent);
        StConnectDevice connectDeviceByBleMac = StarryDeviceManager.getInstance().getConnectDeviceByBleMac(bleOpenNotifyEvent.getMac());
        if (connectDeviceByBleMac == null || connectDeviceByBleMac.getTerminalType() != 6) {
            if (connectDeviceByBleMac == null) {
                StLog.w(TAG, "receive  notification event, device is null");
            } else {
                StLog.w(TAG, "receive  notification event, device =%s, or terminal type= %d", connectDeviceByBleMac.getDeviceName(), Byte.valueOf(connectDeviceByBleMac.getTerminalType()));
            }
        } else if (BleServerCache.getInstance().isServerPhysicsConnected(bleOpenNotifyEvent.getMac())) {
            int isServerLogicConnected4IOS = BleServerCache.getInstance().isServerLogicConnected4IOS(bleOpenNotifyEvent.getMac());
            StLog.d(TAG, "handleIOSNotificationEvent enable =%s, logic connection state =%d", Boolean.valueOf(z), Integer.valueOf(isServerLogicConnected4IOS));
            if (z) {
                if (isServerLogicConnected4IOS == 0 && isIOSCanDisableNotification(bleOpenNotifyEvent.getCharacter())) {
                    BleServerCache.getInstance().updateServerLogicConnected4IOS(bleOpenNotifyEvent.getMac(), true);
                    onBleConnected(bleOpenNotifyEvent.getMac());
                }
            } else if (isServerLogicConnected4IOS <= 0 || !isIOSCanDisableNotification(bleOpenNotifyEvent.getCharacter())) {
                StLog.w(TAG, "receiveOpenNotifyEvent server logic disconnected, so no need to disconnect it again.");
            } else {
                onBleDisconnected(bleOpenNotifyEvent.getMac());
                BleServerCache.getInstance().updateServerLogicConnected4IOS(bleOpenNotifyEvent.getMac(), false);
            }
        } else {
            StLog.w(TAG, "receiveOpenNotifyEvent server(%s) is disconnected, so ignore disable notification!", bleOpenNotifyEvent.getMac());
        }
    }

    private boolean isIOSCanDisableNotification(UUID uuid) {
        return BluetoothConstants.STARRY_NET_WRITE_MESSAGE_UUID.equals(uuid) || BluetoothConstants.STARRY_NET_MULTI_WRITE_UUID.equals(uuid);
    }

    private void onBleConnected(String str) {
        StLog.d(TAG, "onBleConnected mac = " + str);
        this.mConnectedCache.add(str);
        StarryDeviceManager.getInstance().bleConnectForDiscovery(str, true);
    }

    private void onBleDisconnected(String str) {
        BleServerCache.getInstance().clearCharacterCategory(str);
        if (!this.mConnectedCache.remove(str)) {
            StLog.w(TAG, "onBleDisconnected mac =%s, cannot found connect record, so ignore it's disconnect event!", str);
            return;
        }
        StLog.d(TAG, "onBleDisconnected mac = " + str);
        BleReceiveMsgManager.getInstance().unregisterBleDataReceiver(str, this.mShortMessageReceiver);
        StConnectDevice connectDeviceByBleMac = StarryDeviceManager.getInstance().getConnectDeviceByBleMac(str);
        if (connectDeviceByBleMac != null) {
            ProtocolVersionsCache.remove(connectDeviceByBleMac.getIdentifier2String());
            IChannelCallback iChannelCallback = this.mCallback;
            if (iChannelCallback != null) {
                iChannelCallback.onDisconnected(connectDeviceByBleMac, this);
            }
        }
        StarryDeviceManager.getInstance().bleConnectForDiscovery(str, false);
    }

    private void onStarryNetData(BluetoothDevice bluetoothDevice, byte[] bArr, int i) {
        StConnectDevice connectDeviceByBleMac = StarryDeviceManager.getInstance().getConnectDeviceByBleMac(bluetoothDevice.getAddress());
        if (connectDeviceByBleMac == null) {
            connectDeviceByBleMac = new StConnectDevice();
            connectDeviceByBleMac.setBleMac(bluetoothDevice.getAddress());
            connectDeviceByBleMac.setDeviceName(bluetoothDevice.getName());
            connectDeviceByBleMac.setDeviceType((byte) 1);
        }
        connectDeviceByBleMac.setBleMac(bluetoothDevice.getAddress());
        if (connectDeviceByBleMac.getCharacterCategory() < 0) {
            connectDeviceByBleMac.setCharacterCategory(BleServerCache.getInstance().getCharacterCategory(bluetoothDevice.getAddress()));
        }
        IChannelCallback iChannelCallback = this.mCallback;
        if (iChannelCallback != null) {
            iChannelCallback.onRecv(connectDeviceByBleMac, bArr, getMsgType(i), this);
        }
    }

    private void onStarryNetMessage(byte[] bArr) {
        BleEventBus.get().post(new BleMessageEvent(bArr));
    }

    private void receiveOpenNotifyEvent(BleOpenNotifyEvent bleOpenNotifyEvent) {
        boolean isEnable = bleOpenNotifyEvent.isEnable();
        if (isEnable) {
            BleServerCache.getInstance().updateOpenNotifyUUID(bleOpenNotifyEvent.getMac(), bleOpenNotifyEvent.getCharacter());
            if (BluetoothConstants.STARRY_NET_AIR_INTERNAL_MESSAGE_UUID.equals(bleOpenNotifyEvent.getCharacter()) || BluetoothConstants.STARRY_NET_MULTI_WRITE_UUID.equals(bleOpenNotifyEvent.getCharacter())) {
                StLog.d(TAG, "receiveOpenNotifyEvent ,uuid =" + bleOpenNotifyEvent.getCharacter());
                ServerChannelManager.getInstance().registerChannelReader(new ChannelTag(bleOpenNotifyEvent.getMac(), bleOpenNotifyEvent.getCharacter()), this);
            } else if (BluetoothConstants.STARRY_NET_WRITE_MESSAGE_UUID.equals(bleOpenNotifyEvent.getCharacter())) {
                BleReceiveMsgManager.getInstance().registerBleDataReceiver(bleOpenNotifyEvent.getMac(), this.mShortMessageReceiver);
            }
        }
        handleIOSNotificationEvent(isEnable, bleOpenNotifyEvent);
    }

    public int connect(StDevice stDevice) {
        StLog.d(TAG, "connect device = " + stDevice);
        return StErrorCode.CONNECT_STRATEGY_BLE_OPERATE_NOT_SUPPORT;
    }

    public int disconnect(StDevice stDevice) {
        if (stDevice == null) {
            return 0;
        }
        if (!ProtocolVersionsCache.isSupportBleVersionV2Plus(stDevice.getIdentifier2String())) {
            StLog.d(TAG, "not ble version v2+, disconnect device = " + stDevice);
            BleServerManager.getInstance().disconnect(stDevice.getBleMac());
        } else {
            byte[] bleServerRequestClientDisconnectConnection = StarryNetEncryptHelper.bleServerRequestClientDisconnectConnection();
            StLog.d(TAG, "support ble version v2+, sendMsg to disconnect");
            sendMsg(stDevice, bleServerRequestClientDisconnectConnection, 10);
        }
        return 0;
    }

    public int getProfile() {
        return 2;
    }

    public void init() {
        BleServerManager.getInstance().addServices(new BleConnectGattCharacterService(this, ServerChannelManager.getInstance()));
    }

    public /* bridge */ /* synthetic */ boolean isConnected(String str) {
        return super.isConnected(str);
    }

    public void onBleServerConnectChangeEvent(ServerConnectChangeEvent serverConnectChangeEvent) {
        String mac = serverConnectChangeEvent.getMac();
        if (!TextUtils.isEmpty(mac)) {
            if (BleClientCache.getInstance().isExternalDevice(mac)) {
                StLog.w(TAG, "check device(%s) is external device , then ignore it connection state.", mac);
            } else if (serverConnectChangeEvent.isConnected()) {
                onBleConnected(mac);
            } else {
                BleServerCache.getInstance().clearServerLogicConnected4IOS(mac);
                onBleDisconnected(mac);
            }
        }
    }

    public void onCharacteristicReadRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice bluetoothDevice, UUID uuid, int i) {
        if (BluetoothConstants.STARRY_NET_GLASS_WRITE_UUID.equals(uuid)) {
            StLog.d(TAG, "BleCharacterHandler onCharacteristicReadRequest from 0x2023 ,is Star");
            bluetoothGattServer.sendResponse(bluetoothDevice, i, 0, 0, new byte[]{1});
            return;
        }
        StLog.d(TAG, "BleCharacterHandler onCharacteristicReadRequest uuid =" + uuid);
        byte[] handleBleBondReq = StarryNetPairUtil.handleBleBondReq(bluetoothDevice.getAddress());
        if (handleBleBondReq != null) {
            bluetoothGattServer.sendResponse(bluetoothDevice, i, 0, 0, handleBleBondReq);
            return;
        }
        StLog.d(TAG, "masterValue ERROR");
        bluetoothGattServer.cancelConnection(bluetoothDevice);
    }

    public void onCharacteristicWriteRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice bluetoothDevice, UUID uuid, int i, byte[] bArr) {
        if (BluetoothConstants.STARRY_NET_WRITE_MESSAGE_UUID.equals(uuid)) {
            BleReceiveMsgManager.getInstance().receiveBleData(new BleReceiveData(false, bluetoothDevice.getAddress(), uuid, bArr));
        }
    }

    public void onEvent(Object obj) {
        if (obj instanceof ServerConnectChangeEvent) {
            onBleServerConnectChangeEvent((ServerConnectChangeEvent) obj);
        } else if (obj instanceof BleOpenNotifyEvent) {
            receiveOpenNotifyEvent((BleOpenNotifyEvent) obj);
        }
    }

    public void onRead(ChannelTag channelTag, byte[] bArr, int i) {
        StLog.d(TAG, "onRead tag=%s, packageType=%d", channelTag, Integer.valueOf(i));
        BluetoothDevice remoteDevice = BluetoothUtils.getRemoteDevice(channelTag.getBleMac());
        if (remoteDevice != null) {
            onStarryNetData(remoteDevice, bArr, i);
        } else {
            StLog.w(TAG, "something may be wrong ,cannot find bluetoothDevice by mac(%s)", channelTag.toString());
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
        MessageManager.getInstance().sendInnerBleServerMultipleMessage(stDevice, z, getCTR(i), bArr2, new ISendMessageListener() {
            public void onSendFail(StarryMessage starryMessage, int i, String str) {
                Integer valueOf = Integer.valueOf(i2);
                Integer valueOf2 = Integer.valueOf(bArr2.length);
                Boolean valueOf3 = Boolean.valueOf(z2);
                Integer valueOf4 = Integer.valueOf(i);
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                StLog.w(BleServerChannel.TAG, "sendMsg (msgType =%d, data length =%d, withAck = %s) fail (code=%d, msg=%s)", valueOf, valueOf2, valueOf3, valueOf4, str);
                IMessageCallback iMessageCallback = iMessageCallback2;
                if (iMessageCallback != null) {
                    iMessageCallback.onResult(i);
                }
            }

            public void onSendSuccess(StarryMessage starryMessage) {
                StLog.d(BleServerChannel.TAG, "sendMsg (msgType =%d, data length =%d, withAck = %s) success", Integer.valueOf(i2), Integer.valueOf(bArr2.length), Boolean.valueOf(z2));
                IMessageCallback iMessageCallback = iMessageCallback2;
                if (iMessageCallback != null) {
                    iMessageCallback.onResult(0);
                }
            }
        });
        return 0;
    }
}
