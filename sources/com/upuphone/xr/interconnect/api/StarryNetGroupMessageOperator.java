package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.listener.GroupMessageReceiver;
import com.upuphone.xr.interconnect.listener.SendGroupMessageCallback;

public interface StarryNetGroupMessageOperator {
    void disableGroupModel(int i);

    int sendGroupMsg(byte b, byte[] bArr, int i, SendGroupMessageCallback sendGroupMessageCallback);

    int waitGroupMsg(byte b, int i, GroupMessageReceiver groupMessageReceiver);
}
