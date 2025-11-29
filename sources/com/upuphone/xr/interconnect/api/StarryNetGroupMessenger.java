package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.common.IGroupMessageReceiver;
import com.upuphone.xr.interconnect.common.IGroupMessageSendCallback;

public interface StarryNetGroupMessenger {
    void disableGroupModel(int i);

    int sendGroupMsg(byte b, byte[] bArr, int i, IGroupMessageSendCallback iGroupMessageSendCallback);

    int waitGroupMsg(byte b, int i, IGroupMessageReceiver iGroupMessageReceiver);
}
