package com.upuphone.starrynet.strategy.message;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.core.util.Pair;
import com.honey.account.g7.c;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.api.bean.StMessage;
import com.upuphone.starrynet.api.message.IMessageResponseListener;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.client.BleClientCache;
import com.upuphone.starrynet.core.ble.listener.IReceiveBleDataListener;
import com.upuphone.starrynet.core.ble.server.BleServerCache;
import com.upuphone.starrynet.core.ble.utils.MessageHandlerThread;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersionsCache;

public class MessageManagerV2 {
    private static final String TAG = "MessageManagerV2";
    private ArrayMap<String, Integer> id2CharacterCategoryMap;
    private IMessageSender mBleMessageSender;
    private IBleMsgSender mBleSenderAir;
    private ArrayMap<String, IBleMsgSender> mBleSenderMap;
    private IBleMsgSender mBleSenderOld;
    private Handler mHandler;
    private IReceiveBleDataListener mIReceiveDataListener;
    private volatile boolean mIsSendingMsg;
    private MessageHandler mMessageHandler;
    private Handler mResponseHandler;
    private IBleMsgSender mSppSender;

    public static class Holder {
        public static final MessageManagerV2 INSTANCE = new MessageManagerV2();

        private Holder() {
        }
    }

    private int commonCheck(StMessage stMessage) {
        byte[] content = stMessage.getContent();
        if (content == null || content.length == 0) {
            StLog.w(TAG, "StMessage content byte[] is null or length is 0, code =7");
            return 7;
        }
        String bleMac = stMessage.getBleMac();
        if (TextUtils.isEmpty(bleMac)) {
            StDevice device = StarryDeviceManager.getInstance().getDevice(stMessage.getIdentifier());
            if (device != null) {
                device.getBleMac();
                bleMac = device.getBleMac();
                stMessage.setBleMac(bleMac);
            } else {
                StLog.w(TAG, "cannot find starry device ,mac is empty!, code = 5");
                return 5;
            }
        }
        if (StarryNetData.getInstance().isBleServer()) {
            if (BleServerCache.getInstance().isServerPhysicsConnected(stMessage.getBleMac())) {
                return 0;
            }
            StLog.w(TAG, "gatt server is disconnected, bleMac =%s, code = %d", stMessage.getBleMac(), 3);
            return 3;
        } else if (BleClientCache.getInstance().isClientReady(bleMac)) {
            return 0;
        } else {
            StLog.w(TAG, "gatt client not connected or not ready!! code = 4");
            return 4;
        }
    }

    private IBleMsgSender getBleSender(String str, String str2) {
        IBleMsgSender iBleMsgSender;
        IBleMsgSender iBleMsgSender2;
        IBleMsgSender iBleMsgSender3 = (IBleMsgSender) this.mBleSenderMap.get(str);
        if (iBleMsgSender3 != null) {
            return iBleMsgSender3;
        }
        if (StarryNetData.getInstance().isBleServer()) {
            int characterCategory = BleServerCache.getInstance().getCharacterCategory(str);
            if (characterCategory == 2) {
                StLog.d(TAG, "server bleSender (%s) is BleSenderAir", str);
                this.id2CharacterCategoryMap.put(str2, 2);
                iBleMsgSender2 = this.mBleSenderAir;
            } else if (characterCategory == 0) {
                StLog.d(TAG, "server bleSender (%s) is BleSenderV1", str);
                this.id2CharacterCategoryMap.put(str2, 0);
                iBleMsgSender2 = this.mBleSenderOld;
            } else {
                StLog.w(TAG, "ble server need wait sometime, message category not ready");
                return null;
            }
            this.mBleSenderMap.put(str, iBleMsgSender2);
            return iBleMsgSender2;
        }
        int characterCategory2 = BleClientCache.getInstance().getCharacterCategory(str);
        if (characterCategory2 == 2) {
            StLog.d(TAG, "client bleSender (%s) is BleSenderAir", str);
            this.id2CharacterCategoryMap.put(str2, 2);
            iBleMsgSender = this.mBleSenderAir;
        } else if (characterCategory2 == 0) {
            StLog.d(TAG, "client bleSender (%s) is BleSenderV1", str);
            this.id2CharacterCategoryMap.put(str2, 0);
            iBleMsgSender = this.mBleSenderOld;
        } else {
            StLog.w(TAG, "ble client need wait sometime, message category not ready");
            return null;
        }
        this.mBleSenderMap.put(str, iBleMsgSender);
        return iBleMsgSender;
    }

    public static MessageManagerV2 getInstance() {
        return Holder.INSTANCE;
    }

    private boolean isSupportBleVersionV2(StDevice stDevice) {
        return ProtocolVersionsCache.isSupportBleVersionV2Plus(stDevice.getIdentifier2String());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$receiveStMessage$0(StMessage stMessage) {
        IReceiveBleDataListener iReceiveBleDataListener = this.mIReceiveDataListener;
        if (iReceiveBleDataListener != null) {
            iReceiveBleDataListener.receiveStMessage(stMessage);
        } else {
            StLog.e(TAG, "receiveStMessage, but mIReceiveDataListener is null ,need registerReceiveDataListener method, so cannot relay message!!!");
        }
    }

    public int getDeviceCharacterCategory(String str) {
        int characterCategory = BleClientCache.getInstance().getCharacterCategory(str);
        return characterCategory < 0 ? BleServerCache.getInstance().getCharacterCategory(str) : characterCategory;
    }

    public int getDeviceCharacterCategoryByIdt(byte[] bArr) {
        String bytes2HexString = StDevice.bytes2HexString(bArr);
        Integer num = (Integer) this.id2CharacterCategoryMap.get(bytes2HexString);
        if (num != null) {
            return num.intValue();
        }
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(bArr);
        if (connectDevice == null) {
            return -1;
        }
        int deviceCharacterCategory = getDeviceCharacterCategory(connectDevice.getBleMac());
        if (deviceCharacterCategory >= 0) {
            this.id2CharacterCategoryMap.put(bytes2HexString, Integer.valueOf(deviceCharacterCategory));
        }
        return deviceCharacterCategory;
    }

    public void onCallback(IMessageResponseListener iMessageResponseListener, int i, String str) {
        if (iMessageResponseListener != null) {
            iMessageResponseListener.onFail(i, str);
        }
    }

    public void receiveStMessage(StMessage stMessage) {
        if (stMessage == null) {
            StLog.i(TAG, "receiveStMessage decode message failed, ignore..");
        } else {
            this.mHandler.post(new c(this, stMessage));
        }
    }

    public void registerReceiveDataListener(IReceiveBleDataListener iReceiveBleDataListener) {
        this.mIReceiveDataListener = iReceiveBleDataListener;
    }

    public void removeBleSender(String str) {
        this.mBleSenderMap.remove(str);
        StConnectDevice connectDeviceByBleMac = StarryDeviceManager.getInstance().getConnectDeviceByBleMac(str);
        if (connectDeviceByBleMac != null) {
            this.id2CharacterCategoryMap.remove(connectDeviceByBleMac.getIdentifier2String());
            return;
        }
        this.id2CharacterCategoryMap.clear();
        StLog.w(TAG, "removeBleSender , StConnectDevice is null");
    }

    public void sendInnerBleClientMultipleMessage(StDevice stDevice, boolean z, int i, byte[] bArr, ISendMessageListener iSendMessageListener) {
        if (bArr == null) {
            StLog.e(TAG, "sendInnerBleServerMultipleMessage, msgType=%d,data is null", Integer.valueOf(i));
            return;
        }
        int mtuSize = BleClientCache.getInstance().getMtuSize(stDevice.getBleMac());
        if (mtuSize > 0) {
            final int i2 = (mtuSize + -7 < bArr.length || !isSupportBleVersionV2(stDevice)) ? z ? 1 : 2 : z ? 4 : 5;
            StLog.d(TAG, "sendInnerBleClientMultipleMessage, opCode=%d, msgType=%d,data length=%d", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(bArr.length));
            final StDevice stDevice2 = stDevice;
            final int i3 = i;
            final byte[] bArr2 = bArr;
            final ISendMessageListener iSendMessageListener2 = iSendMessageListener;
            this.mHandler.post(new Runnable() {
                public void run() {
                    StarryMessage buildInnerBleClientMultipleMessage = StarryMessage.buildInnerBleClientMultipleMessage(stDevice2, i2, i3, bArr2, iSendMessageListener2);
                    int sendSyncMessage = MessageManagerV2.this.sendSyncMessage(buildInnerBleClientMultipleMessage);
                    ISendMessageListener iSendMessageListener = iSendMessageListener2;
                    if (iSendMessageListener == null) {
                        StLog.w(MessageManagerV2.TAG, "buildInnerBleClientMultipleMessage listener is null");
                    } else if (sendSyncMessage == 0) {
                        iSendMessageListener.onSendSuccess(buildInnerBleClientMultipleMessage);
                    } else {
                        iSendMessageListener.onSendFail(buildInnerBleClientMultipleMessage, sendSyncMessage, "");
                    }
                }
            });
            return;
        }
        StLog.e(TAG, "sendInnerBleClientMultipleMessage mtu is zero , ble mac =" + stDevice.getBleMac());
    }

    public void sendInnerBleServerMultipleMessage(StDevice stDevice, boolean z, int i, byte[] bArr, ISendMessageListener iSendMessageListener) {
        if (bArr == null) {
            StLog.e(TAG, "sendInnerBleServerMultipleMessage, msgType=%d,data is null", Integer.valueOf(i));
            return;
        }
        int mtu = BleServerCache.getInstance().getMtu(stDevice.getBleMac());
        if (mtu > 0) {
            final int i2 = (mtu + -7 < bArr.length || !isSupportBleVersionV2(stDevice)) ? z ? 1 : 2 : z ? 4 : 5;
            StLog.d(TAG, "sendInnerBleServerMultipleMessage, opCode=%d, msgType=%d,data length=%d", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(bArr.length));
            final StDevice stDevice2 = stDevice;
            final int i3 = i;
            final byte[] bArr2 = bArr;
            final ISendMessageListener iSendMessageListener2 = iSendMessageListener;
            this.mHandler.post(new Runnable() {
                public void run() {
                    StarryMessage buildInnerBleServerMultipleMessage = StarryMessage.buildInnerBleServerMultipleMessage(stDevice2, i2, i3, bArr2, iSendMessageListener2);
                    int sendSyncMessage = MessageManagerV2.this.sendSyncMessage(buildInnerBleServerMultipleMessage);
                    ISendMessageListener iSendMessageListener = iSendMessageListener2;
                    if (iSendMessageListener == null) {
                        StLog.w(MessageManagerV2.TAG, "buildInnerBleServerMultipleMessage listener is null");
                    } else if (sendSyncMessage == 0) {
                        iSendMessageListener.onSendSuccess(buildInnerBleServerMultipleMessage);
                    } else {
                        iSendMessageListener.onSendFail(buildInnerBleServerMultipleMessage, sendSyncMessage, "");
                    }
                }
            });
            return;
        }
        StLog.e(TAG, "sendInnerBleServerMultipleMessage mtu is zero , ble mac =" + stDevice.getBleMac());
    }

    public void sendMessage(Bundle bundle, IMessageResponseListener iMessageResponseListener) {
        StarryMessage parse = this.mMessageHandler.parse(bundle, iMessageResponseListener);
        Pair<Integer, String> preCheck = this.mBleMessageSender.preCheck(parse);
        if (preCheck == null) {
            int sendSyncMessage = sendSyncMessage(parse);
            if (sendSyncMessage == 0) {
                if (iMessageResponseListener != null) {
                    iMessageResponseListener.onSuccess();
                }
            } else if (iMessageResponseListener != null) {
                iMessageResponseListener.onFail(sendSyncMessage, "");
            }
        } else {
            onCallback(iMessageResponseListener, ((Integer) preCheck.f847a).intValue(), (String) preCheck.b);
        }
    }

    public int sendSppMessage(StMessage stMessage) {
        StarryMessage starryMessage = new StarryMessage(stMessage);
        int deviceCharacterCategoryByIdt = getDeviceCharacterCategoryByIdt(stMessage.getIdentifier());
        if (deviceCharacterCategoryByIdt < 0) {
            return 9;
        }
        if (deviceCharacterCategoryByIdt == 2) {
            starryMessage.setSppMsgType((byte) 2);
        } else {
            starryMessage.setSppMsgType((byte) 1);
        }
        return this.mSppSender.sendSyncMessage(starryMessage);
    }

    public int sendSyncMessage(StarryMessage starryMessage) {
        IBleMsgSender bleSender = getBleSender(starryMessage.getPeerBleMac(), starryMessage.getIdentifier());
        if (bleSender == null) {
            return 9;
        }
        return bleSender.sendSyncMessage(starryMessage);
    }

    private MessageManagerV2() {
        this.mIsSendingMsg = false;
        this.mHandler = null;
        this.mResponseHandler = null;
        this.mBleSenderOld = new BleMessageSenderV1();
        this.mBleSenderAir = new BleMessageSender4Air();
        this.mSppSender = new SppMsgSender();
        this.mBleSenderMap = new ArrayMap<>();
        this.id2CharacterCategoryMap = new ArrayMap<>();
        MessageHandlerThread messageHandlerThread = new MessageHandlerThread(TAG);
        messageHandlerThread.start();
        MessageHandlerThread messageHandlerThread2 = new MessageHandlerThread("ResponseThread");
        messageHandlerThread2.start();
        this.mHandler = new Handler(messageHandlerThread.getLooper());
        this.mResponseHandler = new Handler(messageHandlerThread2.getLooper());
        this.mMessageHandler = new MessageHandler();
        this.mBleMessageSender = new BleMessageSender();
    }

    public int sendSyncMessage(StMessage stMessage) {
        if (stMessage == null) {
            StLog.w(TAG, "StMessage is null, code=6");
            return 6;
        }
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stMessage.getIdentifier());
        if (connectDevice != null && stMessage.getTargetChannel() == 32 && connectDevice.isSppChannelOpen()) {
            return sendSppMessage(stMessage);
        }
        int commonCheck = commonCheck(stMessage);
        if (commonCheck != 0) {
            return commonCheck;
        }
        StarryMessage starryMessage = new StarryMessage(stMessage);
        IBleMsgSender bleSender = getBleSender(starryMessage.getPeerBleMac(), starryMessage.getIdentifier());
        if (bleSender == null) {
            return 9;
        }
        int sendSyncMessage = bleSender.sendSyncMessage(starryMessage);
        StLog.d(TAG, "sendSyncMessage result =" + sendSyncMessage);
        return sendSyncMessage;
    }
}
