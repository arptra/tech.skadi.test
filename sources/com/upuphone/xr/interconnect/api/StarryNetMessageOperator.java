package com.upuphone.xr.interconnect.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.entity.StarryNetRingMsgConfig;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import com.upuphone.xr.interconnect.listener.RingMessageReceiver;
import com.upuphone.xr.interconnect.listener.SendMessageListener;

public interface StarryNetMessageOperator {
    void registerMessageReceiver(@NonNull MessageReceiver messageReceiver);

    void registerRingMessageReceiver(@NonNull RingMessageReceiver ringMessageReceiver);

    @Deprecated
    void sendMessage(@NonNull StarryNetMessage starryNetMessage, @Nullable SendMessageListener sendMessageListener);

    String sendMessage2(@NonNull StarryNetMessage starryNetMessage, @Nullable SendMessageListener sendMessageListener);

    String sendRingMessage(StarryNetRingMsgConfig starryNetRingMsgConfig, @NonNull String str, byte[] bArr, @Nullable SendMessageListener sendMessageListener);

    void unregisterMessageReceiver(@NonNull MessageReceiver messageReceiver);

    void unregisterRingMessageReceiver(@NonNull RingMessageReceiver ringMessageReceiver);
}
