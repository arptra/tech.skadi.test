package com.upuphone.xr.interconnect.inner;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetGroupMessageOperator;
import com.upuphone.xr.interconnect.listener.GroupMessageReceiver;
import com.upuphone.xr.interconnect.listener.SendGroupMessageCallback;

class InnerGroupMessageOperator implements StarryNetGroupMessageOperator {
    public void disableGroupModel(int i) {
        InterconnectManager.getInstance().getStarryNetSdkGroupMessenger().disableGroupModel(i);
    }

    public int sendGroupMsg(byte b, byte[] bArr, int i, SendGroupMessageCallback sendGroupMessageCallback) {
        return InterconnectManager.getInstance().getStarryNetSdkGroupMessenger().sendGroupMsg(b, bArr, i, sendGroupMessageCallback);
    }

    public int waitGroupMsg(byte b, int i, GroupMessageReceiver groupMessageReceiver) {
        return InterconnectManager.getInstance().getStarryNetSdkGroupMessenger().waitGroupMsg(b, i, groupMessageReceiver);
    }
}
