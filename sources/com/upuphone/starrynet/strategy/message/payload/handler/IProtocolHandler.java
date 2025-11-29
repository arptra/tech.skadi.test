package com.upuphone.starrynet.strategy.message.payload.handler;

import androidx.core.util.Consumer;
import com.upuphone.starrynet.api.message.IReceivePayloadMessageListener;
import com.upuphone.starrynet.payload.PayloadProtocolMessage;
import com.upuphone.starrynet.strategy.message.payload.PayloadMessage;
import java.util.UUID;

public interface IProtocolHandler {
    UUID getCharacterUUID();

    int getDeviceType();

    UUID getServiceUUID();

    boolean handleCommonService(String str, UUID uuid, UUID uuid2, byte[] bArr);

    void handleMessage(PayloadMessage payloadMessage);

    void handleProtocolMessage(PayloadMessage payloadMessage, PayloadProtocolMessage payloadProtocolMessage);

    boolean isSupportCommonService();

    void receiveData(String str, byte[] bArr);

    void registerReceiveMessageListener(IReceivePayloadMessageListener iReceivePayloadMessageListener);

    void sendInternalMessage(String str, byte b, byte[] bArr, Consumer<byte[]> consumer);
}
