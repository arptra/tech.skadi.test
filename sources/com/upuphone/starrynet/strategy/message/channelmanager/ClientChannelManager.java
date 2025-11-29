package com.upuphone.starrynet.strategy.message.channelmanager;

import android.text.TextUtils;
import com.upuphone.starrynet.api.bean.StMessage;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.channel.ChannelCallback;
import com.upuphone.starrynet.core.ble.channel.ChannelManager;
import com.upuphone.starrynet.core.ble.channel.ChannelTag;
import com.upuphone.starrynet.core.ble.channel.SendChannel;
import com.upuphone.starrynet.core.ble.client.BleClientCache;
import com.upuphone.starrynet.core.ble.client.BleConnectManager;
import com.upuphone.starrynet.core.ble.client.response.BleWriteNoRespResponse;
import com.upuphone.starrynet.core.ble.event.BleEventBus;
import com.upuphone.starrynet.core.ble.event.CharacterChangedEvent;
import com.upuphone.starrynet.core.ble.event.ClientConnectChangeEvent;
import com.upuphone.starrynet.core.ble.event.EventReceiver;
import com.upuphone.starrynet.core.ble.manager.BleReceiveData;
import com.upuphone.starrynet.core.ble.manager.BleReceiveMsgManager;
import com.upuphone.starrynet.core.ble.manager.IBleDataReceiver;
import com.upuphone.starrynet.core.ble.manager.IBleMultiDataReceiver;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import com.upuphone.starrynet.strategy.message.MessageManagerV2;
import java.util.List;
import java.util.UUID;

public final class ClientChannelManager extends ChannelManager implements EventReceiver {
    private static final String TAG = "ClientChannelManager";
    private IBleDataReceiver mMultiMessageReceiver;
    private IBleDataReceiver mShortMessageReceiver;

    public static class Holder {
        public static final ClientChannelManager INSTANCE = new ClientChannelManager();

        private Holder() {
        }
    }

    public static void clearDMTU(String str) {
        if (!TextUtils.isEmpty(str)) {
            BleClientCache.getInstance().clearMtu(str);
        }
    }

    public static ClientChannelManager getInstance() {
        return Holder.INSTANCE;
    }

    private void onCharacterChanged(CharacterChangedEvent characterChangedEvent) {
        if (BluetoothConstants.STARRY_NET_SERVICE_UUID.equals(characterChangedEvent.getService())) {
            if (BluetoothConstants.STARRY_NET_AIR_EXTERNAL_MESSAGE_UUID.equals(characterChangedEvent.getCharacter()) || BluetoothConstants.STARRY_NET_AIR_INTERNAL_MESSAGE_UUID.equals(characterChangedEvent.getCharacter())) {
                SendChannel channel = getChannel(new ChannelTag(characterChangedEvent.getMac(), characterChangedEvent.getCharacter()));
                if (channel != null) {
                    channel.onRead(characterChangedEvent.getValue());
                } else {
                    BluetoothLog.error(TAG, "onCharacterChanged ,but cannot find bleMac(%s-%s)'s ble-channel", characterChangedEvent.getMac(), characterChangedEvent.getCharacter());
                }
            } else if (BluetoothConstants.STARRY_NET_MULTI_WRITE_UUID.equals(characterChangedEvent.getCharacter()) || BluetoothConstants.STARRY_NET_WRITE_MESSAGE_UUID.equals(characterChangedEvent.getCharacter())) {
                BleReceiveMsgManager.getInstance().receiveBleData(new BleReceiveData(true, characterChangedEvent.getMac(), characterChangedEvent.getCharacter(), characterChangedEvent.getValue()));
            } else if (BluetoothConstants.STARRY_NET_READ_CONFIG_UUID.equals(characterChangedEvent.getCharacter()) && characterChangedEvent.getValue()[0] == 1) {
                String mac = characterChangedEvent.getMac();
                BluetoothLog.log(TAG, "receive disconnect(%s) opcode from gatt server ,start disconnect!", mac);
                BleConnectManager.getInstance().disconnect(mac);
            }
        }
    }

    public int getDMTU(String str) {
        int mtuSize = BleClientCache.getInstance().getMtuSize(str);
        if (mtuSize < 5) {
            return 18;
        }
        return mtuSize - 5;
    }

    public boolean isClient() {
        return true;
    }

    public void onBleConnected(String str) {
        super.onBleConnected(str);
        BleReceiveMsgManager.getInstance().resetDispatcher(str);
        BleReceiveMsgManager.getInstance().registerBleDataReceiver(str, this.mMultiMessageReceiver);
        BleReceiveMsgManager.getInstance().registerBleDataReceiver(str, this.mShortMessageReceiver);
    }

    public void onBleDisconnected(String str) {
        super.onBleDisconnected(str);
        clearDMTU(str);
        BleReceiveMsgManager.getInstance().unregisterBleDataReceiver(str, this.mMultiMessageReceiver);
        BleReceiveMsgManager.getInstance().unregisterBleDataReceiver(str, this.mShortMessageReceiver);
        MessageManagerV2.getInstance().removeBleSender(str);
    }

    public void onClientConnectStatusChanged(ClientConnectChangeEvent clientConnectChangeEvent) {
        if (clientConnectChangeEvent.isConnected()) {
            onBleConnected(clientConnectChangeEvent.getMac());
        } else {
            onBleDisconnected(clientConnectChangeEvent.getMac());
        }
    }

    public void onEvent(Object obj) {
        if (obj instanceof CharacterChangedEvent) {
            onCharacterChanged((CharacterChangedEvent) obj);
        } else if (obj instanceof ClientConnectChangeEvent) {
            onClientConnectStatusChanged((ClientConnectChangeEvent) obj);
        }
    }

    public void receiveData(ChannelTag channelTag, byte[] bArr, int i) {
        if (BluetoothLog.isDetailMode()) {
            BluetoothLog.log(TAG, "onRead mac =%s,packageType=%d,value=%s", channelTag, Integer.valueOf(i), ByteUtils.byteToString(bArr));
        } else {
            BluetoothLog.log(TAG, "onRead mac =%s,packageType=%d,value length=%d", channelTag, Integer.valueOf(i), Integer.valueOf(bArr.length));
        }
        if (BluetoothConstants.STARRY_NET_AIR_EXTERNAL_MESSAGE_UUID.equals(channelTag.getCharacter())) {
            MessageManagerV2.getInstance().receiveStMessage(StMessage.buildReceiveStMessage(channelTag.getBleMac(), bArr, false, 2));
        }
    }

    public boolean useCrc32Verify() {
        return false;
    }

    public void writeBatchBleData(ChannelTag channelTag, List<byte[]> list, final ChannelCallback channelCallback) {
        BleConnectManager.getInstance().writeBatchNoRsp(channelTag.getBleMac(), BluetoothConstants.STARRY_NET_SERVICE_UUID, channelTag.getCharacter(), list, new BleWriteNoRespResponse() {
            public void onResponse(int i, Void voidR) {
                ChannelCallback channelCallback = channelCallback;
                if (channelCallback != null) {
                    channelCallback.onCallback(i);
                }
            }
        });
    }

    public void writeBle(ChannelTag channelTag, byte[] bArr, final ChannelCallback channelCallback, boolean z) {
        BleConnectManager.getInstance().writeNoRsp(channelTag.getBleMac(), BluetoothConstants.STARRY_NET_SERVICE_UUID, channelTag.getCharacter(), bArr, new BleWriteNoRespResponse() {
            public void onResponse(int i, Void voidR) {
                ChannelCallback channelCallback = channelCallback;
                if (channelCallback != null) {
                    channelCallback.onCallback(i);
                }
            }
        });
    }

    private ClientChannelManager() {
        this.mShortMessageReceiver = new IBleDataReceiver() {
            public UUID getFocusUuid() {
                return BluetoothConstants.STARRY_NET_WRITE_MESSAGE_UUID;
            }

            public boolean isClient() {
                return true;
            }

            public boolean isSticky() {
                return false;
            }

            public void receiveData(BleReceiveData bleReceiveData) {
                MessageManagerV2.getInstance().receiveStMessage(StMessage.buildReceiveStMessage(bleReceiveData.getRemoteBleMac(), bleReceiveData.getData(), false, 0));
            }
        };
        this.mMultiMessageReceiver = new IBleMultiDataReceiver() {
            public UUID getFocusUuid() {
                return BluetoothConstants.STARRY_NET_MULTI_WRITE_UUID;
            }

            public boolean isClient() {
                return true;
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
                SendChannel channel = ClientChannelManager.this.getChannel(bleReceiveData.getTag());
                ClientChannelManager clientChannelManager = ClientChannelManager.this;
                clientChannelManager.log("receiveData ,mac =" + bleReceiveData.getRemoteBleMac(), new Object[0]);
                if (channel != null) {
                    channel.onRead(bleReceiveData.getData());
                } else {
                    BluetoothLog.error(ClientChannelManager.TAG, "onCharacterChanged ,but cannot find bleMac(%s)'s ble-channel", bleReceiveData.getRemoteBleMac());
                }
            }
        };
        BleEventBus.get().register(ClientConnectChangeEvent.class, this);
        BleEventBus.get().register(CharacterChangedEvent.class, this);
    }
}
