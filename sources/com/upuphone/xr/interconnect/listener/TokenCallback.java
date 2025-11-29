package com.upuphone.xr.interconnect.listener;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.ITokenCallback;

public abstract class TokenCallback extends ITokenCallback.Stub {
    public boolean onAuthError(int i, String str) throws RemoteException {
        return false;
    }
}
