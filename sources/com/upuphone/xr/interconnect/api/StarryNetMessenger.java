package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.common.IMessageSendListener;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.entity.StarryNetRingMsgConfig;

public interface StarryNetMessenger {
    boolean canSendMessage(String str);

    int getDeviceMsgVersion(String str);

    void sendMessage(StarryNetMessage starryNetMessage, IMessageSendListener iMessageSendListener);

    void sendMessage(String str, String str2, String str3, String str4, byte[] bArr, IMessageSendListener iMessageSendListener);

    int sendMessageRequireId(StarryNetMessage starryNetMessage, IMessageSendListener iMessageSendListener);

    int sendRingMessage(StarryNetRingMsgConfig starryNetRingMsgConfig, String str, byte[] bArr, IMessageSendListener iMessageSendListener);
}
