package com.upuphone.starrynet.api.manager;

import android.os.Bundle;
import com.upuphone.starrynet.api.bean.StMessage;
import com.upuphone.starrynet.api.message.IMessageResponseListener;
import com.upuphone.starrynet.api.message.IReceiveMessageListener;
import com.upuphone.starrynet.api.message.IReceivePayloadMessageListener;

public interface IStarryTransferManager {
    int getDeviceCharacterCategory(String str);

    int getDeviceCharacterCategoryByIdt(byte[] bArr);

    void registerReceiveMessageListener(String str, IReceiveMessageListener iReceiveMessageListener);

    void registerReceivePayloadMessageListener(IReceivePayloadMessageListener iReceivePayloadMessageListener);

    void sendMessage(Bundle bundle, IMessageResponseListener iMessageResponseListener);

    void sendPayloadMessage(Bundle bundle, IMessageResponseListener iMessageResponseListener);

    int sendSyncMessage(StMessage stMessage);

    void unregisterReceiveMessageListener(String str);
}
