package com.upuphone.starrynet.strategy.message;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.util.Pair;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.channel.ChannelTag;
import com.upuphone.starrynet.core.ble.channel.IBleChannelWriter;
import com.upuphone.starrynet.core.ble.client.BleClientCache;
import com.upuphone.starrynet.core.ble.client.BleConnectManager;
import com.upuphone.starrynet.core.ble.client.response.BleResponse;
import com.upuphone.starrynet.core.ble.client.response.BleWriteNoRespResponse;
import com.upuphone.starrynet.core.ble.server.BleServerCache;
import com.upuphone.starrynet.core.ble.server.BleServerManager;
import com.upuphone.starrynet.core.ble.server.reponse.BleNotificationResponse;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.message.channelmanager.ClientChannelManager;
import com.upuphone.starrynet.strategy.message.channelmanager.ServerChannelManager;

public class BleMessageSender implements IMessageSender {
    private static final String TAG = "BleMessageSender";

    private void sendLongMessage(StarryMessage starryMessage, ISendMessageListener iSendMessageListener) {
        IBleChannelWriter iBleChannelWriter;
        ChannelTag channelTag = new ChannelTag(starryMessage.getPeerBleMac(), BluetoothConstants.STARRY_NET_MULTI_WRITE_UUID);
        if (StarryNetData.getInstance().isBleServer()) {
            iBleChannelWriter = ServerChannelManager.getInstance().getWriterByMac(channelTag);
        } else {
            String peerBleMac = starryMessage.getPeerBleMac();
            if (peerBleMac != null) {
                iBleChannelWriter = ClientChannelManager.getInstance().getWriterByMac(channelTag);
                if (iBleChannelWriter == null) {
                    String format = String.format("ble mac(%s)'s channel writer is null", new Object[]{peerBleMac});
                    StLog.e(TAG, format);
                    onCallback(starryMessage, iSendMessageListener, 2, format);
                    return;
                }
            } else {
                String format2 = String.format("cannot found starry device by iendtifier[] =" + starryMessage.getIdentifier(), new Object[0]);
                StLog.e(TAG, format2);
                onCallback(starryMessage, iSendMessageListener, 1, format2);
                return;
            }
        }
        if (iBleChannelWriter != null) {
            byte[] content = starryMessage.getContent();
            int packetType = starryMessage.getPacketType();
            final long currentTimeMillis = System.currentTimeMillis();
            StLog.d(TAG, "start send long message, content length=%d ", Integer.valueOf(content.length));
            final StarryMessage starryMessage2 = starryMessage;
            final ISendMessageListener iSendMessageListener2 = iSendMessageListener;
            iBleChannelWriter.writeWithOpCode(starryMessage.getOpCode(), content, packetType, new BleResponse<Bundle>() {
                public void onResponse(int i, Bundle bundle) {
                    StLog.d(BleMessageSender.TAG, "send long message code=%d ,cost time = (%d)ms, wait time =%d(ms)", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(starryMessage2.getWaitTime()));
                    ISendMessageListener iSendMessageListener = iSendMessageListener2;
                    if (iSendMessageListener == null) {
                        return;
                    }
                    if (i == 0) {
                        iSendMessageListener.onSendSuccess(starryMessage2);
                    } else {
                        iSendMessageListener.onSendFail(starryMessage2, i, bundle != null ? bundle.toString() : "");
                    }
                }
            });
            return;
        }
        StLog.e(TAG, "channel writer is null");
        onCallback(starryMessage, iSendMessageListener, 2, "channel writer is null");
    }

    private void sendShortMessage(StarryMessage starryMessage, ISendMessageListener iSendMessageListener) {
        StLog.d(TAG, "start send short message, content length=%d", Integer.valueOf(starryMessage.getContent().length));
        if (starryMessage.isMessageFromServer()) {
            final long currentTimeMillis = System.currentTimeMillis();
            final StarryMessage starryMessage2 = starryMessage;
            final ISendMessageListener iSendMessageListener2 = iSendMessageListener;
            BleServerManager.getInstance().sendNotification(starryMessage.getPeerBleMac(), BluetoothConstants.STARRY_NET_WRITE_MESSAGE_UUID, starryMessage.getContent(), new BleNotificationResponse() {
                public void onResponse(int i, Void voidR) {
                    StLog.d(BleMessageSender.TAG, "send notification onResponse ,code=%d, cost time=%d(ms), wait time=%d(ms)", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(starryMessage2.getWaitTime()));
                    ISendMessageListener iSendMessageListener = iSendMessageListener2;
                    if (iSendMessageListener == null) {
                        return;
                    }
                    if (i == 0) {
                        iSendMessageListener.onSendSuccess(starryMessage2);
                    } else {
                        iSendMessageListener.onSendFail(starryMessage2, i, voidR != null ? voidR.toString() : "");
                    }
                }
            });
            return;
        }
        final long currentTimeMillis2 = System.currentTimeMillis();
        final StarryMessage starryMessage3 = starryMessage;
        final ISendMessageListener iSendMessageListener3 = iSendMessageListener;
        BleConnectManager.getInstance().writeNoRsp(starryMessage.getPeerBleMac(), BluetoothConstants.STARRY_NET_SERVICE_UUID, BluetoothConstants.STARRY_NET_WRITE_MESSAGE_UUID, starryMessage.getContent(), new BleWriteNoRespResponse() {
            public void onResponse(int i, Void voidR) {
                StLog.d(BleMessageSender.TAG, "write noResp code = %d, cost time=%d(ms), wait time=%d(ms).", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), Long.valueOf(starryMessage3.getWaitTime()));
                ISendMessageListener iSendMessageListener = iSendMessageListener3;
                if (iSendMessageListener == null) {
                    return;
                }
                if (i == 0) {
                    iSendMessageListener.onSendSuccess(starryMessage3);
                } else {
                    iSendMessageListener.onSendFail(starryMessage3, i, voidR != null ? voidR.toString() : "");
                }
            }
        });
    }

    public String getBleClientMac(byte[] bArr) {
        StDevice device = StarryDeviceManager.getInstance().getDevice(bArr);
        if (device != null) {
            return device.getBleMac();
        }
        return null;
    }

    public void onCallback(StarryMessage starryMessage, ISendMessageListener iSendMessageListener, int i, String str) {
        if (iSendMessageListener != null) {
            iSendMessageListener.onSendFail(starryMessage, i, str);
        }
    }

    public Pair<Integer, String> preCheck(StarryMessage starryMessage) {
        if (!StarryNetData.getInstance().isBleServer()) {
            String bleClientMac = getBleClientMac(starryMessage.getId());
            if (TextUtils.isEmpty(bleClientMac)) {
                return new Pair<>(5, "cannot find starry device ,mac is empty!");
            }
            if (!BleClientCache.getInstance().isClientReady(bleClientMac)) {
                return new Pair<>(4, "gatt client not connected or not ready!!");
            }
            return null;
        } else if (!BleServerCache.getInstance().isServerPhysicsConnected(starryMessage.getPeerBleMac())) {
            return new Pair<>(3, "gatt server is disconnected");
        } else {
            return null;
        }
    }

    public void sendMessage(StarryMessage starryMessage, ISendMessageListener iSendMessageListener) {
        if (starryMessage.isShortMessage()) {
            sendShortMessage(starryMessage, iSendMessageListener);
        } else if (starryMessage.isLongMessage()) {
            sendLongMessage(starryMessage, iSendMessageListener);
        } else {
            StLog.e(TAG, "message is not short or long ,may be not execute prepare().");
        }
    }

    public void sendShortMessageAtOnce(final StarryMessage starryMessage) {
        StLog.d(TAG, "start sendShortMessageAtOnce, content length=%d", Integer.valueOf(starryMessage.getContent().length));
        if (starryMessage.isMessageFromServer()) {
            final long currentTimeMillis = System.currentTimeMillis();
            BleServerManager.getInstance().sendNotificationAtOnce(starryMessage.getPeerBleMac(), BluetoothConstants.STARRY_NET_WRITE_MESSAGE_UUID, starryMessage.getContent(), new BleNotificationResponse() {
                public void onResponse(int i, Void voidR) {
                    StLog.d(BleMessageSender.TAG, "send notification onResponse ,code= %d, send cost time (%d)ms ,wait time =%d(ms)", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(starryMessage.getWaitTime()));
                }
            });
            return;
        }
        final long currentTimeMillis2 = System.currentTimeMillis();
        BleConnectManager.getInstance().writeNoRspAtOnce(starryMessage.getPeerBleMac(), BluetoothConstants.STARRY_NET_SERVICE_UUID, BluetoothConstants.STARRY_NET_WRITE_MESSAGE_UUID, starryMessage.getContent(), new BleWriteNoRespResponse() {
            public void onResponse(int i, Void voidR) {
                StLog.d(BleMessageSender.TAG, "write noResp cost time(ms) =%d, wait time=%d(ms)", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), Long.valueOf(starryMessage.getWaitTime()));
            }
        });
    }
}
