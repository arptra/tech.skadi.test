package com.here.services.positioning.upload.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.here.odnp.util.Log;
import com.here.posclient.Status;
import com.here.posclient.upload.UploadOptions;
import com.here.posclient.upload.UploadUtils;
import com.here.services.internal.IBoundService;
import com.here.services.internal.Manager;
import com.here.services.internal.ServiceUtil;
import com.here.services.positioning.upload.internal.IUploadClient;

public class UploadClient implements Manager {
    private static final String TAG = "services.positioning.internal.UploadManagerClient";
    private IUploadClient mClient;
    /* access modifiers changed from: private */
    public Connection mConnection;
    /* access modifiers changed from: private */
    public final Context mContext;

    public class Connection implements ServiceConnection {
        final Manager.ConnectionListener mListener;
        private IUploadClient mService;

        public Connection(Manager.ConnectionListener connectionListener) {
            this.mListener = connectionListener;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                if (!ServiceUtil.isServiceNotAvailableBinder(iBinder)) {
                    Log.v(UploadClient.TAG, "onServiceConnected: %s", iBinder.getInterfaceDescriptor());
                    IUploadClient asInterface = IUploadClient.Stub.asInterface(iBinder);
                    this.mService = asInterface;
                    UploadClient.this.handleServiceConnected(asInterface);
                    Manager.ConnectionListener connectionListener = this.mListener;
                    if (connectionListener != null) {
                        connectionListener.onConnected();
                        return;
                    }
                    return;
                }
                throw new RemoteException("service is not available");
            } catch (RemoteException e) {
                Log.e(UploadClient.TAG, "onServiceConnected: error: %s", e);
                synchronized (UploadClient.this) {
                    if (UploadClient.this.mConnection != null) {
                        UploadClient.this.mContext.unbindService(this);
                        Connection unused = UploadClient.this.mConnection = null;
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
            Log.v(UploadClient.TAG, "onServiceDisconnected: %s", this.mService);
            IUploadClient iUploadClient = this.mService;
            if (iUploadClient != null) {
                UploadClient.this.handleServiceDisconnected(iUploadClient);
                this.mService = null;
                Manager.ConnectionListener connectionListener = this.mListener;
                if (connectionListener != null) {
                    connectionListener.onDisconnected();
                }
            }
        }
    }

    private UploadClient(Context context) {
        this.mContext = context;
    }

    private synchronized void bindService(Manager.ConnectionListener connectionListener) {
        Log.v(TAG, "bindService", new Object[0]);
        if (this.mConnection == null) {
            try {
                Intent intent = ServiceUtil.getServiceInfo(this.mContext).getIntent();
                intent.setAction(IBoundService.ACTION_BIND_UPLOAD_SERVICE);
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
    public synchronized void handleServiceConnected(IUploadClient iUploadClient) {
        Log.v(TAG, "handleServiceConnected", new Object[0]);
        this.mClient = iUploadClient;
    }

    /* access modifiers changed from: private */
    public synchronized void handleServiceDisconnected(IUploadClient iUploadClient) {
        if (iUploadClient != null) {
            try {
                if (iUploadClient.equals(this.mClient)) {
                    this.mClient = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        disconnect();
    }

    public static UploadClient open(Context context) {
        Log.v(TAG, "UploadClient.open", new Object[0]);
        return new UploadClient(context);
    }

    public synchronized void cancelUpload() {
        try {
            IUploadClient iUploadClient = this.mClient;
            if (iUploadClient != null) {
                iUploadClient.cancelUpload();
            }
        } catch (RemoteException e) {
            Log.e(TAG, "setUploadData: error: %s", e);
        }
        return;
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

    public synchronized Status subscribe(UploadListener uploadListener) {
        try {
            IUploadClient iUploadClient = this.mClient;
            if (iUploadClient != null) {
                return Status.fromInt(iUploadClient.subscribe(uploadListener));
            }
        } catch (RemoteException e) {
            Log.e(TAG, "subscribe: error: %s", Log.getStackTraceString(e));
        }
        return Status.GeneralError;
    }

    public synchronized Status upload(UploadOptions uploadOptions) {
        try {
            IUploadClient iUploadClient = this.mClient;
            if (iUploadClient != null) {
                Bundle bundle = new Bundle();
                UploadUtils.uploadOptionsToBundle(bundle, uploadOptions);
                return Status.fromInt(iUploadClient.upload(bundle));
            }
        } catch (RemoteException e) {
            Log.e(TAG, "setUploadData: error: %s", e);
        }
        return Status.InternalError;
    }
}
