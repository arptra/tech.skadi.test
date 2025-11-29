package com.upuphone.xr.interconnect.remote;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.common.IGroupMessageReceiver;
import com.upuphone.xr.interconnect.common.IGroupMessageSendCallback;
import com.upuphone.xr.interconnect.common.IGroupMessageTransport;

public class GroupMessageTransportImpl extends IGroupMessageTransport.Stub {
    public void disableGroupModel(int i) throws RemoteException {
        InterconnectManager.getInstance().getStarryNetSdkGroupMessenger().disableGroupModel(i);
    }

    public int sendGroupMsg(byte b, byte[] bArr, int i, IGroupMessageSendCallback iGroupMessageSendCallback) throws RemoteException {
        return InterconnectManager.getInstance().getStarryNetSdkGroupMessenger().sendGroupMsg(b, bArr, i, iGroupMessageSendCallback);
    }

    public int waitGroupMsg(byte b, int i, IGroupMessageReceiver iGroupMessageReceiver) throws RemoteException {
        return InterconnectManager.getInstance().getStarryNetSdkGroupMessenger().waitGroupMsg(b, i, iGroupMessageReceiver);
    }
}
