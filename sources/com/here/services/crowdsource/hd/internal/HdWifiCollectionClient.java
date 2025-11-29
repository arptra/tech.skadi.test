package com.here.services.crowdsource.hd.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.here.odnp.util.Log;
import com.here.posclient.crowdsource.hd.ActivityEvent;
import com.here.posclient.crowdsource.hd.ControlEvent;
import com.here.posclient.crowdsource.hd.IActivityEventDispatcher;
import com.here.services.crowdsource.hd.internal.IHdWifiCollectionActivityListener;
import com.here.services.crowdsource.hd.internal.IHdWifiCollectionController;
import com.here.services.internal.IBoundService;
import com.here.services.internal.Manager;
import com.here.services.internal.ServiceNotFoundException;
import com.here.services.internal.ServiceUtil;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class HdWifiCollectionClient implements IHdWifiCollection {
    private static final String TAG = "services.crowdsource.hd.internal.HdWifiCollectionClient";
    final Set<IActivityEventDispatcher> mActivityDispatchers = new CopyOnWriteArraySet();
    final IHdWifiCollectionActivityListener.Stub mActivityListener = new IHdWifiCollectionActivityListener.Stub() {
        public void onActivityEvent(Bundle bundle) {
            for (IActivityEventDispatcher dispatch : HdWifiCollectionClient.this.mActivityDispatchers) {
                ActivityEvent.dispatch(bundle, dispatch);
            }
        }
    };
    /* access modifiers changed from: private */
    public Connection mConnection;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public IHdWifiCollectionController mService;

    public class Connection implements ServiceConnection {
        final Manager.ConnectionListener mListener;

        public Connection(Manager.ConnectionListener connectionListener) {
            this.mListener = connectionListener;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                if (!ServiceUtil.isServiceNotAvailableBinder(iBinder)) {
                    IHdWifiCollectionController unused = HdWifiCollectionClient.this.mService = IHdWifiCollectionController.Stub.asInterface(iBinder);
                    HdWifiCollectionClient hdWifiCollectionClient = HdWifiCollectionClient.this;
                    hdWifiCollectionClient.handleServiceConnected(hdWifiCollectionClient.mService);
                    Manager.ConnectionListener connectionListener = this.mListener;
                    if (connectionListener != null) {
                        connectionListener.onConnected();
                        return;
                    }
                    return;
                }
                throw new RemoteException("service is not available");
            } catch (RemoteException unused2) {
                synchronized (HdWifiCollectionClient.this) {
                    if (HdWifiCollectionClient.this.mConnection != null) {
                        HdWifiCollectionClient.this.mContext.unbindService(this);
                        Connection unused3 = HdWifiCollectionClient.this.mConnection = null;
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
            if (HdWifiCollectionClient.this.mService != null) {
                HdWifiCollectionClient hdWifiCollectionClient = HdWifiCollectionClient.this;
                hdWifiCollectionClient.handleServiceDisconnected(hdWifiCollectionClient.mService);
                IHdWifiCollectionController unused = HdWifiCollectionClient.this.mService = null;
                Manager.ConnectionListener connectionListener = this.mListener;
                if (connectionListener != null) {
                    connectionListener.onDisconnected();
                }
            }
        }
    }

    private HdWifiCollectionClient(Context context) {
        this.mContext = context;
    }

    private synchronized void bindService(Manager.ConnectionListener connectionListener) {
        if (this.mConnection == null) {
            try {
                Intent intent = ServiceUtil.getServiceInfo(this.mContext).getIntent();
                intent.setAction(IBoundService.ACTION_BIND_CROWDSOURCE_SERVICE);
                Connection connection = new Connection(connectionListener);
                this.mConnection = connection;
                if (!this.mContext.bindService(intent, connection, 64)) {
                    throw new RuntimeException();
                }
            } catch (ServiceNotFoundException | RuntimeException unused) {
                this.mConnection = null;
                connectionListener.onConnectionFailed();
            }
        } else {
            connectionListener.onConnected();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void handleServiceConnected(IHdWifiCollectionController iHdWifiCollectionController) {
        this.mService = iHdWifiCollectionController;
    }

    /* access modifiers changed from: private */
    public synchronized void handleServiceDisconnected(IHdWifiCollectionController iHdWifiCollectionController) {
        if (iHdWifiCollectionController != null) {
            try {
                if (iHdWifiCollectionController.equals(this.mService)) {
                    this.mService = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        disconnect();
    }

    public static HdWifiCollectionClient open(Context context) {
        return new HdWifiCollectionClient(context);
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

    public boolean sendEvent(ControlEvent controlEvent) {
        Log.v(TAG, "sendEvent: %s", controlEvent.name());
        try {
            IHdWifiCollectionController iHdWifiCollectionController = this.mService;
            if (iHdWifiCollectionController != null) {
                return iHdWifiCollectionController.sendEvent(controlEvent.name());
            }
            return false;
        } catch (RemoteException e) {
            Log.e(TAG, "sendEvent: error: %s", e);
            return false;
        }
    }

    public boolean setWifiIntervals(int i, int i2) {
        Log.v(TAG, "setWifiIntervals: normal: %d, gnssShadow: %d", Integer.valueOf(i), Integer.valueOf(i2));
        try {
            IHdWifiCollectionController iHdWifiCollectionController = this.mService;
            if (iHdWifiCollectionController != null) {
                return iHdWifiCollectionController.setWifiIntervals(i, i2);
            }
            return false;
        } catch (RemoteException e) {
            Log.e(TAG, "setWifiIntervals: error: %s", e);
            return false;
        }
    }

    public boolean startActivityEventListening(IActivityEventDispatcher iActivityEventDispatcher) {
        boolean isEmpty = this.mActivityDispatchers.isEmpty();
        if (!this.mActivityDispatchers.add(iActivityEventDispatcher)) {
            return false;
        }
        if (!isEmpty) {
            return true;
        }
        try {
            IHdWifiCollectionController iHdWifiCollectionController = this.mService;
            if (iHdWifiCollectionController != null && iHdWifiCollectionController.registerActivityEvents(this.mActivityListener)) {
                return true;
            }
        } catch (RemoteException e) {
            Log.e(TAG, "startActivityEventListenening: error: %s", e);
        }
        this.mActivityDispatchers.remove(iActivityEventDispatcher);
        return false;
    }

    public void stopActivityEventListening(IActivityEventDispatcher iActivityEventDispatcher) {
        this.mActivityDispatchers.remove(iActivityEventDispatcher);
        if (this.mActivityDispatchers.isEmpty()) {
            try {
                IHdWifiCollectionController iHdWifiCollectionController = this.mService;
                if (iHdWifiCollectionController != null) {
                    iHdWifiCollectionController.unregisterActivityEvents(this.mActivityListener);
                }
            } catch (RemoteException e) {
                Log.e(TAG, "stopActivityEventListenening: error: %s", e);
            }
        }
    }
}
