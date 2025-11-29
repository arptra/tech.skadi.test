package com.here.services.positioning.auth.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.here.odnp.posclient.IPosClientManager;
import com.here.odnp.posclient.auth.IAuthSession;
import com.here.odnp.util.Log;
import com.here.posclient.auth.AuthListener;
import com.here.posclient.auth.AuthUtils;
import com.here.services.internal.IBoundService;
import com.here.services.positioning.auth.internal.IAuthClient;

public class AuthClientService extends IAuthClient.Stub implements IBoundService {
    private static final String TAG = "services.positioning.analytics.internal.AuthClientService";
    private final IAuthSession mSession;

    public static class ListenerBridge implements AuthListener {
        private AuthListener mListener;

        public ListenerBridge(AuthListener authListener) {
            this.mListener = authListener;
        }

        public void onAuthDataRequested() {
            Log.i(AuthClientService.TAG, "onAuthDataRequested", new Object[0]);
            AuthListener authListener = this.mListener;
            if (authListener != null) {
                try {
                    authListener.onAuthDataRequested();
                } catch (RemoteException unused) {
                    this.mListener = null;
                }
            }
        }
    }

    public AuthClientService(IPosClientManager iPosClientManager, Intent intent) {
        Log.i(TAG, "AuthClientService", new Object[0]);
        if (iPosClientManager != null) {
            this.mSession = iPosClientManager.createAuthSession();
            return;
        }
        throw new IllegalArgumentException("posClientManager is null");
    }

    public int setAuthData(Bundle bundle) throws RemoteException {
        Log.i(TAG, "setAuthData", new Object[0]);
        return this.mSession.setAuthData(AuthUtils.authDataFromBundle(bundle)).toInt();
    }

    public int subscribe(AuthListener authListener) throws RemoteException {
        Log.i(TAG, "subscribe", new Object[0]);
        return this.mSession.subscribe(new ListenerBridge(authListener)).toInt();
    }

    public void unBind() {
        try {
            unsubscribe();
        } catch (RemoteException e) {
            Log.e(TAG, "onUnbind error", e);
        }
    }

    public int unsubscribe() throws RemoteException {
        Log.i(TAG, "unsubscribe", new Object[0]);
        return this.mSession.unsubscribe().toInt();
    }
}
