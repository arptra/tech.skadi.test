package com.upuphone.xr.interconnect.api;

import android.os.RemoteException;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.common.IVolumeChange;
import com.upuphone.xr.interconnect.remote.BinderClient;
import java.util.ArrayList;
import java.util.Iterator;

public class VolumeChangeImpl implements VolumeChange {
    private static final String TAG = "VolumeChangeImpl";
    private IClientRegister mIClientRegister;
    private ArrayList<IVolumeChange> mList = new ArrayList<>();

    public interface IClientRegister {
        void notifyRegister();
    }

    public void addClientRegister(IClientRegister iClientRegister) {
        this.mIClientRegister = iClientRegister;
    }

    public void dispatchVolumeChange(int i) {
        ArrayList<IVolumeChange> arrayList = this.mList;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<IVolumeChange> it = this.mList.iterator();
            while (it.hasNext()) {
                IVolumeChange next = it.next();
                try {
                    ULog.d(TAG, "dispatchVolumeChange::value is: " + i);
                    next.onMessageReceive(i);
                } catch (RemoteException e) {
                    ULog.d(TAG, "dispatchVolumeChange::error is: " + e.getMessage());
                }
            }
        }
    }

    public void onClientDied(BinderClient binderClient) {
        ArrayList<IVolumeChange> arrayList;
        if (binderClient.getPackageName().equals("com.upuphone.star.launcher") && (arrayList = this.mList) != null) {
            arrayList.clear();
        }
    }

    public void registerMessageReceiver(IVolumeChange iVolumeChange) {
        ULog.d(TAG, "registerMessageReceiver::do register");
        if (iVolumeChange == null || !iVolumeChange.asBinder().isBinderAlive()) {
            ULog.d(TAG, "registerMessageReceiver::volumeChange is invalid");
            return;
        }
        this.mList.add(iVolumeChange);
        IClientRegister iClientRegister = this.mIClientRegister;
        if (iClientRegister != null) {
            iClientRegister.notifyRegister();
        }
    }

    public void removeClientRegister() {
        this.mIClientRegister = null;
    }

    public void unregisterMessageReceiver(IVolumeChange iVolumeChange) {
        ULog.d(TAG, "unregisterMessageReceiver::do unregister");
        if (iVolumeChange != null) {
            this.mList.remove(iVolumeChange);
        }
    }
}
