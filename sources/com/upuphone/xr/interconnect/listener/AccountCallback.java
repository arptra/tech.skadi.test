package com.upuphone.xr.interconnect.listener;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.IAccountCallback;

public abstract class AccountCallback extends IAccountCallback.Stub {
    public boolean onFailed(int i, String str) throws RemoteException {
        return false;
    }
}
