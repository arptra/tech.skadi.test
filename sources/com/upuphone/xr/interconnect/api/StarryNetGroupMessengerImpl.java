package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.common.IGroupMessageReceiver;
import com.upuphone.xr.interconnect.common.IGroupMessageSendCallback;

public class StarryNetGroupMessengerImpl implements StarryNetGroupMessenger {
    private static final String TAG = "StarryNetGroupMessengerImpl";

    public void disableGroupModel(int i) {
    }

    public int sendGroupMsg(byte b, byte[] bArr, int i, IGroupMessageSendCallback iGroupMessageSendCallback) {
        return -100;
    }

    public int waitGroupMsg(byte b, int i, IGroupMessageReceiver iGroupMessageReceiver) {
        return -100;
    }
}
