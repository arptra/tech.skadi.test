package com.upuphone.starrynet.strategy.transfer;

import android.os.Bundle;
import com.upuphone.starrynet.api.bean.StMessage;
import com.upuphone.starrynet.api.manager.IStarryTransferManager;
import com.upuphone.starrynet.api.message.IMessageResponseListener;
import com.upuphone.starrynet.api.message.IReceiveMessageListener;
import com.upuphone.starrynet.api.message.IReceivePayloadMessageListener;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.message.MessageManager;
import com.upuphone.starrynet.strategy.message.MessageManagerV2;
import com.upuphone.starrynet.strategy.message.payload.PayloadMessage;
import com.upuphone.starrynet.strategy.message.payload.SimplePayloadMessageManager;

public class StarryNetTransferDataManager implements IStarryTransferManager {
    private static final String TAG = "StarryNetTransferDataManager";
    private MessageReceiver mMessageReceiver = new MessageReceiver();
    private SimplePayloadMessageManager mSimplePayloadMessageManager = SimplePayloadMessageManager.getInstance();

    public StarryNetTransferDataManager() {
        MessageManagerV2.getInstance().registerReceiveDataListener(this.mMessageReceiver);
    }

    public int getDeviceCharacterCategory(String str) {
        return MessageManagerV2.getInstance().getDeviceCharacterCategory(str);
    }

    public int getDeviceCharacterCategoryByIdt(byte[] bArr) {
        return MessageManagerV2.getInstance().getDeviceCharacterCategoryByIdt(bArr);
    }

    public void registerReceiveMessageListener(String str, IReceiveMessageListener iReceiveMessageListener) {
        MessageReceiver messageReceiver = this.mMessageReceiver;
        if (messageReceiver != null) {
            messageReceiver.registerReceiveMessageListener(str, iReceiveMessageListener);
        } else {
            StLog.e(TAG, "registerReceiveMessageListener ,but message receiver is null!!!");
        }
    }

    public void registerReceivePayloadMessageListener(IReceivePayloadMessageListener iReceivePayloadMessageListener) {
        this.mSimplePayloadMessageManager.registerReceivePayloadMessageListener(iReceivePayloadMessageListener);
    }

    public void sendMessage(Bundle bundle, IMessageResponseListener iMessageResponseListener) {
        MessageManager.getInstance().sendMessage(bundle, iMessageResponseListener);
    }

    public void sendPayloadMessage(Bundle bundle, IMessageResponseListener iMessageResponseListener) {
        StLog.d(TAG, "sendPayloadMessage");
        PayloadMessage parseBundle = PayloadMessage.parseBundle(bundle, iMessageResponseListener);
        if (parseBundle.getMsgType() == 2) {
            this.mSimplePayloadMessageManager.sendPayloadMessage(parseBundle);
        }
    }

    public int sendSyncMessage(StMessage stMessage) {
        return MessageManagerV2.getInstance().sendSyncMessage(stMessage);
    }

    public void unregisterReceiveMessageListener(String str) {
        MessageReceiver messageReceiver = this.mMessageReceiver;
        if (messageReceiver != null) {
            messageReceiver.unregisterReceiveMessageListener(str);
        } else {
            StLog.e(TAG, "unregisterReceiveMessageListener ,but message receiver is null!!!");
        }
    }
}
