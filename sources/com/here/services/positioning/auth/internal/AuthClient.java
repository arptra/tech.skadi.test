package com.here.services.positioning.auth.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.here.odnp.util.Log;
import com.here.posclient.Status;
import com.here.posclient.auth.AuthData;
import com.here.posclient.auth.AuthUtils;
import com.here.services.internal.IBoundService;
import com.here.services.internal.Manager;
import com.here.services.internal.ServiceUtil;
import com.here.services.positioning.auth.internal.IAuthClient;

public class AuthClient implements Manager {
    private static final String TAG = "services.positioning.internal.AuthManagerClient";
    private IAuthClient mClient;
    /* access modifiers changed from: private */
    public Connection mConnection;
    /* access modifiers changed from: private */
    public final Context mContext;

    public class Connection implements ServiceConnection {
        final Manager.ConnectionListener mListener;
        private IAuthClient mService;

        public Connection(Manager.ConnectionListener connectionListener) {
            this.mListener = connectionListener;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                if (!ServiceUtil.isServiceNotAvailableBinder(iBinder)) {
                    Log.v(AuthClient.TAG, "onServiceConnected: %s", iBinder.getInterfaceDescriptor());
                    IAuthClient asInterface = IAuthClient.Stub.asInterface(iBinder);
                    this.mService = asInterface;
                    AuthClient.this.handleServiceConnected(asInterface);
                    Manager.ConnectionListener connectionListener = this.mListener;
                    if (connectionListener != null) {
                        connectionListener.onConnected();
                        return;
                    }
                    return;
                }
                throw new RemoteException("service is not available");
            } catch (RemoteException e) {
                Log.e(AuthClient.TAG, "onServiceConnected: error: %s", e);
                synchronized (AuthClient.this) {
                    if (AuthClient.this.mConnection != null) {
                        AuthClient.this.mContext.unbindService(this);
                        Connection unused = AuthClient.this.mConnection = null;
                    }
                    Manager.ConnectionListener connectionListener2 = this.mListener;
                    if (connectionListener2 != null) {
                        connectionListener2.onConnectionFailed();
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Log.v(AuthClient.TAG, "onServiceDisconnected: %s", this.mService);
            IAuthClient iAuthClient = this.mService;
            if (iAuthClient != null) {
                AuthClient.this.handleServiceDisconnected(iAuthClient);
                this.mService = null;
                Manager.ConnectionListener connectionListener = this.mListener;
                if (connectionListener != null) {
                    connectionListener.onDisconnected();
                }
            }
        }
    }

    private AuthClient(Context context) {
        this.mContext = context;
    }

    private synchronized void bindService(Manager.ConnectionListener connectionListener) {
        Log.v(TAG, "bindService", new Object[0]);
        if (this.mConnection == null) {
            try {
                Intent intent = ServiceUtil.getServiceInfo(this.mContext).getIntent();
                intent.setAction(IBoundService.ACTION_BIND_AUTH_SERVICE);
                Connection connection = new Connection(connectionListener);
                this.mConnection = connection;
                if (!this.mContext.bindService(intent, connection, 64)) {
                    throw new RuntimeException();
                }
            } catch (Exception e) {
                Log.e(TAG, "bindService: error: %s", e);
                this.mConnection = null;
                connectionListener.onConnectionFailed();
            }
        } else {
            connectionListener.onConnected();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void handleServiceConnected(IAuthClient iAuthClient) {
        Log.v(TAG, "handleServiceConnected", new Object[0]);
        this.mClient = iAuthClient;
    }

    /* access modifiers changed from: private */
    public synchronized void handleServiceDisconnected(IAuthClient iAuthClient) {
        if (iAuthClient != null) {
            try {
                if (iAuthClient.equals(this.mClient)) {
                    this.mClient = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        disconnect();
    }

    public static AuthClient open(Context context) {
        Log.v(TAG, "AuthClient.open", new Object[0]);
        return new AuthClient(context);
    }

    public void connect(Manager.ConnectionListener connectionListener) {
        bindService(connectionListener);
    }

    public synchronized void disconnect() {
        try {
            Connection connection = this.mConnection;
            if (connection != null) {
                this.mContext.unbindService(connection);
            }
        } catch (Exception unused) {
            try {
                Log.w(TAG, "disconnect: unbindService error, service already disconnected?", new Object[0]);
            } catch (Throwable th) {
                this.mConnection = null;
                throw th;
            }
        }
        this.mConnection = null;
    }

    public synchronized Status setAuthData(AuthData authData) {
        try {
            IAuthClient iAuthClient = this.mClient;
            if (iAuthClient != null) {
                Bundle bundle = new Bundle();
                AuthUtils.authDataToBundle(bundle, authData);
                return Status.fromInt(iAuthClient.setAuthData(bundle));
            }
        } catch (RemoteException e) {
            Log.e(TAG, "setAuthData: error: %s", e);
        }
        return Status.InternalError;
    }

    public synchronized Status subscribe(AuthListener authListener) {
        try {
            IAuthClient iAuthClient = this.mClient;
            if (iAuthClient != null) {
                return Status.fromInt(iAuthClient.subscribe(authListener));
            }
        } catch (RemoteException e) {
            Log.e(TAG, "subscribe: error: %s", Log.getStackTraceString(e));
        }
        return Status.GeneralError;
    }
}
