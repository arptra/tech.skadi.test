package com.upuphone.xr.interconnect.outer;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.api.StarryNetGroupMessageOperator;
import com.upuphone.xr.interconnect.common.IGroupMessageTransport;
import com.upuphone.xr.interconnect.listener.GroupMessageReceiver;
import com.upuphone.xr.interconnect.listener.SendGroupMessageCallback;

public class StarryNeGroupMessageOperatorImpl implements StarryNetGroupMessageOperator, SuperServiceStateListener {
    private SuperServiceProvider mProvider;

    public void disableGroupModel(int i) {
        IGroupMessageTransport groupMessenger = this.mProvider.getGroupMessenger();
        if (groupMessenger != null) {
            try {
                groupMessenger.disableGroupModel(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void onServiceConnected() {
    }

    public void onServiceDied() {
    }

    public int sendGroupMsg(byte b, byte[] bArr, int i, SendGroupMessageCallback sendGroupMessageCallback) {
        IGroupMessageTransport groupMessenger = this.mProvider.getGroupMessenger();
        if (groupMessenger == null) {
            return -1;
        }
        try {
            return groupMessenger.sendGroupMsg(b, bArr, i, sendGroupMessageCallback);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void setProvider(SuperServiceProvider superServiceProvider) {
        this.mProvider = superServiceProvider;
    }

    public int waitGroupMsg(byte b, int i, GroupMessageReceiver groupMessageReceiver) {
        IGroupMessageTransport groupMessenger = this.mProvider.getGroupMessenger();
        if (groupMessenger == null) {
            return -1;
        }
        try {
            return groupMessenger.waitGroupMsg(b, i, groupMessageReceiver);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
