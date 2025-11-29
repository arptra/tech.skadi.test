package com.upuphone.starrynet.strategy.message.channelmanager;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattServer;
import com.upuphone.starrynet.api.bean.StMessage;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.channel.ChannelCallback;
import com.upuphone.starrynet.core.ble.channel.ChannelManager;
import com.upuphone.starrynet.core.ble.channel.ChannelTag;
import com.upuphone.starrynet.core.ble.channel.SendChannel;
import com.upuphone.starrynet.core.ble.client.BleClientCache;
import com.upuphone.starrynet.core.ble.event.BleEventBus;
import com.upuphone.starrynet.core.ble.event.BleMessageEvent;
import com.upuphone.starrynet.core.ble.event.EventReceiver;
import com.upuphone.starrynet.core.ble.event.ServerConnectChangeEvent;
import com.upuphone.starrynet.core.ble.manager.BleReceiveData;
import com.upuphone.starrynet.core.ble.manager.BleReceiveMsgManager;
import com.upuphone.starrynet.core.ble.manager.IBleDataReceiver;
import com.upuphone.starrynet.core.ble.manager.IBleMultiDataReceiver;
import com.upuphone.starrynet.core.ble.server.BleServerCache;
import com.upuphone.starrynet.core.ble.server.BleServerManager;
import com.upuphone.starrynet.core.ble.server.handler.IMultipleCharacterHandler;
import com.upuphone.starrynet.core.ble.server.reponse.BleNotificationResponse;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import com.upuphone.starrynet.strategy.message.MessageManagerV2;
import java.util.List;
import java.util.UUID;

public final class ServerChannelManager extends ChannelManager implements EventReceiver, IMultipleCharacterHandler {
    private static final String TAG = "ServerChannelManager";
    private IBleDataReceiver mMultiMessageReceiver;

    public static class Holder {
        public static final ServerChannelManager INSTANCE = new ServerChannelManager();
    }

    public static ServerChannelManager getInstance() {
        return Holder.INSTANCE;
    }

    public int getDMTU(String str) {
        return BleServerCache.getInstance().getMtu(str) - 5;
    }

    public boolean isClient() {
        return false;
    }

    public void onBleConnected(String str) {
        super.onBleConnected(str);
        BleReceiveMsgManager.getInstance().resetDispatcher(str);
        BleReceiveMsgManager.getInstance().registerBleDataReceiver(str, this.mMultiMessageReceiver);
    }

    public void onBleDisconnected(String str) {
        super.onBleDisconnected(str);
        BleServerCache.getInstance().clearMtu(str);
        BleReceiveMsgManager.getInstance().unregisterBleDataReceiver(str, this.mMultiMessageReceiver);
        MessageManagerV2.getInstance().removeBleSender(str);
    }

    public void onCharacteristicReadRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice bluetoothDevice, UUID uuid, int i) {
    }

    public void onCharacteristicWriteRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice bluetoothDevice, UUID uuid, int i, byte[] bArr) {
        if (BluetoothConstants.STARRY_NET_MULTI_WRITE_UUID.equals(uuid)) {
            BleReceiveMsgManager.getInstance().receiveBleData(new BleReceiveData(false, bluetoothDevice.getAddress(), uuid, bArr));
            return;
        }
        SendChannel sendChannel = this.mChannels.get(new ChannelTag(bluetoothDevice.getAddress(), uuid));
        if (sendChannel != null) {
            sendChannel.onRead(bArr);
        } else {
            BluetoothLog.error(TAG, "onReceive gatt server data,but channel is null", new Object[0]);
        }
    }

    public void onEvent(Object obj) {
        if (obj instanceof ServerConnectChangeEvent) {
            ServerConnectChangeEvent serverConnectChangeEvent = (ServerConnectChangeEvent) obj;
            if (!BleClientCache.getInstance().isExternalDevice(serverConnectChangeEvent.getMac())) {
                if (!serverConnectChangeEvent.isConnected()) {
                    onBleDisconnected(serverConnectChangeEvent.getMac());
                } else {
                    onBleConnected(serverConnectChangeEvent.getMac());
                }
            }
        }
    }

    public void receiveData(ChannelTag channelTag, byte[] bArr, int i) {
        if (BluetoothLog.isDetailMode()) {
            BluetoothLog.log(TAG, "onRead(收到client的消息） uuid =%s,packageType=%d,value=%s", channelTag, Integer.valueOf(i), ByteUtils.byteToString(bArr));
        } else {
            BluetoothLog.log(TAG, "onRead(收到client的消息） uuid =%s,packageType=%d,length=%d", channelTag, Integer.valueOf(i), Integer.valueOf(bArr.length));
        }
        if (BluetoothConstants.STARRY_NET_AIR_EXTERNAL_MESSAGE_UUID.equals(channelTag.getCharacter())) {
            MessageManagerV2.getInstance().receiveStMessage(StMessage.buildReceiveStMessage(channelTag.getBleMac(), bArr, false, 2));
        }
    }

    public boolean useCrc32Verify() {
        return false;
    }

    public void writeBatchBleData(ChannelTag channelTag, List<byte[]> list, final ChannelCallback channelCallback) {
        BleServerManager.getInstance().sendBatchNotifications(channelTag.getBleMac(), channelTag.getCharacter(), list, new BleNotificationResponse() {
            public void onResponse(int i, Void voidR) {
                ChannelCallback channelCallback = channelCallback;
                if (channelCallback != null) {
                    channelCallback.onCallback(i);
                }
            }
        });
    }

    public void writeBle(ChannelTag channelTag, byte[] bArr, final ChannelCallback channelCallback, boolean z) {
        BleServerManager.getInstance().sendNotification(channelTag.getBleMac(), channelTag.getCharacter(), bArr, new BleNotificationResponse() {
            public void onResponse(int i, Void voidR) {
                ChannelCallback channelCallback = channelCallback;
                if (channelCallback != null) {
                    channelCallback.onCallback(i);
                }
            }
        });
    }

    private ServerChannelManager() {
        this.mMultiMessageReceiver = new IBleMultiDataReceiver() {
            public UUID getFocusUuid() {
                return BluetoothConstants.STARRY_NET_MULTI_WRITE_UUID;
            }

            public boolean isClient() {
                return false;
            }

            public boolean isSticky() {
                return true;
            }

            public void onReceiveFullData(String str, int i, byte[] bArr) {
                if (i == 0 || i == 1) {
                    MessageManagerV2.getInstance().receiveStMessage(StMessage.buildReceiveStMessage(str, bArr, false, 0));
                }
            }

            public void receiveData(BleReceiveData bleReceiveData) {
                SendChannel sendChannel = (SendChannel) ServerChannelManager.this.mChannels.get(new ChannelTag(bleReceiveData.getRemoteBleMac(), BluetoothConstants.STARRY_NET_MULTI_WRITE_UUID));
                if (sendChannel != null) {
                    sendChannel.onRead(bleReceiveData.getData());
                } else {
                    BluetoothLog.error(ServerChannelManager.TAG, "onReceive gatt server data,but channel is null", new Object[0]);
                }
            }
        };
        BleEventBus.get().register(ServerConnectChangeEvent.class, this);
        BleEventBus.get().register(BleMessageEvent.class, this);
    }
}
