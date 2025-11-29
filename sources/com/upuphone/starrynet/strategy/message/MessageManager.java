package com.upuphone.starrynet.strategy.message;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.honey.account.g7.a;
import com.honey.account.g7.b;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.api.bean.StMessage;
import com.upuphone.starrynet.api.message.IMessageResponseListener;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.listener.IReceiveBleDataListener;
import com.upuphone.starrynet.core.ble.utils.MessageHandlerThread;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersionsCache;
import java.util.ArrayList;
import java.util.List;

public final class MessageManager implements ISendMessageListener {
    private static final int MSG_ADD_AND_SEND_MESSAGE = 4;
    private static final int MSG_ADD_MESSAGE = 1;
    private static final int MSG_SEND_MESSAGE = 2;
    private static final int MSG_SEND_MESSAGE_AT_ONCE = 3;
    private static final String TAG = "MessageManager";
    /* access modifiers changed from: private */
    public IMessageSender mBleMessageSender;
    private Handler mHandler;
    IReceiveBleDataListener mIReceiveBleDataListener;
    /* access modifiers changed from: private */
    public volatile boolean mIsSendingMsg;
    private MessageHandler mMessageHandler;
    /* access modifiers changed from: private */
    public List<StarryMessage> mRequests;
    private Handler mResponseHandler;

    public static class Holder {
        public static final MessageManager INSTANCE = new MessageManager();

        private Holder() {
        }
    }

    private void addMessageInQueue(StarryMessage starryMessage) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, starryMessage));
    }

    private void doNextRequest() {
        this.mHandler.sendEmptyMessage(2);
    }

    /* access modifiers changed from: private */
    public void doSend() {
        this.mIsSendingMsg = true;
        this.mBleMessageSender.sendMessage(this.mRequests.remove(0), this);
    }

    public static MessageManager getInstance() {
        return Holder.INSTANCE;
    }

    private boolean isSupportBleVersionV2(StDevice stDevice) {
        return ProtocolVersionsCache.isSupportBleVersionV2Plus(stDevice.getIdentifier2String());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onSendFail$1(StarryMessage starryMessage, int i, String str) {
        if (starryMessage.getListener() != null) {
            onCallback(starryMessage.getListener(), i, str);
        } else if (starryMessage.getInnerMessageListener() != null) {
            starryMessage.getInnerMessageListener().onSendFail(starryMessage, i, str);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onSendSuccess$0(StarryMessage starryMessage) {
        if (starryMessage.getListener() != null) {
            starryMessage.getListener().onSuccess();
        } else if (starryMessage.getInnerMessageListener() != null) {
            starryMessage.getInnerMessageListener().onSendSuccess(starryMessage);
        }
    }

    public void onCallback(IMessageResponseListener iMessageResponseListener, int i, String str) {
        if (iMessageResponseListener != null) {
            iMessageResponseListener.onFail(i, str);
        }
    }

    public void onSendFail(StarryMessage starryMessage, int i, String str) {
        this.mIsSendingMsg = false;
        doNextRequest();
        this.mResponseHandler.post(new a(this, starryMessage, i, str));
    }

    public void onSendSuccess(StarryMessage starryMessage) {
        this.mIsSendingMsg = false;
        doNextRequest();
        this.mResponseHandler.post(new b(starryMessage));
    }

    public void receiveData(final byte[] bArr) {
        this.mResponseHandler.post(new Runnable() {
            public void run() {
                IReceiveBleDataListener iReceiveBleDataListener = MessageManager.this.mIReceiveBleDataListener;
                if (iReceiveBleDataListener != null) {
                    iReceiveBleDataListener.receiveData(bArr);
                } else {
                    StLog.e(MessageManager.TAG, "receiveData, but mIReceiveBleDataListener is null ,need registerReceiveBleDataListener method, so cannot relay message!!!");
                }
            }
        });
    }

    public void registerReceiveBleDataListener(IReceiveBleDataListener iReceiveBleDataListener) {
        this.mIReceiveBleDataListener = iReceiveBleDataListener;
    }

    public void sendInnerBleClientMultipleMessage(StDevice stDevice, boolean z, int i, byte[] bArr, ISendMessageListener iSendMessageListener) {
        MessageManagerV2.getInstance().sendInnerBleClientMultipleMessage(stDevice, z, i, bArr, iSendMessageListener);
    }

    public void sendInnerBleServerMultipleMessage(StDevice stDevice, boolean z, int i, byte[] bArr, ISendMessageListener iSendMessageListener) {
        MessageManagerV2.getInstance().sendInnerBleServerMultipleMessage(stDevice, z, i, bArr, iSendMessageListener);
    }

    public void sendMessage(Bundle bundle, IMessageResponseListener iMessageResponseListener) {
        MessageManagerV2.getInstance().sendMessage(bundle, iMessageResponseListener);
    }

    public int sendSyncMessage(StMessage stMessage) {
        return 0;
    }

    private MessageManager() {
        this.mRequests = new ArrayList();
        this.mIsSendingMsg = false;
        this.mHandler = null;
        this.mResponseHandler = null;
        MessageHandlerThread messageHandlerThread = new MessageHandlerThread(TAG);
        messageHandlerThread.start();
        MessageHandlerThread messageHandlerThread2 = new MessageHandlerThread("ResponseThread");
        messageHandlerThread2.start();
        this.mHandler = new Handler(messageHandlerThread.getLooper()) {
            public void handleMessage(@NonNull Message message) {
                int i = message.what;
                if (i == 1) {
                    MessageManager.this.mRequests.add((StarryMessage) message.obj);
                } else if (i != 2) {
                    if (i == 3) {
                        MessageManager.this.mBleMessageSender.sendShortMessageAtOnce((StarryMessage) message.obj);
                    } else if (i == 4) {
                        MessageManager.this.mRequests.add((StarryMessage) message.obj);
                        if (MessageManager.this.mIsSendingMsg) {
                            StLog.d(MessageManager.TAG, "doNextRequest ,but has a sending message ,wait soon... current requests queue size=" + MessageManager.this.mRequests.size());
                            return;
                        }
                        MessageManager.this.doSend();
                    }
                } else if (!MessageManager.this.mRequests.isEmpty()) {
                    if (MessageManager.this.mIsSendingMsg) {
                        StLog.d(MessageManager.TAG, "doNextRequest ,but has a sending message ,wait soon... current requests queue size=" + MessageManager.this.mRequests.size());
                        return;
                    }
                    MessageManager.this.doSend();
                }
            }
        };
        this.mResponseHandler = new Handler(messageHandlerThread2.getLooper());
        this.mMessageHandler = new MessageHandler();
        this.mBleMessageSender = new BleMessageSender();
    }
}
