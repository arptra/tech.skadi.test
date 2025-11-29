package com.here.services.positioning.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.here.odnp.util.Log;
import com.here.posclient.Status;
import com.here.posclient.analytics.Tracker;
import com.here.services.internal.IBoundService;
import com.here.services.internal.Manager;
import com.here.services.internal.ServiceUtil;
import com.here.services.positioning.analytics.internal.IUsageTrackingClient;
import java.util.EnumSet;

public class UsageTrackingClient implements Manager {
    private static final String TAG = "services.positioning.internal.UsageTrackingManagerClient";
    private IUsageTrackingClient mClient;
    /* access modifiers changed from: private */
    public Connection mConnection;
    /* access modifiers changed from: private */
    public final Context mContext;

    public class Connection implements ServiceConnection {
        final Manager.ConnectionListener mListener;
        private IUsageTrackingClient mService;

        public Connection(Manager.ConnectionListener connectionListener) {
            this.mListener = connectionListener;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                if (!ServiceUtil.isServiceNotAvailableBinder(iBinder)) {
                    Log.v(UsageTrackingClient.TAG, "onServiceConnected: %s", iBinder.getInterfaceDescriptor());
                    IUsageTrackingClient asInterface = IUsageTrackingClient.Stub.asInterface(iBinder);
                    this.mService = asInterface;
                    UsageTrackingClient.this.handleServiceConnected(asInterface);
                    Manager.ConnectionListener connectionListener = this.mListener;
                    if (connectionListener != null) {
                        connectionListener.onConnected();
                        return;
                    }
                    return;
                }
                throw new RemoteException("service is not available");
            } catch (RemoteException e) {
                Log.e(UsageTrackingClient.TAG, "onServiceConnected: error: %s", e);
                synchronized (UsageTrackingClient.this) {
                    if (UsageTrackingClient.this.mConnection != null) {
                        UsageTrackingClient.this.mContext.unbindService(this);
                        Connection unused = UsageTrackingClient.this.mConnection = null;
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
            Log.v(UsageTrackingClient.TAG, "onServiceDisconnected: %s", this.mService);
            IUsageTrackingClient iUsageTrackingClient = this.mService;
            if (iUsageTrackingClient != null) {
                UsageTrackingClient.this.handleServiceDisconnected(iUsageTrackingClient);
                this.mService = null;
                Manager.ConnectionListener connectionListener = this.mListener;
                if (connectionListener != null) {
                    connectionListener.onDisconnected();
                }
            }
        }
    }

    private UsageTrackingClient(Context context) {
        this.mContext = context;
    }

    private synchronized void bindService(Manager.ConnectionListener connectionListener) {
        Log.v(TAG, "bindService", new Object[0]);
        if (this.mConnection == null) {
            try {
                Intent intent = ServiceUtil.getServiceInfo(this.mContext).getIntent();
                intent.setAction(IBoundService.ACTION_BIND_USAGE_TRACKING_SERVICE);
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
    public synchronized void handleServiceConnected(IUsageTrackingClient iUsageTrackingClient) {
        Log.v(TAG, "handleServiceConnected", new Object[0]);
        this.mClient = iUsageTrackingClient;
    }

    /* access modifiers changed from: private */
    public synchronized void handleServiceDisconnected(IUsageTrackingClient iUsageTrackingClient) {
        if (iUsageTrackingClient != null) {
            try {
                if (iUsageTrackingClient.equals(this.mClient)) {
                    this.mClient = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        disconnect();
    }

    public static UsageTrackingClient open(Context context) {
        Log.v(TAG, "UsageTrackingClient.open", new Object[0]);
        return new UsageTrackingClient(context);
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

    public synchronized EnumSet<Tracker> getSupportedTrackers() {
        try {
            IUsageTrackingClient iUsageTrackingClient = this.mClient;
            if (iUsageTrackingClient != null) {
                return UsageTrackingUtils.bundleToEnumSet(iUsageTrackingClient.getSupportedTrackers());
            }
        } catch (RemoteException e) {
            Log.e(TAG, "getSupportedTrackers: error: %s", e);
        }
        return EnumSet.noneOf(Tracker.class);
    }

    public synchronized Status subscribe(UsageTrackingListener usageTrackingListener, Tracker... trackerArr) {
        try {
            IUsageTrackingClient iUsageTrackingClient = this.mClient;
            if (iUsageTrackingClient != null) {
                Bundle trackersToBundle = UsageTrackingUtils.trackersToBundle(trackerArr);
                Log.i(TAG, "subscribe: %s", trackersToBundle);
                return Status.fromInt(iUsageTrackingClient.subscribe(usageTrackingListener, trackersToBundle));
            }
        } catch (RemoteException e) {
            Log.e(TAG, "subscribe: error: %s", Log.getStackTraceString(e));
        }
        return Status.GeneralError;
    }
}
