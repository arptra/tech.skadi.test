package com.here.services.positioning.consent.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.here.odnp.util.Log;
import com.here.posclient.ConsentState;
import com.here.services.internal.IBoundService;
import com.here.services.internal.Manager;
import com.here.services.internal.ServiceUtil;
import com.here.services.positioning.consent.internal.IConsentClient;

public class ConsentClient implements Manager {
    private static final String TAG = "services.positioning.internal.ConsentManagerClient";
    private IConsentClient mClient;
    /* access modifiers changed from: private */
    public Connection mConnection;
    /* access modifiers changed from: private */
    public final Context mContext;

    public class Connection implements ServiceConnection {
        final Manager.ConnectionListener mListener;
        private IConsentClient mService;

        public Connection(Manager.ConnectionListener connectionListener) {
            this.mListener = connectionListener;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                if (!ServiceUtil.isServiceNotAvailableBinder(iBinder)) {
                    Log.v(ConsentClient.TAG, "onServiceConnected: %s", iBinder.getInterfaceDescriptor());
                    IConsentClient asInterface = IConsentClient.Stub.asInterface(iBinder);
                    this.mService = asInterface;
                    ConsentClient.this.handleServiceConnected(asInterface);
                    Manager.ConnectionListener connectionListener = this.mListener;
                    if (connectionListener != null) {
                        connectionListener.onConnected();
                        return;
                    }
                    return;
                }
                throw new RemoteException("service is not available");
            } catch (RemoteException e) {
                Log.e(ConsentClient.TAG, "onServiceConnected: error: %s", e);
                synchronized (ConsentClient.this) {
                    if (ConsentClient.this.mConnection != null) {
                        ConsentClient.this.mContext.unbindService(this);
                        Connection unused = ConsentClient.this.mConnection = null;
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
            Log.v(ConsentClient.TAG, "onServiceDisconnected: %s", this.mService);
            IConsentClient iConsentClient = this.mService;
            if (iConsentClient != null) {
                ConsentClient.this.handleServiceDisconnected(iConsentClient);
                this.mService = null;
                Manager.ConnectionListener connectionListener = this.mListener;
                if (connectionListener != null) {
                    connectionListener.onDisconnected();
                }
            }
        }
    }

    private ConsentClient(Context context) {
        this.mContext = context;
    }

    private synchronized void bindService(Manager.ConnectionListener connectionListener) {
        Log.v(TAG, "bindService", new Object[0]);
        if (this.mConnection == null) {
            try {
                Intent intent = ServiceUtil.getServiceInfo(this.mContext).getIntent();
                intent.setAction(IBoundService.ACTION_BIND_CONSENT_SERVICE);
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
    public synchronized void handleServiceConnected(IConsentClient iConsentClient) {
        Log.v(TAG, "handleServiceConnected", new Object[0]);
        this.mClient = iConsentClient;
    }

    /* access modifiers changed from: private */
    public synchronized void handleServiceDisconnected(IConsentClient iConsentClient) {
        if (iConsentClient != null) {
            try {
                if (iConsentClient.equals(this.mClient)) {
                    this.mClient = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        disconnect();
    }

    public static ConsentClient open(Context context) {
        Log.v(TAG, "ConsentClient.open", new Object[0]);
        return new ConsentClient(context);
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

    public synchronized void onConsentUpdated(ConsentState consentState) {
        Log.v(TAG, "ConsentClient.onConsentUpdated: state: %d", Integer.valueOf(consentState.stateCode));
        try {
            IConsentClient iConsentClient = this.mClient;
            if (iConsentClient != null) {
                iConsentClient.onConsentUpdated(consentState.stateCode);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "onConsentUpdated: error: %s", e);
        }
        return;
    }
}
